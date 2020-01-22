
public class Passenger {
	private String name;
	private Position assignedSeat;
	
	/**
	 * Class constructor to create a passenger and assign a seat.
	 * @param name passenger name (String, no restrictions)
	 * @param row Assigned row (1 < row <= number of rows in plane)
	 * @param seat Assigned seat. (A, B, C, D, or E)
	 */
	public Passenger(String name, int row, char seat) {
		this.setName(name);
		setAssignedSeat(new Position(row, seat));
	}
	
	/**
	 * Class constructor to create a passenger and assign a seat.
	 * @param name name passenger name (String, no restrictions)
	 * @param assignedSeat Position object with a valid seat address
	 */
	public Passenger(String name, Position assignedSeat) {
		this.setName(name);
		this.setAssignedSeat(new Position(assignedSeat));
	}
	
	
	/**
	 * Returns the name associated with the seat. 
	 * @return Booking name (String)
	 */
	public String getName() {
		return name;
	}
	
	
	private void setName(String name) {
		this.name = name;
	}
	/**
	 * Returns seat address in a position object.
	 * @return seat object to identify row and Seat address
	 */
	public Position getAssignedSeat() {
		return assignedSeat;
	}
	
	/**
	 * Assigned a seat to a booking.
	 * @param assignedSeat seat object to identify row and Seat address
	 */
	public void setAssignedSeat(Position assignedSeat) {
		this.assignedSeat = assignedSeat;
	}
	/**
	 * Identifies seat address and the associated name. 
	 * @return seat address and name as String. 
	 */
	public String toString() {
		return assignedSeat + " " + this.name ;
	}
}
