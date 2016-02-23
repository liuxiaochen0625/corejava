/**
 * 线程安全的单例模式，但是花销太大
 */
/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 23, 2016 10:21:00 AM 
 * @version 1.0 
 *
 */
package design.singleton;

public class Singleton2 {
	public static Singleton2 instance = null;
	
	private Singleton2(){
		
	}
	
	public static synchronized Singleton2 getInstance(){
		if(instance == null)
			return new Singleton2();
		return instance;
	}
	
	public Object readResolve(){
		return instance;
	}

}
