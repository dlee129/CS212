import javax.swing.*;

import java.awt.event.*;
import java.io.*;
import java.util.StringTokenizer;

public class FileMenuHandler implements ActionListener{
	
	/**
	 * Declaring JFrame
	 * Declaring and initializing a linked list
	 * Tracking the length of linked list
	 */
	JFrame jframe;
	static BaseBallList sorted = new BaseBallList();
	static int subLength;
    
	/**
	 * Constructor
	 * @param jf
	 */
	public FileMenuHandler(JFrame jf) {
		
		jframe = jf;
		
	}
	
	/**
	 * If user clicks on "Open", go to openFile function
	 * If user clicks on "Quit", exit the program
	 */
		public void actionPerformed(ActionEvent event) {
			
			String menuName = event.getActionCommand();
			if (menuName.equals("Open"))
				try {
					openFile();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			else if (menuName.equals("Quit"))
				System.exit(0);
			
		}
	
	/**
	 * Using JFileChooser to open an file
	 * Using Scanner to read a file
	 * Calling fillList function and return the 
	 * @throws FileNotFoundException length of linked list
	 */
	private void openFile() throws FileNotFoundException{
	       JFileChooser chooser;
	       int status;
	       chooser = new JFileChooser( ); //create chooser object
	       status = chooser.showOpenDialog(null);
	       File file = chooser.getSelectedFile();
	       if (status == JFileChooser.APPROVE_OPTION){ 
		       fillList(file, sorted);
	       }else{ 
		          JOptionPane.showMessageDialog(null, "Open File dialog canceled");
	       }
		    } //openFile
	
	/**
	 * Read from input file line per line
	 * Using a second array and StringTokenizer to store each line
	 * Reject a line from the input file that does not have the proper number of tokens. Print the line 
       to the console
     *Try and Catch if Player Number or Batting Average isn't valid 
     *Try and Catch if Player is not a Fielder or a Pitcher
     *ry and Catch if Player Name isn't valid 
	 * Pass into the linked lists
	 * Return the length
	 * @param inputFile
	 * @param Array
	 * @return
	 * @throws FileNotFoundException
	 */
    public static int fillList(File chosenFile, BaseBallList s){
    	String chosenFileName = chosenFile.getName(); // get name of chosen File
	    TextFileInput inFile = new TextFileInput(chosenFileName);
		int lengthFilled = 0;
	    String[] stat = new String[6];
	    StringTokenizer myTokens;
    	String line;
    	line = inFile.readLine();
		
        while (line!=null){ 
    		    myTokens = new StringTokenizer(line,","); 
                for(int i = 0; i < 6; i++){
                     while (myTokens.hasMoreTokens())
                    	 stat[i++] = myTokens.nextToken();
                      }//for loop
                if (Integer.parseInt(stat[1]) < 0 || Integer.parseInt(stat[1]) > 100 ||
                		Float.parseFloat(stat[4]) < 0.0f || Float.parseFloat(stat[4]) > 1.0f){
                	try{
                		throw new Exception();
                	}catch (Exception e){
                		System.out.println("Invalid player: " + line);
                		continue;
                	}
                }
                if(line.charAt(0) != 'F' && line.charAt(0) != 'P'){
                	try{
                		throw new Exception();
                	}catch (Exception e){
                		System.out.println("Invalid player: " + line);
                		continue;
                	}
                }
                if(line.length() < 5){
                	try{
                		throw new Exception();
                	}catch (Exception e){
                		System.out.println("Invalid player: " + line);
                		continue;
                	}
                }
                if (line.charAt(0) == 'F'){
	                   s.insert(new Fielder(Integer.parseInt(stat[1]), stat[2], stat[3], Float.parseFloat(stat[4])));
	                   lengthFilled++;
	            }else{
	                   s.insert(new Pitcher(Integer.parseInt(stat[1]), stat[2], stat[3], Float.parseFloat(stat[4]), Float.parseFloat(stat[5])));
	                   lengthFilled++;
	                }
                line = inFile.readLine();
        }//while loop
        return lengthFilled;
     }//fillList
}

