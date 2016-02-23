/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 23, 2016 5:57:09 PM 
 * @version 1.0 
 *
 */
package design.mediator;

public abstract class User {
	private Mediator mediator;  
    
    public Mediator getMediator(){  
        return mediator;  
    }  
      
    public User(Mediator mediator) {  
        this.mediator = mediator;  
    }  
  
    public abstract void work(); 
}
