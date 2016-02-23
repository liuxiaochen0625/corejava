/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 23, 2016 11:10:26 AM 
 * @version 1.0 
 *
 */
package design.builder;

import java.util.ArrayList;
import java.util.List;

import design.factory.MailSender;
import design.factory.Sender;
import design.factory.SmsSender;

public class Builder {
	private List<Sender> list = new ArrayList<Sender>();
	public void produceMailSender(int count){
		for(int i=0;i<count;i++)
			list.add(new MailSender());
	}
	
	public void produceSmsSender(int count){
		for(int i=0;i<count;i++)
			list.add(new SmsSender());
	}
}
