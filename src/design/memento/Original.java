/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 23, 2016 5:16:58 PM 
 * @version 1.0 
 *
 */
package design.memento;

public class Original {
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public Original(String value){
		this.value = value;
	}
	
	public Memento createMemento(){
		return new Memento(value);
	}
	
	public void restoreMemento(Memento memento){
		this.value = memento.value;
	}
}
