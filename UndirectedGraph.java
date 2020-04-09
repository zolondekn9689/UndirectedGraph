
import java.lang.reflect.Array;
import java.util.*;

/**
 * @author Nick Zolondek
 */
public class UndirectedGraph
{
    /**
     * Vertices to store name and list of adjacent vertexes.
     */
    private HashMap<String, LinkedList<Vertex>> vertices;

    /**
     * List of all the vertexes.
     */
    private ArrayList<Vertex> listOfVertices;


    /**
     * A constructor for an undirected graph.
     * @param listOfVertices
     */
    public UndirectedGraph(ArrayList<Vertex> listOfVertices)
    {
        vertices = new HashMap<String, LinkedList<Vertex>>();

        for (int i = 0; i < listOfVertices.size(); i++) {
            vertices.put(listOfVertices.get(i).getName(), new LinkedList<>());
        }
        this.listOfVertices = listOfVertices;
    }


    /**
     * Add an edge to the graph.
     * @param u vertex as a key
     * @param v vertex as a resultant vertex.
     * @return true or false.
     */
    public boolean addEdge(Vertex u, Vertex v)
    {
        return (vertices.get(u.getName()).add(v) && vertices.get(v.getName()).add(u));
    }


    /**
     * Breadth first search.
     * @param start starting at this vertex.
     * @return a new undirected graph.
     */
    public UndirectedGraph breadthFirstSearch(Vertex start)
    {


        //Set vertices white.
        for (int i = 0; i < listOfVertices.size(); i++)
        {
            // Set color white.
            listOfVertices.get(i).setColor(Vertex.WHITE);
        }

        // Make an undirected graph.
        UndirectedGraph graph = new UndirectedGraph(listOfVertices);

        //
        LinkedList<Vertex> Q = new LinkedList<>();
        Q.add(start);


        // While Q is not empty.
        while(Q.size() > 0)
        {

            // Remove first element from Q and store it in u.
            Vertex u = Q.removeFirst();

            // For each  v in u-> adjacent do
            for (Vertex v : vertices.get(u.getName()))
            {
                // if color of v is white
                if (v.getColor() == Vertex.WHITE)
                {
                    //Set v green.
                    v.setColor(Vertex.GREEN);

                    // Enqueue v.
                    Q.addLast(v);

                    // Add the edge (u, v)
                    graph.addEdge(u, v);
                }
            }

            // set u's color to black.
            u.setColor(Vertex.BLACK);
        }

        //Return the result.
        return graph;
    }


    /**
     * Depth first search algorithm.
     * @param start starting vertex.
     * @return an Undirected graph.
     */
    public UndirectedGraph depthFirstSearch(Vertex start)
    {
        // Create Stack S.
        Stack<Vertex> S = new Stack<>();

        //Create an arrayList<Vertex> visited;
        ArrayList<Vertex> visited = new ArrayList<>();

        //Create a hashmap<Vertex, Vertex>; Store prede
        HashMap<Vertex, Vertex> predecessor = new HashMap<>();

        for (int i = 0; i < listOfVertices.size(); i++)
        {
            listOfVertices.get(i).setVisited(false);
        }

        S.push(start);
        Vertex u;

        // While S is not empty.
        while (S.size() > 0)
        {
            // u = pop S.
            u = S.pop();

            // If not visited.
            if (!u.isVisited())
            {
                //Set visited is true.
                u.setVisited(true);

                // Add u to the visi
                visited.add(u);

                // for each neighbor w of u do
                for (Vertex w : vertices.get(u.getName())) {

                    // if unvisted.
                    if (!w.isVisited())
                    {
                        S.push(w);
                        predecessor.put(w, u);
                    }
                }
            }
        }

        // Create undirected graph tree with vertices visited.
        UndirectedGraph graph = new UndirectedGraph(visited);

        //for each vertex v stored in visited do
        for (Vertex v : visited)
        {
            // if predecessor contains key for v
            if (predecessor.containsKey(v))
            {
                // get Vertex u from predecessor.
                u = predecessor.get(v);  //predecessor.get(v.getName());

                // add edge (u, v) to tree.
                graph.addEdge(u, v);
            }
        }

        //Return tree.
        return graph;
    }


    /**
     * Print out everything in a nice way.
     * @return string.
     */
    @Override
    public String toString() {

        // Heading for the string.
        String s = "Adjacency list for graph:\n";

        // For each keys of vertices do
        for (String key : vertices.keySet())
        {
            // Add vertex and key to the string.
            s += "Vertex " + key + ":";

            //Add the
            LinkedList<Vertex> adjacentNodes = vertices.get(key);

            //Create an iterator, so while loop can easily be used.
            Iterator<Vertex> iterator = adjacentNodes.iterator();
            //Iterate throughout the entire vertex.
            while (iterator.hasNext())
            {
                Vertex vertex = iterator.next();
                s += " -> " + vertex;
            }
            s += "\n";

        }

        //Return the sting.
        return s;
    }


}
