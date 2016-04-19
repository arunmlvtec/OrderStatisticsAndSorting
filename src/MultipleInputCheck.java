import java.util.Scanner;

public class MultipleInputCheck {
	public static void main(String [] args){
		Scanner filePath;
		System.out.print("Enter your name: ");
		filePath = new Scanner (System.in);
		String csvFilePath = filePath.nextLine();
		System.out.println("Your name is: "+csvFilePath);
		Scanner city;
		System.out.print("Enter your city: ");
		city = new Scanner (System.in);
		String citY = city.nextLine();
		System.out.println("Your name is "+csvFilePath+", and You are from "+ citY+".");
		
	}
}
