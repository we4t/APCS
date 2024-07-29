import java.util.*;

public class SortTest {
	public static void main(String[] args) {
		Random rand = new Random(System.nanoTime());
		int size, loopTime = 1000;
		int[][] testArrays = new int[5][];
		long[] intervals = new long[] { 0, 0, 0, 0, 0 };
		long start, tmp;

		// get user input from arguments
		// input example : 10 1 2 3 4 5 6 7 8 9 10
		if (args.length == 0)
			size = 10000;
		else
			size = Integer.parseInt(args[0]);

		// allocate memories to test arrays
		for (int i = 0; i < testArrays.length; i++) {
			testArrays[i] = new int[size];
		}
		// initialize first test array
		for (int i = 0; i < size; i++)
			testArrays[0][i] = i + 1;

		for (int time = 1; time <= loopTime; time++) {
			// randomize array
			randomInitialize(testArrays[0], rand);

			for (int i = 1; i < testArrays.length; i++) {
				for (int j = 0; j < size; j++) {
					testArrays[i][j] = testArrays[0][j];
				}
			}
			// Selection Sort
			System.out.println("Selection Sort...");
			start = System.currentTimeMillis();
			SelectionSort.sort(testArrays[0], 1);
			tmp = System.currentTimeMillis() - start;
			intervals[0] += tmp;
			System.out.println("elapsed time : " + tmp);

			// Insertion Sort
			System.out.println("Insertion Sort...");
			start = System.currentTimeMillis();
			insertionsort.sort(testArrays[1], 1);
			tmp = System.currentTimeMillis() - start;
			intervals[1] += tmp;
			System.out.println("elapsed time : " + tmp);

			// Merge Sort
			System.out.println("Merge Sort...");
			start = System.currentTimeMillis();
			MergeSort.sort(testArrays[2], 1);
			tmp = System.currentTimeMillis() - start;
			intervals[2] += tmp;
			System.out.println("elapsed time : " + tmp);

			// quickSort
			System.out.println("quick Sort...");
			start = System.currentTimeMillis();
			QuickSort.sort(testArrays[3], 1);
			tmp = System.currentTimeMillis() - start;
			intervals[3] += tmp;
			System.out.println("elapsed time : " + tmp);

			// heapSort
			System.out.println("heap Sort...");
			start = System.currentTimeMillis();
			QuickSort.sort(testArrays[4], 1);
			tmp = System.currentTimeMillis() - start;
			intervals[4] += tmp;
			System.out.println("elapsed time : " + tmp);
		}
		System.out.println("Selection sort average time : " + intervals[0] * 1.0 / loopTime);
		System.out.println("Insertion sort average time : " + intervals[1] * 1.0 / loopTime);
		System.out.println("Merge sort average time : " + intervals[2] * 1.0 / loopTime);
		System.out.println("Quick sort average time : " + intervals[3] * 1.0 / loopTime);
		System.out.println("heap sort average time : " + intervals[4] * 1.0 / loopTime);

		/*
		 * randomInitialize(array, rand);
		 * printArray(array);
		 */
	}

	public static void randomInitialize(int[] a, Random rand) {
		rand = new Random(1);
		for (int i = a.length - 1; i > 0; i--) {
			int swap = rand.nextInt(i);
			int temp = a[i];
			a[i] = a[swap];
			a[swap] = temp;
		}
	}

	public static void printArray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print("[" + a[i] + "] ");
			// if((i + 1) % 10 == 0) System.out.println();
		}
		System.out.println();
	}
}
