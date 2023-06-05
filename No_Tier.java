/**
 * Description: Creates No Tier class and methods needed for the no tier (multiplier and flights)
 * Assignment: Programming Project 1
 * Date: 3/27/2022
 * @author Avinash Sriram
 * @version 0.0.0
 */

public class No_Tier extends Tier
{
	private int miles = 0;
	private int cancelledFlights;
	private int flights;
	private String tier = "No Tier";
	
	/**
	 * @param Primitive integer as cancelledFlights
	 * @return Nothing as method is Constructor
	 * @throws Nothing is implemented
	 */
	
	public No_Tier (int cancelledFlights)
	{
		this.cancelledFlights = cancelledFlights;
	}
	
	/**
	 * @Override
	 * @param Nothing is implemented
	 * @return Primitive String as tier
	 * @throws Nothing is implemented
	 */
	
	public String getTier() 
	{
		return this.tier;
	}
	
	/**
	 * @param String as tier
	 * @return Nothing as method is void
	 * @throws Nothing is implemented
	 */
	
	public void setTier(String tier) {
		this.tier = tier;
	}

	/**
	 * @Override
	 * @param Nothing is implemented
	 * @return Primitive integer as miles
	 * @throws Nothing is implemented
	 */
	
	public int getMiles()
	{
		return miles;
	}
	
	/**
	 * @param Primitive integer miles
	 * @return Nothing as method is void
	 * @throws Nothing is implemented
	 */
	
	public void setMiles(int miles)
	{
		this.miles = 0;
	}
	
	/**
	 * @Override
	 * @param Nothing is implemented
	 * @return Primitive integer as cancelledFlights
	 * @throws Nothing is implemented
	 */
	
	public int getCancelledFlights()
	{
		return cancelledFlights;
	}
	
	/**
	 * @Override
	 * @param Nothing is implemented
	 * @return Primitive integer as flights
	 * @throws Nothing is implemented
	 */
	
	public int getFlights()
	{
		return flights;
	}
	
	/**
	 * @Override
	 * @param Primitive boolean isCancelled
	 * @return Nothing as method is void
	 * @throws Nothing is implemented
	 */
	
	public void addFlight(boolean isCancelled)
	{
		if (isCancelled == true)
		{
			cancelledFlights++;
			flights++;
		}
		else
		{
			flights++;
		}
	}
}
