import java.util.Random;
import java.util.Scanner;

public class MainClass {
	public static int choice= 0;
	public static void main(String[] args) {
		//int[] intArray = { 1, 9, 2, 8, 3, 7, 4, 6, 5, 12, 10 };
		int[] intArray = { 1, 9, 2, 8, 3};
		/*for (int i : intArray) {
			System.out.println(i);
		}*/
		quickSort(intArray);
		for (int i : intArray) {
			System.out.println(i);
		}
	}

	public static void quickSort(int[] intArray) {
		System.out.println("Enter 1, to choose the pivot as 1st element");
        System.out.println("Enter 2, to Choose the pivot as random number");
        System.out.println("Enter 3, to choose the pivot as median of 3 random numbers");
        System.out.println("Enter any random number to choose the pivot from median of median method");
        Scanner sc = new Scanner(System.in);
        choice = sc.nextInt();
        recQuickSort(intArray, 0, intArray.length - 1);
	}

	public static void recQuickSort(int[] intArray, int left, int right) {
		int size = right - left + 1;
		/*if (size < 10)
			insertionSort(intArray, left, right);
		else {*/
			//double median = medianOf3(intArray, left, right);
			int partition = partitionIt(intArray, left, right);
			//int partition = partitionIt(intArray, left, right, median);
			recQuickSort(intArray, left, partition - 1);
			recQuickSort(intArray, partition + 1, right);
		//}
	}

	//public static int partitionIt(int[] intArray, int left, int right, double pivot) {
	public static int partitionIt(int[] intArray, int left, int right) {
		double pivot = 0;
		if (choice == 1)
			pivot = chooseFirstElement(intArray, left, right);
		else if (choice == 2)
			pivot = chooseRandom(intArray, left, right);
		else if (choice == 3)
			pivot = medianOf3Random(intArray, left, right);
		
		int leftPtr = left;
		int rightPtr = right;
		while (true) {
			while (intArray[++leftPtr] <= pivot)
				;
			while (rightPtr > 0 && intArray[--rightPtr] > pivot)
				;
			if (leftPtr >= rightPtr)
				break;
			else
				swap(intArray, leftPtr, rightPtr);
		}
		//swap(intArray, leftPtr, right);
		return leftPtr;
	}
	
	public static double chooseFirstElement(int[] intArray, int left, int right){ 
		if (intArray[left] > intArray[right]) {
			swap(intArray, left, right);
			//swap(intArray, left, right - 1);
			return intArray[right];
		}
		return intArray[left];
	}
	
	public static double chooseRandom(int[] intArray, int left, int right){
		int len = right - left + 1;
		Random rand = new Random();
		int randElement1 = rand.nextInt(len);
		int chosenElem = randElement1+left; 
		if (intArray[chosenElem] > intArray[right])
			swap(intArray, chosenElem, right);

		swap(intArray, chosenElem, right - 1);
		return intArray[right - 1];
	}

	public static double medianOf3Random(int[] intArray, int left, int right) {
		int len = right - left + 1;
		Random rand = new Random();
		int randElement1 = rand.nextInt(len);
		int center = randElement1+left; 

		if (intArray[left] > intArray[center])
			swap(intArray, left, center);

		if (intArray[left] > intArray[right])
			swap(intArray, left, right);

		if (intArray[center] > intArray[right])
			swap(intArray, center, right);

		swap(intArray, center, right - 1);
		return intArray[right - 1];
	}
	
	public static void swap(int[] intArray, int dex1, int dex2) {
		int temp = intArray[dex1];
		intArray[dex1] = intArray[dex2];
		intArray[dex2] = temp;
	}

	public static void insertionSort(int[] intArray, int left, int right) {
		int in, out;
		for (out = left + 1; out <= right; out++) {
			int temp = intArray[out];
			in = out;
			while (in > left && intArray[in - 1] >= temp) {
				intArray[in] = intArray[in - 1];
				--in;
			}
			intArray[in] = temp;
		}
	}
}