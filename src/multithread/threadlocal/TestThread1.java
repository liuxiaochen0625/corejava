/**
 *
 * @author : liuxiaoqiang
 * @date   :Dec 31, 2015 2:56:19 PM 
 * @version 1.0 
 *
 */
package multithread.threadlocal;

/** 
* 测试线程 
* 
* @author leizhimin 2010-1-5 10:39:18 
*/ 
public class TestThread1 extends Thread { 
        private MyThreadLocal1 tlt = new MyThreadLocal1(); 

        public TestThread1(MyThreadLocal1 tlt) { 
                this.tlt = tlt; 
        } 

        @Override 
        public void run() { 
                System.out.println(">>>>>:" + tlt); 
                for (int i = 0; i < 3; i++) { 
                        System.out.println(Thread.currentThread().getName() + "\t" +tlt.getBean()+"\t"+tlt.getBean().showinfo()); 
                } 
        } 
}
