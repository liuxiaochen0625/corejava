/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 23, 2016 4:56:13 PM 
 * @version 1.0 
 *
 */
package design.chain;

public abstract class AbstractHandler {
	private Handler handler;

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}
	
}
