/**
 *
 * @author : liuxiaoqiang
 * @date   :Apr 11, 2016 9:34:48 AM 
 * @version 1.0 
 *
 */
package set.list.arraylist;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListDemo {
    public static void main(String[] args) {
        List<String> arrList=new ArrayList<String>();
        
        arrList.add("a");
        arrList.add("b");
        arrList.add("c");
        arrList.add("c");
        arrList.add("d");

        //使用Iterator输出集合
        Iterator<String> iter=arrList.iterator();
        while(iter.hasNext())
        {
            System.out.print(iter.next()+" ");
        }
        System.out.println();
        //使用For Each输出结合
        for(String e:arrList)
        {
            System.out.print(e+" ");
        }
        System.out.println();
        
        //使用toString输出集合
        System.out.println(arrList);
    }
}
