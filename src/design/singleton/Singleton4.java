/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 23, 2016 10:33:36 AM 
 * @version 1.0 
 *
 */
package design.singleton;

public class Singleton4 {
	public static Singleton4 instance = null;
	private Singleton4(){
	}
	
	/* 此处使用一个内部类来维护单例 */
	public static Singleton4 getInstance(){
		return SingletonFactory.instance;
	}
	
	public Object readResolve(){
		return getInstance();
	}
	private static class SingletonFactory{
		private static Singleton4 instance = new Singleton4();
	}
}
