import java.io.Console;
import java.lang.reflect.Constructor;

/**
 *
 * @author : liuxiaoqiang
 * @date   :Jan 19, 2016 3:08:43 PM 
 * @version 1.0 
 *
 */

public class Construct {
	@SuppressWarnings("rawtypes")
	public static void main(String[] args){
		Constructor[] cons = Console.class.getConstructors();
		for(Constructor cor:cons)
			System.out.println(cor);
	}

}
