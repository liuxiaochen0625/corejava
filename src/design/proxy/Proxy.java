/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 23, 2016 1:53:01 PM 
 * @version 1.0 
 *
 */
package design.proxy;

public class Proxy implements Sourceable{
	private Source source;
	
	public Proxy() {
		super();
		this.source = new Source();
	}
	
	@Override
	public void method() {
		before();
		source.method();
		after();
	}
	
	private void before(){
		System.out.println("before proxy!");
	}
	private void after(){
		System.out.println("after proxy!");
	}

	public static void main(String []args){
		Sourceable source = new Proxy();
		source.method();
		
	}
}
