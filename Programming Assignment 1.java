/**
 * Author: Avinash Sriram
 * Date: 2/12/2023
 * Class: CS 2336.002
 * Assignment: Programming Challenge 1
 */

import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) // Simple program main function. Only calls the method and also uses the Arrays.toString method to check the output
	{
		int[] nums = {5,5,7,7,9,11,11}; // Sample test
		int key = 8;
		
		int[] answerArray = binarySearch(nums, key);
		
		System.out.println(Arrays.toString(answerArray));
	}
	
	public static int[] binarySearch(int[] nums, int key) // The tested method for Zybooks
	{
	    int b = startingBinarySearch(0, nums.length - 1, key, nums);
	    int a = endingBinarySearch(0, nums.length - 1, key, nums);
	    
	    // I wrote the a and b variables backwards since I programmed the code backwards and forgot to change it (sorry about that)
	    
	    int[] answerArray = new int[2];
	    
	    if (a >= 0) // Checks if the value of a is greater than 0 to make sure the return array has the proper return
		{
		    System.out.println("The key was found at index: " + a);
		    answerArray[0] = a;
		    answerArray[1] = b;
		}
		else // Key not found
		{
		    System.out.println("The key could not be found!");
		    answerArray[0] = -1;
		    answerArray[1] = -1;
		}
		
		return answerArray;
	}
	
	// (high+low)/2 is just the middle number
	
	private static int startingBinarySearch(int low, int high, int key, int[] nums) // Actually works for the end index not starting index
	{
	   // System.out.println(nums[low] + "\n" + nums[high]);
	   // The previous comment was me testing out the low and high values to make sure it actually worked
	   if (low > high || high > nums.length - 1) // Breaks out of the recursion
	   {
	       return -1;
	   }
	   else
	   {
		   if (nums[(high+low)/2] == key) // Checks for multiples
	       {
	           if (startingBinarySearch(((high+low)/2) + 1, high, key, nums) == -1)
	        	   return (high+low)/2;
	           else
	        	   return startingBinarySearch(((high+low)/2) + 1, high, key, nums);
	       }
	       else if (nums[(high+low)/2] > key) // Too high
	       {
	           return startingBinarySearch(low, ((high+low)/2 - 1), key, nums);
	       }
	       else // Too low
	       {
	           return startingBinarySearch(((high+low)/2 + 1), high, key, nums);
	       }
	   }
	}
	
	private static int endingBinarySearch(int low, int high, int key, int[] nums) // Actually works for the starting index not ending index
	{
		// System.out.println(nums[low] + "\n" + nums[high]);
		// The previous comment was me testing out the low and high values to make sure it actually worked
		
	   if (low > high || high > nums.length - 1) // Breaks out of the recursion
	   {
	       return -1;
	   }
	   else
	   {
		   if (nums[(high+low)/2] == key) // Checks for multiples
	       {
			   if (endingBinarySearch(low,(high+low)/2 - 1, key, nums) == -1)
			   {
	        	   return (high+low)/2;
			   }
	           else
	           {
	        	   return endingBinarySearch(low,(high+low)/2 - 1, key, nums);
	           }
	       }
	       else if (nums[(high+low)/2] > key) // Too high
	       {
	           return endingBinarySearch(low, ((high+low)/2 - 1), key, nums);
	       }
	       else // Too low
	       {
	           return endingBinarySearch(((high+low)/2 + 1), high, key, nums);
	       }
	   }
	}
}