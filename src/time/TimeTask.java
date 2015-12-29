/**
 *
 * @author : liuxiaoqiang
 * @date   :Dec 29, 2015 4:23:34 PM 
 * @version 1.0 
 *
 */
package time;

import java.util.Timer;
import java.util.TimerTask;

public class TimeTask {
	public static void main(String []args){
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("Hello!!!!");
			}
		};
		Timer timer = new Timer();
		long delay = 0;
		long intervalPeroid = 1*1000;
		timer.scheduleAtFixedRate(task, delay, intervalPeroid);
	}
}
