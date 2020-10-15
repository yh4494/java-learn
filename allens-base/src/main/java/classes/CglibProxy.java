package classes;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import topdf.model.TestPdfModel;

import java.lang.reflect.Method;
import java.util.Map;


/**
 * @Description 普通类
 * @Author      Allens
 * @Date        2020-10-10 16:44
 * @Version     V1.0
 */
public class CglibProxy implements MethodInterceptor {

    private Object target; // 代理对象

    private static ObjectMapper objectMapper = new ObjectMapper();

    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        // 设置父类为实例类
        enhancer.setSuperclass(this.target.getClass());
        // 回调方法
        enhancer.setCallback(this);
        // 创建代理对象
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("调用前");
        Object result = methodProxy.invokeSuper(o, objects); // 执行方法调用
        // System.out.println("调用后");
        return result;
    }

    // 将对象转成字符串
    public static String objectToString(Object obj) throws Exception {
        return objectMapper.writeValueAsString(obj);
    }

    // 将Bean转成Map
    public static Map beanToMap(Object obj) throws Exception {
        return objectMapper.readValue(objectToString(obj), Map.class);
    }

    public static void main(String[] args) throws Exception {
        CglibProxy proxy = new CglibProxy();
        TestPdfModel panda = (TestPdfModel)proxy.getInstance(new TestPdfModel());
        panda.setName("hello");
        long start = System.currentTimeMillis();
        Map map = beanToMap(panda);
        System.out.println(map.keySet());
        System.out.println(map.values());
        long end   = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
