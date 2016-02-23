/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 23, 2016 1:45:00 PM 
 * @version 1.0 
 *
 */
package design.decorator;

public class Source implements Sourceable{

	@Override
	public void method() {
		System.out.println("the original method!");
	}

}
