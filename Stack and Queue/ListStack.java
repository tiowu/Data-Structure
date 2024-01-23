package day_05_queue_stack;

public class ListStack<E> {
	LinkedList<E> stack;
	
	
	@SuppressWarnings("unchecked")
	public ListStack() {
		stack = new LinkedList<>();
	}
	
	/**
	 * Places an element at the top of the stack.
	 * What is the runtime?
	 * @param element
	 */
	public void push(E element) {
		stack.insertFirst(element);
	}
	
	/**
	 * Removes the element at the top of the stack.
	 * If stack is empty, it returns null.
	 * What is the runtime?
	 * @return E
	 */
	public E pop() {
	   if(isEmpty()){
	      return null;
	   }
	   E temp = (E) stack.getFirst().getNodeData();
	   stack.removeFirst();
	   return temp;
	}
	
	/**
	 * Returns but does not remove the element at the top of the stack.
	 * If stack is empty, it returns null.
	 * What is the runtime?
	 * @return E
	 */
	public E peek() {
		if(isEmpty()) {
			return null;
		}
		E temp = (E) stack.getFirst().getNodeData();
		return temp;
	}
	
	public boolean isEmpty() {
		return stack.isEmpty();
	}
	
	public int size() {
		return stack.getLength();
	}
}
