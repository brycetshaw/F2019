package assignment0;

import java.util.*;

public class lab0212 {
	public static void main(String[] args) {
		double[] first_array = { 6.7, 5.9, 10, 23, 44, 4.6, 9.1 };
		double[] second_array = { 11, 12, 13, 14, 15, 16, 17 };

		float[] firstArrayFloat = castToFloat(first_array);
		float[] secondArrayFloat = castToFloat(second_array);

		swapArrays(firstArrayFloat, secondArrayFloat);
		System.out.println(Arrays.toString(firstArrayFloat));
		System.out.println(Arrays.toString(secondArrayFloat));
	}

	public static float[] castToFloat(double[] inputArray) {
		// resolves type error of an input array of type double.

		float[] resultArray = new float[inputArray.length];
		for (int i = 0; i < inputArray.length; i++) {
			resultArray[i] = (float) inputArray[i];
		}
		return resultArray;
	}

	public static void swapArrays(float[] array1, float[] array2) {

		if (!(array1.length == array2.length)) {
			System.out.println("error. the arrays are not the same.");
		}

		for (int x = 0; x < array1.length; x++) {
			float temp = array1[x];
			array1[x] = array2[x];
			array2[x] = temp;
		}
	}
}