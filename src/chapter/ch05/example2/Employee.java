package chapter.ch05.example2;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

public class Employee extends Person{
	private static int nextId = 1;
	private int id;
	private double salary;
	private Date hireDay;
	
	public Employee(String name,double salary,int year,int month,int day){
		super(name);
		this.salary = salary;
		
		GregorianCalendar gc = new GregorianCalendar(year,month-1,day);
		hireDay = gc.getTime();
		id = 0;
	}


	public double getSalary() {
		return salary;
	}

	public Date getHireDay() {
		return (Date) hireDay.clone();
	}
	
	public int getId(){
		return id;
	}
	
	public void setId(){
		id = nextId;
		nextId++;
	}
	
	public void raiseSalary(double byPercent){
		double raise = salary*byPercent/100;
		salary += raise;
	}

	@Override
	public String getDescription() {
		
		return String.format("an employee whit a salary of $%.2f", salary);
	}
	
	public int hashCode(){
		return Objects.hashCode(getName());
	}
	
}
