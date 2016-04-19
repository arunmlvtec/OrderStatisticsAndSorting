/*public class FindMinMax {
	public static void main(String[] args) {
		int arr[] = {3, 2, 1, 4, 5, 0, 7, 9};
		int min = arr[0];
		int max = arr[0];
		int j = 1;  
		FindMinMax fmm = new FindMinMax();
		System.out.println("Min in main: "+min);
		System.out.println("Min from the array is: "+ fmm.findMin(j));
		//System.out.println("Max from the array is: "+ findMax());
	}
	public int findMin(int i){
		System.out.println("i is:" +i);
		System.out.println("Array input is: " + arr[i]);
		System.out.println(min);
		if (i == arr.length)
			return min;
		else if (min > arr[i]){
				System.out.println("Min before swap is: "+min);
				min = arr[i];
				System.out.println("Min after swap is: "+min);
				findMin(i++);
			}
			else{
				findMin(i++);
			}
		return min;
	}
}
*/