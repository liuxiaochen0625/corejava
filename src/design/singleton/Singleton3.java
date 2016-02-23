/**
 * 线程安全的单例模式，创建实例时花销还是比较大，但是相比Singleton2要好一些
 */
/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 23, 2016 10:25:23 AM 
 * @version 1.0 
 *
 */
package design.singleton;

public class Singleton3 {
	public static Singleton3 instance = null;
	private Singleton3(){
		
	}
	
	public static Singleton3 getInstance(){
		if(instance == null)
			synchronized (instance) {
				if(instance == null)
					return new Singleton3();
			}
		return instance;
	}
	
	public Object readResolve(){
		return instance;
	}
}
