import java.awt.Container;
import java.awt.GridLayout;
import java.awt.TextArea;

import javax.swing.JFrame;

public class BaseBallGUI extends JFrame{
	   /**
	    * initialize JFrame
	    */
       public BaseBallGUI(){
    	   new TextArea();
    	   new TextArea();
    	   new TextArea();
		   setSize(1000, 300);
		   setLocation(100, 100);
		   setTitle("BaseballPlayer");
		   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   setVisible(true);
		
        }
       
       public void printToGUI(BaseBallList p, BaseBallList s, int size){
    	   TextArea Original = new TextArea();
    	   TextArea Fielders = new TextArea();
    	   TextArea Pitchers = new TextArea();
    	   setLayout(new GridLayout(1,3));
    	   
    	   this.add(Original);
   		   Original.append("Original\n\n\n");
   		   Original.append(p.toString());
   		   
   		   this.add(Fielders);
   		   Fielders.append("Fielders\n\n\n");
   		   this.add(Pitchers);
   		   Pitchers.append("Pitchers\n\n\n");
   		   
   		   //Get the data of a specific node, then print it on GUI
   		   for(int i = 0; i < size; i++){
   		      if (s.get(i) instanceof Fielder){
   		    	 Fielders.append(s.get(i).toString());
   		    	 Fielders.append("\n");
   		      }else{
   		    	 Pitchers.append(s.get(i).toString()); 
   		    	 Pitchers.append("\n");
   		      }
   		  }
   	   }


}