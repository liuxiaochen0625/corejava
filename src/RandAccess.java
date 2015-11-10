import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author : liuxiaoqiang
 * @date   :Nov 2, 2015 9:47:52 AM 
 * @version 1.0 
 *
 */

public class RandAccess {

	public static void main(String[] args) throws IOException {
		RandomAccessFile rf = new RandomAccessFile("rtest.txt", "rw");
		for (int i = 0; i < 10; i++) {
			//写入基本类型double数据
			rf.writeDouble(i * 1.414);
		}
		rf.close();
		rf = new RandomAccessFile("rtest.txt", "rw");
		//直接将文件指针移到第5个double数据后面
		rf.seek(5 * 8);
		//覆盖第6个double数据
		rf.writeDouble(47.0001);
		rf.close();
		rf = new RandomAccessFile("rtest.txt", "r");
		for (int i = 0; i < 10; i++) {
			System.out.println("Value " + i + ": " + rf.readDouble());
		}
		rf.close();
				

	}

	//随机读取文件
	public static void readFileByRandomAccess(String fileName) {
		RandomAccessFile randomFile = null;
		try {
			System.out.println("随机读取一段文件内容：");
			// 打开一个随机访问文件流，按只读方式
			randomFile = new RandomAccessFile(fileName, "r");
			// 文件长度，字节数
			long fileLength = randomFile.length();
			// 读文件的起始位置
			int beginIndex = (fileLength > 4) ? 4 : 0;
			// 将读文件的开始位置移到beginIndex位置。
			randomFile.seek(beginIndex);
			byte[] bytes = new byte[10];
			int byteread = 0;
			// 一次读10个字节，如果文件内容不足10个字节，则读剩下的字节。
			// 将一次读取的字节数赋给byteread
			while ((byteread = randomFile.read(bytes)) != -1) {
				System.out.write(bytes, 0, byteread);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (randomFile != null) {
				try {
					randomFile.close();
				} catch (IOException e1) {
				}
			}
		}
	}
}
