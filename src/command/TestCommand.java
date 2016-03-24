/**
 *
 * @author : liuxiaoqiang
 * @date   :Mar 23, 2016 3:28:00 PM 
 * @version 1.0 
 *
 */
package command;

public class TestCommand {
	public static void main(String[] args) {
		Runtime runtime = Runtime.getRuntime();
		Process process = null;
		String command = "D:\\tools\\name.bat";
		try {
			process = runtime.exec(command);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(process.getOutputStream().toString());
	}
}
