/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 23, 2016 4:23:49 PM 
 * @version 1.0 
 *
 */
package design.iterator;


public interface  Collection {
	public Iterator iterators();
	public Object get(int i);
	 public int size();
}
