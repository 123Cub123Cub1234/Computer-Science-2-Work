/**
 * Description: Creates Executive Platinum Tier class and methods needed for the executive platinum tier (mileage, multiplier, and flights)
 * Assignment: Programming Project 1
 * Date: 3/27/2022
 * @author Avinash Sriram
 * @version 0.0.0
 */

public class Executive_Platinum extends Tier 
{
	/**
	 * Primitive integer cancelledFlights for storing cancelledFlights
	 * Primitive integer miles contains the miles traveled by Passenger. Uses formula cancelledFlights * 1000 - 24000
	 * Primitive integer flights contains the total flights traveled
	 * String tier holds tier name
	 */
	
	private int cancelledFlights;
	private int miles = (cancelledFlights * 1000 - 24000);
	private int flights;
	private String tier = "Executive_Platinum";
	
	/**
	 * @param Primitive integer as cancelledFlights
	 * @return Nothing as method is Constructor
	 * @throws Nothing is implemented
	 */
	
	public Executive_Platinum(int cancelledFlights)
	{
		this.cancelledFlights = cancelledFlights;
		this.miles = (cancelledFlights * 1000 - 24000);
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
		this.miles = miles;
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
