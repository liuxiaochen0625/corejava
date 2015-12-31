/**
 *
 * @author : liuxiaoqiang
 * @date   :Dec 31, 2015 2:47:03 PM 
 * @version 1.0 
 *
 */
package multithread.threadlocal;

/** 
* 使用了ThreadLocal的类 
* 
* @author leizhimin 2010-1-5 10:35:27 
*/ 
public class MyThreadLocal { 
        //定义了一个ThreadLocal变量，用来保存int或Integer数据 
        private ThreadLocal<Integer> tl = new ThreadLocal<Integer>() { 
                @Override 
                protected Integer initialValue() { 
                        return 0; 
                } 
        }; 

        public Integer getNextNum() { 
                //将tl的值获取后加1，并更新设置t1的值 
                tl.set(tl.get() + 1); 
                return tl.get(); 
        } 
}
