/**
 * Description: This program creates the abstract class and methods needed for each tier class
 * Assignment: Programming Project 1
 * Date: 3/27/2022
 * @author Avinash Sriram
 * @version 0.0.0
 */

public abstract class Tier 
{
	/**
	 * @param Nothing is implemented
	 * @return Nothing as abstract
	 * @throws Nothing is implemented
	 */
	
	public abstract String getTier();
	
	/**
	 * @param Nothing is implemented
	 * @return Nothing as abstract
	 * @throws Nothing is implemented
	 */
	
	public abstract int getMiles();
	
	/**
	 * @param Nothing is implemented
	 * @return Nothing as abstract
	 * @throws Nothing is implemented
	 */
	
	public abstract int getCancelledFlights();
	
	/**
	 * @param Nothing is implemented
	 * @return Nothing as abstract
	 * @throws Nothing is implemented
	 */
	
	public abstract int getFlights();
	
	/**
	 * @param Primitive boolean isCancelled
	 * @return Nothing as abstract
	 * @throws Nothing is implemented
	 */
	
	public abstract void addFlight(boolean isCancelled);
}
