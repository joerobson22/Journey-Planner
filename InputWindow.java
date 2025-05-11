import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Font;
import java.awt.event.*;
import java.awt.font.*;
import javax.swing.*;
import java.util.*;

public class InputWindow extends JFrame implements ActionListener
{
    final Color backgroundColor = new Color(18, 22, 68);

    RoutePlanner routePlanner;

    JPanel mainPanel;
    JPanel titlePanel;
    JPanel plannerPanel;
    JPanel goPanel;

    JButton goButton;

    JComboBox<String> startComboBox;
    JComboBox<String> endComboBox;

    public InputWindow(String filename)
    {
        //create new route planner, loading hte given filename
        routePlanner = new RoutePlanner(filename);

        ArrayList<String> nodeNames = new ArrayList<String>();
        for(Node n : routePlanner.getNodes())
        {
            nodeNames.add(n.getName());
        }
        Collections.sort(nodeNames);

        setupWindow(nodeNames);
    }

    public void setupWindow(ArrayList<String> nodes)
    {
        ImageIcon trainIcon = new ImageIcon("images/train.png");

        //big title label
        JLabel titleLabel = new JLabel("Journey Planner");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 40));
        titleLabel.setForeground(Color.WHITE);

        //train icon
        JLabel iconLabel = new JLabel(trainIcon);

        //setup the title panel
        titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        titlePanel.setBackground(backgroundColor);
        titlePanel.add(iconLabel);
        titlePanel.add(titleLabel);

        //input panel
        startComboBox = new JComboBox<>(nodes.toArray(new String[0]));
        endComboBox = new JComboBox<>(nodes.toArray(new String[0]));

        startComboBox.setSelectedIndex((int)(Math.random() * (nodes.size() - 1)));
        endComboBox.setSelectedIndex((int)(Math.random() * (nodes.size() - 1)));

        //setup planner panel
        plannerPanel = new JPanel(new GridLayout(5, 1));
        plannerPanel.setBackground(backgroundColor);
        plannerPanel.add(new JLabel());

        //slim size for combo boxes
        Dimension comboSize = new Dimension(240, 60); // Adjust as needed

        //start combobox setup
        JPanel startPanel = new JPanel(new BorderLayout());
        startPanel.setBackground(backgroundColor);
        startPanel.add("West", new JLabel(new ImageIcon("images/start.png")));

        //start combobox wrapper setup
        JPanel startBoxWrapper = new JPanel(new FlowLayout(FlowLayout.LEFT));
        startBoxWrapper.setBackground(backgroundColor);
        startComboBox.setPreferredSize(comboSize);
        startBoxWrapper.add(startComboBox);
        startPanel.add("Center", startBoxWrapper);

        //travel panel icon setup
        JPanel travelPanel = new JPanel(new BorderLayout());
        travelPanel.setBackground(backgroundColor);
        travelPanel.add("West", new JLabel(new ImageIcon("images/travel.png")));

        //end combobox setup
        JPanel endPanel = new JPanel(new BorderLayout());
        endPanel.setBackground(backgroundColor);
        endPanel.add("West", new JLabel(new ImageIcon("images/end.png")));

        //end combobox wrapper setup
        JPanel endBoxWrapper = new JPanel(new FlowLayout(FlowLayout.LEFT));
        endBoxWrapper.setBackground(backgroundColor);
        endComboBox.setPreferredSize(comboSize);
        endBoxWrapper.add(endComboBox);
        endPanel.add("Center", endBoxWrapper);

        plannerPanel.add(startPanel);
        plannerPanel.add(travelPanel);
        plannerPanel.add(endPanel);
        plannerPanel.add(new JLabel());

        /*
        //setup input panel
        plannerPanel = new JPanel(new GridLayout(5, 4));
        plannerPanel.setBackground(backgroundColor);
        fillPanel(plannerPanel, 6);
        plannerPanel.add(new JLabel(new ImageIcon("images/start.png")));
        plannerPanel.add(startComboBox);

        fillPanel(plannerPanel, 3);
        plannerPanel.add(new JLabel(new ImageIcon("images/travel.png")));
        fillPanel(plannerPanel, 4);

        plannerPanel.add(new JLabel(new ImageIcon("images/end.png")));
        plannerPanel.add(endComboBox);
        fillPanel(plannerPanel, 7);
        */

        //go button
        goButton = new JButton("Go");
        goButton.addActionListener(this);

        //setup the go button panel
        goPanel = new JPanel(new BorderLayout());
        goPanel.add("Center", goButton);

        //setup main panel
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.add("North", titlePanel);
        mainPanel.add("Center", plannerPanel);
        mainPanel.add("South", goPanel);

        //set up the JFrame
        this.setContentPane(mainPanel);
        this.setVisible(true);
        this.setSize(500, 500);
        this.setTitle("Journey Planner");
        this.setIconImage(trainIcon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
    }

    public void fillPanel(JPanel panel, int reps)
    {
        for(int i = 0; i < reps; i++)
        {
            panel.add(new JLabel());
        }
    }

    public void actionPerformed(ActionEvent e)
    {
        if(goButton == e.getSource())
        {
            System.out.println("go");
            OutputWindow output = new OutputWindow((String) startComboBox.getSelectedItem(), (String) endComboBox.getSelectedItem(), routePlanner);
        }
    }
}
