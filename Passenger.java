/**
 * Description: Creates the methods required for the Passenger Class and its connections to the tier classes
 * Assignment: Programming Project 1
 * Date: 3/27/2022
 * @author Avinash Sriram
 * @version 0.0.0
 */

public class Passenger
{
	/**
	 * Tier object creates a polymorphic object to allow for several tiers
	 * Primitive integer miles contains the miles
	 * Primitive integer cancelledFlights contains the number of cancelled flights
	 * Primitive integer passengerID contains the ID of the passenger for comparisons
	 * Primitive boolean multiplier (set to false) determines if the user has the multiplier (only if true)
	 * Primitive boolean hasComplained (set to false) determines if true then set to true
	 */
	
	private Tier tier;
	private int miles;
	private int cancelledFlights;
	private int flights;
	private int passengerID;
	private boolean multiplier = false;
	private boolean hasComplained = false;
	
	/**
	 * @param Primitive integer as passengerID
	 * @return Nothing as method is Constructor
	 * @throws Nothing is implemented
	 */
	
	public Passenger (int passengerID)
	{
		this.passengerID = passengerID;
	}
	
	/**
	 * @param Nothing is implemented
	 * @return Primitive integer as passengerID
	 * @throws Nothing is implemented
	 */
	
	public int getID() 
	{
		return passengerID;
	}
	
	/**
	 * @param Primitive integer passengerID
	 * @return Nothing as method is void
	 * @throws Nothing is implemented
	 */
	
	public void setID(int passengerID) 
	{
		this.passengerID = passengerID;
	}

	/**
	 * @param Nothing is implemented
	 * @return Tier object as tier
	 * @throws Nothing is implemented
	 */
	
	public String getTier() 
	{
		return tier.getTier();
	}
	
	/**
	 * @param Tier object tier
	 * @return Nothing as method is void
	 * @throws Nothing is implemented
	 */
	
	public void setTier(Tier tier) 
	{
		this.tier = tier;
	}
	
	/**
	 * @param Nothing is implemented
	 * @return Primitive integer as tier.getMiles()
	 * @throws Nothing is implemented
	 */
	
	public int getMiles()
	{
		return tier.getMiles();
	}
	
	/**
	 * @param Primitive integer miles
	 * @return Nothing as method is void
	 * @throws Nothing is implemented
	 */
	
	public void setMiles(int miles)
	{
		this.miles = tier.getMiles();
	}
	
	/**
	 * @parma Nothing is implemented
	 * @return Primitive integer as cancelledFlights
	 * @throws Nothing is implemented
	 */
	
	public int getCancelledFlights()
	{
		return cancelledFlights;
	}
	
	/**
	 * @param Nothing is implemented
	 * @return Primitive boolean as multiplier
	 * @throws Nothing is implemented
	 */
	
	public boolean hasMultiplier()
	{
		return multiplier;
	}
	
	/**
	 * @param Primitive boolean multiplier
	 * @return Nothing as method is void
	 * @throws Nothing is implemented
	 */
	
	public void setMultiplier(boolean multiplier)
	{
		if (!hasComplained)
		{
			this.multiplier = true;
		}
		else
		{
			this.multiplier = false;
		}
	}
	
	/**
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
	 * @param Primitive boolean complained
	 * @return Nothing as method is void
	 * @throws Nothing is implemented
	 */
	
	public void hasComplained(boolean complained)
	{
		if (complained == true)
		{
			hasComplained = true;
		}
	}
	
	/**
	 * @param Nothing is implemented
	 * @return Nothing as method is void
	 * @throws Nothing is implemented
	 */
	
	public void shouldNotHaveMultiplier()
	{
		this.multiplier = false;
	}
	
	/**
	 * @param Nothing is implemented
	 * @return Primitive boolean as hasComplained
	 * @throws Nothing is implemented
	 */
	
	public boolean getComplained()
	{
		return hasComplained;
	}
	
	
}
