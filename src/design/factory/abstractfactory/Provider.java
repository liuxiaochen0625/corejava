/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 23, 2016 10:08:18 AM 
 * @version 1.0 
 *
 */
package design.factory.abstractfactory;

import design.factory.Sender;

public interface Provider {
	public Sender produce();
}
