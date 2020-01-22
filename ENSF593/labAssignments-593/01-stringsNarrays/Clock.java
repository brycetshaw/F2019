package ensf593lab1;
import java.lang.Math; 

public class Clock {
	private int day, hour, minute, second; 
	
	public Clock(int day, int hour, int minute, int second) {
		this.day = day;
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	
	public Clock() {}	
	
	public void increment(int deltaT) {
		int beforeIncrement = this.second;
		this.second = (deltaT + this.second) % 60;
		deltaT = (int) Math.floor((double) (deltaT + beforeIncrement - this.second)/60);
		
		if (deltaT  == 0) {return;}
		beforeIncrement = this.minute;
		this.minute = (deltaT + this.minute) % 60;
		deltaT = (int) Math.floor((double) (deltaT + beforeIncrement- this.minute)/60);
		
		if (deltaT == 0) {return;}
		beforeIncrement = this.hour;
		this.hour = (deltaT + this.hour) % 24;
		deltaT = (int) Math.floor((double) (deltaT + beforeIncrement - this.hour)/24);
		
		if (deltaT == 0) {return;}
		this.day += deltaT;
	}
	
	
	public String toString() {
		return this.day +" days, " + this.hour + " hours, " + this.minute + " minutes, "+ this.second + " seconds";
	}
	public int calculateTotalSeconds() {
		return ((this.day*24+this.hour) * 60 + this.minute) * 60 + this.second;
	}
	
	public static void main(String[] args) {
		
		Clock t1 = new Clock(); // Default constructor
		// sets hour to 23
		t1.setHour(23);
		// sets day to 1
		t1.setDay(1);
		// sets minute to 59
		t1.setMinute(59);
		// sets day to 16
		t1.setSecond(16);
		// prints: 1:23:59:16
		System.out.println(t1);
		// increments time t1 by 44 seconds:
		t1.increment(44);
		// prints: 2:0:0:0
		System.out.println(t1);
		// prints the total elapsed time in seconds: 172,800
		System.out.printf("The elapsed time in seconds is: %d", t1.calculateTotalSeconds());
		System.out.print("\n");
		// REPEAT SIMILAR TESTS FOR t2
		 //Elapsed time is 3 days, 1 hour, 4 mins and 5 secs
		Clock t2 = new Clock(3, 1, 4, 5);
		System.out.println(t2);
		System.out.printf("The elapsed time in seconds is: %d", t2.calculateTotalSeconds());
	}



	public int getDay() {
		return day;
	}



	public void setDay(int day) {
		this.day = day;
	}



	public int getHour() {
		return hour;
	}



	public void setHour(int hour) {
		if(hour >=0 && hour < 24) {
			this.hour = hour;
		} else {
			System.out.println("Entry out of range.");
		}
	}



	public int getMinute() {
		return minute;
	}



	public void setMinute(int minute) {
		if(minute >=0 && minute < 60) {
			this.minute = minute;
		} else {
			System.out.println("Entry out of range.");
		}
	}



	public int getSecond() {
		return second;
	}



	public void setSecond(int second) {
		if(second >=0 && second < 60) {
			this.second = second;
		} else {
			System.out.println("Entry out of range.");
		}
		
	}

}
