package chapter.ch03.example;
import java.util.Scanner;

public class Retirement {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		System.out.println("How much money do you want to retire?");
		double goal = in.nextDouble();
		
		System.out.println("How much money wile you contribute every year?");
		double payment = in.nextDouble();
		
		System.out.println("Interest rate in%");
		double interest = in.nextDouble();
		
		double balance = 0;
		int year = 0;
		
		while(balance<goal){
			balance += payment;
			double intre = balance*interest/100;
			balance += intre;
			year++;
		}
		System.out.println("You can retire in "+year+" years.");
		

	}

}
