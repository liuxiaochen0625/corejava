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
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


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
	
	public static List<String> getFileList(String filePath, String fileSuffix) {
		List<String> ret = new ArrayList<String>();
		try {
			File file = new File(filePath);
			if (file.isDirectory()) {
				String[] filelist = file.list();
				for (int i = 0; i < filelist.length; i++) {
					String filename;
					// 避免双斜杠目录
					if(filePath.endsWith("/") || filePath.endsWith("\\"))
						filename = filePath + filelist[i];
					else filename = filePath + "\\" + filelist[i];
					// 如果以该后缀结尾，假如不是，否则忽略该文件
					if (filename.endsWith(fileSuffix))
						ret.add(filename);
				}
			}
		} catch (Exception e) { }
		return ret;
	}
	
	public static List<String> readFileByLines(String fileName) throws Exception
	{
		return readFileByLines(fileName, true);
	}
	
	public static List<String> readFileByLines(String fileName, boolean ignoreEmptyLine) throws Exception {
		List<String> ret = new ArrayList<String>();
		File file = new File(fileName);
		if(!file.exists())
			throw new Exception("File not found:" + fileName);
		if(!file.isFile())
			throw new Exception("Given path is not a file:" + fileName);
		try (FileInputStream in = new FileInputStream(file);
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(in, "UTF-8"));) {
			String tempString = null;
			// 一次读入一行，直到读入null为文件结束
			while ((tempString = reader.readLine()) != null) {
				// 忽略空行
				if (ignoreEmptyLine && tempString.equals(""))
					continue;
				// 移除BOM头
				byte[] b = tempString.getBytes();
				if (b.length > 3 && b[0] == -17 && b[1] == -69 && b[2] == -65)
					tempString = tempString.substring(1);
				// 忽略空行
				if (ignoreEmptyLine && tempString.trim().equals(""))
					continue;
				ret.add(tempString.trim());
			}
			reader.close();
		} catch (Exception e) {
			throw new Exception("Read file failed", e);
		}
		return ret;
	}
	
	public synchronized static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
	
	/**
	 * 识别字符是否是中文编码
	 * 
	 * @param c
	 * @return
	 */
	private final static boolean isChinese(char c) {
		Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
		if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
				|| ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
				|| ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
				|| ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
			return true;
		}
		return false;
	}
	
	/**
	 * Test a char is ASCII code
	 * 
	 * @param c
	 * @return
	 */
	private final static boolean isAscii(char c) {
		if (c < 128 && c > 0)
			return true;
		return false;
	}
	
	public final static boolean isAllChinese(String strName) {
		char[] ch = strName.toCharArray();
		for (int i = 0; i < ch.length; i++)
			if (!isChinese(ch[i]) && !isAscii(ch[i]))
				return false;
		return true;
	}
	
	/**
	 * 将一个字符串转为int类型
	 * @param String
	 * @return int
	 */
	public static long StringToInt(String str){
		return new BigInteger(str).longValue();
	}
	
	/**
	 * 将一个十进制整数转为16进制的字符串
	 * @param int
	 * @return String
	 */
	public static String intToHex(long integer){
		return Long.toHexString(integer);
	}
	
	
	
}
