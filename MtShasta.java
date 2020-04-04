import java.util.Random;
import java.util.Scanner;

/*
 * Mt. Shasta Ski Simulator
 * 
 * Sam Platt
 * 4 April 2020
 * 
 * MtShasta.java
 */

public class MtShasta {
	
	String s;
	
	public String skiierName;
	
	public int skill;
	public int totalRuns;
	public int totalGreenRuns;
	public int totalBlueRuns;
	public int totalBlackDiamondRuns;
	
	// Runs
	
	public static Run blueGrouse = new Run("Blue Grouse", "green");
	public static Run challenge = new Run("Challenge", "blue");
	public static Run freshAire = new Run("Fresh Aire", "green");
	public static Run pantherGreenway = new Run("Panther Greenway", "green");
	public static Run snowShoe = new Run("Snow Shoe", "blue");
	public static Run telemark = new Run("Telemark", "blue");
	public static Run wintunWay = new Run("Wintun Way", "green");
	
	// Arrays of Options from the Lodge
	
	public static String[] optionsFromLodge = new String[2];
	
	// Arrays of Runs that Originate at Chair Lifts
	
	public static Run[] optionsFromMarmotChair = new Run[4];
	
	// Arrays of Runs that Originate at the Terminus of Runs
	
	public static Run[] optionsFromFreshAire = new Run[4];
	public static Run[] optionsFromMidniteSun = new Run[2];
	public static Run[] optionsFromSnowShoe = new Run[2];
	public static Run[] optionsFromTelemark = new Run[2];
	
	private static Scanner scan = new Scanner(System.in);
	
	public MtShasta(String skiierName) {
		
		this.skiierName = skiierName;
		
		totalRuns = 0;
		totalGreenRuns = 0;
		totalBlueRuns = 0;
		totalBlackDiamondRuns = 0;
		
	}
	
	public void ski() {
		
		optionsFromLodge[0] = "I'm done skiing for the day";
 		optionsFromLodge[1] = "Take Marmot Chair Lift";
		
		optionsFromMarmotChair[1] = blueGrouse;
		optionsFromMarmotChair[2] = freshAire;
		optionsFromMarmotChair[3] = telemark;
		
		optionsFromFreshAire[1] = challenge;
		optionsFromFreshAire[2] = snowShoe;
		optionsFromFreshAire[3] = wintunWay;
		
		optionsFromMidniteSun[1] = wintunWay;
		
		optionsFromSnowShoe[1] = pantherGreenway;
		
		optionsFromTelemark[1] = pantherGreenway;
		
		do {
		
			// Print Options;
			
			System.out.println("\n" + skiierName + ", what would you like to do now?");
			
			for(int i = 0; i < optionsFromLodge.length; i++) {
				
				System.out.println(i + "\t" + optionsFromLodge[i]);
				
			}
			
			// Allow User to Pick an Option
			
			s = scan.nextLine();
			
			// Do Action Based on Selection
			
			if(s.equals("0")) {
				
				System.out.println(statsToString());
				System.out.println(detailedStatsToString());
				System.out.println("\nThank you for visiting Mt. Shasta!");
				
			}
			else if(s.equals("1")) {
				
				pickFromMarmot();
				
			} else {
				
				System.out.println("\nSorry, that is not a valid option.");
				
			}
		
		} while(!(s.equals("0")));
		
	}
	
	public void pickFromMarmot() {
		
		System.out.println("\n" + skiierName + ", which run would you like to ski?");
		
		for(int i = 1; i < optionsFromMarmotChair.length; i++) {
			
			System.out.println(i + "\t" + optionsFromMarmotChair[i].getRunName() + " " + optionsFromMarmotChair[i].getRunLevel());
			
		}
		
		// Allow User to Pick an Option
		
		s = scan.nextLine();
		
		if(s.equals("1")) { // Blue Grouse
			
			skiRun(optionsFromMarmotChair[1]);
			
		} else if(s.equals("2")) { // Fresh Aire
			
			skiRun(optionsFromMarmotChair[2]);
			
			pickFromFreshAire();
		
		} else if(s.equals("3")) { // Telemark
			
			skiRun(optionsFromMarmotChair[3]);
			
			pickFromTelemark();
		
		} else {
			
			System.out.println("\nSorry, that is not a valid option.");
			
		}
		
	}
	
