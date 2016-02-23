/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 23, 2016 5:19:36 PM 
 * @version 1.0 
 *
 */
package design.memento;

public class Storage {
	private Memento memento;
	public Storage (Memento memento) {
		this.memento = memento;
	}
	public Memento getMemento() {
		return memento;
	}
	public void setMemento(Memento memento) {
		this.memento = memento;
	}
	
	public static void main(String[] args) { 
		Original original = new Original("original");
		Storage storage = new Storage(original.createMemento());
		
		// 修改原始类的状态  
        System.out.println("初始化状态为：" + original.getValue());  
        original.setValue("niu");  
        System.out.println("修改后的状态为：" + original.getValue());  
  
        // 回复原始类的状态  
        original.restoreMemento(storage.getMemento());  
        System.out.println("恢复后的状态为：" + original.getValue()); 
	}
}
