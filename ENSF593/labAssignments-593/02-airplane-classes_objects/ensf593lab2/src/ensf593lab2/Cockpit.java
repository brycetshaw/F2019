package ensf593lab2;


import java.lang.Math;


public class Cockpit {
	
	private Point source;          // a point that represents the source airport 
	private Point destination;     // a point that represents the destination airport
	private Point currentPoint;   // the current position of the aircraft on land 
	                       // or in the sky. 
	private Time elapsedTime;     // total elapsed time since started travel from source
	String flightNumber;  // flight's identification number. 
	
	
	/**
	 * Constructor for the cockpit class. Takes in starting point, destination point and flight number identifier
	 * @param src Starting point (Point object)
	 * @param dest Destination point (Point object)
	 * @param fn Flight number (String)
	 */
	public Cockpit (Point src, Point dest, String fn) {
		this.source = new Point(src.getX(), src.getY(), src.getName());
	
		this.destination = new Point();
		this.destination = dest;
		
		this.flightNumber = fn;
		this.currentPoint = new Point(src.getX(), src.getY(), src.getName());
		
		this.elapsedTime = new Time();
	}
	
	
	/**
	 * Moves the plane current point in 2D space. 
	 * @param dx change in x
	 * @param dy Change in y 
	 */
	public void moveForward(double dx, double dy) {
	
		this.currentPoint.setX(dx + this.currentPoint.getX());
		this.currentPoint.setY(dy + this.currentPoint.getY());
		
	}
	
	/**
	 * Updates elapsed time 
	 * @param dt change in time since last update (seconds)
	 */
	public void setElapsedTime(int dt) {
		this.elapsedTime.increment(dt);
	
	}
	/**
	 * Calculated and returns average speed (miles per hr)
	 * @return average speed (miles per hour)
	 */
	private double averageSpeedCalculator() {
		// returns in units of miles / hour
		double timeElapsed = (double) this.elapsedTime.calculateTotalSeconds();
		double totalDistance = distanceIndicator(this.currentPoint, this.source);
		return totalDistance / timeElapsed * 60 * 60;
	}
	/**
	 * Calculates distance between two points, returns miles
	 * @param p1 point 1 coordinate
	 * @param p2 point 2 coordinate
	 * @return distance in miles
	 */
	private double distanceIndicator(Point p1, Point p2) {
		double distanceX = p1.getX() - p2.getX();
		double distanceY = p1.getY() - p2.getY();
		double distanceRemaining = Math.pow(Math.pow(distanceX, 2) + Math.pow(distanceY, 2), 0.5);
		return distanceRemaining;

	}
	/**
	 * estimates remaining travel time based on average speed and remaining distance
	 * @return Remaining Time in Time object
	 */
	private Time remainingTravelTime() {
		double averageSpeed = averageSpeedCalculator();
		double distanceRemaining = distanceIndicator(this.currentPoint, this.destination);
		System.out.println("average speed =" + averageSpeed + " distance Remaining = " + distanceRemaining);
		Time timeRemaining = new Time((int) Math.round(distanceRemaining / averageSpeed * 60 * 60)); // [miles] *
																										// [[miles]*[time]^-1]^-1
		return timeRemaining;
	}
	/**
	 * Returns string identifying vital flight status information
	 */
	public String toString() {
		return "Flight Number: "+ this.flightNumber + "\n Current Location: "+ this.currentPoint+ "\nCurrent Average speed: " + 
				String.valueOf(Math.round(averageSpeedCalculator()*100)/100) + " miles / hr \nElapsed Time: (" + this.elapsedTime + ")\n Remaining Time: (" + this.remainingTravelTime() + ") \n";
	}

	/*
	 * Displays flight information
	 */
	public void displayMonitor () {
		System.out.println(toString());

	}
	
	/**
	 * Allows changes to be made to flight number identifier
	 * @param new_label new flight identifier
	 */
	public void setCurrentLabel(String new_label) {
		currentPoint.setName(new_label);
	}

}
