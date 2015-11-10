import java.util.Vector;

/**
 *
 * @author : liuxiaoqiang
 * @date   :Oct 29, 2015 11:18:23 AM 
 * @version 1.0 
 *
 */

public class UniqueRandom {
	
	public static Vector<Integer> vector = new Vector<Integer>(1000);
	static{
		for(int i=0;i<1000;i++)
			vector.add(i);
	}
	
	public static synchronized void setRandom(){
		for(int i=0;i<1000;i++)
			vector.add(i);
	}
	
}
