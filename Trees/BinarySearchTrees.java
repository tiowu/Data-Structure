package day_07_trees;

public class BinarySearchTrees {
	
	TreeNode root;
	
	BinarySearchTrees(){
		root = null;
	}
	
	public TreeNode insert(TreeNode root, int val) {
        if (root == null) {
        	root = new TreeNode(val);
            return root;
        }
        if (val < root.data)
        	root.leftchild = insert(root.leftchild, val);
        else if (val > root.data)
        	root.rightchild = insert(root.rightchild, val);
 
        return root;
    }
	
	//we can construct insert method iteratively
	public TreeNode insertt(TreeNode root, int val) {
		return root;
	}
 
	public TreeNode search(TreeNode root, int val) {	
        if (root == null || root.data == val)
            return root;
 
        if (val < root.data) {
            return search(root.leftchild, val);
        }
        else {
        	return search(root.rightchild, val);
        }
	}
	
	
	TreeNode deleteNode(TreeNode root, int val) {
        if (root == null)
            return root;
 
        // Recursive calls for ancestors of
        // node to be deleted
        if (val < root.data) {
            root.leftchild = deleteNode(root.leftchild, val);
            return root;
        } else if (root.data < val) {
            root.rightchild = deleteNode(root.rightchild, val);
            return root;
        }
        
        // We reach here because val == root.data 
        // when root is the node to be deleted 
        // If one of the children is empty
        if (root.leftchild == null) {
            TreeNode temp = root.rightchild;
            return temp;
        } else if (root.rightchild == null) {
            TreeNode temp = root.leftchild;
            return temp;
        }
        else {
            TreeNode succParent = root;
            // Find successor
            TreeNode succ = root.rightchild;
            while (succ.leftchild != null) {
                succParent = succ;
                succ = succ.leftchild;
            }
            // Delete successor.  Since successor
            // is always left child of its parent
            // we can safely make successor's right
            // right child as left of its parent.
            // If there is no succ, then assign
            // succ.right to succParent.right
            if (succParent != root)
                succParent.leftchild = succ.rightchild;
            else
                succParent.rightchild = succ.rightchild;
 
            // Copy Successor Data to root
            root.data = succ.data;
 
            // Delete Successor and return root
            return root;
        }
    }
	
	
	public static void main(String[] args) {

	}

}
