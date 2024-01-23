package day_07_trees;

import static org.junit.Assert.*;
import org.junit.Test;

import day_04_lists.LinkedList;
import day_04_lists.Node;

//import day_07_trees.Tree.TreeNode;

public class TreeTest {

    @Test
    public void testGetParent() {
        Tree<String> tree = new Tree<>();
        TreeNode<String> root = new TreeNode<>("Root");
        TreeNode<String> child = new TreeNode<>("Child");

        assertNull(tree.getParent(root));
        assertNull(tree.getParent(child));
    }

    @Test
    public void testGetChildren() {
        Tree<Character> tree = new Tree<>();
        TreeNode<Character> root = new TreeNode<>('A');
        TreeNode<Character> child1 = new TreeNode<>('B');
        TreeNode<Character> child2 = new TreeNode<>('C');

        root.leftchild = child1;
        root.rightchild = child2;

        LinkedList<TreeNode<Character>> children = tree.getChildren(root);
        assertNotNull(children);
        assertEquals(2, children.getLength());
        assertTrue(children.isPresent(new Node(child1)));
        assertTrue(children.isPresent(new Node(child2)));
    }

    @Test
    public void testIsRoot() {
        Tree<Double> tree = new Tree<>();
        TreeNode<Double> root = new TreeNode<>(3.14);

        assertTrue(tree.isRoot(root));
    }

    @Test
    public void testIsExternal() {
        Tree<String> tree = new Tree<>();
        TreeNode<String> externalNode = new TreeNode<>("External");

        assertTrue(tree.isExternal(externalNode));
    }

    @Test
    public void testIsInternal() {
        Tree<Integer> tree = new Tree<>();
        TreeNode<Integer> internalNode = new TreeNode<>(42);

        assertTrue(tree.isInternal(internalNode));
    }

    @Test
    public void testNodeDepth() {
        Tree<String> tree = new Tree<>();
        TreeNode<String> root = new TreeNode<>("Root");
        TreeNode<String> child1 = new TreeNode<>("Child1");
        TreeNode<String> child2 = new TreeNode<>("Child2");

        root.leftchild = child1;
        child1.leftchild = child2;

        assertEquals(0, tree.nodeDepth(root));
        assertEquals(1, tree.nodeDepth(child1));
        assertEquals(2, tree.nodeDepth(child2));
    }

    @Test
    public void testTreeHeight() {
        Tree<Integer> tree = new Tree<>();
        TreeNode<Integer> root = new TreeNode<>(10);
        TreeNode<Integer> child1 = new TreeNode<>(20);
        TreeNode<Integer> child2 = new TreeNode<>(30);
        TreeNode<Integer> grandchild1 = new TreeNode<>(40);
        TreeNode<Integer> grandchild2 = new TreeNode<>(50);

        root.leftchild = child1;
        root.rightchild = child2;
        child1.leftchild = grandchild1;
        child2.rightchild = grandchild2;

        assertEquals(3, tree.treeHeight());
    }

    @Test
    public void testSize() {
        Tree<String> tree = new Tree<>();
        TreeNode<String> root = new TreeNode<>("Root");
        TreeNode<String> child1 = new TreeNode<>("Child1");
        TreeNode<String> child2 = new TreeNode<>("Child2");

        root.leftchild = child1;
        root.rightchild = child2;

        assertEquals(3, tree.size());
    }
}

