package day_05_queue_stack;

public class ArrayQueue<E> {
	private E[] queue;
	private int size;
	private final int CAPACITY = 5;
	private int front;
	private int rear;
	
	@SuppressWarnings("unchecked")
	public ArrayQueue() {
		queue = (E[]) new Object[CAPACITY];
		size = 0;
		front = 0;
		rear = 0;
	}
	
	/**
	 * This methods can also be called "add" or "offer".
	 * Places an element at the end of the queue.
	 * What is the runtime?
	 * @param element
	 */
	public void enqueue(E element) {
	   if(size == queue.length) {
		   return;
	   }
		queue[rear] = element;
		rear = (rear + 1) % queue.length;
		size++;
	}
	
	/**
	 * This methods can also be called "pop" or "remove".
	 * Removes the element at the front of the queue.
	 * If queue is empty, it returns null.
	 * What is the runtime?
	 * @return E
	 */
	public E dequeue() {
	   if(size == 0) {
	      return null;
	   }
	   E temp = queue[front];
	   queue[front] = null;
	   front = (front + 1) % queue.length;
	   size--;
	   return temp;
	}
	
	/**
	 * This methods can also be called "peek" or "element".
	 * Returns but does not remove the element at the front of the queue.
	 * If queue is empty, it returns null.
	 * What is the runtime?
	 * @return E
	 */
	public E front() {
	   if(size == 0) {
	      return null;
	   }
	   return queue[front];
	}
	
	public boolean isEmpty(){
	   return size == 0;
	}
		
	public int size() {
		return size;
	}
}
