
public class ProgramDriver 
{
	public static void main(String[] args) 
	{
		ArrayNumSet myArr = new ArrayNumSet(3);
		
		System.out.println(myArr.size());
		System.out.println(myArr.capacity());
		
		System.out.println(myArr.add(1));		
		System.out.println(myArr.add(3));
		System.out.println(myArr.add(5));
		System.out.println(myArr.add(6));
		System.out.println(myArr.add(9));
		System.out.println(myArr.add(18));
		System.out.println(myArr.add(12));
		System.out.println(myArr.remove(5));
		System.out.println(myArr.remove(9));
		System.out.println(myArr.remove(12));
		
		System.out.println(myArr.size());
		System.out.println(myArr.capacity());
		
		// System.out.println(myArr.get(2));
		
		//System.out.println(myArr.get(1));
		// System.out.println(myArr.get(8));
	}
}
