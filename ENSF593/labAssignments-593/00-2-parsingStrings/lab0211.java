package assignment0;

import java.util.*;

public class lab0211 {

	public static void main(String[] args) {

		double[] inputArray = { 6.7, 5.9, 10, 23, 44, 4.6, 9.1, 100, 79 };
		float[] array = parseArrayDoubletoFloat(inputArray);
		float[] userResponse = recieveUserInputs();
		float[] array2 = (insertAt(array, (int) userResponse[0], userResponse[1]));
		System.out.println(Arrays.toString(array2));
	}

	public static float[] recieveUserInputs() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("position?");
		int position = scanner.nextInt();
		System.out.println("value?");
		float value = scanner.nextFloat();
		scanner.close();
		float[] result = { (float) position, value };
		return result;
	}

	public static float[] parseArrayDoubletoFloat(double[] inputArray) {
		// resolves type error (input is array of doubles, needs to be cast to float.)
		float[] array = new float[inputArray.length];
		for (int i = 0; i < inputArray.length; i++) {
			array[i] = (float) inputArray[i];
		}
		return array;
	}

	public static float[] insertAt(float[] array, int position, float value) {
		float newArray[] = new float[array.length + 1];

		if (position >= array.length || position < 0) {
			System.out.println("error. position is invalid.");
			return null;
		}

		int findCheck = 0;
		for (int i = 0; i < newArray.length; i++) {

			if (i == position) {
				newArray[i] = value;
				findCheck = 1;
			} else {
				newArray[i] = array[i - findCheck];
			}
		}
		return newArray;
	}
}
