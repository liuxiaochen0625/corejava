/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 23, 2016 5:54:27 PM 
 * @version 1.0 
 *
 */
package design.visitor;

public class MySubject implements Subject{

	@Override
	public void accept(Visitor visitor) {
		visitor.visitor(this);
	}

	@Override
	public String getSubject() {
		return "love";
	}

}
