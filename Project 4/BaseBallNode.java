public class BaseBallNode{
	
   public BaseBallPlayer data;
   public BaseBallNode next;

   public BaseBallNode(BaseBallPlayer d)
   {
      data = d;
      next = null;
   } // constructor
   
   /**
	 * Get and Set Method
	 * @return
	 */
   public BaseBallPlayer getData(){	
	   
	   return data;	
	   
   }
   
   public BaseBallNode getNext(){	
	   
	   return next; 	
	   
   }
   
   public void setNext(BaseBallNode n){	
	   
	   next = n;		
	   
   }
}  //

