import java.util.*;

public class Edge 
{
    private String lineColour;
    private double time;
    private Node startNode;
    private Node endNode;

    /*
     * constructor for edge class
     */
    public Edge(String lineColour, double time, Node startNode, Node endNode)
    {
        this.lineColour = lineColour;
        this.time = Round.round(time, 1);
        this.startNode = startNode;
        this.endNode = endNode;
    }

    /*
     * returns the total time it takes to get from the start node to the end node on this edge
     */
    public double getTime()
    {
        return time;
    }

    /*
     * sets the total time to t- used when simplifying the route
     */
    public void setTime(double t)
    {
        time = t;
    }

    /*
     * sets the end node to n- used when simplifying the route
     */
    public void setEndNode(Node n)
    {
        endNode = n;
    }

    /*
     * returns the edge's line colour
     */
    public String getLineColour()
    {
        return lineColour;
    }

    /*
     * returns the edge's start node
     */
    public Node getStartNode()
    {
        return startNode;
    }

    /*
     * returns the edge's end node
     */
    public Node getEndNode()
    {
        return endNode;
    }

    /*
     * outputs the edge
     * outputs its start node, end node, line colour and time taken
     */
    public void outputEdge()
    {
        System.out.println(startNode.getName() + " to " + endNode.getName() + " on the " +  lineColour + " line- " + time + " mins");
    }
}
