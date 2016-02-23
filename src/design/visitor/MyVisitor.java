/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 23, 2016 5:52:28 PM 
 * @version 1.0 
 *
 */
package design.visitor;

public class MyVisitor implements Visitor{

	@Override
	public void visitor(Subject subject) {
		System.out.println("visit the subject:"+subject.getSubject());
	}

}
