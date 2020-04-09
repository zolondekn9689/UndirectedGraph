import java.util.ArrayList;

public class GraphDriver {

	public static void main(String[] args) {
		
		ArrayList<Vertex> vertices = new ArrayList<Vertex>();
		
		Vertex A = new Vertex("A");
		Vertex B = new Vertex("B");
		Vertex C = new Vertex("C");
		Vertex D = new Vertex("D");
		vertices.add(A);
		vertices.add(B);
		vertices.add(C);
		vertices.add(D);
		
		UndirectedGraph graph1 = new UndirectedGraph(vertices);
		System.out.println("Vertices only:\n "+graph1);
		
		graph1.addEdge(A, B);
		graph1.addEdge(B, C);
		graph1.addEdge(B, D);
		graph1.addEdge(C, D);
		System.out.println("Full graph1:\n"+graph1);

		UndirectedGraph bfsTree = graph1.breadthFirstSearch(A);
		System.out.println("BFS Tree:\n"+bfsTree);
		
		UndirectedGraph dfsTree = graph1.depthFirstSearch(A);
		System.out.println("DFS Tree:\n"+dfsTree);

	//Second Graph to test
		ArrayList<Vertex> vertices2 = new ArrayList<Vertex>();
		
		Vertex a = new Vertex("a");
		Vertex b = new Vertex("b");
		Vertex c = new Vertex("c");
		Vertex d = new Vertex("d");
		Vertex e = new Vertex("e");
		Vertex f = new Vertex("f");
				
		vertices2.add(a);
		vertices2.add(b);
		vertices2.add(c);
		vertices2.add(d);
		vertices2.add(e);
		vertices2.add(f);
		
		
		UndirectedGraph graph2 = new UndirectedGraph(vertices2);
				
		graph2.addEdge(a, c);
		graph2.addEdge(a, d);
		graph2.addEdge(c, e);
		graph2.addEdge(c, b);
		graph2.addEdge(d, e);
		graph2.addEdge(e, f);
		graph2.addEdge(b, f);
		
		System.out.println("Graph2:\n"+graph2);
		//BFS and DFS from Vertex a		
		UndirectedGraph bfsTree2 = graph2.breadthFirstSearch(a);
		System.out.println("\n\nBFS Tree2 from a:\n"+bfsTree2);
		
		UndirectedGraph dfsTree2 = graph2.depthFirstSearch(a);
		System.out.println("\nDFS Tree2 from a:\n"+dfsTree2);

		//BFS and DFS from Vertex c
		UndirectedGraph bfsTree2c = graph2.breadthFirstSearch(c);
		System.out.println("\nBFS Tree2 from c:\n"+bfsTree2c);
		
		UndirectedGraph dfsTree2c = graph2.depthFirstSearch(c);
		System.out.println("\nDFS Tree2 from c:\n"+dfsTree2c);


	}
}
