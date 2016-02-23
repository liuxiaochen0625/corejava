/**影子实例
 * 采用"影子实例"的办法为单例对象的属性同步更新
 * 
 * 具体说，就是在更新属性时，直接生成另一个单例对象实例，这个新生成的单例对象实例将从数据库或文件中读取最新的配置信息；
 * 然后将这些配置信息直接赋值给旧单例对象的属性。如下面代码所示。
 * 
 */



/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 23, 2016 10:57:37 AM 
 * @version 1.0 
 *
 */
package design.singleton;

import java.util.Vector;

public class ShadowSingleton {
	public static ShadowSingleton instance = null;
	@SuppressWarnings("rawtypes")
	public Vector properties = null;
	private ShadowSingleton() {  
	     //Load configuration information from DB or file  
	     //Set values for properties  
	   }
	
	public static synchronized void syncInit(){
		if(instance == null)
			instance = new ShadowSingleton();
	}
	
	public static ShadowSingleton getInstance(){
		if(instance == null)
			syncInit();
		return instance;
	}
	
	@SuppressWarnings("rawtypes")
	public Vector getProperties(){
		return properties;
	}
	
	public void updateProperties(){
		ShadowSingleton shadow = new ShadowSingleton();
		properties = shadow.properties; 
		
	}
}
