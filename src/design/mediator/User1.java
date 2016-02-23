/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 23, 2016 5:58:17 PM 
 * @version 1.0 
 *
 */
package design.mediator;

public class User1 extends User{

	public User1(Mediator mediator) {
		super(mediator);
	}

	@Override
	public void work() {
		System.out.println("user1 exe!"); 		
	}

}
