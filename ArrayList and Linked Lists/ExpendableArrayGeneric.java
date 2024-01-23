package day_02_arrays;

public class ExpendableArrayGeneric<T> {
	private int size;
	private int capacity;
	private T[] array;
	
	public ExpendableArrayGeneric(){//default constructor
		this.size = 0;
		this.capacity = 5;
		this.array = (T[]) new Object[capacity];
		this.fillArray();
	}
	
	public ExpendableArrayGeneric(int cap){
		this.size = 0;
		this.capacity = cap;
		this.array = (T[]) new Object[capacity];
		this.fillArray();
	}
	
	private void fillArray() {
		for(int i = 0; i < this.capacity; i++) {
			this.array[i] = null;
		}
	}
	private boolean isAlmostFull() {
		if((100.0 * size)/ capacity >= 70.0) {
			return true;
		}
		return false;
	}
	
	private boolean isAlmostEmpty() {
		if((100.0 * size)/capacity <= 30.0) {
			return true;
		}
		return false;
	}
	
	private void doubleCapacity() {
		this.capacity *= 2;
		this.copyArray();
	}
	
	private void halveCapacity() {
		this.capacity = Math.max(5, this.capacity / 2);
		this.copyArray();
	}
	
	private void copyArray() {
		T[] temp = (T[]) new Object[this.capacity];//create double cap array
		
		for(int i = 0; i < this.size; i++) { //copy over from smaller array
			temp[i] = this.array[i];
		}
		this.array = temp; //change the reference
	}
	
	public T get(int index) {
	    if (index < 0 || index >= size) {
	        throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
	    }
	    return (T) this.array[index];
	}

	
	public void add(T e) {
		this.array[size] = e;
		this.size++;
		if(this.isAlmostFull()) {
			this.doubleCapacity();
		}
	}
	
	public void remove() {
		this.array[size-1] = null;
		this.size--;
		if(this.isAlmostEmpty()) {
			this.halveCapacity();
		}
	}
	
	public void remove(int index) {
		for(int i = index+1; i <= size; i++) {
			this.array[i-1] = this.array[i];
		}
		size--;
		if(this.isAlmostEmpty()) {
			this.halveCapacity();
		}
	}
	
	public void insert(T e, int index) {
		for(int i = size-1; i >= index; i--) {
			this.array[i+1] = this.array[i];
		}
		this.array[index] = e;
		size++;
		if(this.isAlmostFull()) {
			this.doubleCapacity();
		}
	}
	
	public boolean isEmpty() {
		return (this.size == 0) ? true : false;
	}
	
	public String toString() {
		String ans = "[";
		for(int i = 0; i < size-1; i++) {
			ans += this.array[i] + ", ";
		}
		ans += this.array[size-1] + "]";
		return ans;
	}
	
	public int getSize() { return this.size; }
	public int getCapacity() { return this.capacity; }
}
