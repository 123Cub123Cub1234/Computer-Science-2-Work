
public class HashNumSet <E extends Number> implements NumSet<E>
{
	private int cap;
    private ListNode[] myArr;
    private int size;
    
    public HashNumSet(int initialCapacity)
    {
    	this.cap = initialCapacity;
    	this.size = 0;
    	this.myArr =  new ListNode[cap];  
    	
    	for (int i = 0; i < cap; i++)
    	{
    		ListNode dummyNode = new ListNode(null);
    		myArr[i] = dummyNode;
    	}
    }
    
    /* This method is the add method and handles all the chaining and resizing 
     * needed for making the proper implementation of the instructions
     */
    
    public boolean add(E e) throws NullPointerException
    {
    	if (e == null)
		{
    		throw new NullPointerException();
		}
    	
    	if (contains(e)) // Checks for duplicates
    	{
    		return false;
    	}
    	
    	size++;
    	
    	if (((double)size)/cap > 0.75) // Load factor and resize
    	{
    		increaseCap();
    		
    		ListNode[] newArr = new ListNode[cap];
    		 	          	
    		for (int i = 0; i < myArr.length; i++) 
    		{
                ListNode node = myArr[i];
                
                while (node != null) 
                {
                	if (node.getItem() != null)
                	{
                		ListNode tempNode = new ListNode(node.getItem());
                		
                		int index = hash(node.getItem());
                        //node.next = newArr[index];
                        newArr[index] = tempNode;
                        node = node.next;
                	}
                	else
                	{
                		node = node.next;
                	}
                }
            }
    		
            myArr = newArr;
    	}
    	
    	int indexVal = hash(e);
    	ListNode anotherNode = new ListNode(e);
    	anotherNode.next = myArr[indexVal];
    	myArr[indexVal] = anotherNode;
    	
    	
    	return true;
    	
    }
    
    public int capacity() // Returns capacity value
    {
    	return cap;
    }
    
    // Checks if the set contains the value
	public boolean contains(E e) throws NullPointerException
    {
    	if (e == null)
		{
			throw new NullPointerException();
		}
    	
    	for (int i = 0; i < myArr.length; i++)
    	{
    		ListNode newNode = myArr[i];
    		
    		while (newNode != null && newNode.getItem() != null)
    		{
        		if (newNode.getItem().equals(e))
        		{
        			return true;
        		}
            	
    			newNode = newNode.next;
    		}
    	}
    	
    	return false;
    }
    
	// Implements the remove and shifts the links in the LinkedList structure
    public boolean remove(E e) throws NullPointerException
    {
    	if (e == null)
    	{
    		throw new NullPointerException();
    	}
    	
    	int index = hash(e);
    	ListNode newNode = myArr[index];
    	ListNode anotherNode = null;
    	ListNode nNext = newNode.next;
    	
    	if (!contains(e)) // If the value doesn't exist, there is nothing to remove
    	{
    		return false;
    	}
    	
    	while (newNode != null)
    	{
    		if (newNode.getItem() != null)
    		{
    			if (newNode.getItem().equals(e))
    			{
    				if (anotherNode == null)
    				{
    					myArr[index] = nNext;
    				}
    				else
    				{
    					anotherNode.next = nNext;
    				}
    				
    				size--;
    				
    				return true;
    			}
    		}
    		
    		anotherNode = newNode;
    		newNode = nNext;
    	}
    	
    	return false;
    }
    
    public int size() // Returns size
    {
    	return size;
    }
    
    public void increaseCap() // Doubles the cap size
    {
    	this.cap *= 2;
    }
    
    private int hash(Number element) // Hashes based on the capacity of the set
    {   	   	
    	int hashVal = element.hashCode() % cap;
    	return hashVal;
    }
}
