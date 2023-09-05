package sorting;

public class InClass {

	public static void bubbleSort(int[] arr) {
		for (int i = arr.length; i > 0; i--) {
			for (int j = 0; j < arr.length - 1; j++) {
				if (arr[j] > arr[j+1])
					swap (arr, j, j+1);
			}
		}
	}

	public static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int min = findMin(arr, i);
			if(min != i)
				swap(arr, min, i);
		}
	}

	public static void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length - 1; i++) {
			insertInOrder (arr, arr[i], arr.length - 1);
		}
	}

	private static void insertInOrder(int[] arr, int value, int end) {
		int i = end;
		while(i >= 0 && value < arr[i]) {
			arr[i+1] = arr[i];
			i--;
		}
		arr[i+1] = value;
	}

	public static void quickSort(int[] arr, int first, int last) {
		if (arr.length > 10) {
			int pivot = partionIndex(arr, first, last);
			quickSort(arr, first, pivot + 1);
			quickSort(arr, pivot + 1, last);
		} else {
			insertionSort();
		}
	}

	private static int partionIndex(int[] arr, int first, int last) {
		// TODO Auto-generated method stub
		return 0;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;		
	}

	private static int findMin(int[] arr, int n) {
		int minIndex = n;

		for (int i = n; i < arr.length; i++) {
			if (arr[minIndex] < arr[i])
				minIndex = i;
		}
		return minIndex;
	}

	public static void main(String[] args) {
		int[] arr = {4, 6, 2, 8, 9, 0, 5, 1, 7, 3, 10, 14, 13, 12, 11};

		insertionSort(arr);

		for (int i = 0; i < 15; i++)
			System.out.print("" + arr[i] + " ");
	}
}
