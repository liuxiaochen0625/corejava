/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 23, 2016 4:08:01 PM 
 * @version 1.0 
 *
 */
package design.observer;

public interface Subject {
	public void add(Observer observer);
	
	public void delete(Observer observer);

	public void notifyObservers();

	public void operation();
}
