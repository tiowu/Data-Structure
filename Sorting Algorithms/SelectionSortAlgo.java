package day_02_arrays;

public class SelectionSortAlgo {
    public static void main(String[] args) {
        int[] arr = {3, 6, 8, 10, 1, 2, 1};

        System.out.println("Original array:");
        printArray(arr);

        selectionSort(arr);

        System.out.println("\nSorted array:");
        printArray(arr);
    }

    static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // Find the index of the minimum element in the unsorted part of the array
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first element in the unsorted part
            swap(arr, i, minIndex);
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
