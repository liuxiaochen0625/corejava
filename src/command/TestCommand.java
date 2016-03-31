/**
 *
 * @author : liuxiaoqiang
 * @date   :Mar 23, 2016 3:28:00 PM 
 * @version 1.0 
 *
 */
package command;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import util.util;

public class TestCommand {
	public static void main(String[] args) throws IOException {
		uploadByClent();
	}
	
	//七牛客户端上传文件
	public static void uploadByClent(){
		Runtime runtime = Runtime.getRuntime();
		Process process = null;
		String command = "D:\\tools\\name.bat";
		try {
			process = runtime.exec(command);
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line = "";
			while ((line = reader.readLine())!=null) {
				System.out.println(line);
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	//识别图片中的二维码
	public static void execCommandWithParam() throws IOException{
		List<File> listFile = util.getFiles("D:\\release");
		Runtime runtime = Runtime.getRuntime();
		Process process = null;
		for(File file :listFile)
			if(file.getName().equals("1.jpg")){
				String command = "D:\\release\\zxing.exe --try-harder "+file.getAbsolutePath();
				process = runtime.exec(command);
				BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
				String str = "";
				while((str = reader.readLine())!=null)
					System.out.println(str);
				System.out.println(file.getAbsolutePath());
			}
	}
}
