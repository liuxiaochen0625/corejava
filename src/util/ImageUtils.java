package util;
/**
 * 修改图片的大小
 * 是宽度固定，而高度随比例变化
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.ImageIcon;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

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
//		renameImage("D:\\photo\\map.txt", "D:\\photo\\photo\\" ,"D:\\photo\\new_photo\\");
		createThum("D:\\photo\\new_photo");
	}
	
	/**
	 * 
	 * 匹配对应关系
	 * @throws IOException 
	 * 
	 */
	public static void renameImage(String srcFile,String srcImage,String desImage) throws IOException{
		Map<String, String> srcMap = new HashMap<String, String>();
		Map<String, File> desMap = new HashMap<String, File>();
		File file = new File(srcImage);
		File files[] = file.listFiles();
		for(File f:files)
			desMap.put(f.getName(), f);
		FileInputStream fis = new FileInputStream(srcFile);
		BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
		String line = "";
		while((line = reader.readLine())!=null){
			String []str = line.split("	");
			srcMap.put(str[0], str[1]);
		}
		for(Entry<String, String> entry:srcMap.entrySet()){
			File f = desMap.get("XY_"+entry.getKey()+".jpg");
			File d = new File(desImage+f.getName().replaceAll(entry.getKey(), entry.getValue()));
			f.renameTo(d);
		}
		reader.close();
	}
	
	/**
	 * 为每张图片生成一张缩略图
	 */
	
	public static void createThum(String filePath){
		File file = new File(filePath);
		String path = file.getPath()+File.separator;
		if(file.isDirectory()){
			String files[] = file.list();
			for(String str : files){
				String prefix = path+str.substring(0,str.lastIndexOf("."));
				String suffix = str.substring(str.lastIndexOf("."));
				File originalImage = new File(path+str);
				try{
				resize(originalImage, new File(prefix+"_60_60"+suffix),60, 1F);
				 resize(originalImage, new File(prefix+"_120_120"+suffix),120, 1F);
				 resize(originalImage, new File(prefix+"_160_160"+suffix),160, 1F);
				 resize(originalImage, new File(prefix+"_220_220"+suffix),220, 1F);
				 resize(originalImage, new File(prefix+"_350_350"+suffix),350, 1F);
				 resize(originalImage, new File(prefix+"_360_360"+suffix),360, 1F);
				 resize(originalImage, new File(prefix+"_600_600"+suffix),600, 1F);
				 resize(originalImage, new File(prefix+"_800_800"+suffix),800, 1F);
				}catch(IOException e){
					System.out.println(str);
					e.printStackTrace();
				}
			}
				
		}
	}

}
