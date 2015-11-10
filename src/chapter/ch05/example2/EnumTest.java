package chapter.ch05.example2;

import java.util.Scanner;

public class EnumTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a size:");
		String input = in.nextLine().toUpperCase();
		Size size = Enum.valueOf(Size.class, input);
		System.out.println("size = "+size);
		System.out.println(size.getAbbreviation());
		

	}
}

enum Size1
{
	SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");
	
	private String abbreviation;
	
	private Size1(String abbreviation){
		this.abbreviation = abbreviation;
	}
	
	public String getAbbreviation(){
		return abbreviation;
	}
}

enum Size
{
   SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");

   private Size(String abbreviation) { this.abbreviation = abbreviation; }
   public String getAbbreviation() { return abbreviation; }

   private String abbreviation;
}