/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 19, 2016 11:18:59 AM 
 * @version 1.0 
 *
 */
package multithread.thread;

public class Person implements Runnable {

	public Bridge bridge;// 桥
	private String hand;// 在桥哪一端
	int No;// 序号

	public Person(boolean side, int i, Bridge bridge) {

		this.No = i;
		this.bridge = bridge;
		if (bridge.state) {
			System.out.println(i + "已经过桥。");
		}
		if (side) {
			this.hand = new String("右");
		} else {
			this.hand = new String("左");
		}
	}

	// 过桥方法
	public synchronized void through() throws InterruptedException {

		if (bridge.state) {
			System.out.println(hand + "边第" + No + "在过桥");
			bridge.open(No);
		} else {
			bridge.lock(No);

		}
	}

	public void run() {
		try {
			Thread.sleep(1000);
			through();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

