import javax.swing.*;

import java.awt.*;
import java.util.*;

/**
 * 
 * @author David Lee
 * Project 2
 *
 */
/**
 * Instantiate all the required variables
 *call upon baseballplayer class for each specific player
 *
 */
public class Project2{
	   static JFrame BaseBallGUI; 
	   static String inFileName = "project2.txt";
	   static TextFileInput inFile = new TextFileInput(inFileName);
	   static TextArea original;
	   static TextArea sorted;
	   static Container cPane;
	   static int filled=0;
	   static BaseballPlayer []bp = new BaseballPlayer[100];
	   static String []list = new String[100];
	   static int number[]= new int[100];
	   static String []ln = new String[100];
	   static String []fn = new String[100];
	   static float []avg = new float[100];
	   /**
	    * initialize the GUI and print into the GUI
	    * @param args
	    */
	public static void main(String[]args){
			initialize();
			printFromFile(inFileName);
	}//main
	/**
	 * creates the GUI
	 */
	public static void initialize(){
	       original = new TextArea();
	       sorted = new TextArea();
	       BaseBallGUI=new JFrame();
	       BaseBallGUI.setSize(400,400);
	       BaseBallGUI.setLocation(200, 200);
	       BaseBallGUI.setTitle("Project 2");
	       BaseBallGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       BaseBallGUI.setVisible(true);
	}//initializes the GUI
	/**
	 * reads lines from file and gives each variable a value in the stored array
	 * @param filename
	 */
	private static void printFromFile(String filename){
		String line;
		line = inFile.readLine();
		BaseBallGUI.setLayout(new GridLayout(1,2));
		cPane = BaseBallGUI.getContentPane();
	      cPane.add(original);
	      cPane.add(sorted);
		   for(int i=0; line != null;i++) {  
			   list[i]=line;
			   StringTokenizer st = new StringTokenizer(line, ","); 
			   while(st.hasMoreTokens()){
				   number[i]=Integer.parseInt(st.nextToken());
				   ln[i]=st.nextToken();
				   fn[i]=st.nextToken();
				   avg[i]=Float.parseFloat(st.nextToken());
			   }//advance to next line in our inputFile.
			   bp[i] = new BaseballPlayer(number[i],ln[i],fn[i],avg[i]);
				   line = inFile.readLine();
				   filled++;
			   }
/**
 * appends both original and sorted arrays from textfile
 */
		   for(int i=0;i<filled;i++){
			   original.append(list[i]+"\n");
			}//for loop to append/print text into GUI
				sortWords(ln,list);
		   for(int a=0; a<filled; a++){
				sorted.append(list[a]+"\n");
					}//sorting append
					BaseBallGUI.setVisible(true);
	}
	/**
	 * sorts the words by last name and sorts the entire line by sorting last names
	 * @param list
	 * @param s
	 */
	public static void sortWords(String []list, String []s){
		for(int j=0; j<filled-1;j++){
			for(int k=j+1; k<filled;k++){
				if(Character.toLowerCase(list[j].charAt(0))>Character.toLowerCase(list[k].charAt(0))){
					String temp = list[j];
					list[j]=list[k];
					list[k]=temp;
					temp=s[j];
					s[j]=s[k];
					s[k]=temp;
				}//if
			}//k for
		}//j for
	}// sorts the words to be appended to the right side 

	

}//Project2