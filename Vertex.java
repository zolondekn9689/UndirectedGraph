/**
 * Custom Vertex that will be used in the Undirected Graph algorithm.
 * @author nick zolondek
 */
public class Vertex
{
    // Name of the vertex.
    private String name;

    // Color integer.
    private int color;

    // visited or not visited.
    private boolean visited;

    //Color for not visited yet.
    public static final int WHITE = 1;

    //Color for visited, but not visited all neighbors.
    public static final int GREEN = 2;

    //Color for visited all neighbors include this vertex.
    public static final int BLACK = 3;


    /**
     * Constructor for a vertex.
     * @param name name of the vertex.
     */
    public Vertex(String name)
    {
        this.name = name;
        color = 0;
        visited = false;
    }

    public String getName()
    {
        return this.name;
    }

    /**
     * Retrieve color.
     * @return black, white, or green.
     */
    public int getColor()
    {
        return color;
    }


    /**
     * Set the color of the vertex.
     * @param color the color options of vertex.
     */
    public void setColor(int color) {
        this.color = color;
    }

    /**
     * Is visited or not visited.
     * @return true or false.
     */
    public boolean isVisited()
    {
        return visited;
    }


    /**
     * Set visited, incase of needing to be changed
     * during the graph algorithm.
     * @param visited true or false.
     */
    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    /**
     * Prints out the name.
     * @return name of the
     */
    @Override
    public String toString()
    {
        return name;
    }

}
