import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

class Neighbor {
	public int vertexNum;
	public Neighbor next;
//		int weight;
	
	public Neighbor (int vnum, Neighbor nbr) {
		this.vertexNum = vnum;
		this.next = nbr;
	}
}

class Vertex {
	public String name;
	public Neighbor adjList;
	
	public Vertex(String name, Neighbor neighbors) {
		this.name = name;
		this.adjList = neighbors;
	}
}
	
public class Graph {

	Vertex[] adjLists;
	
	public Graph(String file) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(file));
		
		String graphType = sc.next();
		boolean undirected = true;
		if (graphType.equalsIgnoreCase("directed")) {
			undirected = false;
		};
		
		adjLists = new Vertex[sc.nextInt()];
		
		// read vertices
		for (int v = 0; v < adjLists.length; v++) {
			adjLists[v] = new Vertex(sc.next(), null);
		}
		
		// read edges
		while (sc.hasNext()) {
			// read vertex names and translate to vertex numbers
			int v1 = indexForName(sc.next());
			int v2 = indexForName(sc.next());
			
			// add v2 to front of v1's adjacency list and
			// add v1 to front of v2's adjacency list
			adjLists[v1].adjList = new Neighbor(v2, adjLists[v1].adjList);
			if (undirected) {
				adjLists[v2].adjList = new Neighbor(v1, adjLists[v2].adjList);
			}
		}
	}
	
	public int indexForName(String name) {
		for (int v = 0; v < adjLists.length; v++) {
			if (adjLists[v].name.equals(name)) {
				return v;
			}
		}
		return -1;
	}

	public void print() {
		System.out.println();
		for (int v = 0; v < adjLists.length; v++) {
			System.out.print(adjLists[v].name);
			for (Neighbor nbr = adjLists[v].adjList; nbr != null; nbr = nbr.next) {
				System.out.print(" --> " + adjLists[nbr.vertexNum].name); 
			}
			System.out.println("\n");
		}
	}
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a graph input file name: ");
		String file = sc.nextLine();
		Graph graph = new Graph(file);
		graph.print();
		
	}
}
