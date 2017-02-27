import java.util.LinkedList;


public class Main {
	
	public static boolean search(Graph g, Node start, Node end) {
		LinkedList<Node> queue = new LinkedList<Node>();
		
		for (Node u : g.getNodes()) {
			u.state = State.Unvisited;
		}
		start.state = State.Visiting;
		queue.add(start);
		Node u;
		while (!queue.isEmpty()) {
			u = queue.removeFirst();
			if (u != null) {
				for (Node v : u.getAdjacent()) {
					if (v.state == State.Unvisited) {
						if (v == end) {
							return true;
						} else {
							v.state = State.Visiting;
							queue.add(v);
						}
					}
				}
				u.state = State.Visited;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(5);
		tree.insert(3);
		tree.insert(4);
		tree.insert(1);
		tree.insert(2);
		tree.insert(0);
		
		tree.insert(7);
		tree.insert(6);
		tree.insert(8);
		tree.insert(10);
		tree.insert(9);
		tree.insert(11);
		boolean result = tree.isBalanced(tree.root);
		System.out.println("result: " + result);
		
		tree.print(tree.root);
	}

}
