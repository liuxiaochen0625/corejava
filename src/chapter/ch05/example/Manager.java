package chapter.ch05.example;

import chapter.ch04.example.Employee;

public class Manager extends Employee{
	private double bouns;

	public double getBouns() {
		return bouns;
	}

	public void setBouns(double bouns) {
		this.bouns = bouns;
	}

	public Manager(String name, double salary, int year, int month, int day) {
		super(name, salary, year, month, day);
		bouns = 0.0;
	}

	public double getSalary(){
		return super.getSalary()+bouns;
	}
	
	public boolean equals(Object otherObject){
		if(!super.equals(otherObject))
			return false;
		Manager other = (Manager)otherObject;
		return bouns == other.bouns;
	}
	
	public int hashCode(){
		return super.hashCode()+17*new Double(bouns).hashCode();
	}
	
	public String toString(){
		return super.toString()+"[bouns="+bouns+"]";
	}
	
	public static void main(String args[]){
		Manager boss = new Manager("Carl", 80000, 1987, 12, 15);
		Employee []staff = new Employee[3];
		staff[0] = boss;
		boss.setBouns(5000);
		staff[1] = new Employee("Harry", 50000, 1989, 1, 4);
		staff[2] = new Employee("Tony", 40000, 1989, 6, 8);
		
		for(Employee s:staff)
			System.out.println(s.toString());
		
	}
}
