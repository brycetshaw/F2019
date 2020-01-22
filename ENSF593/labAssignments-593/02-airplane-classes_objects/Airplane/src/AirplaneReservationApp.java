import java.util.Scanner;

public class AirplaneReservationApp {
	public static void main(String[] args) {

		int numOfRows = 10;
		Airplane a1 = new Airplane(numOfRows);
		mainMenu(a1);
		
	
	}
	
	 public static void mainMenu(Airplane plane) {
		 
		 boolean loopSet = true;
		 while(loopSet) {
			 String answer = "";
			 answer = getInput("Welcome to the ENSF 593 airlines booking backend! \n\n"
					 + "What would you like to do today? \n"
					 + "1: Add passenger(s) \n"
					 + "2: Remove passenger \n"
					 + "3: Search for passenger\n"
					 + "4: Print Seat map\n"
					 + "5: Print Flight Roster\n"
					 + "6: Quit \n");
			 loopSet = caseSelector(answer, plane);	 
		 }
	 }
	 
	 private static boolean caseSelector(String answer, Airplane plane) {
		 switch(answer)
		 {
		 case "1":
			 fillUpPlane(plane);
			 return true;

		 case "2":
			 answer = getInput("Who would you like to remove?");
			 plane.removePassenger(answer, true);
			 promptForEnter();
			 return true;

		 case "3":
			 answer = getInput("Who would you like to search for?");
			 plane.searchForPassenger(answer);
			 promptForEnter();
			 return true;

		 case "4":
			 plane.showSeatMap();
			 promptForEnter();
			 return true;
		 case "5":
			 plane.printRoster();
			 promptForEnter();
			 return true;
		 case "6":
			 
		 }	
		 return false; 
	 }
	 

	 
	/**
	 * Opens loop to input passengers
	 * Passengers must be input one at a time
	 * to unique seats. 
	 * 
	 */
	private static void fillUpPlane(Airplane plane) {
		 System.out.println("Enter your inputs in the form: name | xpoint | ypoint \n Type quit when done. \n"); 
		 while (true) { 
			 String [] answer = new String[3]; 
			 answer[0] = getInput("Name:");
			 if (answer[0].toUpperCase().equals("QUIT"))
				 break; 
			answer[1] = getInput("Row:");
			answer[2] = getInput("seat:");

			 if(checkValidResponse(answer) && plane.addPassenger(answer[0], Integer.parseInt(answer[1]), answer[2].toUpperCase().charAt(0))) {
				 System.out.println("Passenger added. Add next or type 'quit'.");
			 } else {
				 System.out.println("Passenger was not added. Add next or type 'quit'.");
			 }
		 }
	  }

	
	private static boolean checkValidResponse(String [] answer) {
		if(answer[0].length() < 1 || answer[1].length() < 1 || answer[2].length() < 1) {
			return false;
		}
		try { 
				Integer.parseInt(answer[1]);  
		    } catch(NumberFormatException e) { 
		        return false; 
		    } catch(NullPointerException e) {
		        return false;
		    }
		    // only got here if we didn't return false
		    return true;
	}
	


	private static void promptForEnter() {
		System.out.println("press ENTER to contine");
		Scanner scan = new Scanner(System.in); 
		scan.nextLine(); 
		//scan.close();
	}
	
	private static String getInput(String prompt) {
		System.out.println(prompt);
		String answer = ""; 
		Scanner scan = new Scanner(System.in); 
		answer = scan.nextLine(); 
		//scan.close();
		return answer; 
	}
	


	
}

