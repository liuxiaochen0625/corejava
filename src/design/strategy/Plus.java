/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 23, 2016 3:36:22 PM 
 * @version 1.0 
 *
 */
package design.strategy;

public class Plus extends AbstractCalculator implements ICalculator{

	@Override
	public int calculate(String exp) {
		int arrayInt[] = split(exp, "\\+");
		return arrayInt[0]+arrayInt[1];
	}

}
