import java.util.ArrayList;
import java.util.LinkedList;


public class BinarySearchTree {
	
	Node root;
	
	public BinarySearchTree() {
		// TODO Auto-generated constructor stub
		root = null;
	}

	public boolean isEmpty() {
		if (root == null) {
			return true;
		}
		
		return false;
	}
	
	public int checkHeight(Node root) {
		if (root == null) {
			return 0;
		}
		
		int leftHeight = checkHeight(root.left);
		if (leftHeight == -1) {
			return -1;
		}
		
		int rightHeight = checkHeight(root.right);
		if (rightHeight == -1) {
			return -1;
		}
		
		int heightDiff = leftHeight - rightHeight;
		if (Math.abs(heightDiff) > 1) {
			return -1;
		} else {
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}
	
	public boolean isBalanced(Node root) {
		if (checkHeight(root) == -1) {
			return false;
		}
		return true;
	}
	
	public boolean insert(int d) {
		Node newNode = new Node(d);
		if (isEmpty()) {
			root = newNode;
		} else {
			Node curr = root;
			boolean isInserted = false;
			
			while (!isInserted) {
				if (newNode.data < curr.data) {
					if (curr.left == null) {
						curr.left = newNode;
						isInserted = true;
					} else {
						curr = curr.left;
					}
				} else if (newNode.data > curr.data) {
					if (curr.right == null) {
						curr.right = newNode;
						isInserted = true;
					} else {
						curr = curr.right;
					}
				} else {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public Node createMinimalBST(int[] arr, int start, int end) {
		if (end < start) {
			return null;
		}
		
		int mid = (start + end) / 2;
		Node n = new Node(arr[mid]);
		n.left = createMinimalBST(arr, start, mid - 1);
		n.right = createMinimalBST(arr, mid + 1, end);
		return n;
	}
	
	public Node createMinimalBST(int[] array) {
		return createMinimalBST(array, 0, array.length - 1);
	}
	
	public ArrayList<LinkedList<Node>> createLevelLinkedList(Node root) {
		ArrayList<LinkedList<Node>> result = new ArrayList<LinkedList<Node>>();
		
		LinkedList<Node> current = new LinkedList<Node>();
		if (root != null) {
			current.add(root);
		}
		
		while (current.size() > 0) {
			result.add(current);
			LinkedList<Node> parents = current;
			current = new LinkedList<Node>();
			for (Node parent : parents) {
				if (parent.left != null) {
					current.add(parent.left);
				}
				if (parent.right != null) {
					current.add(parent.right);
				}
			}
		}
		return result;
	}
	
	public boolean isBST(Node n) {
		return isBST(n, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public boolean isBST(Node n, int min, int max) {
		if (n == null) {
			return true;
		}
		
		if (n.data <= min || n.data > max) {
			return false;
		}
		
		if (!isBST(n.left, min, n.data) || !isBST(n.right, n.data, max)) {
			return false;
		}
		
		return true;
	}
	
	public Node inorderSucc(Node n) {
		if (n == null) {
			return null;
		}
		
		if (n.right != null) {
			return leftmostChild(n.right);
		} else {
			Node q = n;
			Node x = q.parent;
			
			while (x != null && x.left != q) {
				q = x;
				x = x.parent;
			}
			return x;
		}
	}
	
	private Node leftmostChild(Node n) {
		// TODO Auto-generated method stub
		if (n == null) {
			return null;
		}
		
		while (n.left != null) {
			n = n.left;
		}
		return n;
	}
	
	public Node commonAncestor(Node root, Node p, Node q) {
		if (!covers(root, p) || !covers(root, q)) {
			return null;
		}
		
		return commonAncestorHelper(root, p, q);
	}

	private Node commonAncestorHelper(Node root, Node p, Node q) {
		// TODO Auto-generated method stub
		if (root == null) {
			return null;
		}
		
		if (root == p || root == q) {
			return root;
		}
		
		boolean is_p_on_left = covers(root.left, p);
		boolean is_q_on_left = covers(root.left, q);
		
		if (is_p_on_left != is_q_on_left) {
			return root;
		}
		
		Node childSide = is_p_on_left ? root.left : root.right;
		return commonAncestorHelper(childSide, p, q);
	}

	private boolean covers(Node root, Node p) {
		// TODO Auto-generated method stub
		if (root == null) {
			return false;
		}
		
		if (root == p) {
			return true;
		}
		
		return covers(root.left, p) || covers(root.right, p);
	}

	public void print(Node root) {
		if (root == null) {
			return;
		}
		System.out.println("root: " + root.data);
		printHelper(root);
	}
	
	public void printHelper(Node curr) {
		if (curr == null) {
			return;
		}
		
		printHelper(curr.left);
		System.out.print(curr.data + " => ");
		printHelper(curr.right);
	}
}
