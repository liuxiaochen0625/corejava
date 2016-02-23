/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 23, 2016 11:54:24 AM 
 * @version 1.0 
 *
 */
package design.adapter;

public class Adapter extends Source implements Targetable{

	@Override
	public void method2() {
		System.out.println("this is the targetable method!");
	}

	public static void main(String []args){
		Targetable targetable = new Adapter();
		targetable.method1();
		targetable.method2();
	}
}
