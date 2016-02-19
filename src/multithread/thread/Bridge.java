/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 19, 2016 11:19:44 AM 
 * @version 1.0 
 *
 */
package multithread.thread;

public class Bridge {
	// 可用状态判断true：可用
	public boolean state = false;

	// 自行实例化
	public static Bridge getInstance() {
		return new Bridge();
	}

	public synchronized void open(int i) throws InterruptedException {
		if (state) {
			Thread.sleep(1000);
			this.state = true;
			notify();
		}
	}

	public synchronized void lock(int i) throws InterruptedException {
		if (!state) {
			this.state = false;
			System.out.println(i + " 在等待.");
			wait();
		}
	}
}
