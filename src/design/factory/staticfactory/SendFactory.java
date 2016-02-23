/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 23, 2016 10:01:56 AM 
 * @version 1.0 
 *
 */
package design.factory.staticfactory;

import design.factory.MailSender;
import design.factory.Sender;
import design.factory.SmsSender;

public class SendFactory {
	public static Sender produceMailSender(){
		return new MailSender();
	}
	public static Sender produceSmsSender(){
		return new SmsSender();
	}
	public static void main(String []args){
		Sender sender = SendFactory.produceMailSender();
		sender.Send();
		sender = SendFactory.produceSmsSender();
		sender.Send();
	}
}
