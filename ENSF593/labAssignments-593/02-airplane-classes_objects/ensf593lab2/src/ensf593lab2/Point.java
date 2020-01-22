package ensf593lab2;

public class Point {

	private double x, y;
	private String name;
	/**
	 * default constructor
	 */
	public Point() {}
	/**
	 * constructor with initialized contents, name, x coord, y coord
	 * @param x coord in x
	 * @param y coord in y
	 * @param name point name
	 */
	public Point(double x, double y, String name) {
		this.x = x;
		this.y=y;
		this.name = name;
	}
	/**
	 * Returns string of point information
	 */
	public String toString() {
		return this.name +" ("+  this.x + "x, "+this.y+ "y)"; 
	}
	/**
	 * returns x coord
	 * @return x coord
	 */
	public double getX() {
		return x;
	}
	/**
	 * Sets x coord
	 * @param x x coord
	 */
	public void setX(double x) {
		this.x = x;
	}
	/**
	 * Gets y coord
	 * @return y coord
	 */
	public double getY() {
		return y;
	}
	/**
	 * sets y coord
	 * @param y y coord
	 */
	public void setY(double y) {
		this.y = y;
	}
	/**
	 * Returns point name
	 * @return point name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Sets point name
	 * @param name new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}
