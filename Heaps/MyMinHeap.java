package day_10_heaps;

public class MinHeap {
	int[] heapArray;
	int size;
	int capacity;
	
	public MyMinHeap() {
		capacity = 20;
		size = 1;
		heapArray = new int[capacity];
	}
	
	public MyMinHeap(int cap) {
		capacity = cap;
		size = 1;
		heapArray = new int[capacity];
	}
	
	/**
	 * Insert in the min-heap array and heapify-up
	 * @param num
	 */
	public void insertMinHeap(int num) {
		if(size == capacity - 1) { 
			//why size == capacity - 1
			//because we start at index 1 instead of 0. 
			//Not sure why skip 0
			throw new IllegalStateException("Heap is full, cannot insert " + num);
			return;
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
		int min = heapArray[1];
		heapArray[1] = heapArray[size];
		heapArray[size] = (Integer) null;
		size--;
		heapifyDown();
		return min;
	}
	
	/**
	 * Once a value is inserted, make sure it's on the right spot.
	 * Move it up in necessary.
	 * @param index
	 */
	public void heapifyUp(int n) {
		int index = n;
		while(index > 0) {
			int parentIndex = index / 2;
			if(heapArray[parentIndex] < heapArray[index]) {
				break;
			}
			swap(parentIndex, index);
			index = parentIndex;
		}
	}
	
	/**
	 * Once the min (root) is removed, replace the root with the last node.
	 * Move root down if necessary.
	 * @param index
	 */
	public void heapifyDown() {
		int curr = 1;
		int smallest, left = curr * 2, right = curr * 2 + 1;
		
		while(curr < size) {
			if(heapArray[left] < heapArray[right]) {
				smallest = left;
			}
			else
				smallest = right;
			if(heapArray[smallest] >= heapArray[curr])
				break;
			else {
				swap(curr, smallest);
				curr = smallest;
			}
		}
		/*
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
		*/
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
