/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 23, 2016 5:06:48 PM 
 * @version 1.0 
 *
 */
package design.command;

public class MyCommand implements Command{
	private Receiver receiver;
	
	public MyCommand(Receiver receiver) {
		this.receiver = receiver;
	}

	@Override
	public void exec() {
		receiver.action();
	}

}
