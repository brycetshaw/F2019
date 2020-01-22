package ensf593lab2;

import java.util.Scanner;
public class RunCockpit {
	
	

	public static void main(String [] args)
	{
		int x_source = 50;  // the x-coordinate of source airport in miles  
		int y_source = 50;  // the y-coordinate of source airport in miles
		int x_dest = 2000;  // the x-coordinate of source airport in miles 
		int y_dest = 2000;  // the y-coordinate of source airport in miles
		final int max_interval = 10;
		
		// Calls the constructor of class Point to create two instances of this class
		Point sourceAirport = new Point (x_source, y_source, "Calgary Airport");
		Point destinationAirport = new Point (x_dest, y_dest, "Toronto Airport");
		
		String flightNumber = "CYC 1888";  
		
		// Calls the constructor of class Cockpit to create an instance of this class
		Cockpit cp = new Cockpit (sourceAirport, destinationAirport, flightNumber);
		
		System.out.println("Flight number " + flightNumber + 
		               " is ready for departure ... \nFrom: ");
		System.out.println(sourceAirport.toString());
	    System.out.println("To: ");
	    System.out.println(destinationAirport.toString());
		
		System.out.println("Please Press ENTER/RETURN key to Take Off... ");
		Scanner scan = new Scanner(System.in); // Pauses the program, until user presses the ENTER key.
		scan.nextLine();

		cp.setCurrentLabel("On The Sky at"); 
		
		int i=0;	
		
		// Simulating the change of time and position of the aircraft with some 
		// arbitrary numbers.
		while(i < max_interval)
		{
			// simulates the change in the aircraft's speed 
			if(i % 2 != 0){
				cp.moveForward(170+i, 170+i);    // change the aircraft's position
				cp.setElapsedTime(1000);        // the passage of time
			}
			else {
				cp.moveForward(160+i, 160+i);   
				cp.setElapsedTime(1500);
			}
			cp.displayMonitor();             
			
			
			 // call to the library function sleep to create few seconds delay
			  // in the execution of the program and giving the impression of 
			   // the passage of time.
				  try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			i++;
		}
		System.out.println();
		System.out.println("Arrived to the destination. ");
		System.out.println();
		System.out.println("Please Press ENTER/RETURN key to Stop.");
		scan.nextLine();
		//cin.get(); // Pauses the program, until user presses the ENTER/RETURN key.
		scan.close();
	}

}
