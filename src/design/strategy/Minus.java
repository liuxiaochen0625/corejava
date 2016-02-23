/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 23, 2016 3:38:20 PM 
 * @version 1.0 
 *
 */
package design.strategy;

public class Minus extends AbstractCalculator implements ICalculator{

	@Override
	public int calculate(String exp) {
		int arrayInt[] = split(exp, "-");
		return arrayInt[0] - arrayInt[1];
	}

}
