/**
 * Class for StudentAdvanceTicket which is a subclass of AdvanceTicket.
 * 
 * @author Austin Hollis 
 * @version 4/7/17
 */
public class StudentAdvanceTicket extends AdvanceTicket
{
    /**
     * Constructor for objects of class StudentAdvanceTicket
     */
    public StudentAdvanceTicket(int number, int daysInAdv)
    {
		//Call to super class with parameters of number(ticket)
		//days in advance that the ticket was purchased.
        super(number, daysInAdv);
    }

    /**
     * @param  None
     * @return     returns the price of the ticket for StudentAdvanceTicket. 
     */
	//Method for getPrice.
    public double getPrice()
    {
		//cuts the super class price in half.
        return (super.getPrice()) / 2;
    }

    /**
     * @param  None
     * @return     adds to the toString method.
     */
	public String toString()
    {
		//adds " (ID required)" to end of toString method.
        return super.toString() + " (ID required)";
    }
}