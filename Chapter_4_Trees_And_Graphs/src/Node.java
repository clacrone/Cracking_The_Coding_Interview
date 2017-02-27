import java.util.LinkedList;


public class Node {

	public Node left;
	public Node right;
	public int data;
	
	// Used for Graph
	public State state;
	public Node parent;
	
	
	public Node(int d) {
		// TODO Auto-generated constructor stub
		data = d;
	}


	public LinkedList<Node> getAdjacent() {
		// TODO Auto-generated method stub
		return null;
	}

}
