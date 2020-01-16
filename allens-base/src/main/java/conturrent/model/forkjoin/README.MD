> Java提供Fork/Join框架用于并行执行任务，它的思想就是讲一个大任务分割成若干小任务，最终汇总每个小任务的结果得到这个大任务的结果。
* 第一、任务切分
* 第二、结果合并

<img src="https://upload-images.jianshu.io/upload_images/3047136-2044de505345b0a1.png?imageMogr2/auto-orient/strip|imageView2/2/w/1200"/>

它的模型大致是这样的：线程池中的每个线程都有自己的工作队列（PS：这一点和ThreadPoolExecutor不同，ThreadPoolExecutor是所有线程公用一个工作队列，所有线程都从这个工作队列中取任务），当自己队列中的任务都完成以后，会从其它线程的工作队列中偷一个任务执行，这样可以充分利用资源。

分治的原理上面已经介绍了，就是切割大任务成小任务来完成。看起来好像也不难实现啊！为什么专门弄一个新的框架呢？
我们先看一下，在不使用 Fork-Join 框架时，使用普通的线程池是怎么实现的。

我们往一个线程池提交了一个大任务，规定好任务切割的阀值。
由线程池中线程（假设是线程A）执行大任务，发现大任务的大小大于阀值，于是切割成两个子任务，并调用 submit() 提交到线程池，得到返回的子任务的 Future。
线程A就调用 返回的 Future 的 get() 方法阻塞等待子任务的执行结果。
池中的其他线程（除线程A外，线程A被阻塞）执行两个子任务，然后判断子任务的大小有没有超过阀值，如果超过，则按照步骤2继续切割，否则，才计算并返回结果。

咦，好像一切都很美好。真的吗？别忘了， 每一个切割任务的线程（如线程A）都被阻塞了，直到其子任务完成，才能继续往下运行 。如果任务太大了，需要切割多次，那么就会有多个线程被阻塞，性能将会急速下降。更糟糕的是，如果你的线程池的线程数量是有上限的，极可能会造成池中所有线程被阻塞，线程池无法执行任务。

#### 工作窃取（work-stealing）
<img src="https://images2018.cnblogs.com/blog/874963/201805/874963-20180523154643214-1612544334.png"/>  

那么为什么需要使用工作窃取算法呢？  
假如我们需要做一个比较大的任务，我们可以把这个任务分割为若干互不依赖的子任务，为了减少线程间的竞争，于是把这些子任务分别放到不同的队列里，并为每个队列创建一个单独的线程来执行队列里的任务，线程和队列一一对应，比如A线程负责处理A队列里的任务。但是有的线程会先把自己队列里的任务干完，而其他线程对应的队列里还有任务等待处理。干完活的线程与其等着，不如去帮其他线程干活，于是它就去其他线程的队列里窃取一个任务来执行。而在这时它们会访问同一个队列，所以为了减少窃取任务线程和被窃取任务线程之间的竞争，通常会使用双端队列，被窃取任务线程永远从双端队列的头部拿任务执行，而窃取任务的线程永远从双端队列的尾部拿任务执行。  
工作窃取算法的优点是充分利用线程进行并行计算，并减少了线程间的竞争，其缺点是在某些情况下还是存在竞争，比如双端队列里只有一个任务时。并且消耗了更多的系统资源，比如创建多个线程和多个双端队列。  

#### RecursiveTask和RecursiveAction区别

* RecursiveTask 
通过源码的查看我们可以发现RecursiveTask在进行exec之后会使用一个result的变量进行接受返回的结果。而result返回结果类型是通过泛型进行传入。也就是说RecursiveTask执行后是有返回结果。
~~~java
public abstract class RecursiveTask<V> extends ForkJoinTask<V> {
    private static final long serialVersionUID = 5232453952276485270L;

    /**
     * The result of the computation.
     */
    V result;

    /**
     * The main computation performed by this task.
     * @return the result of the computation
     */
    protected abstract V compute();

    public final V getRawResult() {
        return result;
    }

    protected final void setRawResult(V value) {
        result = value;
    }

    /**
     * Implements execution conventions for RecursiveTask.
     */
    protected final boolean exec() {
        result = compute();
        return true;
    }

}
~~~
* RecursiveAction  
RecursiveAction在exec后是不会保存返回结果，因此RecursiveAction与RecursiveTask区别在与RecursiveTask是有返回结果而RecursiveAction是没有返回结果。
~~~java
public abstract class RecursiveAction extends ForkJoinTask<Void> {
    private static final long serialVersionUID = 5232453952276485070L;

    /**
     * The main computation performed by this task.
     */
    protected abstract void compute();

    /**
     * Always returns {@code null}.
     *
     * @return {@code null} always
     */
    public final Void getRawResult() { return null; }

    /**
     * Requires null completion value.
     */
    protected final void setRawResult(Void mustBeNull) { }

    /**
     * Implements execution conventions for RecursiveActions.
     */
    protected final boolean exec() {
        compute();
        return true;
    }
}
~~~

使用ForkJoin将相同的计算任务通过多线程的进行执行。从而能提高数据的计算速度。在google的中的大数据处理框架mapreduce就通过类似ForkJoin的思想。通过多线程提高大数据的处理。但是我们需要注意：
使用这种多线程带来的数据共享问题，在处理结果的合并的时候如果涉及到数据共享的问题，我们尽可能使用JDK为我们提供的并发容器。
在使用JVM的时候我们要考虑OOM的问题，如果我们的任务处理时间非常耗时，并且处理的数据非常大的时候。会造成OOM。
ForkJoin也是通过多线程的方式进行处理任务。那么我们不得不考虑是否应该使用ForkJoin。因为当数据量不是特别大的时候，我们没有必要使用ForkJoin。因为多线程会涉及到上下文的切换。所以数据量不大的时候使用串行比使用多线程快。


