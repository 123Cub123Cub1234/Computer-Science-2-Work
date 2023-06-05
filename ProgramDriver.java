/**
 * Description: This program goes through the flight-data.txt file and creates/stores the Passenger objects
 * Description Continued: The program also contains and handles all user input and code output
 * Assignment: Programming Project 1
 * Date: 3/27/2022
 * @author Avinash Sriram
 * @version 0.0.0
 */

import java.io.*;
import java.util.*;

public class ProgramDriver 
{
	/**
	 * @param String[] as args
	 * @returns Nothing as void
	 * @throws FileNotFoundException
	 * @throws Exception e for InputMismatch
	 */
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("flight-data.txt");
		Scanner inFile = new Scanner(file);
		Scanner keyboard = new Scanner(System.in);

		// Flight-data.txt parsing

		String tempString = "";
		ArrayList<Integer> idList = new ArrayList<Integer>();
		ArrayList<String> cancelledList = new ArrayList<String>();
		ArrayList<String> complainedList = new ArrayList<String>();
		ArrayList<Passenger> passengerList = new ArrayList<Passenger>();

		// int tempInt = 1;
		int val = 0;
		int count = 0;
		int i = 0;
		

		// Populates the ArrayLists

		while (inFile.hasNext()) 
		{
			boolean duplicate = false;
			tempString = inFile.nextLine();

			Scanner checker = new Scanner(tempString);
			int id = checker.nextInt();
			
			String[] stArr = tempString.split(" ");

			String cancelledString = stArr[1];
			cancelledList.add(cancelledString);
			
			String complainedString = "";
			
			int cancelledFlightsCount = 0;
			
			if (stArr.length > 2) 
			{
				complainedString = stArr[2];
				complainedList.add(complainedString);
				// System.out.println(complainedString);
			} 
			else 
			{
				complainedList.add(" ");
			}
			
			if (i == 0) 
			{
				// IdList
				Passenger passenger = new Passenger(id);
				passenger.setID(id);
				
				if (cancelledString.equals("Y"))
				{
					passenger.addFlight(true);
				}
				else
				{
					passenger.addFlight(false);
				}
				
				if (complainedString.equals("Y"))
				{
					passenger.hasComplained(true);
				}
				else
				{
					passenger.hasComplained(false);
				}
				
				passengerList.add(passenger);
				
				for (int g = 0; g < passengerList.size(); g++)
	            {
	                if (id == passengerList.get(g).getID())
	                {
	                    Passenger currentPassenger = passengerList.get(g);
	                    cancelledFlightsCount = currentPassenger.getCancelledFlights();

	                    // Update mileage
	                    //currentPassenger.setMiles(cancelledFlightsCount * 1000 - 24000);

	                    // Update tier and multiplier based on cancelled flights and complaints
	                    if (cancelledFlightsCount >= 100)
	                    {
	                        if (currentPassenger.getComplained()) // Complained
	                        {
	                            currentPassenger.setTier(new Executive_Platinum(cancelledFlightsCount));
	                            currentPassenger.setMultiplier(false);
	                        }
	                        else // Hasn't complained
	                        {
	                            currentPassenger.setTier(new Executive_Platinum(cancelledFlightsCount));
	                            currentPassenger.setMultiplier(false);
	                        }
	                    }
	                    else if (cancelledFlightsCount >= 50)
	                    {
	                        if (currentPassenger.getComplained()) // Complained
	                        {
	                            currentPassenger.setTier(new Platinum(cancelledFlightsCount));
	                            currentPassenger.setMultiplier(false);
	                        }
	                        else // Hasn't complained
	                        {
	                            currentPassenger.setTier(new Platinum(cancelledFlightsCount));
	                            currentPassenger.setMultiplier(false);
	                        }
	                    }
	                    else if (cancelledFlightsCount >= 25)
	                    {
	                        if (currentPassenger.getComplained()) // Complained
	                        {
	                            currentPassenger.setTier(new Gold(cancelledFlightsCount));
	                            currentPassenger.setMultiplier(false);
	                        }
	                        else // Hasn't complained
	                        {
	                            currentPassenger.setTier(new Gold(cancelledFlightsCount));
	                            currentPassenger.setMultiplier(false);
	                        }
	                    }
	                    else
	                    {
	                        if (currentPassenger.getComplained()) // Complained
	                        {
	                            currentPassenger.setTier(new No_Tier(cancelledFlightsCount));
	                        	currentPassenger.setMultiplier(false);
	                        }
	                        else // Hasn't complained
	                        {
	                        	currentPassenger.setTier(new No_Tier(cancelledFlightsCount));
	                            currentPassenger.setMultiplier(false);
	                        }
	                    }
	                    
	                    break;
	                }
				}
				
				idList.add(id);
				checker.close();
			} 
			else 
			{
				for (int f = 0; f < idList.size(); f++) 
				{
					if (idList.get(f) == id) 
					{
						duplicate = true;
						val = f;
					}
				}

				if (duplicate) // Duplicate case
				{
					for (int j = 0; j < passengerList.size(); j++)
				    {                        
				        if (id == passengerList.get(j).getID())
				        {
				            Passenger passenger = passengerList.get(j);

				            // Update cancelled flights and complaints
				            if (cancelledString.equals("Y"))
				            {
				                passenger.addFlight(true);
				            }
				            else
				            {
				                passenger.addFlight(false);
				            }

				            if (complainedString.equals("Y"))
				            {
				                passenger.hasComplained(true);
				            }
				            else
				            {
				                passenger.hasComplained(false);
				            }

				            // Update passenger in list
				            passengerList.set(j, passenger);

				            // Update tier and multiplier for all instances of this passenger
				            for (int g = 0; g < passengerList.size(); g++)
				            {
				                if (id == passengerList.get(g).getID())
				                {
				                    Passenger currentPassenger = passengerList.get(g);
				                    cancelledFlightsCount = currentPassenger.getCancelledFlights();

				                    // Update mileage
				                    //currentPassenger.setMiles(cancelledFlightsCount * 1000 - 24000);

				                    // Update tier and multiplier based on cancelled flights and complaints
				                    if (cancelledFlightsCount >= 100)
				                    {
				                        if (currentPassenger.getComplained()) // Complained
				                        {
				                            currentPassenger.setTier(new Executive_Platinum(cancelledFlightsCount));
				                            currentPassenger.setMultiplier(false);
				                        }
				                        else // Hasn't complained
				                        {
				                            currentPassenger.setTier(new Executive_Platinum(cancelledFlightsCount));
				                            currentPassenger.setMultiplier(false);
				                        }
				                    }
				                    else if (cancelledFlightsCount >= 50)
				                    {
				                        if (currentPassenger.getComplained()) // Complained
				                        {
				                            currentPassenger.setTier(new Platinum(cancelledFlightsCount));
				                            currentPassenger.setMultiplier(false);
				                        }
				                        else // Hasn't complained
				                        {
				                            currentPassenger.setTier(new Platinum(cancelledFlightsCount));
				                            currentPassenger.setMultiplier(false);
				                        }
				                    }
				                    else if (cancelledFlightsCount >= 25)
				                    {
				                        if (currentPassenger.getComplained()) // Complained
				                        {
				                            currentPassenger.setTier(new Gold(cancelledFlightsCount));
				                            currentPassenger.setMultiplier(false);
				                        }
				                        else // Hasn't complained
				                        {
				                            currentPassenger.setTier(new Gold(cancelledFlightsCount));
				                            currentPassenger.setMultiplier(false);
				                        }
				                    }
				                    else
				                    {
				                        if (currentPassenger.getComplained()) // Complained
				                        {
				                        	currentPassenger.setTier(new No_Tier(cancelledFlightsCount));
				                        	currentPassenger.setMultiplier(false);
				                        }
				                        else // Hasn't complained
				                        {
				                        	currentPassenger.setTier(new No_Tier(cancelledFlightsCount));
				                        	currentPassenger.setMultiplier(false);
				                        }
				                    }
				                }
				            }
				            break;
				        }
				    }
				}	
				else // Not duplicate case
				{
					Passenger passenger = new Passenger(id);
					passenger.setID(id);
					
					if (cancelledString.equals("Y"))
					{
						passenger.addFlight(true);
					}
					else
					{
						passenger.addFlight(false);
					}
					
					if (complainedString.equals("Y")) 
					{
						passenger.hasComplained(true);
					}
					else
					{
						passenger.hasComplained(false);
					}
					
					passengerList.add(passenger);
					idList.add(id);
					
					for (int g = 0; g < passengerList.size(); g++)
		            {
		                if (id == passengerList.get(g).getID())
		                {
		                    Passenger currentPassenger = passengerList.get(g);
		                    cancelledFlightsCount = currentPassenger.getCancelledFlights();

		                    // Update tier and multiplier based on cancelled flights and complaints
		                    if (cancelledFlightsCount >= 100)
		                    {
		                        if (currentPassenger.getComplained()) // Complained
		                        {
		                            currentPassenger.setTier(new Executive_Platinum(cancelledFlightsCount));
		                            currentPassenger.setMultiplier(false);
		                        }
		                        else // Hasn't complained
		                        {
		                            currentPassenger.setTier(new Executive_Platinum(cancelledFlightsCount));
		                            currentPassenger.setMultiplier(false);
		                        }
		                    }
		                    else if (cancelledFlightsCount >= 50)
		                    {
		                        if (currentPassenger.getComplained()) // Complained
		                        {
		                            currentPassenger.setTier(new Platinum(cancelledFlightsCount));
		                            currentPassenger.setMultiplier(false);
		                        }
		                        else // Hasn't complained
		                        {
		                            currentPassenger.setTier(new Platinum(cancelledFlightsCount));
		                            currentPassenger.setMultiplier(false);
		                        }
		                    }
		                    else if (cancelledFlightsCount >= 25)
		                    {
		                        if (currentPassenger.getComplained()) // Complained
		                        {
		                            currentPassenger.setTier(new Gold(cancelledFlightsCount));
		                            currentPassenger.setMultiplier(false);
		                        }
		                        else // Hasn't complained
		                        {
		                            currentPassenger.setTier(new Gold(cancelledFlightsCount));
		                            currentPassenger.setMultiplier(false);
		                        }
		                    }
		                    else
		                    {
		                        if (currentPassenger.getComplained()) // Complained
		                        {
		                        	currentPassenger.setTier(new No_Tier(cancelledFlightsCount));
		                        	currentPassenger.setMultiplier(false);
		                        }
		                        else // Hasn't complained
		                        {
		                        	currentPassenger.setTier(new No_Tier(cancelledFlightsCount));
		                        	currentPassenger.setMultiplier(false);
		                        }
		                    }
		                    
		                    break;
		                }
					}
				}
			}
			i++;
			
			passengerList.get(0);
		}	
		
