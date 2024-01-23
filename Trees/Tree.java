package day_07_trees;

public class Tree<E> {
	
	TreeNode<E> root;
	int size;
	
	public E element(TreeNode<E> node) {
		if(node == null) return null;
		return node.data;
	}
	
	public void traversePreOrder(TreeNode<E> node) {
		if(node != null) {
			System.out.println(node.getTreeNodeData());
			traversePreOrder(node.getLeftChild());
			traversePreOrder(node.getRightChild());
		}
	}
	
	public void traverseInOrder(TreeNode<E> node) {
		if(node != null) {
			traverseInOrder(node.getLeftChild());
			System.out.println(node.getTreeNodeData());
			traverseInOrder(node.getRightChild());
		}
	}
	
	public void traversePostOrder(TreeNode<E> node) {
		if(node != null) {
			traversePostOrder(node.getLeftChild());
			traversePostOrder(node.getRightChild());
			System.out.println(node.getTreeNodeData());
		}
	}
	
	public Tree<E> insert(E data, TreeNode<E> node){
		if(data < node.getTreeNodeData()) {
			if(node.getLeftChild() != null) {
				
			}
		}
		else {
			if(node.getRightChild() != null) {
				
			}
		}
	}
	
	public TreeNode<E> getParent(TreeNode<E> node) {
		//return null if node == root
		return null;
	}
	
	public LinkedList<TreeNode<E>> getChildren(TreeNode<E> node) {
		
		return null;
	}
	
	
	public boolean isRoot(TreeNode<E> node) {
		return false;
	}
	
	public boolean isExternal(TreeNode<E> node) {
		return false;
	}
	
	public boolean isInternal(TreeNode<E> node) {
		return false;
	}
	
	public int nodeDepth(TreeNode<E> node) {
		return 0;
		
	}
	
	public int treeHeight() {
		return 0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public E getMin() {
		if(isEmpty()) {
			return null;
		}
		TreeNode<E> curr = root;
		while(curr.getLeftChild() != null) {
			curr = curr.getLeftChild();
		}
		return curr.getTreeNodeData();
	}
	
	public E getMax() {
		if(isEmpty()) {
			return null;
		}
		TreeNode<E> curr = root;
		while(curr.getRightChild() != null) {
			curr = curr.getRightChild();
		}
		return curr.getTreeNodeData();
	}
}
