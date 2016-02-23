/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 23, 2016 9:47:38 AM 
 * @version 1.0 
 *
 */
package design.factory;

public class SmsSender implements Sender{

	@Override
	public void Send() {
		System.out.println("this is a sms sender!");
	}

}
