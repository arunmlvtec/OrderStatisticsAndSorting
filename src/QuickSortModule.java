import java.io.BufferedReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class QuickSortModule {
	public BufferedReader file = null;
	public static int maxSize = 0, availableIndex = 0;
	//public static String choice= "";
	public static Scanner sc;
	/*public static void main(String[] args) {
		int[] intArray = { 1, 9, 2, 8, 3, 7, 4, 6, 5 };
		quickSort(intArray);
		for (int i : intArray) {
			System.out.println(i);
		}
	}*/
	
	public static void processFileData(double[] dataset, String choice){
	//public void processFileData(double[] dataset) {
		//this.choice = choice;
		long startTime = 0;
		startTime = System.currentTimeMillis();
		quickSort(dataset, choice);
		long endTime = System.currentTimeMillis();
		if(startTime != 0) {
			System.out.println("Time Taken to perform Quick Sort on " + maxSize +
					" data is :" + (endTime - startTime));
		}
		for(double i: dataset)
			System.out.println(i);
	/*	try {
			WriteOutputToCSV.generateOutput(dataSet);
		} catch (IOException e) {
			e.printStackTrace();
		}*/
	}
		
	public static void quickSort(double[] doubleArray, String choice) {
		maxSize = doubleArray.length-1;
		if (doubleArray.length <= 1)
			return;
		else {
			if (doubleArray.length>1)
				recQuickSort(doubleArray, 0, maxSize, choice);
			//sc.close();
		}
	}

	public static void recQuickSort(double[] doubleArray, int start, int end, String choice){
		int len = end - start + 1;
		/*if (len<10)
			insertionSort(intArray, start, end);
		else*/
		double pivot = chooseOption(doubleArray, start, end, choice);
		int partition = partition(doubleArray, start, end, pivot);
		if (start < partition-1)
			recQuickSort(doubleArray, start, partition - 1, choice);
		if (partition < end)
			recQuickSort(doubleArray, partition, end, choice);
	}
	
	public static double chooseOption(double[] doubleArray, int start, int end, String choice){
		double pivot = 0;
		if (choice.equals("1"))
			pivot = doubleArray[start];
		else if (choice.equals("2")){
			int len = end - start + 1;
			Random rand = new Random();
			int randElement1 = rand.nextInt(len);
			int chosenElem = randElement1+start;
			pivot = doubleArray[chosenElem];
		}
		else if (choice.equals("3")){
			//double chosenElem 
			pivot = medianof3Randoms(doubleArray, start, end);
		}
		System.out.println("pivot element is: "+ pivot);
		return pivot;
	}
	
	public static double medianof3Randoms(double[] doubleArray, int start, int end){
		int len = end - start + 1;
		double chosenOne = 0;
		Random rand = new Random();
		int randElement1 = rand.nextInt(len);
		int randElement2 = rand.nextInt(len);
		int randElement3 = rand.nextInt(len);
		int chosenElem1 = randElement1+start;
		int chosenElem2 = randElement2+start;
		int chosenElem3 = randElement3+start;
		if ((doubleArray[chosenElem1] <= doubleArray[chosenElem2] && doubleArray[chosenElem1] >= doubleArray[chosenElem3]) || (doubleArray[chosenElem1] >= doubleArray[chosenElem2] && doubleArray[chosenElem1] <= doubleArray[chosenElem3])){
			chosenOne = doubleArray[chosenElem1];
		}
		else if ((doubleArray[chosenElem2] <= doubleArray[chosenElem1] && doubleArray[chosenElem2] >= doubleArray[chosenElem3]) || (doubleArray[chosenElem2] >= doubleArray[chosenElem1] && doubleArray[chosenElem2] <= doubleArray[chosenElem3])){
			chosenOne = doubleArray[chosenElem2];
		}
		else if ((doubleArray[chosenElem3] <= doubleArray[chosenElem1] && doubleArray[chosenElem3] >= doubleArray[chosenElem2]) || (doubleArray[chosenElem3] >= doubleArray[chosenElem1] && doubleArray[chosenElem3] <= doubleArray[chosenElem2])){
			chosenOne = doubleArray[chosenElem3];
		}
		//System.out.println("The chosen one is: " + chosenOne);
		return chosenOne;
	}
	
	public static int partition(double[] doubleArray, int start, int end, double pivot){
        while (start <= end){
            while (doubleArray[start] < pivot)
                start++;
            while (doubleArray[end] > pivot)
                end--;
            if (start <= end) {
                double tmp = doubleArray[start];
                doubleArray[start] = doubleArray[end];
                doubleArray[end] = tmp;
                start++;
                end--;
            }
        }
        return start;
    }

/*	public void processFileData1(double[] dataSet) {
		
	}*/
}