/**
 *
 * @author : liuxiaoqiang
 * @date   :Apr 11, 2016 9:28:27 AM 
 * @version 1.0 
 *
 */
package set.hashset;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetDemo {

    public static void main(String[] args) {
        Set<String> set=new HashSet<String>();
        
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("c");
        set.add("d");
        
        //使用Iterator输出集合
        Iterator<String> iter=set.iterator();
        while(iter.hasNext())
        {
            System.out.print(iter.next()+" ");
        }
        System.out.println();
        //使用For Each输出结合
        for(String e:set)
        {
            System.out.print(e+" ");
        }
        System.out.println();
        
        //使用toString输出集合
        System.out.println(set);
    }
}
