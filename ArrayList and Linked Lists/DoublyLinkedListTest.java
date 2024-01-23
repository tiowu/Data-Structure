package day_04_lists;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class DoublyLinkedListTest {

    @Test
    public void testInsertFirst() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        // Test case 1
        list.insertFirst(5);
        if (5 == (int) list.getFirst().getNodeData() && 1 == list.getLength()) {
            System.out.println("testInsertFirst - Case 1: SUCCESS");
        } else {
            System.out.println("testInsertFirst - Case 1: FAILURE");
        }

        // Test case 2
        list.insertFirst(10);
        if (10 == (int) list.getFirst().getNodeData() && 2 == list.getLength()) {
            System.out.println("testInsertFirst - Case 2: SUCCESS");
        } else {
            System.out.println("testInsertFirst - Case 2: FAILURE");
        }

        // Add more test cases as needed
    }

    @Test
    public void testInsertLast() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();

        // Test case 1
        list.insertLast("Hello");
        if ("Hello".equals(list.getLast().getNodeData()) && 1 == list.getLength()) {
            System.out.println("testInsertLast - Case 1: SUCCESS");
        } else {
            System.out.println("testInsertLast - Case 1: FAILURE");
        }

        // Test case 2
        list.insertLast("World");
        if ("World".equals(list.getLast().getNodeData()) && 2 == list.getLength()) {
            System.out.println("testInsertLast - Case 2: SUCCESS");
        } else {
            System.out.println("testInsertLast - Case 2: FAILURE");
        }

        // Add more test cases as needed
    }

    @Test
    public void testInsertAtPosition() {
        DoublyLinkedList<Character> list = new DoublyLinkedList<>();
        list.insertFirst('A');
        list.insertLast('C');

        // Test case 1
        list.insertAtPosition('B', 1);
        if ('B' == (Character) list.getFirst().getNodeNext().getNodeData() && 3 == list.getLength()) {
            System.out.println("testInsertAtPosition - Case 1: SUCCESS");
        } else {
            System.out.println("testInsertAtPosition - Case 1: FAILURE");
        }

        // Test case 2
        list.insertAtPosition('X', 2);
        if ('X' == (Character) list.getFirst().getNodeNext().getNodeNext().getNodeData() && 4 == list.getLength()) {
            System.out.println("testInsertAtPosition - Case 2: SUCCESS");
        } else {
            System.out.println("testInsertAtPosition - Case 2: FAILURE");
        }

        // Add more test cases as needed
    }

    @Test
    public void testRemoveFirst() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.insertFirst(1);
        list.insertLast(2);

        // Test case 1
        list.removeFirst();
        if (2 == (int) list.getFirst().getNodeData() && 1 == list.getLength()) {
            System.out.println("testRemoveFirst - Case 1: SUCCESS");
        } else {
            System.out.println("testRemoveFirst - Case 1: FAILURE");
        }

        // Test case 2
        list.insertFirst(3);
        list.removeFirst();
        if (2 == (int) list.getFirst().getNodeData() && 1 == list.getLength()) {
            System.out.println("testRemoveFirst - Case 2: SUCCESS");
        } else {
            System.out.println("testRemoveFirst - Case 2: FAILURE");
        }

        // Add more test cases as needed
    }

    @Test
    public void testRemoveLast() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.insertFirst("First");
        list.insertLast("Last");

        // Test case 1
        list.removeLast();
        if ("First".equals(list.getFirst().getNodeData()) && 1 == list.getLength()) {
            System.out.println("testRemoveLast - Case 1: SUCCESS");
        } else {
            System.out.println("testRemoveLast - Case 1: FAILURE");
        }

        // Test case 2
        list.insertLast("NewLast");
        list.removeLast();
        if ("First".equals(list.getFirst().getNodeData()) && 1 == list.getLength()) {
            System.out.println("testRemoveLast - Case 2: SUCCESS");
        } else {
            System.out.println("testRemoveLast - Case 2: FAILURE");
        }

        // Add more test cases as needed
    }

    @Test
    public void testRemoveAtPosition() {
        DoublyLinkedList<Character> list = new DoublyLinkedList<>();
        list.insertFirst('A');
        list.insertLast('C');
        list.insertAtPosition('B', 1);

        // Test case 1
        list.removeAtPosition(1);
        if ('A' == (Character) list.getFirst().getNodeData() && 'C' == (Character) list.getLast().getNodeData() && 2 == list.getLength()) {
            System.out.println("testRemoveAtPosition - Case 1: SUCCESS");
        } else {
            System.out.println("testRemoveAtPosition - Case 1: FAILURE");
        }

        // Test case 2
        list.insertAtPosition('X', 2);
        list.removeAtPosition(3);
        if ('A' == (Character) list.getFirst().getNodeData() && 'X' == (Character) list.getLast().getNodeData() && 2 == list.getLength()) {
            System.out.println("testRemoveAtPosition - Case 2: SUCCESS");
        } else {
            System.out.println("testRemoveAtPosition - Case 2: FAILURE");
        }

        // Add more test cases as needed
    }

    @Test
    public void testIsEmpty() {
        DoublyLinkedList<Double> emptyList = new DoublyLinkedList<>();
        DoublyLinkedList<Integer> nonEmptyList = new DoublyLinkedList<>();
        nonEmptyList.insertFirst(1);

        // Test case 1
        if (emptyList.isEmpty()) {
            System.out.println("testIsEmpty - Case 1: SUCCESS");
        } else {
            System.out.println("testIsEmpty - Case 1: FAILURE");
        }

        // Test case 2
        if (!nonEmptyList.isEmpty()) {
            System.out.println("testIsEmpty - Case 2: SUCCESS");
        } else {
            System.out.println("testIsEmpty - Case 2: FAILURE");
        }

        // Add more test cases as needed
    }

    @Test
    public void testIsPresent() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.insertFirst(1);
        list.insertLast(2);

        // Test case 1
        if (list.isPresent(list.getFirst())) {
            System.out.println("testIsPresent - Case 1: SUCCESS");
        } else {
            System.out.println("testIsPresent - Case 1: FAILURE");
        }

        // Test case 2
        if (!list.isPresent(new DoublyLinkedList<Integer>().getFirst())) {
            System.out.println("testIsPresent - Case 2: SUCCESS");
        } else {
            System.out.println("testIsPresent - Case 2: FAILURE");
        }

        // Add more test cases as needed
    }

    @Test
    public void testGetFirst() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.insertFirst(1);
        list.insertLast(2);

        // Test case 1
        if (1 == (int) list.getFirst().getNodeData()) {
            System.out.println("testGetFirst - Case 1: SUCCESS");
        } else {
            System.out.println("testGetFirst - Case 1: FAILURE");
        }

        // Test case 2
        list.removeFirst();
        if (2 == (int) list.getFirst().getNodeData()) {
            System.out.println("testGetFirst - Case 2: SUCCESS");
        } else {
            System.out.println("testGetFirst - Case 2: FAILURE");
        }

        // Add more test cases as needed
    }

    @Test
    public void testGetLast() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.insertFirst("First");
        list.insertLast("Last");

        // Test case 1
        if ("Last".equals(list.getLast().getNodeData())) {
            System.out.println("testGetLast - Case 1: SUCCESS");
        } else {
            System.out.println("testGetLast - Case 1: FAILURE");
        }

        // Test case 2
        list.removeLast();
        if ("First".equals(list.getLast().getNodeData())) {
            System.out.println("testGetLast - Case 2: SUCCESS");
        } else {
            System.out.println("testGetLast - Case 2: FAILURE");
        }

        // Add more test cases as needed
    }

    @Test
    public void testGetLength() {
        DoublyLinkedList<Character> list = new DoublyLinkedList<>();
        list.insertFirst('A');
        list.insertLast('C');
        list.insertAtPosition('B', 1);

        // Test case 1
        if (3 == list.getLength()) {
            System.out.println("testGetLength - Case 1: SUCCESS");
        } else {
            System.out.println("testGetLength - Case 1: FAILURE");
        }

        // Test case 2
        list.removeAtPosition(1);
        if (2 == list.getLength()) {
            System.out.println("testGetLength - Case 2: SUCCESS");
        } else {
            System.out.println("testGetLength - Case 2: FAILURE");
        }

        // Add more test cases as needed
    }

    @Test
    public void testToArray() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.insertFirst(1);
        list.insertLast(2);

        // Test case 1
        Integer[] array = list.toArray();
        Integer[] expectedArray = {1, 2};
        if (Arrays.equals(expectedArray, array)) {
            System.out.println("testToArray - Case 1: SUCCESS");
        } else {
            System.out.println("testToArray - Case 1: FAILURE");
        }

        // Test case 2
        list.insertAtPosition(3, 2);
        array = list.toArray();
        Integer[] expectedArray2 = {1, 3, 2};
        if (Arrays.equals(expectedArray2, array)) {
            System.out.println("testToArray - Case 2: SUCCESS");
        } else {
            System.out.println("testToArray - Case 2: FAILURE");
        }

        // Add more test cases as needed
    }

    @Test
    public void testToArrayInverse() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.insertFirst("First");
        list.insertLast("Last");

        // Test case 1
        String[] array = list.toArrayInverse();
        String[] expectedArray = {"Last", "First"};
        if (Arrays.equals(expectedArray, array)) {
            System.out.println("testToArrayInverse - Case 1: SUCCESS");
        } else {
            System.out.println("testToArrayInverse - Case 1: FAILURE");
        }

        // Test case 2
        list.removeLast();
        list.insertLast("NewLast");
        array = list.toArrayInverse();
        String[] expectedArray2 = {"NewLast", "First"};
        if (Arrays.equals(expectedArray2, array)) {
            System.out.println("testToArrayInverse - Case 2: SUCCESS");
        } else {
            System.out.println("testToArrayInverse - Case 2: FAILURE");
        }

        // Add more test cases as needed
    }
}
