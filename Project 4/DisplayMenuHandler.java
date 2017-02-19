import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public  class DisplayMenuHandler implements ActionListener{
	
	/**
	 * Declaring JFrame
	 * Declaring Container 
	 * Declaring TextArea
	 */
	JFrame jframe;
	Container myContentPane ;
	TextArea myText = new TextArea();
	
	/**
	 * Constructor
	 * @param jf
	 */
	public DisplayMenuHandler(JFrame jf) {
		
		jframe = jf;
		
	}
    
	/**
	 * If user clicks on "All", go to displayAll function
	 * If user clicks on "Fielder", go to displayFielders function
	 * If user clicks on "Pitcher", go to displayPitchers function
	 */
	public void actionPerformed(ActionEvent event) {
		
		String menuName = event.getActionCommand();
		
		if (menuName.equals("All")){
			displayAll();
		} // if
		else if (menuName.equals("Fielder")){
			displayFielders();
		} // else if	 
		else if (menuName.equals("Pitcher")){
			displayPitchers();
		} // else if
		
	} //actionPerformed
	
	
	 /**
	  * Resetting  TextArea
	  * Printing linked list data to GUI(pass from FileMenuHandler)
	  */
	 public void displayAll(){
		 
		 myText.setText(null);
		 
		 myContentPane = jframe.getContentPane();
		 myContentPane.add(myText);
  	    
		 myText.append("Original\n\n\n");
		 myText.append(FileMenuHandler.sorted.toString());
		 
		 jframe.setVisible(true);
		    
     }
     
	 /**
	  * Resetting  TextArea
	  * Printing Fielders to GUI(pass from FileMenuHandler)
	  */
     public void displayFielders(){
    	 
    	 myText.setText(null);
    	 
    	 myContentPane = jframe.getContentPane();
    	 myContentPane.add(myText);
  	   
    	 myText.append("Fielders\n\n\n");
  	     for(int i = 0; i < FileMenuHandler.subLength; i++){
	   		  if (FileMenuHandler.sorted.get(i) instanceof Fielder){
	   			myText.append(FileMenuHandler.sorted.get(i).toString());
	   			myText.append("\n");
		      } // if
		 } // for
  	     
  	     jframe.setVisible(true);
  	   
     }
     
     /**
	  * Resetting  TextArea
	  * Printing Pitchers to GUI(pass from FileMenuHandler)
	  */
     public void displayPitchers(){
    	 
    	 myText.setText(null);
    	
    	 myContentPane = jframe.getContentPane();
    	 myContentPane.add(myText);
    	 
  	     int size = FileMenuHandler.subLength;
  	     BaseBallList s = FileMenuHandler.sorted;
  	   
  	   myText.append("Pitchers\n\n\n");
  	     for(int i = 0; i < size; i++){
	   		  if (s.get(i) instanceof Pitcher){
	   			myText.append(s.get(i).toString());
	   			myText.append("\n");
		      } // if
		 } // for
  	     
  	     jframe.setVisible(true);
     }
     
} // main
