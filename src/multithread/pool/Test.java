/**
 *
 * @author : liuxiaoqiang
 * @date   :Mar 23, 2016 1:33:44 PM 
 * @version 1.0 
 *
 */
package multithread.pool;
import java.util.concurrent.ExecutionException;
  
/** 
 * 线程池类，线程管理器：创建线程，执行任务，销毁线程，获取线程基本信息 
 */  
public class Test {
    public static void main(String[] args) throws InterruptedException, ExecutionException { 
    	//开十个线程 用来开线程 哈哈
    	for(int i=1;i<10;i++){
    	MyTask m2=new MyTask(i);
    	m2.start();
    	}
    }
}


class MyTask  extends Thread {
	   private int taskNum;
	    
	   public MyTask(int num) {
	       this.taskNum = num;
	   }
	   /**
	    * 拿到线程池
	    * */
	   public ThreadPool threadPool= ThreadPool.init();
	    @Override
	   public void run() {
	    	   for(int i=0;i<150;i++){
	           	MyTaskRun myTask = new MyTaskRun(taskNum+"--"+i+"  \n");
	           	//正题 
	           	threadPool.execute(myTask);
	               System.out.println("线程池中线程数目："+threadPool.getExecutor().getPoolSize()+"，队列中等待执行的任务数目："+
	            		   threadPool.getExecutor().getQueue().size()+"，已执行玩别的任务数目："+threadPool.getExecutor().getCompletedTaskCount());
	            }
	           System.out.println("ok--- 线程池中线程数目："+threadPool.getExecutor().getPoolSize()+"，队列中等待执行的任务数目："+
	        		   threadPool.getExecutor().getQueue().size()+"，已执行玩别的任务数目："+threadPool.getExecutor().getCompletedTaskCount());
	    }

	  
	}

class MyTaskRun  implements Runnable{
	   private String taskNum;
	    
	   public MyTaskRun(String num) {
	       this.taskNum = num;
	   }
	   /**
	    * 拿到线程池
	    * */
	   public ThreadPool threadPool= ThreadPool.init();
	   @SuppressWarnings("static-access")
	public void run() {
	       try {
	           Thread.currentThread().sleep(1000);
	       } catch (InterruptedException e) {
	           e.printStackTrace();
	       }
	       System.out.println(taskNum+"taskNum 线程池中线程数目 ："+threadPool.getExecutor().getPoolSize()+"，队列中等待执行的任务数目："+
	    		   threadPool.getExecutor().getQueue().size()+"，已执行玩别的任务数目："+threadPool.getExecutor().getCompletedTaskCount());
	   }

	}

