import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.*;
import java.util.*;
import java.awt.Dimension;
import java.awt.Component;

public class OutputWindow extends JFrame
{
    final Color textColor = new Color(255, 255, 255);
    final Color titlePanelBackground = new Color(18, 22, 68);
    final Color routePanelBackground = new Color(80, 86, 152);

    final int windowWidth = 500;

    Route route;

    JPanel mainPanel;
    JPanel titlePanel;
    JPanel titleWrapper;
    JPanel routePanel;
    JScrollPane scrollPane;

    public OutputWindow(String source, String target, RoutePlanner routePlanner)
    {
        route = routePlanner.calculateRoute(source, target);
        //route.output();

        setupWindow(route, source, target);
    }

    public void setupWindow(Route route, String source, String target)
    {
        setupTitlePanel();

        setupRoutePanel(route);

        setupMain(source, target);
    }

    public void setupTitlePanel()
    {
        //setup title wrapper
        titleWrapper = new JPanel(new FlowLayout(FlowLayout.LEFT));
        titleWrapper.setBackground(titlePanelBackground);

        //setup title panel
        titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));
        titlePanel.setBackground(titlePanelBackground);
        titlePanel.setForeground(textColor);
        titlePanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        titlePanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));

        addRouteInformation((route.getRouteTime() + " mins"), titlePanel, 24);
        addRouteInformation((route.getNumChanges() + " changes"), titlePanel, 24);

        titleWrapper.add(titlePanel);
    }

    public void setupRoutePanel(Route route)
    {
        ArrayList<Edge> simpleRoute = route.getSimpleRoute();

        //setup route panel
        routePanel = new JPanel();
        routePanel.setBackground(routePanelBackground);
        routePanel.setForeground(textColor);
        routePanel.setLayout(new BoxLayout(routePanel, BoxLayout.Y_AXIS));

        addNode(simpleRoute.get(0).getStartNode(), routePanel, "images/start.png");
        for(Edge e : simpleRoute)
        {
            addConnection(e, routePanel);
            addNode(e.getEndNode(), routePanel, "images/end.png");
        }
    }

    public void setupMain(String source, String target)
    {
        //setup main panel
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        mainPanel.add(titleWrapper);
        mainPanel.add(routePanel);

        //set main content pane and title of window
        scrollPane = new JScrollPane(mainPanel);
        this.setContentPane(scrollPane);
        this.setTitle(source + " -> " + target);
        this.setResizable(false);

        //force the layout to set the size by packing, so that every panel now has a determined size
        pack();

        //now calculate the desired height and set the window's size
        int preferredHeight = titlePanel.getHeight() + routePanel.getHeight();
        int windowHeight = Math.min(preferredHeight, 400);
        
        this.setSize(windowWidth, windowHeight);
        this.setVisible(true);
    }

    public void addNode(Node n, JPanel panel, String imagePath)
    {
        JPanel newNode = new JPanel(new FlowLayout(FlowLayout.LEFT));
        newNode.setBackground(routePanelBackground);

        JLabel image = new JLabel(new ImageIcon(imagePath));

        JLabel label = new JLabel(n.getName());
        label.setFont(new Font("SansSerif", Font.PLAIN, 20));
        label.setForeground(textColor);

        newNode.add(image);
        newNode.add(label);

        panel.add(newNode);
        panel.add(Box.createVerticalStrut(10));
    }

    public void addConnection(Edge e, JPanel panel)
    {
        JPanel newConnection = new JPanel(new FlowLayout(FlowLayout.LEFT));
        newConnection.setBackground(routePanelBackground);

        newConnection.add(new JLabel("            "));

        JPanel rectangle = new JPanel();
        rectangle.setPreferredSize(new Dimension(20, 100));
        rectangle.setBackground(ColorMap.getColor(e.getLineColour()));
        newConnection.add(rectangle);

        JPanel connectionInfo = new JPanel();
        connectionInfo.setBackground(routePanelBackground);
        connectionInfo.setLayout(new BoxLayout(connectionInfo, BoxLayout.Y_AXIS));

        addRouteInformation(upperFirstLetter(e.getLineColour()) + " line", connectionInfo, 16);
        addRouteInformation(e.getTime() + " mins", connectionInfo, 16);

        newConnection.add(new JLabel("             "));
        newConnection.add(connectionInfo);

        panel.add(newConnection);

        panel.revalidate();
        panel.repaint();
    }

    public void addRouteInformation(String info, JPanel panel, int fontSize)
    {
        JLabel label = new JLabel(info);
        label.setFont(new Font("SansSerif", Font.BOLD, fontSize));
        label.setForeground(textColor);
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(label);
        panel.add(Box.createVerticalStrut(2));
    }

    public String upperFirstLetter(String s)
    {
        return s.substring(0, 1).toUpperCase() + s.substring(1, s.length()).toLowerCase();
    }
}
