import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;
import java.util.Scanner;

/* A Program to generate CSV file with random float numbers*/
public final class GenerateCSVInput {

	public static final void main(String[] args){
		int total = 0, min = 0, max = 0;
		System.out.println("Welcome to CSV Generator --->");
		// Get the Input
		while(true) {
			try {
				System.out.println("Enter the total number of input required:");
				Scanner totalStream = new Scanner (System.in);
				total = Integer.parseInt(totalStream.nextLine());
				System.out.println("Enter the minimum number for the input:");
				Scanner minStream = new Scanner (System.in);
				min = Integer.parseInt(minStream.nextLine());
				System.out.println("Enter the maximum number for the input:");
				Scanner maxStream = new Scanner (System.in);
				max = Integer.parseInt(maxStream.nextLine());
				totalStream.close();
				minStream.close();
				maxStream.close();
				break;

			} catch(Exception e) {
				System.out.println("Invalid Data, Input should be only integer, Start again");
			}
		}
		System.out.println("Generating a CSV file with " + total + " values...");
		try {
			generateFile(total,min,max);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Done...!! Check the same folder for the generated csv file");

	}

	// Method to generate random numbers and store it a csv file
	private static void generateFile(int total, int rangeMin, int rangeMax) throws IOException{
		int count = 1;
		String fileName = "InputDataSet" + total + ".csv";
		String content = "";
		FileWriter write = new FileWriter(fileName);
		content = "1," + total + "\n"; //Default value of k to 1
		write.append(content);
		content = "";
		Random randomGenerator = new Random();
		NumberFormat formatter = new DecimalFormat("#0.00"); // Restrict the format to xx.xx
		for (int idx = 1; idx <= total; ++idx){
			double randomDouble = rangeMin + (rangeMax - rangeMin) * randomGenerator.nextDouble();
			content = content + formatter.format(randomDouble) + "\n";
			if(count == 100) {
				write.append(content);
				content = "";
				count = 0;
			} else{
				count++;
			}
		}
		write.append(content);
		write.flush();
		write.close();
	}
}