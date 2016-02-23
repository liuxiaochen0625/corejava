/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 23, 2016 1:37:52 PM 
 * @version 1.0 
 *
 */
package design.adapter;

public class Wrapper2Test {
	public static void main(String []args){
		Sourceable sub1 = new SourceSub1();
		Sourceable sub2 = new SourceSub2();
		sub1.method1();
		sub1.method2();
		sub2.method1();
		sub2.method2();
	}
}
