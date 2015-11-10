import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author : liuxiaoqiang
 * @date   :Oct 29, 2015 11:38:33 AM 
 * @version 1.0 
 *
 */

public class RandomTest implements Runnable{
	public static void main(String []args){
		String str = "Hello World!";
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			byte b[] = md.digest();
			StringBuffer bf = new StringBuffer();
			for(int i=0;i<b.length;i++)
				bf.append(Integer.toHexString(0xff&b[i]));
			System.out.println(bf.toString());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		System.out.println(StringStorage.getRandomUserName());
	}
}
