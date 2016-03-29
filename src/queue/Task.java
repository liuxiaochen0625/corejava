/**
 *
 * @author : liuxiaoqiang
 * @date   :Mar 28, 2016 11:06:54 AM 
 * @version 1.0 
 *
 */
package queue;

public abstract class Task implements Runnable{
	
}

enum State{
	
	START(0),CANCEL(1),STOP(2),COMPLETE(3);
	private State(int state){
		this.state = state;
	}
	
	private int state;
	
	public String toString(){
		return "State[state = " + state +"]";
	}
}