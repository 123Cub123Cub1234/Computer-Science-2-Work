/**
 * Description: Creates Super_Executive_Platinum Tier class and methods needed for the super executive platinum tier (mileage, multiplier, and flights)
 * Assignment: Programming Project 1
 * Date: 3/27/2022
 * @author Avinash Sriram
 * @version 0.0.0
 */

public class Super_Executive_Platinum extends Tier
{
	/**
	 * Primitive integer cancelledFlights for storing cancelledFlights
	 * Primitive integer miles contains the miles traveled by Passenger. Uses formula cancelledFlights * 2000 - 24000
	 * Primitive integer flights contains the total flights traveled
	 * String tier holds tier name
	 */
	
	private int cancelledFlights;
	private int miles;
	private int flights;
	private String tier = "Super Executive Platinum";
	
	/**
	 * @param Primitive integer as cancelledFlights
	 * @return Nothing as method is Constructor
	 * @throws Nothing is implemented
	 */
	
	public Super_Executive_Platinum (int cancelledFlights)
	{
		this.cancelledFlights = cancelledFlights;
		this.miles = ((cancelledFlights - 24) * 2000);
	}
	
	/**
	 * @Override
	 * @param Nothing is implemented
	 * @return Primitive String as tier
	 * @throws Nothing is implemented
	 */
	
	public String getTier() {
		return this.tier;
	}

	/**
	 * @Override
	 * @param Nothing is implemented
	 * @return Primitive integer as miles
	 * @throws Nothing is implemented
	 */
	
	public int getMiles() {
		return this.miles = miles;
		//System.out.println(miles);
	}

	/**
	 * @Override
	 * @param Nothing is implemented
	 * @return Primitive integer as cancelledFlights
	 * @throws Nothing is implemented
	 */
	
	public int getCancelledFlights() {
		return cancelledFlights;
	}

	/**
	 * @Override
	 * @param Nothing is implemented
	 * @return Primitive integer as flights
	 * @throws Nothing is implemented
	 */
	
	public int getFlights() {
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
	
	/**
	 * @param String as tier
	 * @return Nothing as method is void
	 * @throws Nothing is implemented
	 */
	
	public void setTier(String tier) {
		this.tier = tier;
	}
	
	/**
	 * @param Primitive integer miles
	 * @return Nothing as method is void
	 * @throws Nothing is implemented
	 */
	
	public void setMiles(int miles)
	{
		this.miles = miles;
		//System.out.println(miles);
	}
}
