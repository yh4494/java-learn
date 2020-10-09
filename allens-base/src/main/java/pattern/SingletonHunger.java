package pattern;

/**
 * @Description 普通类
 * @Author Allens
 * @Date 2020-09-15 18:17
 * @Version V1.0
 */
public class SingletonHunger {

    private static final SingletonHunger INSTANCE = new SingletonHunger();

    //私有化构造子,阻止外部直接实例化对象
    private SingletonHunger(){

    }

    /**
     * <B>方法描述：</B>
     * <p style="margin-left:20px;color:#A52A2A;">
     * 获取类的单例实例
     * @return <span style="color: #008080;"> 返回类的唯一实例 </span>
     */
    public static SingletonHunger getInstance(){
        return INSTANCE;
    }
}
