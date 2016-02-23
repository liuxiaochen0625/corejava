/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 23, 2016 5:51:14 PM 
 * @version 1.0 
 *
 */
package design.visitor;

public interface Subject {
	public void accept(Visitor visitor);
	public String getSubject();
}
