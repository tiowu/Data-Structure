package day_04_lists;

public class DoublyLinkedList<T> {
	//---------------------Nested Node Class---------------------//
	public class Node<T> {
		private T data;
		private Node<T> prev;
		private Node<T> next;
		
		public Node(T data) {
			this.data = data;
			this.prev = null;
			this.next = null;
		}
		
		public T getNodeData() {return this.data;}
		public Node getNodePrev() {return this.prev;}
		public Node getNodeNext() {return this.next;}
		
		public void setNodeData(T data) {this.data = data;}
		public void setNodePrev(Node prev) {this.prev = prev;}
		public void setNodeNext(Node next) {this.next = next;}
	}
	//-----------------------------------------------------------//
	
	private Node dummyhead;
	private Node tail;
	private int length;
	
	public DoublyLinkedList() {
		dummyhead = new Node(null);
		tail = dummyhead;
		length = 0;
	}
	
	public void insertFirst(T data) {
	   Node<T> tempNode = new Node<>(data);
	   tempNode.next = dummyhead.next;
	   if(dummyhead.next != null) {
	      dummyhead.next.prev = tempNode;
	   }
	   tempNode.prev = dummyhead;
	   dummyhead.next = tempNode;
	   if(tail == dummyhead) {
          tail = tempNode;
       }
	   length++;
	   /*
	   tempNode.setNodeNext(dummyhead.getNodeNext());
	   if(dummyhead.getNodeNext() != null) {
	      dummyhead.getNodeNext().setNodePrev(tempNode);
	   }
	   tempNode.setNodePrev(dummyhead);
	   dummyhead.setNodeNext(tempNode);
	   if(tail == dummyhead) {
	      tail = tempNode;
	   }
	   */
	}
	
	public void insertLast(T data) {
		Node<T> tempNode = new Node<>(data);
		tempNode.prev = tail;
		tail.next = tempNode;
		tail = tempNode;
		/*
		tempNode.setNodePrev(tail);
		tail.setNodeNext(tempNode);
		tail = tempNode;
		*/
		length++;
	}
	
	public void insertAtPosition(T data, int pos) {
       if(pos < 0 || pos > length) {
          System.out.println("Invalid position number.");
          return;
       }
       else if (pos == length) {
          insertLast(data);
       }
       else if(pos == 0) {
          insertFirst(data);
       }
       else{
          Node<T> tempNode = new Node(data);
          Node<T> current = dummyhead;
          for(int i = 0; i < pos; i++) {
             current = current.next;
             //current = current.getNodeNext();
          }
          tempNode.next = current.next;
          tempNode.prev = current;
          if(current.next !=  null) {
             current.next.prev = tempNode;
          }
          current.next = tempNode;
       }
       length++;
       /*
       tempNode.setNodeNext(current.getNodeNext());
       tempNode.setNodePrev(current);
       if(current.getNodeNext() != null) {
          current.getNodeNext().setNodePrev(tempNode);
       }
       current.setNodeNext(tempNode);
       */
	}
	
	public void removeFirst() {
		if(length == 0) {
		   System.out.println("List is empty.");
		   return;
		}
		dummyhead.next = dummyhead.next.next;
		if(dummyhead.next != null) {
		   dummyhead.next.prev = dummyhead;
		}
		else {
		   tail = dummyhead;
		}
	    length--;
		/*
		dummyhead.setNodeNext(dummyhead.getNodeNext().getNodeNext());
		if(dummyhead.getNodeNext() != null) {
		   dummyhead.getNodeNext().setNodePrev(dummyhead);
		}
		else
		   tail = dummyhead;
		*/
	}
	
	public void removeLast() {
       if(length == 0) {
          System.out.println("List is empty.");
          return;
       }
       else if (length == 1) {
          dummyhead.next = null;
          tail = dummyhead;
       }
       else {
          Node<T> current = tail.prev;
          current.next = null;
          tail = current;
       }
       length--;
	}
	
	public void removeAtPosition(int pos) {
       if(length == 0 || pos < 0 || pos >= length) {
          System.out.println("Invalid position number.");
          return;
       }
       else if(pos == 0) {
          removeFirst();
       }
       else if(pos == length - 1) {
          removeLast();
       }
       else{
          Node<T> current = dummyhead;
          for(int i = 0; i < pos; i++) {
             current = current.next;
          }
          current.next = current.next.next; 
          current.next.prev = current;
          //current.next.next.prev = current;
          length--;
       }
	}
	
	public boolean isPresent(Node n) {
	   Node<T> current = dummyhead.next;
	   while(current != null) {
	      if(current == n)
	         return true;
	      current = current.next;
	   }
	   return false;
	}
	
	public boolean isEmpty() {
		return length == 0;
	}
	
	public Node getFirst() {
		return dummyhead.next;
	}
	
	public Node getLast() {
		return tail;
	}
	
	public int getLength() {
		return length;
	}
	
	public T[] toArray() {
	   if(length == 0) {
	      return null;
	   }
	   T[] array = (T[])new Object[length];
	   Node<T> current = dummyhead.next;
	   for(int i = 0; i < length; i++) {
	      array[i] = (T)current.data;
	      current = current.next;
	   }
	   return array;
	}
	
	public T[] toArrayInverse() {
	   if(length == 0) {
	      return null;
	   }
	   T[] array = (T[])new Object[length];
	   Node<T> current = tail;
	   for(int i = length - 1; i >= 0; i--) {
	      array[i] = (T)current.data;
	      current = current.prev;
	   }
	   return array;
	}

}
