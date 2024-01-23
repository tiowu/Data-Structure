package day_05_queue_stack;

import static org.junit.Assert.*;
import org.junit.Test;

public class ListStackTest {

    @Test
    public void testPushPop() {
    	ListStack<Integer> stack = new ListStack<>();
        assertTrue(stack.isEmpty());
        System.out.println("Test 1: Initial state - success");

        // Push elements
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.size());
        System.out.println("Test 2: Push elements - success");

        // Pop elements
        assertEquals(Integer.valueOf(3), stack.pop());
        assertEquals(Integer.valueOf(2), stack.pop());
        assertEquals(Integer.valueOf(1), stack.pop());

        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
        System.out.println("Test 3: Pop elements - success");
    }

    @Test
    public void testPeek() {
    	ListStack<String> stack = new ListStack<>();
        assertNull(stack.peek());
        System.out.println("Test 4: Initial state - success");

        stack.push("A");
        stack.push("B");

        assertEquals("B", stack.peek());
        System.out.println("Test 5: Peek element after push - success");

        // Pop and check peek
        stack.pop();
        assertEquals("A", stack.peek());
        System.out.println("Test 6: Peek element after pop - success");
    }

    @Test
    public void testIsEmpty() {
    	ListStack<Character> stack = new ListStack<>();
        assertTrue(stack.isEmpty());
        System.out.println("Test 7: Initial state - success");

        stack.push('A');
        assertFalse(stack.isEmpty());
        System.out.println("Test 8: Not empty after push - success");

        stack.pop();
        assertTrue(stack.isEmpty());
        System.out.println("Test 9: Empty after pop - success");
    }

    @Test
    public void testSize() {
    	ListStack<Double> stack = new ListStack<>();
        assertEquals(0, stack.size());
        System.out.println("Test 10: Initial state - success");

        stack.push(3.14);
        stack.push(2.71);

        assertEquals(2, stack.size());
        System.out.println("Test 11: Size after push - success");

        // Pop elements
        stack.pop();
        assertEquals(1, stack.size());
        System.out.println("Test 12: Size after pop - success");

        stack.pop();
        assertEquals(0, stack.size());
        System.out.println("Test 13: Size after pop all - success");
    }

    @Test
    public void testPushEdgeCase() {
        // Test pushing more elements than the initial capacity
    	ListStack<Integer> stack = new ListStack<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }

        assertEquals(10, stack.size());
        assertEquals(Integer.valueOf(9), stack.peek());
        System.out.println("Test 14: Push more than initial capacity - success");
    }

    @Test
    public void testPopEmptyStack() {
        // Test pop on an empty stack
    	ListStack<String> stack = new ListStack<>();
        assertNull(stack.pop());
        System.out.println("Test 15: Pop from empty stack - success");
    }
}