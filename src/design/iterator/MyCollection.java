/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 23, 2016 4:27:40 PM 
 * @version 1.0 
 *
 */
package design.iterator;

public class MyCollection implements Collection{

	public String string[] = new String[]{"A","B","C","D","E","F"};
	@Override
	public Iterator iterators() {
		return new MyIterator(this);
	}

	@Override
	public Object get(int i) {
		return string[i];
	}

	@Override
	public int size() {
		return string.length;
	}

}
