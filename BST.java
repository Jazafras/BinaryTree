/**
 * For any node x: 
 * (1) the left child of x compares "less than" x; 
 * (2) the right node of x compares "greater than or equal to" x
 * 
 * @param <T> the type of data object stored by the BST's Nodes
 */
public class BST<T extends Comparable<T>> {

	/**The root Node is a reference to the Node at the 'top' of a QuestionTree**/
	private Node<T> root;
	
	
	/** Construct a BST**/
	public BST() {
		root = null;
	}
	
	/**@return the root of the BST**/
	public Node<T> getRoot() { 
		return root;
	}
	
	/**
	 * 1) If the tree has no root, create a root node 
	 *    with the supplied data
	 * 2) Otherwise, walk the tree from to the bottom (to a leaf) as though
	 *    searching for the supplied data. Then:
	 * 3) Add a new Node to the leaf where the search ended.
	 * @param data - the data to be added to the tree
	 */
	public void add(T data) {
		Node<T> x = root;
		Node<T> y = null;
		while (x != null) //trying to find the bottom of the tree where the new data should be inserted
		{
			y = x;
			if (data.compareTo(x.data) < 0) //new data is less than the data it's being compared to
				x = x.left;
			else 
			{
				x = x.right; //new data is greater than the data it's being compared to
			}
		}
		if (y == null) //tree has no root
		{
			root = new Node<T>(data); //new inserted data is the root
		}
		else //tree has a root
		{
			if (data.compareTo(y.data) < 0)
			{
				y.left = new Node<T>(data); 
				y.left.parent = y;
			}
			else 
			{
				y.right = new Node<T>(data);
				y.right.parent = y;
			}
		}
		return;
	}
	

	/**
	 * Find a Node containing the specified key and
	 * return it.  If such a Node cannot be found,
	 * return null.  This method works by walking
	 * through the tree starting at the root and
	 * comparing each Node's data to the specified 
	 * key and then branching appropriately.
	 * 
	 * @param key - the data to find in the tree
	 * @return a Node containing the key data, or null.
	 */
	public Node<T> find(T key) {
		Node<T> x = root;
		while (x != null)
		{
			if (key.compareTo(x.data) < 0) //key is less than the data it's being compared to
			{	
				x = x.left;
			}
			if (key.compareTo(x.data) > 0) //key is greater than the data it's being compared to
			{
				x = x.right; 
			}
			if (key.compareTo(x.data) == 0) //key was found
			{
				return x;
			}
		}
		return null; //key wasn't found
	}

	/**@return the Node with the largest value in the BST**/
	public Node<T> maximum() {
		Node<T> x = root;
		while (x.right != null) //keep checking the right side until you reach the bottom
		{
			x = x.right; //number farthest to the right is the largest number
		}
		return x;
	}
	
	/**@return the Node with the smallest value in the BST**/
	public Node<T> minimum() {
		Node<T> x = root;
		while (x.left != null) //keep checking the left side until you reach the bottom
		{
			x = x.left; //number farthest to the left is the smallest number
		}
		return x;
	}
	

	
	/** 
	 * Search for a Node with the specified key.
	 * If found, this method removes that node
	 * while maintaining the properties of the BST.
	 *  
	 * @return the Node that was removed or null.
	 */
	public Node<T> remove(T data) {
		if (find(data) != null) //data is in the tree
		{
			Node<T> x = find(data);
			if (x.left == null && x.right == null) //data has no children
			{
				if (x.parent == null) //x is the root
				{
					root = null;
				}
				else if (x.parent.right == x) //data is on the right side of the parent
				{
					x.parent.right = null;
					x.parent = null;
				}
				else //data is on the left side of the parent
				{
					x.parent.left = null;
					x.parent = null;
				}
			}
			else if (x.left != null && x.right == null) //data has one child on the left
			{
				x.left.parent = x.parent; //x's parent is now the parent of x's left child
				x.parent.left = x.left; //x's left child is now x's parent's left child
				x.parent = null;
				x.left = null;
			}
			else if (x.left == null && x.right != null) // data has one child on the right
			{
				x.right.parent = x.parent; //x's parent is now the parent of x's right child
				x.parent.right = x.right; //x's right child is now x's parent's right children
				x.parent = null;
				x.right = null;
			}
			
			else if (x.left != null && x.right != null) //data has two children
			{
				Node<T> y = x.right;
				while (y.left != null) //keep checking the left side until you reach the bottom
				{
					y = y.left; //number farthest to the left is the smallest number
				}
				x.right.parent = y; //assign y as the new parent to x's children
				x.left.parent = y;
				y.left = x.left; //link y to x's children
				y.right = x.right;
				if (x.parent.left == x) //node being removed is on the left side of the parent
				{
					x.parent.left = y; //link x's parent to y
				}
				else //node being removed is on the right side of the parent
				{
					x.parent.right = y; //link x's parent to y
				}
				x.parent = y.parent;
				y.parent.left = null;

			}
			return x;
			
		}
		return null;
	}
	
	/**
	 * The Node class for BST.  The BST
	 * as defined above is constructed from zero or more
	 * Node objects. Each object has between 0 and 2 children
	 * along with a data member that must implement the
	 * Comparable interface.
	 * 
	 * @param <T>
	 */
	public static class Node<T extends Comparable<T>> {
		private Node<T> parent;
		private Node<T> left;
		private Node<T> right;
		private T data;
		
		private Node(T d) {
			data = d;
			parent = null;
			left = null;
			right = null;
		}
		public Node<T> getParent() { return parent; }
		public Node<T> getLeft() { return left; }
		public Node<T> getRight() { return right; }
		public T getData() { return data; }
	}
}
