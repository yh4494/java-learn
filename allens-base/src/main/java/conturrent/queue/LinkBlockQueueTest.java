package conturrent.queue;

import java.util.concurrent.LinkedBlockingDeque;

public class LinkBlockQueueTest {

    /**
     * JDK提供的阻塞队列
     *
     * ArrayBlockingQueue：一个由数组结构组成的有界阻塞队列，遵循FIFO原则。
     * LinkedBlockingQueue：一个由链表结构组成的有界阻塞队列，遵循FIFO原则，默认和最大长度为Integer.MAX_VALUE。
     * PriorityBlockingQueue：一个支持优先级排序的无界阻塞队列。
     * DelayQueue：一个使用优先级队列实现的无界阻塞队列。
     * SynchronousQueue：一个不存储元素的阻塞队列。
     * LinkedTransferQueue：一个由链表结构组成的无界阻塞队列。
     * LinkedBlockingDeque：一个由链表结构组成的双向阻塞队列。
     *
     * offer Inserts the specified element at the tail of this queue if it is possible to do so immediately without exceeding the queue's capacity, returning true upon success and false if this queue is full.
     *
     * take 如果队列为空则会阻塞等待
     * remove 如果队列为空则会抛出异常
     * poll 如果队列为空会返回null
     */
    public static void main(String[] args) {
        LinkedBlockingDeque<String> linkedBlockingDeque = new LinkedBlockingDeque<>();
        linkedBlockingDeque.add("some");
        System.out.println(linkedBlockingDeque.poll());
    }

}
