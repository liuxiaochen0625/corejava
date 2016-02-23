/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 23, 2016 5:43:28 PM 
 * @version 1.0 
 *
 */
package design.state;

public class Context {
	private State state;
	
	public Context(State state){
		this.state = state;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	public void method(){
		if(state.getValue().equals("state1"))
			state.method1();
		if(state.getValue().equals("state2"))
			state.method2();
	}
	
	public static void main(String[] args) {
		State state = new State();
		Context context = new Context(state);
		state.setValue("state1");
		context.method();
		state.setValue("state2");
		context.method();
	}
	
}
