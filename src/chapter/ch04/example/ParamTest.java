package chapter.ch04.example;

public class ParamTest {

	public static void main(String[] args) {
		System.out.println("Testing tripValue:");
		double percent = 10;
		System.out.println("Before percent:"+percent);
		tripValue(percent);
		System.out.println("After percent:"+percent);
		
		System.out.println("Testing tripSalary:");
		Employee1 harry = new Employee1("Harry", 50000);
		System.out.println("Before salary:"+harry.getSalary());
		tripSalary(harry);
		System.out.println("After salary:"+harry.getSalary());
		
		System.out.println("Testing swap:");
		Employee1 a = new Employee1("Alice", 70000);
		Employee1 b = new Employee1("Bob", 60000);
		System.out.println("Before a="+a.getName());
		System.out.println("Before b="+b.getName());
		swap(a, b);
		System.out.println("After a="+a.getName());
		System.out.println("After b="+b.getName());

	}
	
	public static void tripValue(double x){
		x = 3*x;
		System.out.println("End of method: x="+x);
	}
	
	public static void tripSalary(Employee1 x){
		x.raiseSalary(200);
		System.out.println("End of method: salary="+x.getSalary());
	}
	
	public static void swap(Employee1 x,Employee1 y){
		Employee1 temp = x;
		x = y;
		y = temp;
		System.out.println("End of method: x="+x.getName());
		System.out.println("End of method: y="+y.getName());
	}

}

class Employee1{
	private String name;
	private double salary;
	public Employee1(String name,double salary){
		this.name = name;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void raiseSalary(double precent){
		double raise = salary*precent/100;
		salary += raise;
	}
}