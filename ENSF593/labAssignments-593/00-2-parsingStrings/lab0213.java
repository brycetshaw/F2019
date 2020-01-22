package assignment0;

public class lab0213 {

	public static void main(String[] args) {
		int[] testArray = { 1, 2, 2, 4, -999, 0, 10 };

		System.out.println(allUnique(testArray));

	}

	public static boolean allUnique(int[] array) {

		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] == array[j]) {
					return false;
				}
			}
		}
		return true;
	}
}
