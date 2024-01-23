package day_05_queue_stack;

public class ArrayStack<E> {
	private E[] stack;
	private int size;
	private final int CAPACITY = 5;
	private int top;
	
	@SuppressWarnings("unchecked")
	public ArrayStack() {
		stack = (E[]) new Object[CAPACITY];
		top = -1;
		size = 0;
	}
	
	/**
	 * Places an element at the top of the stack.
	 * What is the runtime?
	 * @param element
	 */
	public void push(E element) {
		if(size == stack.length) {
			return;
		   //increase the length of stack array;
		}
		top++;
		stack[top] = element;
		size++;
	}
	
	/**
	 * Removes the element at the top of the stack.
	 * If stack is empty, it returns null.
	 * What is the runtime?
	 * @return E
	 */
	public E pop() {
	   if(size == 0) {
	      return null;
	   }
	   else {
	      E temp = stack[top];
	      stack[top] = null;
	      top--;
	      size--;
	      return temp;
	   }
	}
	
	/**
	 * Returns but does not remove the element at the top of the stack.
	 * If stack is empty, it returns null.
	 * What is the runtime?
	 * @return E
	 */
	public E peek() {
	   if(size == 0) {
	      return null;
	   }
	   else {
	      return stack[top];
	   }
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size() {
		return size;
	}
}
