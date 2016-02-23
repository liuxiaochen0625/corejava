/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 23, 2016 10:10:52 AM 
 * @version 1.0 
 *
 */
package design.factory.abstractfactory;

import design.factory.Sender;

public class Test {

	public static void main(String[] args) {
		Provider provider = new SendMailFactory();
		Sender sender = provider.produce();
		sender.Send();
		provider = new SendSmsFactory();
		sender = provider.produce();
		sender.Send();
	}

}
