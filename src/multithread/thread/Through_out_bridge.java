/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 19, 2016 11:18:10 AM 
 * @version 1.0 
 *
 */
package multithread.thread;

public class Through_out_bridge {
	public static void main(String[] args) {
		Bridge b = Bridge.getInstance();// 实例化桥
		// 实例化左端9个人，此时所有人都不能过桥，桥的可以状态标志为不可以用
		for (int i = 1; i <= 10; i++) {
			Thread t = new Thread(new Person(false, i, b));
			t.start();
		}
		// 实例化右端12个人，此时所有人都不能过桥，桥的可以状态标志为不可以用
		for (int i = 1; i <= 12; i++) {
			Thread t = new Thread(new Person(true, i, b));
			t.start();
		}
		// 桥的可用状态给左端第10个人，可以自定义给谁
		b.state = true;
		Thread t = new Thread(new Person(false, 10, b));
	}
}