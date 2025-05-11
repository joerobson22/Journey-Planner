import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Font;
import java.awt.event.*;
import java.awt.font.*;
import javax.swing.*;
import java.util.*;

public class OutputWindow extends JFrame
{
    Route route;

    public OutputWindow(String source, String target, RoutePlanner routePlanner)
    {
        route = routePlanner.calculateRoute(source, target);
        route.output();

        this.setSize(500, 500);
        this.setVisible(true);
        this.setTitle("Journey");
        this.setResizable(false);
    }
}
