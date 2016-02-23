/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 23, 2016 9:46:46 AM 
 * @version 1.0 
 *
 */
package design.factory;

public class MailSender implements Sender{

	@Override
	public void Send() {
		System.out.println("this is a mail sender!");
	}

}
