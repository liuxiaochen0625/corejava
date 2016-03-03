/**
 *
 * @author : liuxiaoqiang
 * @date   :Mar 3, 2016 10:24:47 AM 
 * @version 1.0 
 *
 */
package util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import qiniu.StringStorage;

import com.qiniu.util.Auth;

public class util {
	public static void main(String []args) throws IOException{
		Auth auth = Auth.create(StringStorage.ACCESS_KEY, StringStorage.SECRET_KEY);
		String url = "http://7xrggt.com2.z0.glb.qiniucdn.com/reus.jpg";
		String urlsign = auth.privateDownloadUrl(url, 3600);
		saveImage(urlsign,"D:\\image");
	}
	
	/**
	 * java 从网络中下载图片
	 * @throws IOException 
	 */
	
	public static void saveImage(String imageUrl,String savePath) throws IOException{
		URL url = new URL(imageUrl);
		URLConnection conn = (URLConnection) url.openConnection();
		String imageName = url.getFile();
		imageName = imageName.substring(0,imageName.indexOf("?"));
		InputStream inputStream = conn.getInputStream();
		byte []buffer = new byte[1024];
		int len = 0;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		while((len=inputStream.read(buffer))!=-1){
			bos.write(buffer, 0, len);
		}
		bos.close();
		byte[] data = bos.toByteArray();
		File saveDir = new File(savePath);
		if(!saveDir.exists())
			saveDir.mkdir();
		File file = new File(saveDir+File.separator+imageName);
		
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(data);
		fos.close();
	}
}