	public void pickFromFreshAire() {
		
		System.out.println("\n" + skiierName + ", which run would you like to ski?");
		
		for(int i = 1; i < optionsFromFreshAire.length; i++) {
			
			System.out.println(i + "\t" + optionsFromFreshAire[i].getRunName() + " " + optionsFromFreshAire[i].getRunLevel());
			
		}
		
		// Allow User to Pick an Option
		
		s = scan.nextLine();
				
		if(s.equals("1")) { // Challenge
			
			skiRun(optionsFromFreshAire[1]);
					
		} else if(s.equals("2")) { // Snow Shoe
			
			skiRun(optionsFromFreshAire[2]);
			
		} else if(s.equals("3")) { // Wintun Way
			
			skiRun(optionsFromFreshAire[3]);
			
		} else {	
			
			System.out.println("\nSorry, that is not a valid option.");
			
		}
		
	}
	
	public void pickFromMidniteSun() {
		
		System.out.println("\n" + skiierName + ", which run would you like to ski?");
		
		// Print Out the Options
		
		for(int i = 1; i < optionsFromMidniteSun.length; i++) {
			
			System.out.println(i + "\t" + optionsFromMidniteSun[i].getRunName() + " " + optionsFromMidniteSun[i].getRunLevel());
			
		}
		
		// Allow User to Pick an Option
		
		s = scan.nextLine();
				
		if(s.equals("1")) { // Wintun Way
			
			skiRun(optionsFromMidniteSun[1]);
					
		} else {
			
			System.out.println("\nSorry, that is not a valid option.");
				
		}
	}
	
	public void pickFromSnowShoe() {
		
		System.out.println("\n" + skiierName + ", which run would you like to ski?");
		
		for(int i = 1; i < optionsFromSnowShoe.length; i++) {
			
			System.out.println(i + "\t" + optionsFromSnowShoe[i].getRunName() + " " + optionsFromSnowShoe[i].getRunLevel());
		}
		
		// Allow User to Pick an Option
		
		s = scan.nextLine();
				
		if(s.equals("1")) { // Panther Greenway
			
			skiRun(optionsFromSnowShoe[1]);
					
		} else {
			
			System.out.println("\nSorry, that is not a valid option.");
		}
		
	}
	
	public void pickFromTelemark() {
		
		System.out.println("\n" + skiierName + ", which run would you like to ski?");
		
		// Print Out the Options
		
		for(int i = 1; i < optionsFromTelemark.length; i++) {
			
			System.out.println(i + "\t" + optionsFromTelemark[i].getRunName() + " " + optionsFromTelemark[i].getRunLevel());
		
		}
		
		// Allow User to Pick an Option
		
		s = scan.nextLine();
				
		if(s.equals("1")) { // Panther Greenway
			
			skiRun(optionsFromTelemark[1]);
					
		} else {
			
			System.out.println("\nSorry, that is not a valid option.");
			
		}
		
	}
	
	/*
	 * Lets the user ski a run.
	 */
	public void skiRun(Run run) {
		
		int chanceOfNoFall;
		
		if(run.getRunLevel().equals("green")) {
			
			totalRuns += 1;
			totalGreenRuns +=1;
			
			chanceOfNoFall = (int)(skill / 1);
			
			skill += 1;
			
		} else if(run.getRunLevel().equals("blue")) {
			
			totalRuns += 1;
			totalBlueRuns +=1;
			
			chanceOfNoFall = (int)(skill / 1.5);
			
			skill += 2;
			
		} else if(run.getRunLevel().equals("black diamond")) {
			
			totalRuns += 1;
			totalBlackDiamondRuns += 1;
			
			chanceOfNoFall = (int)(skill / 3);
			
			skill += 3;
			
		}
		
		System.out.println("\nCongratulations on skiing " + run.getRunName() + ", " + skiierName + "!");
		System.out.println(statsToString());
		
	}
	
	/*
	 * Returns basic stats about the skiier's day as a String;
	 */
	public String statsToString() {
		
		String stats = "\nTotal Runs: " + totalRuns + "\nSkill Points: " + skill;
		
		return stats;
		
	}
	
	/*
	 * Returns more detailed stats about the runs the skiier has skiied as a String;
	 */
	public String detailedStatsToString() {
		
		String stats = "\nTotal Green Runs: " + totalGreenRuns + "\nTotalBlueRuns: " + totalBlueRuns + "\nTotal Black Diamond Runs: " + totalBlackDiamondRuns;
		
		return stats;
		
	}
	
}
