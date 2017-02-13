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
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;

/**
 *
 * @author Suli
 */
public class View extends JFrame{
    private final AbstractAction buttonClick = new AbstractAction() {
		@Override
		public void actionPerformed(ActionEvent e) {
                        final JButton button = (JButton) e.getSource();
			button.setBackground(new Color(140,240, 50));
		}
	};
        
	ArrayList<Node> cities=new ArrayList<Node>();
        

	
	
       
	public View()  {
		super("Ablakom");
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.setSize(600, 400);
                File file = new File("file.txt");
            try {
                Scanner sc = new Scanner(file);
                Node node=new Node("példa");//első város
                Node node2= new Node("példa2");//második város
                int cost;//sc.next();
                AddCity(node);
                AddCity(node2);
                //AddNewPath(node,node2,cost);
                
                
                sc.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
            }
		

		createStuff();
	}

        public void AddCity(Node newcity)
        {
            int i=0;
                boolean l=false;
                while(l&&i<cities.size())
                {
                    Node city = cities.get(i);
                    if (city.value.equals(newcity.value)) {
                        l=true;
                    }
                }
                if (!l) {
                    
                    cities.add(newcity);
                }
        }
	private void createStuff() {
                JButton button= new JButton(buttonClick);
                button.setText("beolvas");
               
		
                add(button,BorderLayout.PAGE_START);
                
	}
}
