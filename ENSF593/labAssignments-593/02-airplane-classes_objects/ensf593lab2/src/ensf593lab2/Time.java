package ensf593lab2;

public class Time {
	private int hours, minutes, seconds;
	/** 
	 * default constructor
	 */
	public Time() {}
	/**
	 * constructor for a specified time (in seconds)
	 * @param totalTime time in seconds
	 */
	public Time(int totalTime) {
		increment(totalTime);	
	}
	/**
	 * Increments time by specified delta
	 * @param deltaT change in time (s)
	 */
	public void increment(int deltaT) {
		int beforeIncrement = this.seconds;
		this.seconds = (deltaT + this.seconds) % 60;
		deltaT = (int) Math.floor((double) (deltaT + beforeIncrement - this.seconds)/60);
		
		if (deltaT  == 0) {return;}
		beforeIncrement = this.minutes;
		this.minutes = (deltaT + this.minutes) % 60;
		deltaT = (int) Math.floor((double) (deltaT + beforeIncrement- this.minutes)/60);
		this.hours = (deltaT + this.hours);	
	}
	/**
	 * returns total seconds
	 * @return total seconds
	 */
	public int calculateTotalSeconds() {
		return ((this.hours) * 60 + this.minutes) * 60 + this.seconds;
	}
	
	/**
	 * returns time string
	 */
	public String toString() {
		return this.hours + "h:" + this.minutes + "m:"+ this.seconds + "s";
	}
	/**
	 * getter for house
	 * @return hours 
	 */
	public int getHours() {
		return hours;
	}
	/**
	 * setter for hours
	 * @param hours 
	 */
	public void setHours(int hours) {
		this.hours = hours;
	}
	/**
	 * getter for minutes
	 * @return minutes
	 */
	public int getMinutes() {
		return minutes;
	}
	/**
	 * setter for minutes
	 * @param minutes minutes
	 */
	public void setMinutes(int minutes) {
		if(minutes >=0 && minutes < 60) {
			this.minutes = minutes;
		} else {
			System.out.println("Entry out of range.");
		}
	}
	/**
	 * getter for seconds
	 * @return seconds
	 */
	public int getSeconds() {
		return seconds;
	}
	/**
	 * setter for seconds
	 * @param seconds seconds
	 */
	public void setSeconds(int seconds) {
		if(seconds >=0 && seconds < 60) {
			this.seconds = seconds;
		} else {
			System.out.println("Entry out of range.");
		}
	}
	

}
