/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 23, 2016 4:26:54 PM 
 * @version 1.0 
 *
 */
package design.iterator;

public interface Iterator {
	 //前移  
    public Object previous();  
      
    //后移  
    public Object next();  
    public boolean hasNext();  
      
    //取得第一个元素  
    public Object first();
}
