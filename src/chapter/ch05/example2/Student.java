package chapter.ch05.example2;

public class Student extends Person{

	private String major;
	public Student(String name,String major) {
		super(name);
		this.major = major;
	}

	public static void main(String[] args) {
		Person []person = new Person[2];
		person[0] = new Student("Harry", "computer science");
		person[1] = new Employee("maric", 5000, 1994, 6, 18);
		for(Person p:person)
			System.out.println(p.getName()+" "+p.getDescription());
	}

	@Override
	public String getDescription() {
		return "a student major in" + major;
	}

}
