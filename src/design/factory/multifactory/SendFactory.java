/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 23, 2016 9:55:33 AM 
 * @version 1.0 
 *
 */
package design.factory.multifactory;

import design.factory.MailSender;
import design.factory.Sender;
import design.factory.SmsSender;

public class SendFactory {
	public Sender produceMailSender(){
		return new MailSender();
	}
	
	public Sender produceSmsSender(){
		return new SmsSender();
	}
	
	public static void main(String args){
		SendFactory sendFactory = new SendFactory();
		Sender sender = sendFactory.produceMailSender();
		sender.Send();
		sender = sendFactory.produceSmsSender();
		sender.Send();
	}
}
