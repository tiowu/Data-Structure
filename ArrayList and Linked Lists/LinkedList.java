package day_04_lists;

public class LinkedList<T> {

   //---------------------Nested Node Class---------------------//
    public class Node<T> {
        private T data;
        private Node next;
                
        public Node(T data) {
            this.data = data;
            this.next = null;
        }
        public void setNodeData(T data) { this.data = data; }
        public void setNodeNext(Node next) { this.next = next; }
        
        public T getNodeData() { return this.data; }
        public Node getNodeNext() { return this.next; }
    }
    //-----------------------------------------------------------//
    
    private Node dummyhead;
    private Node tail;
    private int length;
    
    public LinkedList() {
       dummyhead = new Node<T>(null); 
       tail = dummyhead;
       length = 0;
    }
    
    public void insertFirst(T data) {
       Node<T> tempNode = new Node<>(data);
       //tempNode.setNodeNext(dummyhead.getNodeNext());
       //dummyhead.setNodeNext(tempNode);
       tempNode.next = dummyhead.next;
       dummyhead.next = tempNode;
       if(tail == dummyhead) {
          tail = tempNode;
       }
       length++;
    }
    
    public void insertLast(T data) {
        Node<T> tempNode = new Node<T>(data);
        //tempNode.setNodeNext(tail.getNodeNext());
        //tail.setNodeNext(tempNode);
        tail.next = tempNode;
        tail = tempNode;
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
        else if (pos == 0) {
           insertFirst(data);
        }
        else {
           Node<T> tempNode = new Node<>(data);
           Node<T> current = dummyhead;
           for(int i = 0; i < pos; i++) {
             //current = current.getNodeNext();
             current = current.next; 
           }
           tempNode.next = current.next;
           current.next = tempNode;
           //tempNode.setNodeNext(current.getNodeNext());
           //current.setNodeNext(tempNode);
           length++;
        }
    }
    
    public void removeFirst() {
       if(isEmpty()) {
          System.out.println("List is empty.");
          return;
       }
       dummyhead.next = dummyhead.next.next;
       //dummyhead.setNodeNext(dummyhead.getNodeNext().getNodeNext());
       if(dummyhead.next == null) {
          tail = dummyhead;
       }
       length--;
    }
    
    public void removeLast() {
       if(isEmpty()) {
          System.out.println("List is empty.");
          return;
       }
       else if(length == 1) {
          dummyhead.next = null;
          tail = dummyhead;
       }
       else {
          Node current = dummyhead;
          while(current.next.next != null) {
             current = current.next;
          }
          current.next = null;
          //current.next = current.next.next;
          tail = current;
       }
       length--;
    }
    
    public void removeAtPosition(int pos) {
      
      if(length == 0 || pos < 0 || pos > length) {
         System.out.println("Invalid position.");
         return;
      }
      else if(pos == 0) {
          removeFirst();
      }
      else if(pos == length -1) {
          removeLast();
      }
      else {
          Node currrent = dummyhead;
          for(int i = 0; i < pos; i++) {
             currrent = currrent.next;
          }
          currrent = currrent.next.next;
          length--;
      }
    }
    
    public boolean isPresent(Node n) {
       Node<T> current = dummyhead.next;
       while(current != null) {
          if(current == n) {
             return true;
          }
          current = current.next;
       }
       return false;
       
       //Node current = dummyhead.getNodeNext();
       //while(current.getNodeData() != null) {
       //   if(current.getNodeData() == n.getNodeData())
       //      return true;
       //   current = current.getNodeNext();
       //}
       //return false;
    }
    
    public boolean isEmpty() {
       return length == 0;
       //if(length == 0) { 
       //   return true;
       //}
       //return false;
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
}
