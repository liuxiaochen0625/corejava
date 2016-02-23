/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 23, 2016 4:05:12 PM 
 * @version 1.0 
 *
 */
package design.observer;

public class Observer2 implements Observer{

	@Override
	public void update() {
		 System.out.println("observer2 has received!");
	}

}
