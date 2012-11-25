package org.celestial;

public class SectionFour_BinarySearch {

	public static int binarySearch(int[] arr, int num) {
		if(arr.length > 0) {
			int low = 0;
			int high = arr.length - 1;
			while(low <= high) {
				int mid = (low + high) / 2;
				if(num < arr[mid])
					high = mid - 1;
				else if(num > arr[mid])
					low = mid + 1;
				else
					return mid;
			}
		}
		
		return -1;
	}
	
	public static int binarySearchRecursion(int[] arr, int num, int low, int high) {
		if(arr.length == 0 || low > high)
			return -1;
		int mid = (low + high) / 2; 
		if(num < arr[mid])
			return binarySearchRecursion(arr, num, low, mid - 1);
		else if(num > arr[mid])
			return binarySearchRecursion(arr, num, mid + 1, high);
		else
			return mid;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
		System.out.println(binarySearch(arr, 4));
		System.out.println(binarySearchRecursion(arr, 4, 0, arr.length - 1));
	}

}
