package zx.learn.proxyLearn;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;


/**
 * proxy 代理  书上的示例
 * 我还需要找找网上的示例看看 书上讲的少 不清晰
 * 总的来说，Proxy的理解离不开对代理这个设计模式的理解。就是创建一个代理人，
 * 通过调用代理类的方法来调用源对象（被代理对象）的方法，
 * 而代理类的对象早原对象的方法周围包含了其他逻辑
 * 代理类可以访问到 调用参数，可以根据这些参数 通过一定逻辑决定 不执行原对象的函数 这样就起到了拦截的作用
 * 暂时就这么多
 *
 * 参考：
 * https://blog.csdn.net/qwssd/article/details/81367385
 * 找时间 仔细看上面这篇文章， 写个总结， 今晚没啥时间了
 */
public class proxyLearn {

    public static void main(String[] args) {
        Object[] elements = new Object[1000];
        for (int i = 0; i < elements.length; i++) {
            Integer value = i + 1;
            InvocationHandler handler = new TraceHandler(value);
            Object proxy = Proxy.newProxyInstance(null, new Class[]{Comparable.class}, handler);
            elements[i] = proxy;
        }
        Integer key = new Random().nextInt(elements.length) + 1;

        int result = Arrays.binarySearch(elements, key);
        if(result>0) System.out.println(elements[result]);
    }
}

//TraceHandler  轨迹记录 ，就是记录函数调用的轨迹
class TraceHandler implements InvocationHandler {
    private Object target;
    public TraceHandler(Object object) {
        target = object;
    }

    //他的意思是  不管调用源对象的任何方法 ， 这个程序的invoke方法都会被调用  你就可以在这里添加一些东西  例如 这里 输出了调用源  方法名 参数名 等
    @Override
    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
        System.out.print(target);
        System.out.print("." + method.getName() + "(");
        if(args != null){
            for (int i = 0; i < args.length; i++) {
                System.out.print(args[i]);
                if(i<args.length-1) System.out.print(",");
            }
        }
        System.out.println(")");
        return method.invoke(target, args);
    }

}