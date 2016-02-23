/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 23, 2016 6:02:59 PM 
 * @version 1.0 
 *
 */
package design.interpreter;

public class Test {

	public static void main(String[] args) {
		// 计算9+2-8的值  
        int result = new Minus().interpret((new Context(new Plus()  
                .interpret(new Context(9, 2)), 8)));  
        System.out.println(result);  

	}

}
