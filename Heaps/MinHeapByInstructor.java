package day_10_heaps;

public class MinHeapByProfessor {
	int[] heapArray;
	int size; //also last element
	int capacity;
	
	public MinHeapByInstructor() {
		capacity = 10;
		size = 0;
		heapArray = new int[capacity];
	}
	
	public MinHeapByInstructor(int cap) {
		capacity = cap;
		size = 0;
		heapArray = new int[capacity];
	}
	
	/**
	 * Insert in the min-heap array and heapify-up
	 * @param num
	 */
	public void insertMinHeap(int num) {
		if(size == capacity-1) {
			throw new IllegalStateException("Heap is full, cannot insert "+num);
		}
		size++;
		heapArray[size] = num;
		heapifyUp(size);
	}
	
	/**
	 * Remove the min value from the min-heap
	 * and heapify-down
	 * @return
	 */
	public int removeMinHeap() {
		if(size == 0) {
			throw new IllegalStateException("Heap is empty, no value to remove.");
		}
		int ans = heapArray[1];
		heapArray[1] = heapArray[size];
		size--;
		heapifyDown();
		return ans;
	}
	
	/**
	 * Once a value is inserted, make sure it's on the right spot.
	 * Move it up in necessary.
	 * @param index
	 */
	public void heapifyUp(int index) {
		int currIndex = index;
		while(currIndex > 1) {
			int parentIndex = currIndex / 2;
			if(heapArray[parentIndex] < heapArray[currIndex]) {
				break;
			}
			swap(currIndex, parentIndex);
			currIndex = parentIndex;
		}
	}
	
	/**
	 * Once the min (root) is removed, replace the root with the last node.
	 * Move root down if necessary.
	 * @param index
	 */
	public void heapifyDown() {
		int currIndex = 1;
		
		while(currIndex < size) {
			int smallestChildIndex, leftChildIndex = currIndex * 2, rightChildIndex = currIndex * 2 + 1;
			
			if(leftChildIndex <= size && rightChildIndex <= size) {
				if(heapArray[leftChildIndex] < heapArray[rightChildIndex]) {
					smallestChildIndex = leftChildIndex;
				} else {
					smallestChildIndex = rightChildIndex;
				}
			} else if(leftChildIndex <= size) {
				smallestChildIndex = leftChildIndex;
			} else if(rightChildIndex <= size) {
				smallestChildIndex = rightChildIndex;
			} else {
				return;
			}
			
			if(heapArray[currIndex] > heapArray[smallestChildIndex]) {
				swap(currIndex, smallestChildIndex);
			}
			currIndex = smallestChildIndex;
		}
	}
	
	/**
	 * Helper method two swap two nodes in the heap array.
	 * @param i
	 * @param j
	 */
	public void swap(int i, int j) {
		int temp = heapArray[i];
		heapArray[i] = heapArray[j];
		heapArray[j] = temp;
	}
	
	/**
	 * Give a string representation of the heap array
	 * Example: [1,2,3,4,5]
	 */
	public String toString() {
		String ans = "[";
		for(int i = 1; i <= size; i++) {
			ans += heapArray[i];
			if(i != size) ans += ", ";
		}
		ans += "]";
		return ans;
	}
}
