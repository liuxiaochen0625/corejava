/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 23, 2016 2:44:49 PM 
 * @version 1.0 
 *
 */
package design.bridge;

public class MyBridge extends Bridge{
	public void method(){
		getSource().method();
	}
	
	public static void main(String []args){
		Bridge bridge = new MyBridge();
		Sourceable source1 = new SourceSub1();
		bridge.setSource(source1);
		bridge.method();
		
		Sourceable source2 = new SourceSub2();
		bridge.setSource(source2);
		bridge.method();
	}
}
