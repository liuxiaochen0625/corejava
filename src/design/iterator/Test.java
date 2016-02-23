/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 23, 2016 4:41:25 PM 
 * @version 1.0 
 *
 */
package design.iterator;

public class Test {

	public static void main(String[] args) {
		Collection collection = new MyCollection();  
        Iterator it = collection.iterators();  
        while(it.hasNext())
            System.out.println(it.next());  
	}

}
