/**
 *
 * @author : liuxiaoqiang
 * @date   :Dec 31, 2015 2:54:18 PM 
 * @version 1.0 
 *
 */
package multithread.threadlocal;

import java.util.Collections; 
import java.util.HashMap; 
import java.util.Map; 

/** 
* 使用了ThreadLocal的类 
* 
* @author leizhimin 2010-1-5 10:35:27 
*/ 
public class MyThreadLocal1 { 

        //定义了一个ThreadLocal变量，用来保存int或Integer数据 
        //        private ThreadLocal<Bean> tl = new ThreadLocal<Bean>() { 
        private ThreadLocal<Bean> tl = new ThreadLocal<Bean>() { 
                @Override 
                protected Bean initialValue() { 
                        return new Bean(); 
                } 
        }; 

        @Override 
        public String toString() { 
                return "MyThreadLocal{" + 
                                "tl=" + tl + 
                                '}'; 
        } 

        public Bean getBean() { 
                return tl.get(); 
        } 

} 

class ThreadLocal<T> { 
        private Map<Thread, T> map = Collections.synchronizedMap(new HashMap<Thread, T>()); 

        public ThreadLocal() { 
        } 

        protected T initialValue() { 
                return null; 
        } 

        public T get() { 
                Thread t = Thread.currentThread(); 
                T obj = map.get(t); 
                if (obj == null && !map.containsKey(t)) { 
                        obj = initialValue(); 
                        map.put(t, obj); 
                } 
                return obj; 
        } 

        public void set(T value) { 
                map.put(Thread.currentThread(), value); 
        } 

        public void remove() { 
                map.remove(Thread.currentThread()); 
        } 
}