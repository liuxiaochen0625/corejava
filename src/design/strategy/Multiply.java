/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 23, 2016 3:39:43 PM 
 * @version 1.0 
 *
 */
package design.strategy;

public class Multiply extends AbstractCalculator implements ICalculator{

	@Override
	public int calculate(String exp) {
		int arrayInt[] = split(exp, "\\*");
		return arrayInt[0] * arrayInt[1];
	}
}
