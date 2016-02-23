/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 23, 2016 5:55:28 PM 
 * @version 1.0 
 *
 */
package design.visitor;

public class Test {

	 public static void main(String[] args) {  
         
	        Visitor visitor = new MyVisitor();  
	        Subject sub = new MySubject();  
	        sub.accept(visitor);      
	    }  
}
