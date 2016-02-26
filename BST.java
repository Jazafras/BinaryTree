
/**
 * A Binary Search Tree is a Binary Tree with the following
 * properties:
 * 
 * For any node x: (1) the left child of x compares "less than" x; 
 * and (2) the right node of x compares "greater than or equal to" x
 *
 *
 * @param <T> the type of data object stored by the BST's Nodes
 */
public class BST<T extends Comparable<T>> {

	/**
	 * The root Node is a reference to the 
	 * Node at the 'top' of a QuestionTree
	 */
	private Node<T> root;
	
	
	/**
	 * Construct a BST
	 */
	public BST() {
		root = null;
	}
	
	/**
	 * @return the root of the BST
	 */
	public Node<T> getRoot() { 
		return root;
	}
	
	/**
	 * _Part 1: Implement this method._
	 *
	 * Add a new piece of data into the tree. To do this, you must:
	 * 
	 * 1) If the tree has no root, create a root node 
	 *    with the supplied data
	 * 2) Otherwise, walk the tree from to the bottom (to a leaf) as though
	 *    searching for the supplied data. Then:
	 * 3) Add a new Node to the leaf where the search ended.
	 *
	 * @param data - the data to be added to the tree
	 */
	public void add(T data) {
		// TODO: implement this
		return;
	}
	

	/**
	 * _Part 2: Implement this method._
	 * 
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
		// TODO: implement this
		return null;
	}

	/**
	 * _Part 3: Implement this method._
	 *  
	 * @return the Node with the largest value in the BST
	 */
	public Node<T> maximum() {
		// TODO: implement this
		return null;
	}
	
	/**
	 * _Part 4: Implement this method._
	 *  
	 * @return the Node with the smallest value in the BST
	 */
	public Node<T> minimum() {
		// TODO: implement this
		return null;
	}
	

	
	/**
	 * _Part 5: Implement this method._
	 *  
	 * Searches for a Node with the specified key.
	 * If found, this method removes that node
	 * while maintaining the properties of the BST.
	 *  
	 * @return the Node that was removed or null.
	 */
	public Node<T> remove(T data) {
		// TODO: implement this
		return null;
	}
	
	/**
	 * 
	 * The Node class for our BST.  The BST
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
