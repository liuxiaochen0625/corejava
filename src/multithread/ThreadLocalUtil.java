/**
 *
 * @author : liuxiaoqiang
 * @date   :Dec 31, 2015 2:22:46 PM 
 * @version 1.0 
 *ThreadLocal和synchronized都是解决多线程的方法，ThreadLocal是实现数据的隔离，而synchronized是为了实现数据的同步。
 *
 */
package multithread;

import java.util.Random;

import model.Student;

public class ThreadLocalUtil implements Runnable{
	private final static ThreadLocal<Student> studentLocal = new ThreadLocal<Student>();
	public static void main(String[] args) {
		ThreadLocalUtil threadLocalUtil = new ThreadLocalUtil();
		Thread t1 = new Thread(threadLocalUtil,"a");
		Thread t2 = new Thread(threadLocalUtil,"b");
		t1.start();
		t2.start();
	}
	@Override
	public void run() {
		accessStudent();
	}

	public void accessStudent(){
		String currentThreadName = Thread.currentThread().getName();
		System.out.println(currentThreadName+" is running!");
		Random random = new Random();
		int age = random.nextInt(100);
		System.out.println("Thread "+currentThreadName+" is set age to " + age);
		Student student = getStudent();
		student.setAge(age);
		System.out.println("thread " + currentThreadName + " first read age is:" + student.getAge());
		try {
	            Thread.sleep(500);
	        }catch (InterruptedException ex) {
	            ex.printStackTrace();
	        }
	    System.out.println("thread " + currentThreadName + " second read age is:" + student.getAge());
	}
	
	public Student getStudent(){
		Student student = studentLocal.get();
		if(student == null){
			student = new Student();
			studentLocal.set(student);
		}
		return student;
	}
}
