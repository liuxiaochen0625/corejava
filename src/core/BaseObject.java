/**
 *
 * @author : liuxiaoqiang
 * @date   :Jan 29, 2016 3:42:03 PM 
 * @version 1.0 
 *
 */
package core;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BaseObject {
	protected transient Long objectId = 0L;

	public Long getObjectId() {
		return objectId;
	}

	public BaseObject setObjectId(Long objectId) {
		this.objectId = objectId;
		return this;
	}
	
	protected transient static Log log = LogFactory.getLog(BaseObject.class);
	
	protected static class Lock { };
	protected transient Lock lock = new Lock();
	
	protected void await(Long timeout){
		synchronized (lock) {
			try {
				lock.wait(timeout);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	protected void await(){
		synchronized (lock) {
			try {
				lock.wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	protected void signal(){
		synchronized (lock) {
			lock.notify();
		}
	}
	
	protected void signalAll(){
		synchronized (lock) {
			lock.notifyAll();
		}
	}
	
}
