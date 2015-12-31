/**
 *
 * @author : liuxiaoqiang
 * @date   :Dec 31, 2015 2:47:30 PM 
 * @version 1.0 
 *
 */
package multithread.threadlocal;

public class TestThread extends Thread { 
    private MyThreadLocal tlt = new MyThreadLocal(); 

    public TestThread(MyThreadLocal tlt) { 
            this.tlt = tlt; 
    } 

    @Override 
    public void run() { 
            for (int i = 0; i < 3; i++) { 
                    System.out.println(Thread.currentThread().getName() + "\t" + tlt.getNextNum()); 
            } 
    } 
}
