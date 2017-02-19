import java.util.StringTokenizer; 

public class Project3{
	
	
	public static void main(String[]args){
		/*
		 * preparing to use StringTokenizer to read input from file
		 * initializing JFrame
		 * Tracking length of linkedlist
		 */

		BaseBallGUI myGUI = new BaseBallGUI();
		BaseBallList player = new BaseBallList();
		BaseBallList sorted = new BaseBallList();
		
		int sublength = fillList(player, sorted);
		myGUI.printToGUI(player, sorted, sublength);
		
		
	}
	/*
	 * read input from files using StringTokenizer
	 * pass two lists of players
	 * return the length
	 */
	 public static int fillList(BaseBallList p, BaseBallList s){
			String FileName = "project3.txt";
			TextFileInput tfi = new TextFileInput(FileName);
	    	int lengthFilled = 0;
		    String[] stat = new String[6];
		    StringTokenizer myTokens;
	    	String line = tfi.readLine();
			
	        while (line!=null){
	    		    myTokens = new StringTokenizer(line,","); 
	                for(int i = 0; i <=6; i++){
	                     while (myTokens.hasMoreTokens())
	                    	 stat[i++] = myTokens.nextToken();
	                      }//for loop
	                if (line.charAt(0) == 'F'){
	                   p.append(new Fielder(Integer.parseInt(stat[1]), stat[2], stat[3], Float.parseFloat(stat[4])));
	                   s.insert(new Fielder(Integer.parseInt(stat[1]), stat[2], stat[3], Float.parseFloat(stat[4])));
	                   lengthFilled++;
	                }else{
	                   p.append(new Pitcher(Integer.parseInt(stat[1]), stat[2], stat[3], Float.parseFloat(stat[4]), Float.parseFloat(stat[5])));
	                   s.insert(new Pitcher(Integer.parseInt(stat[1]), stat[2], stat[3], Float.parseFloat(stat[4]), Float.parseFloat(stat[5])));
	                   lengthFilled++;
	                }
	                line=tfi.readLine();
	        }//while loop
	        
	        return lengthFilled++;
	        
	   }//fillList
}