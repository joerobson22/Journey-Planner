import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Font;
import java.awt.font.*;
import javax.swing.*;
import java.util.*;

public class OutputWindow extends JFrame
{
    Route route;

    JPanel mainPanel;
    JScrollPane scrollPane;

    public OutputWindow(String source, String target, RoutePlanner routePlanner)
    {
        route = routePlanner.calculateRoute(source, target);
        route.output();

        setupWindow(route);

        this.setSize(500, 300);
        this.setVisible(true);
        this.setContentPane(scrollPane);
        this.setTitle(source + " -> " + target);
        this.setResizable(false);
    }

    public void setupWindow(Route route)
    {
        ArrayList<Edge> simpleRoute = route.getSimpleRoute();

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        addNode(simpleRoute.get(0).getStartNode(), mainPanel);
        for(Edge e : simpleRoute)
        {
            addNode(e.getEndNode(), mainPanel);
        }

        scrollPane = new JScrollPane(mainPanel);
    }

    public void addNode(Node n, JPanel panel)
    {
        JLabel label = new JLabel(n.getName());
        label.setFont(new Font("SansSerif", Font.PLAIN, 16));
        panel.add(label);
        panel.add(Box.createVerticalStrut(5));

    }
}
