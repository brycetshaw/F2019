
public class Position {
	private int row;
	private char seat;
	
	
	/**
	 * Returns Row number as integer
	 * @return row number, integer
	 */
	public int getRow() {
		return row;
	}
	

	
	/**
	 * Set row for position object.
	 * @param row integer from 1 to the plane size
	 */
	public void setRow(int row) {
		this.row = row;
	}
	
	/**
	 * 
	 * @return
	 */
	public char getSeat() {
		return seat;
	}
	
	/**
	 * specifies Seat location as a character
	 * @param row (Character from A to E)
	 */
	public void setSeat(char seat) {
		this.seat = seat;
	}
	
	/**
	 * Constructor to initialize row and seat at the same time
	 * @param row integer from 1 to the size of the plane
	 * @param seat char from A to E
	 */
	public Position(int row, char seat) {
		setRow(row);
		setSeat(seat);
	}
	
	/**
	 * Constructor to create a position from another position. 
	 * not that useful unless you wanted to over load seats I guess
	 * @param p position (has row and seat)
	 */
	public Position(Position p) {
	if( p != null) {
		setRow(p.row);
			setSeat(p.seat);
		}
	}
	/**
	 * returns row and seat, with a space added in to make the output fixed width and pretty. 
	 * @return seat address as string.
	 */
	public String toString() {
		String convertRow = Integer.toString(this.row + 1);
		String gap = (convertRow.length() > 1) ? " " : "  ";
		return " " + convertRow +  this.seat + gap;
	}

}
