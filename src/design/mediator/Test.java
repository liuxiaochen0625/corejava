/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 23, 2016 5:59:32 PM 
 * @version 1.0 
 *
 */
package design.mediator;

public class Test {
	public static void main(String[] args) {  
        Mediator mediator = new MyMediator();  
        mediator.createMediator();  
        mediator.workAll();  
    }  
}
