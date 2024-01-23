package day_05_queue_stack;

import static org.junit.Assert.*;
import org.junit.Test;

public class ListQueueTest {

    @Test
    public void testEnqueueDequeue() {
    	ListQueue<Integer> queue = new ListQueue<>();
        assertTrue(queue.isEmpty());
        System.out.println("Test 1: Initial state - success");

        // Enqueue elements
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(3, queue.size());
        System.out.println("Test 2: Enqueue elements - success");

        // Dequeue elements
        assertEquals(Integer.valueOf(1), queue.dequeue());
        assertEquals(Integer.valueOf(2), queue.dequeue());
        assertEquals(Integer.valueOf(3), queue.dequeue());

        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
        System.out.println("Test 3: Dequeue elements - success");
    }

    @Test
    public void testFront() {
    	ListQueue<String> queue = new ListQueue<>();
        assertNull(queue.front());
        System.out.println("Test 4: Initial state - success");

        queue.enqueue("A");
        queue.enqueue("B");

        assertEquals("A", queue.front());
        System.out.println("Test 5: Front element after enqueue - success");

        // Dequeue and check front
        queue.dequeue();
        assertEquals("B", queue.front());
        System.out.println("Test 6: Front element after dequeue - success");
    }

    @Test
    public void testIsEmpty() {
    	ListQueue<Character> queue = new ListQueue<>();
        assertTrue(queue.isEmpty());
        System.out.println("Test 7: Initial state - success");

        queue.enqueue('A');
        assertFalse(queue.isEmpty());
        System.out.println("Test 8: Not empty after enqueue - success");

        queue.dequeue();
        assertTrue(queue.isEmpty());
        System.out.println("Test 9: Empty after dequeue - success");
    }

    @Test
    public void testSize() {
    	ListQueue<Double> queue = new ListQueue<>();
        assertEquals(0, queue.size());
        System.out.println("Test 10: Initial state - success");

        queue.enqueue(3.14);
        queue.enqueue(2.71);

        assertEquals(2, queue.size());
        System.out.println("Test 11: Size after enqueue - success");

        // Dequeue elements
        queue.dequeue();
        assertEquals(1, queue.size());
        System.out.println("Test 12: Size after dequeue - success");

        queue.dequeue();
        assertEquals(0, queue.size());
        System.out.println("Test 13: Size after dequeue all - success");
    }

    @Test
    public void testEnqueueEdgeCase() {
        // Test enqueueing more elements than the initial capacity
    	ListQueue<Integer> queue = new ListQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }

        assertEquals(10, queue.size());
        assertEquals(Integer.valueOf(0), queue.front());
        System.out.println("Test 14: Enqueue more than initial capacity - success");
    }

    @Test
    public void testDequeueEmptyQueue() {
        // Test dequeue on an empty queue
    	ListQueue<String> queue = new ListQueue<>();
        assertNull(queue.dequeue());
        System.out.println("Test 15: Dequeue from empty queue - success");
    }
}
