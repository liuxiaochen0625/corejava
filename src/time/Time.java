/**
 *
 * @author : liuxiaoqiang
 * @date   :Jan 18, 2016 4:26:11 PM 
 * @version 1.0 
 *
 */
package time;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class Time {
	public static void main(String []args){
		Timer timer = new Timer();
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 16);
		calendar.set(Calendar.MINUTE, 35);
		calendar.set(Calendar.SECOND, 0);
		//定时任务必须继承TimerTask类，并实现其中的run()方法
		//schedule中的三个参数分别为TimerTask任务，第一次执行的时间，最后一个参数是连续执行两次之间的时间间隔，其单位为毫秒
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("hello world");
				
			}
		}, calendar.getTime(), 2000);
	}
}
