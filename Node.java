import java.util.*;

public class Node 
{
    private String name;
    private ArrayList<Edge> edges;
    private double timeToSource;
    private boolean visited;
    private Edge previousEdge;

    /*
     * constructor for node class
     */
    public Node(String name)
    {
        this.name = name;
        edges = new ArrayList<Edge>();
        timeToSource = Double.MAX_VALUE;
        visited = false;
    }

    /*
     * returns the name of the station
     */
    public String getName()
    {
        return name;
    }

    /*
     * adds an edge to the node's list of edges
     */
    public void addEdge(Edge e)
    {
        edges.add(e);
    }

    /*
     * outputs the node's name and all its connections
     */
    public void outputNode()
    {
        System.out.println("Node: " + name);
        for(Edge e : edges)
        {
            e.outputEdge();
        }
        System.out.println();
    }

    /*
     * returns the arraylist of the node's connections
     */
    public ArrayList<Edge> getEdges()
    {
        return edges;
    }

    /*
     * returns if the node has been visited by dijkstra's yet or not
     */
    public boolean getVisited()
    {
        return visited;
    }

    /*
     * visits the node
     */
    public void visit()
    {
        visited = true;
    }

    /*
    * returns the shortest time to source
    */
    public double getTimeToSource()
    {
        return timeToSource;
    }

    /*
     * returns the previous edge on the shortest path from the source
     */
    public Edge getPreviousEdge()
    {
        return previousEdge;
    }

    /*
     * sets the time to source if it's smaller than the node's current time to the source
     * also sets the edge leading to it to later regenerate the route taken
     */
    public void setTimeToSource(double time, Edge e)
    {
        if(time < timeToSource)
        {
            timeToSource = time;
            previousEdge = e;
        }
    }

    /*
     * resets the node to allow the algorithm to generate a new route
     */
    public void reset()
    {
        visited = false;
        timeToSource = Double.MAX_VALUE;
    }
}
