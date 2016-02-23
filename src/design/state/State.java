/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 23, 2016 5:41:46 PM 
 * @version 1.0 
 *
 */
package design.state;

public class State {
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public void method1(){
		System.out.println("execute the first opt!");
	}
	
	public void method2(){
		System.out.println("execute the second opt!");
	}
}
