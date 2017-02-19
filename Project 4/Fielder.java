/*
 * set parameters for class fielder
 */

public class Fielder extends BaseBallPlayer{
	
  public Fielder(int n, String ln, String fn, float avg){
	  /*
	   * calls parent constructor of BaseBallPlayer
	   */
    super(n, ln, fn, avg);
  }
  /**
	 * /**
 * toString Method
 */
	@Override
	public String toString(){
		
		String s;
		s = number + " " + firstname + " " + lastname + " " + average + " ";
    return s;
		
	}
}
