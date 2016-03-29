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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;

import qiniu.StringStorage;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.FileInfo;
import com.qiniu.storage.model.FileListing;
import com.qiniu.util.Auth;

public class util {
	public static void main(String []args) throws IOException{
		Auth auth = Auth.create(StringStorage.ACCESS_KEY, StringStorage.SECRET_KEY);
//		String url = "http://7xrggt.com2.z0.glb.qiniucdn.com/reus.jpg";
//		String urlsign = auth.privateDownloadUrl(url, 3600);
//		saveImage(urlsign,"D:\\image");
//		List<File> list = getFiles("C:\\Users\\Administrator\\Desktop\\jianbao\\tong\\im_upload");
//		System.out.println(list.size());
//		convertImage("D:\\2016-03-28", "tpaimg", "2016-03-28");
//		for(File file:list)
//			System.out.println(file.getName());
		
		BucketManager bucketManager = new BucketManager(auth);
		BucketManager.FileListIterator it = bucketManager.createFileListIterator("tpaimg", "", 1000, null);
		List<FileInfo> listFile = new ArrayList<FileInfo>();
		while (it.hasNext()) {  
            FileInfo[] items = it.next();  
            if (null != items && items.length > 0) {  
            	listFile.addAll(Arrays.asList(items));  
            }  
        } 
		System.out.println(listFile.size());
		for(FileInfo f:listFile)
			System.out.println(f.key);
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
	
	/**
	 * 图片转移工具,其中图片路径所在的格式为yyyy/MM/dd/HH/文件
	 */
	public static void convertImage(String filePath,String bucket,String filter){
		List<File> list = new ArrayList<File>();
		list = getFiles(filePath);
		Auth auth = Auth.create(StringStorage.ACCESS_KEY, StringStorage.SECRET_KEY);
		UploadManager uploadManager = new UploadManager();
		System.out.println(list.size());
		for(File file1:list){
			String path = file1.getAbsolutePath();
			path = path.substring(path.indexOf(filter));
			path = path.replaceAll("\\\\", "/");
			path = path.replaceAll(filter+"/", "");
			try {
				uploadManager.put(file1.getAbsolutePath(), path, auth.uploadToken(bucket));
			} catch (QiniuException e) {
				System.out.println(file1);
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 遍历一个文件夹下面的所有文件
	 */
	private static List<File> list = new ArrayList<File>();
	
	public static List<File> getFiles(String filePath){
		File file = new File(filePath);
		if(!file.isDirectory())
			list.add(file);
		else 
			for(File temp:file.listFiles())
				getFiles(temp.getAbsolutePath());
		return list;
	}
}
