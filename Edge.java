import java.util.*;

public class Edge 
{
    private String lineColour;
    private float time;
    private Node startNode;
    private Node endNode;

    public Edge(String lineColour, float time, Node startNode, Node endNode)
    {
        this.lineColour = lineColour;
        this.time = time;
        this.startNode = startNode;
        this.endNode = endNode;
    }

    public float getTime()
    {
        return time;
    }

    public String getLineColour()
    {
        return lineColour;
    }

    public Node getStartNode()
    {
        return startNode;
    }

    public Node getEndNode()
    {
        return endNode;
    }

    public void outputEdge()
    {
        System.out.printf("Edge: %s to %s on %s line- %f mins\n", startNode.getName(), endNode.getName(), lineColour, time);
    }
}
