package chapter.ch04.example;

public class EmployeeTest {
	public static void main(String []args){
		Employee staff[] = new Employee[3];
		staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 17);
		staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
		staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);
		
		for(Employee e:staff){
			e.raiseSalary(-5);
			e.setId();
		}
		for(Employee e:staff)
			System.out.println("id:"+e.getId()+" "+"name:"+e.getName()+","+"salary:"+e.getSalary()+","+"hireDay:"+e.getHireDay());
	}

}

