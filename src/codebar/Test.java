/**
 *
 * @author : liuxiaoqiang
 * @date   :Jan 22, 2016 2:48:23 PM 
 * @version 1.0 
 *
 */
package codebar;

import java.io.File;
import java.util.Hashtable;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

public class Test{
	public static void main(String []args) throws Exception{
		String text = "刘小强";
		int width = 300;
		int height = 300;
		//二维码的图片格式
		String format = "jpg";
		Hashtable<EncodeHintType,String> hints = new Hashtable<EncodeHintType,String>();
		//内容所使用的编码
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height,hints);
		//生成二维码
		File outputFile = new File("D:"+File.separator+"new.jpg");
		MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);
	}
}
