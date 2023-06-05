public class ArrayNumSet <E extends Number> implements NumSet<E>
{
    private int cap;
    private E[] myArr;
    private int size;
    
    @SuppressWarnings("unchecked")
	public ArrayNumSet(int initialCapacity)
    {
    	// Initialize all fields
        this.cap = initialCapacity;
        this.size = 0;
        this.myArr = (E[]) new Number[cap];
    }
    
	@Override
	@SuppressWarnings("unchecked")
    public boolean add(E e) throws NullPointerException
    {
    	if (e == null) // Null cases
    	{
    		throw new NullPointerException();
    	}
    	
    	// Checks for duplicate cases
    	if (contains(e))
    	{
    		return false;
    	}
    	
    	if (size >= cap) // Make array capacity doubled
    	{
    		increaseCap();
    		E[] newArr = (E[]) new Number[cap];
    		// System.arraycopy(myArr, 0, newArr, 0, size);
        	
        	for (int i = 0; i < myArr.length; i++)
        	{
        		newArr[i] = myArr[i];
        	}
        	
    		myArr = newArr;
    	}
    	
    	myArr[size] = e;
    	size++;
    	
    	return true;
    }
    
    @Override
    public int capacity() // Returns capacity
    {
        return cap;
    }
    
    @Override
    public boolean contains(E e) throws NullPointerException
    {
    	if (e == null) // Null cases
    	{
    		throw new NullPointerException();
    	}
    	
    	for (int i = 0; i < size; i++)
    	{
    		if (e.equals(myArr[i]))
    		{
    			return true;
    		}
    	}
    	
    	return false;
    }
    
    @Override
    // @SuppressWarnings("unchecked")
    public E get(int index) throws IndexOutOfBoundsException
    {
    	if (index >= myArr.length)
    	{
    		throw new IndexOutOfBoundsException();
    	}
    	
    	return myArr[index];
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public boolean remove(E e) throws NullPointerException
    {
    	if (e == null) // Null cases
    	{
    		throw new NullPointerException();
    	}
    	
    	//Basically create a new array and store the values except the one removed
		E[] newArr = (E[]) new Number[cap];
    	boolean myBool = false;
    	
    	for (int i = 0; i < myArr.length; i++)
    	{
    		if (e.equals(myArr[i])) // Finds the value
    		{
    			myBool = true;
    			continue;
    		}
    		else
    		{
    			if (myBool) // When found
    			{
    				newArr[i - 1] = myArr[i];
    			}
    			else // Otherwise
    			{
    				newArr[i] = myArr[i];
    			}
    		}
    	}
    	
    	this.myArr = newArr; //Change reference of myArr to new array
    	size--;
    	
    	return true;
    }
    
    @Override
    public int size() // Returns the size of the set
    {
        return size;
    }
    
    public void increaseCap() // Doubles the cap size
    {
    	cap *= 2;
    }
}