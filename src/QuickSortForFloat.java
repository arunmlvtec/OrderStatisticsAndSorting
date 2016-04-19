import java.util.Scanner;
import java.util.Random;

public class QuickSortForFloat {
	public static int choice= 0; 
	public static void main(String[] args) {
		double inputArray []= {20.5, 35.0, 1.9, 20.2, 39.5, 70.9, 0.5, 107.0, 25.9, 7.3, 11.5};
		quickSort(inputArray);
		for (double i : inputArray) {
		      System.out.println(i);
		    }
	}
	
	public static void quickSort(double input[]){
		System.out.println("Enter 1, to choose the pivot as 1st element");
        System.out.println("Enter 2, to Choose the pivot as random number");
        System.out.println("Enter 3, to choose the pivot as median of 3 random numbers");
        System.out.println("Enter any random number to choose the pivot from median of median method");
        Scanner sc = new Scanner(System.in);
        choice = sc.nextInt();
        if(input.length <= 1)
        	return;
        else
        	recursiveQuickSort(input, 0, input.length-1);
	}
	
	public static void recursiveQuickSort(double[] input, int start, int end){
		if (input.length <10)
			insertionSort(input, start, end);
		else {
			int pivot = partition(input, start, end);
			//if (start < pivot-1)
				recursiveQuickSort(input, start, pivot-1);
			if (start > pivot)
				recursiveQuickSort(input, pivot, end);
		}
	}
	
	public static int partition(double[] input, int start, int end){
        double x = choosePivot(input, start, end);
        int startPtr = start;
        int endPtr = end - 1;
        while (true) {
          while (input[++startPtr] < x)
            ;
          while (input[--endPtr] > x)
            ;
          if (startPtr >= endPtr)
            break;
          else
            swap(input, startPtr, endPtr);
        }
        swap(input, startPtr, end - 1);
        
        return startPtr;
	}
	
	public static double choosePivot(double[] input, int start, int end){
		double pivot = 0;
		int randElement1, randElement2,randElement3;
		int len = end - start + 1;
		Random rand = new Random();
		if (choice == 1)
			pivot = input[start];
		else if (choice == 2){
			randElement1 = rand.nextInt(len);
			swap(input, start, randElement1+start);
			pivot = input[start];
		}
		else if (choice == 3){
			randElement1 = rand.nextInt(len);
			randElement2 = rand.nextInt(len);
			randElement3 = rand.nextInt(len);
			pivot = medianOf3(input, randElement1, randElement2, randElement3);
		}
		return pivot;
	}
	
	public static double medianOf3(double[] input, int left, int right, int center) {
		if (input[left] > input[center])
			swap(input, left, center);
	    if (input[left] > input[right])
	    	swap(input, left, right);
	    if (input[center] > input[right])
	    	swap(input, center, right);

	    swap(input, center, right - 1);
	    return input[right - 1];
	}
	
	public static void swap(double[] input, int left, int right) {
	    double temp = input[left];
	    input[left] = input[right];
	    input[right] = temp;
	  }
	public static void insertionSort(double[] input, int start, int end) {
		int i, j;
		for (j = start + 1; j <= end; j++) {
			double temp = input[j];
			i = j;
			while (i > start && input[i - 1] >= temp) {
				input[i] = input[i - 1];
				i--;
			}
			input[i] = temp;
		}
	}
}
