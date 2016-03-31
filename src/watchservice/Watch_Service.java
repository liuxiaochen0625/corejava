/**
 *
 * @author : liuxiaoqiang
 * @date   :Mar 31, 2016 3:22:31 PM 
 * @version 1.0 
 *
 */
package watchservice;
import java.nio.file.FileSystems;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
/**
 * NIO.2的Path类提供了如下的一个方法来监听文件系统的变化。
 *  register(WatcherService watcher,WatchEvent.Kind<?>... events):用watcher监听该path代表的目录下文件变化。event参数指定要监听哪些类型的事件。
 *  WatchService有三个方法来监听目录的文件变化事件。
 *	WatchKey poll():获取下一个WatchKey，如果没有WatchKey发生就立即返回null；
 *	WatcheKey poll(long timeout,TimeUnit unit):尝试等待timeout时间去获取下一个WatchKey；
 *	WatchKey  take():获取下一个WatchKey，如果没有发生就一直等待；
 *	如果程序需要一直监控，则应该选择使用take()方法，如果程序只需要监控指定时间，则使用poll方法。
 * 
 */
public class Watch_Service {
	public static void main(String[] args) throws Exception
	{
		
		WatchService watchService=FileSystems.getDefault().newWatchService();
		Paths.get("C:/").register(watchService, 
				StandardWatchEventKinds.ENTRY_CREATE,
				StandardWatchEventKinds.ENTRY_DELETE,
				StandardWatchEventKinds.ENTRY_MODIFY);
		while(true)
		{
			WatchKey key=watchService.take();
			for(WatchEvent<?> event:key.pollEvents())
			{
				System.out.println(event.context()+"发生了"+event.kind()+"事件");
			}
			if(!key.reset())
			{
				break;
			}
		}
	}
}
