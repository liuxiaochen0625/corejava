/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 23, 2016 10:08:58 AM 
 * @version 1.0 
 *
 */
package design.factory.abstractfactory;

import design.factory.MailSender;
import design.factory.Sender;

public class SendMailFactory implements Provider{

	@Override
	public Sender produce() {
		return new MailSender();
	}

}
