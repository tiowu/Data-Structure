package day_06_hashmaps;

public class LinkedList<T> {
	
	private Node<T> dummyhead;
	private Node<T> tail;
	private int length;
	
	public LinkedList() {
		dummyhead = new Node<T>(null);
		tail = dummyhead;
		length = 0;
	}
	
	public void insertFirst(T data) {
		Node<T> node = new Node<>(data);
		node.next = dummyhead.next;
		dummyhead.next = node;
		if(length == 0)	tail = tail.next;
		length++;
	}
	
	public void insertLast(T data) {
		Node<T> node = new Node<>(data);
		tail.next = node;
		tail = tail.next;
		length++;
	}
	
	public void insertAtPosition(T data, int pos) {
		if(pos == 0) {
			insertFirst(data);
		}
		else if(pos >= length) {
			insertLast(data);
		} 
		else {
			Node<T> node = new Node<>(data);
			Node<T> curr = this.dummyhead;
			for(int i = 0; i < pos; i++) {
				curr = curr.next;
			}
			
			node.next = curr.next;
			curr.next = node;
		}
		
		
		this.length++;
	}
	
	public void removeFirst() {
		if(this.length == 0) return;
		this.dummyhead.next = dummyhead.next.next;
		this.length--;
	}
	
	public void removeLast() {
		if(this.length == 0) {
			return;
		}
		else if(this.length == 1) {
			this.dummyhead.next = null;
			this.tail = this.dummyhead;
		} 
		else {
			Node<T> curr = this.dummyhead;
			while(curr.next.next != null) {
				curr = curr.next;
			}
		
			curr.next = null;
			this.tail = curr;
		}
		this.length--;
	}
	
	public void removeAtPosition(int pos) {
		
		if(this.length == 0 || pos > this.length) {
			return;
		}
		else if(pos == 0) {
			this.removeFirst();
		}
		else if(pos == this.length-1) {
			this.removeLast();
		}
		else {
			Node<T> curr = this.dummyhead;
			for(int i = 0; i < pos; i++) {
				curr = curr.next;
			}
			curr = curr.next.next;
			this.length--;
		}
		
		
	}
	
	public boolean isPresent(Node<T> n) {
		Node<T> curr = dummyhead.next;
		while(curr != null) {
			if(curr == n) return true;
			curr = curr.next;
		}
		return false;
	}
	
	
	public boolean isEmpty() {
		return this.length == 0;
	}
	
	public Node<T> getFirst() {
		return this.dummyhead.next;
	}
	
	public Node<T> getLast() {
		return this.tail;
	}
	
	public int getLength() {
		return this.length;
	}
	
	public String toString() {
		String ans = "";
		Node<T> curr = this.dummyhead.next;
		while(curr != null) {
			ans += curr.data + " -> ";
			curr = curr.next;
		}
		
		return ans + "null\n";
	}
	
}
