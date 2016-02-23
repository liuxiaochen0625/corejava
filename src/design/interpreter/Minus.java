/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 23, 2016 6:02:11 PM 
 * @version 1.0 
 *
 */
package design.interpreter;

public class Minus implements Expression{

	@Override
	public int interpret(Context context) {
		return context.getNum1()-context.getNum2();
	}

}
