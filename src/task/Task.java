/**
 *
 * @author : liuxiaoqiang
 * @date   :Jan 29, 2016 3:21:09 PM 
 * @version 1.0 
 *
 */
package task;

import java.io.Serializable;

import core.BaseObject;
import core.CloneableBaseObject;
import interfaces.Executor;

public abstract class Task extends CloneableBaseObject implements Executor,Runnable,Serializable{
	private static final long serialVersionUID = -4032014242597115227L;
	//静态常量
	static public final int STOPPED = -3;
	static public final int CANCELLED = -2;
	static public final int FAILED = -1;
	static public final int BEGAN = 0;
	static public final int STARTED = 1;
	static public final int COMPLETED = 2;
	
	//超时时间
	protected long timeout = 10*60*1000;
	
	protected volatile Integer retryCount = 0;
	
	private Long taskId;
	private Integer state = BEGAN;
	
	@Override
	public BaseObject clone(){
		return super.clone();
	}

	@Override
	public final void run() {
		synchronized (getState()) {
			if(getState() != BEGAN)
				return;
			try{
			setState(STARTED);
			exec();
			setState(COMPLETED);
			}catch(Exception e){
				e.printStackTrace();
				setState(FAILED);
			}
		}
	}

	public final Long getTaskId() {
		return taskId;
	}

	public final Task setTaskId(Long taskId) {
		this.taskId = taskId;
		return this;
	}

	public final Integer getState() {
		return state;
	}

	public final Task setState(Integer state) {
		this.state = state;
		return this;
	}

}
