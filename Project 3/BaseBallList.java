public class BaseBallList{
  /*
   * setting up the linkedlist starting with a dummy node
   */
  private BaseBallNode first = new BaseBallNode(null);
  private BaseBallNode last = this.first;
  private int length = 0;
  
  /**
	 * Gets the number of data values currently stored in this LinkedList.
	 * 
	 * @return the number of elements in the list.
	 */

	public int getLength() {
		return length;
	}

	public BaseBallNode getFirst() {
		return first;
	}
	
	/**
	 * add element to the end
	 * @param d
	 */
	public void append(BaseBallPlayer d) {
		BaseBallNode n = new BaseBallNode(d);
		last.next = n;
		last = n;
		++length;
	} 
	
	/**
	 * add element to the beginning
	 * 
	 * 
	 * @param data
	 *            the data element to be prepended.
	 */
	public void prepend(BaseBallPlayer d) {
		BaseBallNode n = new BaseBallNode(d);
		if(length==0){
			first.next=n;
			last=n;
		}else{
			n.next = first.next;
			first.next = n;
		}
		++length;

	} 
	/**
	 * @return String representation of elements in linked list 
	 *         
	 */
	public String toString() {
		BaseBallNode p = first.next;
		String returnString = "";
		while (p != null) {
			returnString += p.data + " " + "\n";
			p = p.next;
		}
		return returnString;
	}
	/**
	 * if there is no element(length == 0), append a element
	 * then, sorted the elements in linked list
	 * 
	 * @param p
	 */
	public void insert(BaseBallPlayer p) {
		
		BaseBallNode n = new BaseBallNode(p);
		
		if(length == 0){
			
			last.next = n;
			last = n;
			length++;
			
		}
		
		if (p.compareTo(first.next.getData()) < 0) {			
			n.setNext(first.next);
			first.next = n;
			length++;
		} else {
			BaseBallNode current = first.next;
			BaseBallNode previous = first.next;
			while (current != null) {
				if (p.compareTo(current.getData() ) < 0)
					break;
				previous = current;
				current = current.getNext();
				length++;
			}
			previous.setNext(n);
			n.setNext(current);
		}//if
	
	}//insert
    
	/**
	 * Get the data of a specific node
	 * @param n
	 * @return
	 */
	public BaseBallPlayer get(int n) {
		
		BaseBallNode current = first.next;
		for (int i = 0; i < n; i++)
			current = current.next;
		return current.data;

	}
}
