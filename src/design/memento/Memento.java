/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 23, 2016 5:18:26 PM 
 * @version 1.0 
 *
 */
package design.memento;

public class Memento {
	public String value;

	public Memento(String value){
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
