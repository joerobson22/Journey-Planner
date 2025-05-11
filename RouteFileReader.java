
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class RouteFileReader 
{
    public static RouteData readFile(String filename) 
    {
        ArrayList<ArrayList> arrays = new ArrayList<ArrayList>();
        ArrayList<Node> nodes = new ArrayList<Node>();
        ArrayList<Edge> edges = new ArrayList<Edge>();

        try
        {
            BufferedReader br = new BufferedReader(new FileReader(filename));

            String line = br.readLine();

            while ((line = br.readLine()) != null) 
            {
                String[] data = line.split(",");
                String start = data[0];
                String end = data[1];
                String colour = data[2];
                float time = Float.parseFloat(data[3]);

                Node startNode = new Node(start);
                Node endNode = new Node(end);

                Edge e1 = new Edge(colour, time, startNode, endNode);
                Edge e2 = new Edge(colour, time, endNode, startNode);
                edges.add(e1);
                edges.add(e2);

                nodes = addNode(startNode, nodes, e1);
                nodes = addNode(endNode, nodes, e2);
            }
        }
        catch (IOException e) 
        {
            System.out.println("Something went wrong while reading the file!");
            System.err.println("Error reading the CSV file: " + e.getMessage());
            e.printStackTrace();
        }

        RouteData data = new RouteData(nodes, edges);
        return data;
    }

    public static int nodeIndex(Node c, ArrayList<Node> nodes) 
    {
        for (int i = 0; i < nodes.size(); i++) 
        {
            if (nodes.get(i).getName().equals(c.getName())) 
            {
                return i;
            }
        }
        return -1;
    }

    public static ArrayList<Node> addNode(Node n, ArrayList<Node> nodes, Edge e)
    {
        int i = nodeIndex(n, nodes);   
        if(i == -1)
        {
            n.addEdge(e);
            nodes.add(n);
        }
        else
        {
           nodes.get(i).addEdge(e);
        }
        return nodes;
    }
}
