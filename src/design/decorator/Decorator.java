/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 23, 2016 1:45:54 PM 
 * @version 1.0 
 *
 */
package design.decorator;

public class Decorator implements Sourceable{

	private Source source;
	public Decorator(Source source) {
		super();
		this.source = source;
	}
	@Override
	public void method() {
		System.out.println("Before decorator!");
		source.method();
		System.out.println("After decorator!");
	}
	
	public static void main(String []args){
		Source source = new Source();
		Sourceable obj = new Decorator(source);
		obj.method();
	}

}
