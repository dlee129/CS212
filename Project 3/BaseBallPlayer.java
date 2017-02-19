public class BaseBallPlayer implements Comparable<BaseBallPlayer>{
	
  protected int number;
  protected String lastname;
  protected String firstname;
  protected float average;
  
  public BaseBallPlayer(int n, String ln, String fn, float avg)
  {
    if ((n < 0) || (n > 100)) {
      throw new IllegalArgumentException("Player's number is invalid");
    }
    if ((avg < 0.0F) || (avg > 1.0F)) {
      throw new IllegalArgumentException("Player's batting average is illegal");
    }
	number = n;
	lastname = ln;
	firstname = fn;
	average = avg;    
  }
  
	/**
	 * Get and Set Method
	 * @return
	 */
  public void setNumber(int n)
  {
    if ((n < 0) || (n > 100)) {
      throw new IllegalArgumentException("Player's number is invalid");
    }
    this.number = n;
  }
  
  public void setLastName(String ln)
  {
    this.lastname = ln;
  }
  
  public void setFirstName(String fn)
  {
    this.firstname = fn;
  }
  
  public void setAverage(float avg)
  {
    if ((avg < 0.0F) || (avg > 1.0F)) {
      throw new IllegalArgumentException("Player's batting average is illegal");
    }
    this.average = avg;
  }
  
  public int getNumber()
  {
    return this.number;
  }
  
  public String getLastName()
  {
    return this.lastname;
  }
  
  public String getFirstName()
  {
    return this.firstname;
  }
  
  public float getAverage()
  {
    return this.average;
  }
  
  public int compareTo(BaseBallPlayer other){
  	
  	if (number < other.number)
  		return -1;
		return 0;
		
  }
}
