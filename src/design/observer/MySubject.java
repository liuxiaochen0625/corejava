/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 23, 2016 4:17:20 PM 
 * @version 1.0 
 *
 */
package design.observer;

public class MySubject extends AbstractSubject{

	@Override
	public void operation() {
		System.out.println("update self!");  
        notifyObservers(); 
	}
	
	public static void main(String[] args) {
		Subject subject = new MySubject();
		subject.add(new Observer1());
		subject.add(new Observer2());
		subject.operation();
	}

}
