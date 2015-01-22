package myadvocateui.utils;

public class Utils 
{
	/**
	 * sleep
	 * 
	 * The main reason this method was developed was to handle the exception the 
	 * Thread.sleep method throws.  It prevents the rest of the test code from having to 
	 * handle this situation. 
	 * 
	 * @param millisec
	 */
	public static void sleep(int millisec)  
	{
		try
		{
			Thread.sleep(millisec);
		}
		catch(Exception e)
		{
			System.out.println("Exception detected after thread.sleep:  " + e);
		}
	}
}