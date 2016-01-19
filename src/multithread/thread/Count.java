/**
 *
 * @author : liuxiaoqiang
 * @date   :Jan 19, 2016 11:26:08 AM 
 * @version 1.0 
 *
 */
package multithread.thread;

public class Count extends Thread{
	private int count = 0;
	
	public synchronized int increCount(){
		return count++;
	}
	
	@Override
	public void run(){
		while (true) {
			System.out.println(Thread.currentThread().getName()+":"+count);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			increCount();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+":"+count);
		}
		
	}
	
	public static void main(String[] args){
		Count count = new Count();
		Thread thread = new Thread(count,"thread1");
		Thread thread2 = new Thread(count,"thread2");
		thread.start();
		thread2.start();
	}
}
