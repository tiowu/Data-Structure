package day_02_arrays;

public class MergeSortAlgo {
	
	public static int[] merge(int[] firstHalf, int[] secondHalf) {
		int nfirst = firstHalf.length;
		int nsecond = secondHalf.length;
		
		int[] result = new int[nfirst+nsecond];
		
		int firstPtr = 0;
		int secondPtr = 0;
		int resultPtr = 0;
		
		while(firstPtr < nfirst && secondPtr < nsecond) {
			if(firstHalf[firstPtr] < secondHalf[secondPtr]) {
				result[resultPtr] = firstHalf[firstPtr];
				firstPtr++;
			} else {
				result[resultPtr] = secondHalf[secondPtr];
				secondPtr++;
			}
			resultPtr++;
		}
		
		while(firstPtr < nfirst) {
			result[resultPtr] = firstHalf[firstPtr];
			firstPtr++;
			resultPtr++;
		}
		
		while(secondPtr < nsecond) {
			result[resultPtr] = secondHalf[secondPtr];
			secondPtr++;
			resultPtr++;
		}
		
		return result;
	}
	
	public static int[] mergeSort(int[] arr, int left, int right) {
		if(left == right) {
			int[] baseCase = { arr[left] };  // Single element array
	        return baseCase;
		}
		
		int mid = left + (right - left) / 2;
        int[] firstHalf = mergeSort(arr, left, mid);
        int[] secondHalf = mergeSort(arr, mid + 1, right);
        return merge(firstHalf, secondHalf);

	}


	public static void main(String[] args) {
		int[] arr = {9, 0, -3, 21, 5, 9, 1, -15};
		arr = mergeSort(arr, 0, arr.length - 1);
		for(int n: arr) {
			System.out.print(n + " ");
		}
	}

}
