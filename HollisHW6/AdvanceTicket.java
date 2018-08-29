/**
 * Class for AdvanceTicket which is a sub class of the Abstract Class Ticket.
 * 
 * @author Austin Hollis 
 * @version 4/7/17
 */
public class AdvanceTicket extends Ticket
{
	//variables to be used privately in this class.
    private int daysInAdv;
    private static final int FIRST_DAY_PURCHASE = 10;
    private static final double EARLIEST_CHEAPEST_PRICE = 30.00;
    private static final double LATEST_CHEAPEST_PRICE = 40.00;
    /**
     * Constructor for objects of class AdvanceTicket
     */
    public AdvanceTicket(int number, int daysInAdv)
    {
		//call to the super class with parameter of ticket number.
        super(number);
		//initialises daysInAdv.
		this.daysInAdv = daysInAdv;
    }
	//method to getPrice of ticket.
    public double getPrice()
    {
		//if the days in advance that the ticket was purchased is greater than the
		//first day purchase return the price of $30.00 else return the less of the
		//discounted prices which is $40.00.
        if(daysInAdv >= FIRST_DAY_PURCHASE)
        {
			return EARLIEST_CHEAPEST_PRICE;
        }
        else
        {
            return LATEST_CHEAPEST_PRICE;
        }
    }
}