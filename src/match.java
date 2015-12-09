import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Random;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;


public class match {
	public static void main(String []args) throws IOException{
//		System.out.println(randomString(-229985452) + " " + randomString(-147909649));
//		FileInputStream inputStream = new FileInputStream(new File("config.txt"));
//		System.out.println(convertStreamToString(inputStream));
//		StringWriter writer = new StringWriter();
//		IOUtils.copy(inputStream, writer, "UTF-8");
//		System.out.println(writer.toString());
//		System.out.println("\\a");
		System.out.println(new Integer(1) == null);
	}
	
	public static String randomString(int i)
	{
	    Random ran = new Random(i);
	    StringBuilder sb = new StringBuilder();
	    while (true)
	    {
	        int k = ran.nextInt(27);
	        if (k == 0)
	            break;

	        sb.append((char)('`' + k));
	    }

	    return sb.toString();
	}
	
	@SuppressWarnings("resource")
	public static String convertStreamToString(InputStream is) {
		  Scanner s = new Scanner(is).useDelimiter("\\a"); 
		  return s.hasNext() ? s.next() : "";
		}
}
