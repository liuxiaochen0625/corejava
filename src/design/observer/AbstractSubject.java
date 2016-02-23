/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 23, 2016 4:11:11 PM 
 * @version 1.0 
 *
 */
package design.observer;

import java.util.Enumeration;
import java.util.Vector;

public abstract class AbstractSubject implements Subject{
	private Vector<Observer> vector = new Vector<Observer>();
	
	@Override
	public void add(Observer observer) {  
	     vector.add(observer);  
	}  
	  
	@Override
	public void delete(Observer observer) {
		vector.remove(observer);
	}
	
	@Override
	public void notifyObservers(){
		Enumeration<Observer> enumer = vector.elements();
		while(enumer.hasMoreElements())
			enumer.nextElement().update();
	}
}
