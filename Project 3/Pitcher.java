/*
 * sets parameters for class Pitcher
 * with extra running average
 */

public class Pitcher extends BaseBallPlayer{
	
	private float era;
	
  public Pitcher(int n, String ln, String fn, float avg, float e){
	  /*
	   * call parent constructor BaseBallPlayer using super 
	   */
    super(n, ln, fn, avg);
    era=e;
  }
  /**
	 * Get and Set Method
	 * @return
	 */
	public float getEra(){
		
		return era;
		
	}
	
	public void setEra(float e){
		
		era = e;
		
	}
	
	/**
	 * /**
   * toString Method
   */
	@Override
	public String toString(){
		
		String s;
		s = number + " " + firstname + " " + lastname + " " + average + " " + era;
      return s;
		
	}
}
