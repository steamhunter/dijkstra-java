/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstra;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Suli
 */
public class View extends JFrame {

    private final AbstractAction buttonClick = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            final JButton button = (JButton) e.getSource();
            int retval = fc.showOpenDialog(button);
            if (retval == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                ReadFile(file);
            }

        }
    };
    JFileChooser fc = new JFileChooser();
    JTextArea textarea;
    JTextField startCity;
    JTextField endCity;
    ArrayList<Node> cities = new ArrayList<Node>();

    public View() {
        super("Ablakom");
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setSize(600, 400);
        createStuff();
    }

    public void AddNewPath(Node from, Node to, int cost) {
        for (int i = 0; i < cities.size(); i++) {
            if (cities.get(i).value.equals(from.value)) {

                cities.get(i).AddNeighbour(to, cost);
            }
        }
    }

    public void AddCity(Node newcity) {
        int i = 0;
        boolean l = false;
        while (!l && i < cities.size()) {
            Node city = cities.get(i);
            if (city.value.equals(newcity.value)) {
                l = true;
            } else {
                i++;
            }
        }
        if (!l) {

            cities.add(newcity);
        }
    }

    private void createStuff() {
        JButton button = new JButton(buttonClick);
        button.setText("beolvas");
        button.setAlignmentX(CENTER_ALIGNMENT);
        startCity = new JTextField(20);
        endCity = new JTextField(20);
        textarea= new JTextArea(15,20);
        JPanel panel=new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
        panel.add(button);
        panel.add(startCity);
        panel.add(endCity);
        panel.add(textarea);
        startCity.setText("<kiinduló város>");
        endCity.setText("<cél város>");
        add(panel,BorderLayout.PAGE_START);


    }

    private void ReadFile(File file) {
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                Node node = new Node(sc.next());//első város
                Node node2 = new Node(sc.next());//második város
                int cost = sc.nextInt();
                AddCity(node);
                AddCity(node2);
                AddNewPath(node, node2, cost);
            }

            sc.close();

            for (int i = 0; i < cities.size(); i++) {
                if (cities.get(i).neighbours.size() > 0) {
                   textarea.append(cities.get(i).value + " " + cities.get(i).neighbours.get(0).node.value + " " + cities.get(i).neighbours.get(0).cost);
                } else {
                    textarea.append(cities.get(i).value);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
