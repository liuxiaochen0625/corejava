/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 23, 2016 10:09:53 AM 
 * @version 1.0 
 *
 */
package design.factory.abstractfactory;

import design.factory.Sender;
import design.factory.SmsSender;

public class SendSmsFactory implements Provider{

	@Override
	public Sender produce() {
		return new SmsSender();
	}

}
