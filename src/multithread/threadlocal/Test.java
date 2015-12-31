/**
 *
 * @author : liuxiaoqiang
 * @date   :Dec 31, 2015 2:48:00 PM 
 * @version 1.0 
 *
 */
package multithread.threadlocal;

/** 
* ThreadLocal测试 
* 
* @author leizhimin 2010-1-5 10:43:48 
*/ 
public class Test { 
        public static void main(String[] args) { 
                MyThreadLocal tlt = new MyThreadLocal(); 
                Thread t1 = new TestThread(tlt); 
                Thread t2 = new TestThread(tlt); 
                Thread t3 = new TestThread(tlt); 
                Thread t4 = new TestThread(tlt); 
                t1.start(); 
                t2.start(); 
                t3.start(); 
                t4.start(); 

        } 
}
