
public class ProgramDriver 
{

	public static void main(String[] args) 
	{
		NumSet<Long> mySet = new HashNumSet<>(5);

		System.out.println(mySet.add((long) 101)); // 1
		System.out.println(mySet.add((long) 112)); // 2
		System.out.println(mySet.add((long) 96)); // 3
		System.out.println(mySet.remove((long) 112)); // 2
		System.out.println(mySet.add((long) 512)); // 3
		System.out.println(mySet.add((long) 513)); // 4
		System.out.println(mySet.add((long) 632)); // 5
		System.out.println(mySet.add((long) 320)); //6
		System.out.println(mySet.remove((long) 512)); //5
		System.out.println(mySet.remove((long) 513)); //4
		System.out.println(mySet.add((long) 21)); //5
		System.out.println(mySet.add((long) 1024));//6
		System.out.println(mySet.add((long) 32));//7
		System.out.println(mySet.add((long) 101));
		System.out.println(mySet.add((long) 102));
		System.out.println(mySet.add((long) 2048));
		System.out.println(mySet.size()); 
		System.out.println(mySet.capacity()); 
		
		//System.out.println(mySet.remove(5)); 
		//System.out.println(mySet.contains(5)); 
		/*
		
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		mySet.add(1);
		mySet.add(3);
		mySet.add(7);
		System.out.println(mySet.size());
		System.out.println(mySet.capacity());
		mySet.add(12);
		System.out.println(mySet.size());
		System.out.println(mySet.capacity());
		System.out.println(mySet.contains(5));
		System.out.println(mySet.contains(3));
		System.out.println(mySet.contains(7));
		System.out.println(mySet.contains(12));
		*/
	}

}
