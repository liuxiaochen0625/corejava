/**
 * 线程不安全的单例模式
 */
/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 23, 2016 10:14:59 AM 
 * @version 1.0 
 *
 */
package design.singleton;

public class Singleton {
	public static Singleton instance = null;
	
	//私有方法，防止类被实例化
	private Singleton(){
		
	}
	
	public static Singleton getInstance(){
		if(instance == null)
			return new Singleton();
		return instance;
	}
	
	public Object readResolve(){
		return instance;
	}
}
