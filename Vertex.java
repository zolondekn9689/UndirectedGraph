public class Vertex {
    private String name;
    private int color;
    private boolean visited;

    //Color constants for the graph.
    public static final int WHITE = 1;
    public static final int GREEN = 2;
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
     * @return
     */
    public int getColor()
    {
        return color;
    }


    public void setColor(int color) {
        this.color = color;
    }

    public boolean isVisited()
    {
        return visited;
    }


    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    /**
     * Prints out the name.
     * @return
     */
    @Override
    public String toString()
    {
        return name;
    }

}
