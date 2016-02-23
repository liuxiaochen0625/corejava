/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 23, 2016 2:41:55 PM 
 * @version 1.0 
 *
 */
package design.bridge;

public class SourceSub1 implements Sourceable{

	@Override
	public void method() {
		System.out.println("this is the first sub!");
	}

}
