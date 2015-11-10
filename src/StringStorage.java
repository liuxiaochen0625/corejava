import java.util.Random;

/**
 *
 * @author : liuxiaoqiang
 * @date   :Oct 29, 2015 11:31:10 AM 
 * @version 1.0 
 *
 */

public class StringStorage {
	public static String getRandomUserName() {
		int random = new Random().nextInt(UniqueRandom.vector.size());
		return "eb" + String.format("%03d", UniqueRandom.vector.remove(random));
	}
}
