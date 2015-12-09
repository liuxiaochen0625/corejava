/**
 *
 * @author : liuxiaoqiang
 * @date   :Dec 9, 2015 9:26:34 AM 
 * @version 1.0 
 *
 */
package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\pic1.txt")),"UTF-8"));
		String line = "";
		Writer writer = new OutputStreamWriter(new FileOutputStream(new File("D:\\pic2.txt")),"UTF-8");
		while((line = reader.readLine()) != null){
			if(line.startsWith("/2010/")||line.startsWith("/2011/")||line.startsWith("/2012/")){
				File file = new File("D:/pic/jianbao/jianbao/website"+line);
				if(!file.exists()){
					writer.write(line+"\n");
				}
			}
		}
		reader.close();
		writer.close();
	}

}
