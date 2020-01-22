



public class Airplane {
	private Passenger [] passArray;
	private char [][] seatMap;
	private int numOfPassengers;
	private final int numOfRows;
	
	//This program would be much easier using array lists. I should learn this. 
	
	

	
	/**
	 * Constructor for the object. 
	 * initializes an airplane with specified number of rows. 
	 * 
	 * 
	 * @param row number of rows in the airplane. 
	 */
	public Airplane(int row) {

	
		setNumOfPassengers (0);
		numOfRows = row;
		seatMap = new char [row][5]; //assuming 5 seats per row
		populateSeatMap();
		this.passArray = new Passenger[0];
	}

	private void populateSeatMap() {
	
		for (int i = 0; i < seatMap.length; i++) {
			for(int j = 0; j < seatMap[i].length; j++) {
				seatMap[i][j] = 'O';
			}
		}
		
	}
	
	/**
	 * Adds a passenger to the plane, if seat is available. 
	 * @param name Passenger name
	 * @param row requested row
	 * @param seat requested seat
	 * @return returns true if passenger was added successfully
	 */
	public boolean addPassenger(String name, int row, char seat) {
		if(checkAvailability(row-1, seat)) {
			Passenger newPass = new Passenger(name, row-1, seat);
			appendPassArray(newPass);
			markSeatMap(newPass.getAssignedSeat(), 'X');
			incrementNumofPassengers(1);
			return true;
		}
		return false;
	}
	
	
	private void markSeatMap(Position pos, char mark) {
		this.seatMap[pos.getRow()][Character.getNumericValue(pos.getSeat())-Character.getNumericValue('a')] = mark;
	}
	
	
	private void incrementNumofPassengers(int increment) {
		numOfPassengers += increment;
	}
	
	private boolean checkAvailability(int row, char seat) {
		
		if ((row >= this.numOfRows)|| (row < 0)) {
			return false;
		}
		if ((seat > 'E')||(seat < 'A')) {
			return false;
		}
		if (seatMap[row][Character.getNumericValue(seat)-Character.getNumericValue('a')] == 'O') {
			return true;
		}
		return false;
	}
	

	/**
	 * Removes a passenger from the plane. Input is passenger name. 
	 * Case and whitespace sensitive.
	 * 
	 * @param name Passenger name to be removed. 
	 * @param dispOut verbose flag to notify on success of operation
	 */
	 public void removePassenger(String name, boolean dispOut) {
		 int passIndex = searchForPassenger(name,false);
		 if(passIndex == -1) {
			 if(dispOut) {System.out.println("Passenger not found");}
			 return;
		 }
		 markSeatMap(passArray[passIndex].getAssignedSeat(), 'O');
		 removePassArrayElement(passIndex);
		 incrementNumofPassengers(-1);
		 if(dispOut) {System.out.println("Passenger removed.");}
	 }
	 
	 private void removePassArrayElement(int passIndex) {
		 Passenger [] newPassArray = new Passenger[passArray.length - 1];
		 int removeFlag = 0;
		 for(int i = 0; i < newPassArray.length; i++) {
			 if(i == passIndex)
				 removeFlag = 1;
			 newPassArray[i] = passArray[i+removeFlag];
		 }
		 passArray = newPassArray;
	 }
	 
	 /**
	  * Prints the seat list of the flight
	  */
	 public void printRoster() {
		 System.out.println(toString());
		 for (int i = 0; i< passArray.length; i++) {
			 System.out.println(passArray[i]);
		 }
	 }
	 
	 /**
	  * Allows a search for a passenger name (case and whitespace sensitive)
	  *  Displays the name and seat if the passenger is present in the roster.
	  *  Displays a failed to find message if search fails
	  * @param name roster query
	  */
	 public void searchForPassenger(String name) {
		 searchForPassenger(name, true);
	 }
	 
	 private int searchForPassenger(String name, boolean dispOut) {
		 
		 for(int i = 0; i < passArray.length; i++) {
			 if (name.equals(passArray[i].getName())) {
				 if(dispOut) {
					 System.out.println(passArray[i]);
				 }
				 return i;
			 }
		 }
		 if(dispOut) {
			 System.out.println("Passenger not found");			 
		 }
		 return -1;
	 }
	 

	private void setNumOfPassengers(int numOfPassengers) {
		this.numOfPassengers = numOfPassengers;
	}


	private void appendPassArray(Passenger newPassenger) {
		Passenger [] newPassArray = new Passenger[passArray.length + 1];
		for(int i = 0; i < newPassArray.length; i++) {
			if (i < newPassArray.length - 1) {
				newPassArray[i] = this.passArray[i];
			} else {
				newPassArray[i] = new Passenger(newPassenger.getName(), newPassenger.getAssignedSeat());
				passArray = newPassArray;
			}
		}
	}
	
	/**
	 * @return Outputs number of seats {@link #numOfPassengers} out of 
	 * total seats available {@link #numOfRows}*5
	 */
	public String toString() {
		String message = Integer.toString(this.numOfPassengers) + " of " + Integer.toString(this.numOfRows * 5) + " seats full";
		return message; 
	}
	
	
	/**
	 * Prints a map of the airplane seats. 
	 */
	public void showSeatMap() {
		String message = "";
		for (int i = 0; i< this.numOfRows; i++) {
			for(int j =0; j < this.seatMap[i].length; j++) {
				message += this.seatMap[i][j] + " ";
			}
			message += '\n';
		}
		System.out.println(message);
	}

}


