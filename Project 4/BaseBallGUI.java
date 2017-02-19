import java.awt.TextArea;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class BaseBallGUI extends JFrame{
	
	   JMenuBar menuBar;
	  
        /**
	    * initialize JFrame
	    */
       public BaseBallGUI(){
    	   
    	   setTitle("BaseballPlayers");
		   setSize(400, 400);
		   setLocation(100, 100);
		   createFileMenu();
		   displayFileMenu();
		   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   setVisible(true);
	
        }
       
       /**
        * Create a menu call "File"
        * with two options "Open" and "Quit"
        * "Open" - open a file
        * "Quit" - exit
        */
       private void createFileMenu(){
    	   
    	   menuBar = new JMenuBar();
    	   JMenu fileMenu = new JMenu("File");
    	   FileMenuHandler fmh = new FileMenuHandler(this);
    	   JMenuItem item;
    	   
    	   item = new JMenuItem("Open"); // Open
    	   item.addActionListener(fmh);
   		   fileMenu.add(item);
   		   
   		   item = new JMenuItem("Quit"); // Quit
		   item.addActionListener(fmh);
		   fileMenu.add(item);
		   
		   setJMenuBar(menuBar);
		   menuBar.add(fileMenu);
		   
       }
       
       /**
        * Create a menu call "Display"
        * with three options "All", "Fielders" and "Pitchers"
        * "All" - Display unsorted players
        * "Fielders" - Display Fielders
        * "Pitchers" - Display Pitchers
        * 
        */
       private void displayFileMenu() {
    	   
   		   JMenu displayMenu = new JMenu("Display");
   		   DisplayMenuHandler dmh = new DisplayMenuHandler(this);
   		   JMenuItem item;

   		   item = new JMenuItem("All"); // Display
 	       item.addActionListener(dmh);
 	       displayMenu.add(item);
		   
		   item = new JMenuItem("Fielder"); // Fielders
		   item.addActionListener(dmh);
		   displayMenu.add(item);
		   
		   item = new JMenuItem("Pitcher"); // Pitchers
		   item.addActionListener(dmh);
		   displayMenu.add(item);
		   
		   setJMenuBar(menuBar);
		   menuBar.add(displayMenu);

   	   } // createMenu
       

}