package ensf593lab1;

import java.util.Scanner;


public class SinValidator {

	private int[] SIN;

	private int sumDigit(int x) {
		int result = 0;

		while (x > 0) {
			result += x % 10;
			x = x / 10;
		}

		return result;
	}

	public SinValidator(String sin) {

		SIN = new int[9];
		int i = 0;
		int counter = 0;
		while (i < sin.length()) {

			if (Character.isDigit(sin.charAt(i))) {
				if (counter < 9)
					SIN[counter] = (int) sin.charAt(i) - 48;
				counter++;
			} else {
				System.err.println("Error: Invalid input by the user");
				return;
			}
			i++;
		}

		if (counter != 9) {
			System.err.println("Error: SIN must be 9 digits...");
			return;
		}
	}
	private int addSomeSINdigitsTogether() {
		return SIN[0] +SIN[2]+ SIN[4] + SIN[6];
	}
	private int multiplyDigitbyTwo(int digit) {
		return SIN[digit-1]*2;
	}
	
	private int tenMinusleastSigDigit(int input) {
		
		return 10 - input % 10;
	}
	public boolean validateSin() {
		int stepOne = addSomeSINdigitsTogether();
		int stepFour = 0;
		for (int i = 2; i<9; i= i + 2) {
			stepFour += sumDigit(multiplyDigitbyTwo(i));
		}
		int stepFive = stepFour + stepOne;
		int stepSix = tenMinusleastSigDigit(stepFive);
		return (stepSix == SIN[8]);
	}

	public static void main(String[] args) {
		// Read user input

		String sin;
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println(
					"Please enter your 9 digit social insurance number" + " or enter quit to terminate the program: ");
			sin = scan.nextLine();
			if (sin.toUpperCase().equals("QUIT"))
				break;
			SinValidator sv = new SinValidator(sin);
			if (sv.validateSin())
				System.out.println("Yes this is a valid SIN\n");
			else
				System.out.println("No this is NOT a valid SIN\n");

		}
		scan.close();
	}

}
