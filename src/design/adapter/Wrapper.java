/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 23, 2016 11:57:09 AM 
 * @version 1.0 
 *
 */
package design.adapter;

public class Wrapper implements Targetable{

	private Source source;
	
	public Wrapper(Source source) {
		super();
		this.source = source;
	}
	
	@Override
	public void method1() {
		source.method1();
	}

	@Override
	public void method2() {
		 System.out.println("this is the targetable method!");
	}

	
	public static void main(String []args){
		Source source = new Source();
		Targetable target = new Wrapper(source);
		target.method1();
		target.method2();
	}
}
