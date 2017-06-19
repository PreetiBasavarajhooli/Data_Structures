import java.util.Arrays;

public class quicksort {

	private static int[] theArray;

	private static int arraySize;

	public static void main(String[] args) {

		quicksort partitionArray = new quicksort(10);

		partitionArray.generateRandomArray();

		System.out.println(Arrays.toString(quicksort.theArray));
		partitionArray.partitionArray(35);

		System.out.println(Arrays.toString(quicksort.theArray));

	}

	public void partitionArray(int pivot) {

		int leftPointer = -1;


		int rightPointer = arraySize;

		while (true) {

			while (leftPointer < (arraySize - 1)
					&& theArray[++leftPointer] < pivot)
				;

			printHorzArray(leftPointer, rightPointer);

			System.out.println(theArray[leftPointer] + " in index "
					+ leftPointer + " is bigger than the pivot value " + pivot);


			while (rightPointer > 0 && theArray[--rightPointer] > pivot)
				;

			printHorzArray(leftPointer, rightPointer);

			System.out.println(theArray[rightPointer] + " in index "
					+ rightPointer + " is smaller than the pivot value "
					+ pivot);

			printHorzArray(leftPointer, rightPointer);

			if (leftPointer >= rightPointer)
				break;

			else {

				swapValues(leftPointer, rightPointer);

				System.out.println(theArray[leftPointer] + " was swapped for "
						+ theArray[rightPointer]);

			}

		}

	}

	public void swapValues(int indexOne, int indexTwo) {

		int temp = theArray[indexOne];
		theArray[indexOne] = theArray[indexTwo];
		theArray[indexTwo] = temp;

	}

	quicksort(int newArraySize) {

		arraySize = newArraySize;

		theArray = new int[arraySize];

		generateRandomArray();

	}

	public void generateRandomArray() {

		for (int i = 0; i < arraySize; i++) {

			// Generate a random array with values between
			// 10 and 59

			theArray[i] = (int) (Math.random() * 50) + 10;

		}

	}

	static void printHorzArray(int i, int j) {

		for (int n = 0; n < 61; n++)
			System.out.print("-");

		System.out.println();

		for (int n = 0; n < arraySize; n++) {

			System.out.format("| %2s " + " ", n);

		}

		System.out.println("|");

		for (int n = 0; n < 61; n++)
			System.out.print("-");

		System.out.println();

		for (int n = 0; n < arraySize; n++) {

			System.out.print(String.format("| %2s " + " ", theArray[n]));

		}

		System.out.println("|");

		for (int n = 0; n < 61; n++)
			System.out.print("-");

		System.out.println();

		if (i != -1) {

			// Number of spaces to put before the F

			int spacesBeforeFront = 5 * i + 1;

			for (int k = 0; k < spacesBeforeFront; k++)
				System.out.print(" ");

			System.out.print("H");

			// Number of spaces to put before the R

			int spacesBeforeRear = (5 * j + 1 - 1) - spacesBeforeFront;

			for (int l = 0; l < spacesBeforeRear; l++)
				System.out.print(" ");

			System.out.print("P");

			System.out.println("\n");

		}

	}

}