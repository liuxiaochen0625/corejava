/**
 *
 * @author : liuxiaoqiang
 * @date   :Feb 23, 2016 2:04:22 PM 
 * @version 1.0 
 *
 */
package design.facade;

public class Computer {
	private CPU cpu;
	private Memory memory;
	private Disk disk;
	
	public Computer(){
		cpu = new CPU();
		memory = new Memory();
		disk = new Disk();
	}
	
	public void startup(){
		System.out.println("start computer startup!");
		cpu.startup();
		memory.startup();
		disk.startup();
		System.out.println("computer startup finish!");
	}
	public void shutdown(){
		System.out.println("start computer shutdown!");
		cpu.shutdown();
		memory.shutdown();
		disk.shutdown();
		System.out.println("computer shutdown finish!");
	}
	
	public static void main(String []args){
		Computer computer = new Computer();
		computer.startup();
		computer.shutdown();
	}
}
