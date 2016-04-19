public class QuickSort {

	public static void main(String args[]) {
		float[] input = { 23, 31, 1, 21, 36, 72};
		quickSort(input);
		for(float i: input){
			System.out.println(i);
		}
	}

	public static void quickSort(float array[]) {
		recursiveQuickSort(array, 0, array.length - 1);
	}

	public static void recursiveQuickSort(float[] array, int startIdx, int endIdx) {
		int idx = partition(array, startIdx, endIdx);
		if (startIdx < idx - 1)
			recursiveQuickSort(array, startIdx, idx - 1);

		if (endIdx > idx)
			recursiveQuickSort(array, idx, endIdx);
	}

	public static int partition(float[] array, int left, int right) {
		float pivot = array[left];
		while (left <= right){
			while (array[left] < pivot)
				left++;
			while (array[right] > pivot)
				right--;
			if (left <= right) {
				float tmp = array[left];
				array[left] = array[right];
				array[right] = tmp;

				left++;
				right--;
			}
		}
		return left;
	}
}