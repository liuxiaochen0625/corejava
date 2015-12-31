/**
 *
 * @author : liuxiaoqiang
 * @date   :Dec 31, 2015 2:55:20 PM 
 * @version 1.0 
 *
 */
package multithread.threadlocal;

/** 
* 测试Bean 
* 
* @author leizhimin 2010-1-5 14:18:26 
*/ 
public class Bean { 
        private String id = "0"; 
        private String name = "none"; 

        public Bean() { 
        } 

        public Bean(String id, String name) { 
                this.id = id; 
                this.name = name; 
        } 

        public String getId() { 
                return id; 
        } 

        public void setId(String id) { 
                this.id = id; 
        } 

        public String getName() { 
                return name; 
        } 

        public void setName(String name) { 
                this.name = name; 
        } 

        public String showinfo() { 
                return "Bean{" + 
                                "id='" + id + '\'' + 
                                ", name='" + name + '\'' + 
                                '}'; 
        } 
}
