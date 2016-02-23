/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 23, 2016 3:40:38 PM 
 * @version 1.0 
 *
 */
package design.strategy;

public class StrategyTest {
	public static void main(String []args){
		String exp = "5+6";
		ICalculator iCalculator = new Plus();
		int result = iCalculator.calculate(exp);
		System.out.println(result);
	}
}
