import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Project1{
	   static JFrame WordsGUI; 
	   static String inFileName = "input1.txt";
	   static TextFileInput inFile = new TextFileInput(inFileName);
	   static TextArea original;
	   static TextArea sorted;
	   static Container cPane;
	   static int lengthFilled = 0;
	   
	public static void main(String[]args){
			initialize();
			printFromFile(inFileName);
	}//main
	public static void initialize(){
	       original = new TextArea();
	       sorted = new TextArea();
	       WordsGUI=new JFrame();
	       WordsGUI.setSize(400,400);
	       WordsGUI.setLocation(200, 200);
	       WordsGUI.setTitle("Project 1");
	       WordsGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       WordsGUI.setVisible(true);
	}//initializes the GUI
	
	private static void printFromFile(String filename){      
		String []words = new String[50];
		String nextWord;
		String line;
		line = inFile.readLine();
		WordsGUI.setLayout(new GridLayout(1,2));
		cPane = WordsGUI.getContentPane();
	      cPane.add(original);
	      cPane.add(sorted);
		   while (line != null ) {   
			   StringTokenizer st = new StringTokenizer(line, ","); 
			   while(st.hasMoreTokens()){
				   nextWord =  st.nextToken();
				   words[lengthFilled++] = nextWord;
			   }//advance to next line in our inputFile.
				   line = inFile.readLine();
			   }
		   for(int i=0;i<lengthFilled;i++){
				original.append(words[i]+"\n");
			}//for loop to append/print text into GUI
				sortWords(words);
					for(int a=0; a<lengthFilled; a++){
						sorted.append(words[a]+"\n");
					}//sorting append
				WordsGUI.setVisible(true);
	}
	
	public static void sortWords(String []list){
		for(int j=0; j<lengthFilled-1;j++){
			for(int k=j+1; k<lengthFilled;k++){
				if(list[j].compareTo(list[k])>0){
					String temp = list[j];
					list[j]=list[k];
					list[k]=temp;
				}//if
			}//k for
		}//j for
	}// sorts the words to be appended to the right side 

}//Project1