		// Sets multipliers
		for (int j = 0; j < passengerList.size(); j++)
		{
			Passenger currentPassenger = passengerList.get(j);
			int cancelledTotalFlights = currentPassenger.getCancelledFlights();
			// System.out.println(currentPassenger.hasMultiplier());
            
			if (currentPassenger.getTier().equals("Executive_Platinum") && currentPassenger.hasMultiplier())
			{
				currentPassenger.setTier(new Super_Executive_Platinum(cancelledTotalFlights));
			}
			
			if (currentPassenger.getTier().equals("Platinum") && currentPassenger.hasMultiplier())
			{
				currentPassenger.setTier(new Platinum_Pro(cancelledTotalFlights));
			}
			
			if (currentPassenger.getTier().equals("Gold") || currentPassenger.getTier().equals("No Tier"))
			{
				currentPassenger.shouldNotHaveMultiplier();
			}
		}
		
		int userInput = 0;
		
		// Sentinel Value Approach
		while (userInput != -999)
		{
			try
			{
				System.out.print("Enter the id of the passenger. Enter -999 to stop: ");
				userInput = keyboard.nextInt();
				
				boolean bool = false;
			
				if (userInput == -999)
				{
					System.out.println("Bye!");
					break;
				}
			
				for (int j = 0; j < passengerList.size(); j++)
				{
					if (userInput == passengerList.get(j).getID())
					{
						bool = true;
						
						if (bool)
						{
							Passenger currentPassenger = passengerList.get(j);
							
							System.out.println("Found ID!");
							System.out.println("Rewards Tier of Customer: " + currentPassenger.getTier());
							System.out.println("Total Miles: " + currentPassenger.getMiles());
							System.out.println("Total Cancellations: " + currentPassenger.getCancelledFlights());
							System.out.println("Obtained Multiplier: " + currentPassenger.hasMultiplier());
						}

						break;
					}
					else
					{
						bool = false;
					}
				}
				
				if (!bool)
				{
					System.out.println("Didn't find ID! Try again.");
				}
				
			}
			catch (Exception e)
			{
				System.out.println("You entered an invalid input!");
				break;
			}
		}
		
		inFile.close();
		keyboard.close();
	}
}