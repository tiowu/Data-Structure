package day_07_trees;

public class TreeNode<E>{
	int data;
	TreeNode<E> leftchild;
	TreeNode<E> rightchild;
	//TreeNode<E> parent;
	
	public TreeNode(int e) {
		data = e;
		leftchild = null;
		rightchild = null;
	}
	
	public TreeNode<E> getLeftChild(){
		return leftchild;
	}
	
	public TreeNode<E> getRightChild(){
		return rightchild;
	}
	
	public E getTreeNodeData(){
		return data;
	}
	
	
}
