
import java.lang.reflect.Array;
import java.util.*;

public class UndirectedGraph
{
    private HashMap<String, LinkedList<Vertex>> vertices;
    private ArrayList<Vertex> listOfVertices;



    public UndirectedGraph(ArrayList<Vertex> listOfVertices) {
        vertices = new HashMap<String, LinkedList<Vertex>>();

        for (int i = 0; i < listOfVertices.size(); i++) {
            vertices.put(listOfVertices.get(i).getName(), new LinkedList<>());
        }
        this.listOfVertices = listOfVertices;
    }


    public boolean addEdge(Vertex u, Vertex v)
    {
        return (vertices.get(u.getName()).add(v) && vertices.get(v.getName()).add(u));
    }


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



        while(Q.size() > 0)
        {


            Vertex u = Q.removeFirst();



            for (Vertex v : vertices.get(u.getName()))
            {
                if (v.getColor() == Vertex.WHITE) {
                    v.setColor(Vertex.GREEN);
                    Q.addLast(v);
                    graph.addEdge(u, v);
                }
            }
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


    @Override
    public String toString() {
        String s = "Adjacency list for graph:\n";
        for (String key : vertices.keySet())
        {
            s += "Vertex " + key + ":";
            LinkedList<Vertex> adjacentNodes = vertices.get(key);
            Iterator<Vertex> iterator = adjacentNodes.iterator();

            while (iterator.hasNext())
            {
                Vertex vertex = iterator.next();
                s += " -> " + vertex;
            }
            s += "\n";

        }


        return s;
    }


}
