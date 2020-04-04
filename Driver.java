import java.util.Scanner;

/*
 * Mt. Shasta Ski Simulator
 * 
 * Sam Platt
 * 4 April 2020
 * 
 * Driver.java
 */

public class Driver {
	
	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Hello, welcome to Mt. Shasta! What's your name?");
		
		String s = scan.nextLine();
		
		MtShasta skiier = new MtShasta(s);
		
		skiier.ski();
		
	}
	
}
