/**
 *
 * @author : liuxiaoqiang
 * @date   :Jan 29, 2016 4:03:38 PM 
 * @version 1.0 
 *
 */
package core;

public class CloneableBaseObject extends BaseObject implements Cloneable{
	
	@Override
	public BaseObject clone(){
		BaseObject obj = null;
		try {
			obj = (BaseObject)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		obj.setObjectId(0L);
		return obj;
	}
}
