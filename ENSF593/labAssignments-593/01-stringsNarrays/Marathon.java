package ensf593lab1;

import java.util.ArrayList;
import java.util.Scanner;

public class Marathon {
	
	public static void partOne() {
		
        String[] part1Names = { "Elena", "Tom", "frabreezee" };
        int[] part1Times = { 453, 200, 340 };
        int fastestIndex = fastestTime(part1Times);
        System.out.println("The fastest runner was " + part1Names[fastestIndex] + "\n with a time of: " + part1Times[fastestIndex]);

        
	}
	private static void scanInputs(ArrayList<String> names, ArrayList<String> times) {
		String sin;
		Scanner scan = new Scanner(System.in);
		
		while (true)
		{
		System.out.println("Please enter the name of the participant");
		sin = scan.nextLine();
		if(sin.toUpperCase().equals("QUIT"))
		break;
		names.add(sin);
		System.out.println("Please enter the running time of the participant");
		sin = scan.nextLine();
		times.add(sin);
		}	
		scan.close();
	}
	public static void partTwo() {
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<String> times = new ArrayList<String>();
		scanInputs(names, times);
		int fastest = fastestTime(times);
		System.out.println(names.get(fastest) + " is the fastes"
				+ "t with a time of "+times.get(fastest) +". What a keener.");
		
	}

    public static void main(String[] args) {
    	System.out.println("Part 1 !!!");
    	partOne();
    	System.out.println("Part 2 !!!");
        partTwo();
    }

    public static int fastestTime(int[] times) {
        int fastest = 0;
        for (int i = 0; i < times.length; i++) {
            if (times[i] < times[fastest]) {
                fastest = i;
            }
        }
        return fastest;
    }
    
    public static int fastestTime(ArrayList<String> times) {
        int fastest = 0;
        for (int i = 0; i < times.size(); i++) {
            if (Integer.parseInt(times.get(i)) < Integer.parseInt(times.get(fastest))) {
                fastest = i;
            }
        }
        return fastest;
    }
}