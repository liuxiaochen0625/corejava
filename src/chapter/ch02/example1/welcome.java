package chapter.ch02.example1;

public class welcome {
	public static void main(String arg[]){
		String []greeting = new String[3];
		greeting[0] = "Welcome to Core Java";
		greeting[1] = "hello";
		greeting[2] = "world!";
		
		for(String str:greeting)
			System.out.println(str);
	}

}
