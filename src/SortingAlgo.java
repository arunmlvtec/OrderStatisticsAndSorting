import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SortingAlgo {
	public static BufferedReader br = null;
	//public static int maxSize = 0, availableIndex = 0;
	public static double[] dataSet;

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		String csvFilePath = "";
		Scanner filePath;
		String choice;
		while(true) {
			System.out.print("Enter your csv input file path & file name:");
			System.out.println("(Ex:C:\\xx\\filex.csv)");
			filePath = new Scanner (System.in);
			csvFilePath = filePath.nextLine();
			try {
				br = new BufferedReader(new FileReader(csvFilePath));
				break;
			}catch(FileNotFoundException e) {
				System.out.println("Invalid Path. Try again..!!");
			}
		}

		readDatatoArray();
		//filePath.close();
		br.close();
		System.out.println("Enter 1, to choose the pivot as 1st element");
		System.out.println("Enter 2, to Choose the pivot as random number");
		System.out.println("Enter 3, to choose the pivot as median of 3 random numbers");
		System.out.println("Enter any random number to choose the pivot from median of median method");
		filePath = new Scanner(System.in);
		choice = filePath.nextLine();
		//QuickSortModule qsm = new QuickSortModule();
		QuickSortModule.processFileData(dataSet, choice);
		//processFileData(dataSet, choice);
		filePath.close();
		//qsm.processFileData();
	}

	public static void readDatatoArray() throws IOException {
		int maxSize = 0, availableIndex = 0;
		String[] lineData = br.readLine().split(","); // Row No 1 for general details
		maxSize = Integer.parseInt(lineData[1]); // k,n is the value
		availableIndex = maxSize;
		dataSet = new double[maxSize];
		for(int i =0; i<maxSize; i++) {
			dataSet[i] = (Double.parseDouble(br.readLine()));
		}
	}

}