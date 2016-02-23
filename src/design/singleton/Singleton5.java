/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 23, 2016 10:39:31 AM 
 * @version 1.0 
 *
 */
package design.singleton;

public class Singleton5 {
	public static Singleton5 instance = null;
	private Singleton5(){}
	
	public static synchronized void syncInit(){
		if(instance == null)
			instance = new Singleton5();
	}
	
	public static Singleton5 getInstance(){
		if(instance == null)
			syncInit();
		return instance;
	}
}
