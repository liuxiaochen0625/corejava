/**
 *
 * @author : liuxiaoqiang
 * @date   :Jan 28, 2016 3:53:56 PM 
 * @version 1.0 
 *
 */
package model;

import java.util.Date;

import interfaces.NeedToJson;

public class Person implements NeedToJson{
	public volatile static int count = 1;
	private String name = "JSON";
	private Integer age = 21;
	private Date date = new Date();
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Person(){
		count++;
	}
	public Person(String name, Integer age){
		this.name = name;
		this.age = age;
		count++;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString(){
		return "[name = "+ name +","+ " age = " + age + "]";
	}
	
	public int getInt(){
		return count;
	}
}
