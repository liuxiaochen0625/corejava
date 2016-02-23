/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 23, 2016 2:43:04 PM 
 * @version 1.0 
 *
 */
package design.bridge;

public abstract class Bridge {
	private Sourceable source;
	public void method(){
		source.method();
	}
	public Sourceable getSource() {
		return source;
	}
	public void setSource(Sourceable source) {
		this.source = source;
	}
	
}
