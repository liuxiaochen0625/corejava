/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 23, 2016 5:10:14 PM 
 * @version 1.0 
 *
 */
package design.command;

public class Invoker {
	private Command command;
	
	public Invoker(Command command){
		this.command = command;
	}
	
	public void action(){
		command.exec();
	}
	
	public static void main(String[] args) {
		Receiver receiver = new Receiver();
		Command command = new MyCommand(receiver);
		Invoker invoker = new Invoker(command);
		invoker.action();
	}
}
