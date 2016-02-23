/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 23, 2016 4:04:46 PM 
 * @version 1.0 
 *
 */
package design.observer;

public class Observer1 implements Observer{

	@Override
	public void update() {
		System.out.println("observer1 has received!");
	}

}
