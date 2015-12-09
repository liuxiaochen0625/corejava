/**
 *
 * @author : liuxiaoqiang
 * @date   :Dec 9, 2015 9:20:20 AM 
 * @version 1.0 
 *
 */
package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class Utils {
	//在每行前面添加一个/
	public static void  readFileByLine(String readFile,String writeFile) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(readFile)),"UTF-8"));
		Writer writer = new OutputStreamWriter(new FileOutputStream(new File(writeFile)),"UTF-8");
		String line = "";
		while((line = reader.readLine()) != null){
			if(line.equals(""))
				continue;
			String str = "/";
			if(!line.startsWith("/"))
				line = str+line;
			writer.write(line);
			writer.write("\n");
		}
		reader.close();
		writer.close();
	}
	
	//检查文件是否存在
	public static void  JudgeFileExist(String readFile,String writeFile) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(readFile)),"UTF-8"));
		String line = "";
		Writer writer = new OutputStreamWriter(new FileOutputStream(new File(writeFile)),"UTF-8");
		while((line = reader.readLine()) != null){
			File file = new File(line);
			if(!file.exists()){
				writer.write(line+"\n");
			}
		}
		reader.close();
		writer.close();
	}
}
