package util;
/**
 * 修改图片的大小
 * 是宽度固定，而高度随比例变化
 */

import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;

import javax.swing.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.Kernel;
import java.awt.image.ConvolveOp;

@SuppressWarnings("restriction")
public class ImageUtils {
	public static void resize(File originalFile, File resizedFile,
			int newWidth, float quality) throws IOException {

		if (quality > 1) {
			throw new IllegalArgumentException(
					"Quality has to be between 0 and 1");
		}

		ImageIcon ii = new ImageIcon(originalFile.getCanonicalPath());
		Image i = ii.getImage();
		Image resizedImage = null;

		int iWidth = i.getWidth(null);
		int iHeight = i.getHeight(null);

		if (iWidth > iHeight) {
			resizedImage = i.getScaledInstance(newWidth, (newWidth * iHeight)
					/ iWidth, Image.SCALE_SMOOTH);
		} else {
			resizedImage = i.getScaledInstance((newWidth * iWidth) / iHeight,
					newWidth, Image.SCALE_SMOOTH);
		}

		// This code ensures that all the pixels in the image are loaded.
		Image temp = new ImageIcon(resizedImage).getImage();

		// Create the buffered image.
		BufferedImage bufferedImage = new BufferedImage(temp.getWidth(null),
				temp.getHeight(null), BufferedImage.TYPE_INT_RGB);

		// Copy image to buffered image.
		Graphics g = bufferedImage.createGraphics();

		// Clear background and paint the image.
		g.setColor(Color.white);
		g.fillRect(0, 0, temp.getWidth(null), temp.getHeight(null));
		g.drawImage(temp, 0, 0, null);
		g.dispose();

		// Soften.
		float softenFactor = 0.05f;
		float[] softenArray = { 0, softenFactor, 0, softenFactor,
				1 - (softenFactor * 4), softenFactor, 0, softenFactor, 0 };
		Kernel kernel = new Kernel(3, 3, softenArray);
		ConvolveOp cOp = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
		bufferedImage = cOp.filter(bufferedImage, null);

		// Write the jpeg to a file.
		FileOutputStream out = new FileOutputStream(resizedFile);

		// Encodes image as a JPEG data stream
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);

		JPEGEncodeParam param = encoder
				.getDefaultJPEGEncodeParam(bufferedImage);

		param.setQuality(quality, true);

		encoder.setJPEGEncodeParam(param);
		encoder.encode(bufferedImage);
		out.close();
	} // Example usage

	public static void main(String[] args) throws IOException {
		 BufferedReader reader = null;
		 try{
			 reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\new_img.txt")),"UTF-8"));
			 String line = "";
			 while((line = reader.readLine()) != null){
				 String str[] = line.split("	");
				 String prefix = str[1].substring(0,str[1].lastIndexOf("."));
				 String suffix = str[1].substring(str[1].lastIndexOf("."));
				 File originalImage = new File(str[1]);
				 resize(originalImage, new File(prefix+"_60_60"+suffix),60, 1F);
				 resize(originalImage, new File(prefix+"_120_120"+suffix),120, 1F);
				 resize(originalImage, new File(prefix+"_160_160"+suffix),160, 1F);
				 resize(originalImage, new File(prefix+"_220_220"+suffix),220, 1F);
				 resize(originalImage, new File(prefix+"_350_350"+suffix),350, 1F);
				 resize(originalImage, new File(prefix+"_360_360"+suffix),360, 1F);
				 resize(originalImage, new File(prefix+"_600_600"+suffix),600, 1F);
				 resize(originalImage, new File(prefix+"_800_800"+suffix),800, 1F);
			 }
		 }catch(Exception e){
			 
		 }finally{
			 reader.close();
		 }
	}

}
