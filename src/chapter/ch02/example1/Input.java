package chapter.ch02.example1;

import java.util.Date;

//import java.io.Console;
//import java.util.Scanner;

public class Input {

	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		String nameString = in.next();
//		System.out.println(nameString);

//		Console con = System.console();
//		String username = con.readLine("username:");
//		char []passwd = con.readPassword("password:");
//		System.out.println(username+":"+passwd.toString());
		System.out.printf("%,.2f",10000/3.0);
		System.out.println();
		System.out.printf("%tc", new Date());
		System.out.println();
		System.out.printf("%tF", new Date());
		System.out.println();
		System.out.printf("%tD", new Date());
		System.out.println();
		System.out.printf("%tT", new Date());
		System.out.println();
		System.out.printf("%tr", new Date());
	}

}
