/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 1, 2016 11:05:27 AM 
 * @version 1.0 
 *
 */
package util;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
 
/**
 * 使用 Java 动态代理。具体有如下四步骤： 
 * 1、通过实现 InvocationHandler 接口创建自己的调用处理器；
 * 2、通过为 Proxy 类指定 * ClassLoader 对象和一组 interface 来创建动态代理类；
 * 3、通过反射机制获得动态代理类的构造函数，其唯一参数类型是调用处理器接口类型；
 * 4、通过构造函数创建动态代理类实例，构造时调用处理器对象作为参数被传入。
 */
public class DynamicProxyTest {
 
    public static void main(String[] args) {
        // InvocationHandlerImpl 实现了 InvocationHandler 接口，并能实现方法调用从代理类到委托类的分派转发
        InvocationHandler invocationHandler = new DynamicProxy();
        // 该方法用于为指定类装载器、一组接口及调用处理器生成动态代理类实例
        Resource resource = (Resource) Proxy.newProxyInstance(Resource.class.getClassLoader(), new Class[] { Resource.class }, invocationHandler);
        resource.operationB();
    }
}
 
class DynamicProxy implements InvocationHandler {
 
    // 委托类，用于真正执行分派转发过来的方法调用
    private Resource resource = new ConcreateResource();
 
    // 该方法负责集中处理动态代理类上的所有方法调用。第一个参数既是代理类实例，第二个参数是被调用的方法对象
    // 第三个方法是调用参数。调用处理器根据这三个参数进行预处理或分派到委托类实例上发射执行
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(resource, args);
    }
}
 
interface Resource {
    public void operationA();
    public void operationB();
}
 
class ConcreateResource implements Resource {
 
    public void operationA() {
        System.out.println("A");
    }
    public void operationB() {
        System.out.println("B");
    }
}

