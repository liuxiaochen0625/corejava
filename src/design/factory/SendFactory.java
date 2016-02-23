/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 23, 2016 9:48:46 AM 
 * @version 1.0 
 *
 */
package design.factory;

public class SendFactory {
	public Sender produce(String type){
		if("mail".equals(type))
			return new MailSender();
		if("sms".equals(type))
			return new SmsSender();
		else {
			System.out.println("请输入正确的类型!");
			return null;
		}
	}
	public static void main(String []args){
		SendFactory sendFactory = new SendFactory();
		Sender sender = sendFactory.produce("mail");
		sender.Send();
		sender = sendFactory.produce("sms");
		sender.Send();
	}
}
