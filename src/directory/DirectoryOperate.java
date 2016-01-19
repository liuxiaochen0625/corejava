/**
 *
 * @author : liuxiaoqiang
 * @date   :Jan 19, 2016 11:43:21 AM 
 * @version 1.0 
 *
 */
package directory;

import java.util.ArrayList;
import java.util.List;
import java.io.File;

public class DirectoryOperate {
	//判断目录是否存在
	public static boolean exists(String path){
		try {
			File file = new File(path);
			if(file.exists()&&file.isDirectory())
				return true;
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//创建目录
	public static boolean createDirectory(String path){
		try {
			if(exists(path))
				return true;
			File file = new File(path);
			file.mkdir();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	//获取文件的绝对路径
	public static List<String> getFileList(String path){
		List<String> list = new ArrayList<String>();
		try {
			File file = new File(path);
			if(file.isDirectory()){
				String[] fileList = file.list();
				for(String str:fileList){
					String fileName = "";
					if(path.endsWith("/"))
						fileName = path+"/"+str;
					else
						fileName = path+"\\"+str;
					list.add(fileName);
				}
			}
		} catch (Exception e) {
		}
		return list;
	}
}
