package day_02_arrays;

public class ExpendableArray {
	private int size;
	private int capacity;
	private String[] array;
	
	public ExpendableArray(){//default constructor
		this.size = 0;
		this.capacity = 5;
		this.array = new String[capacity];
		this.fillArray();
	}
	
	public ExpendableArray(int cap){
		this.size = 0;
		this.capacity = cap;
		this.array = new String[capacity];
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
		String[] temp = new String[this.capacity];//create double cap array
		
		for(int i = 0; i < this.size; i++) { //copy over from smaller array
			temp[i] = this.array[i];
		}
		this.array = temp; //change the reference
	}
	
	public String get(int index) {
		return this.array[index];
	}
	
	public void add(String e) {
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
