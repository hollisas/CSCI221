/**
 * Class for object WalkupTicket for tickets bought on site.
 * 
 * @author Austin Hollis 
 * @version 4/7/17
 */
public class WalkupTicket extends Ticket
{
	//Final value for a walkup and purchase ticket. Set to $50.
    private static final double TICKET_PRICE = 50.00;
    /**
     * Constructor for objects of class WalkupTicket
     */
    public WalkupTicket(int number)
    {
        //Call to Super Class
        super(number);
    }

    /**
     * getPrice() Returns the price of the ticket for WalkupTicket.
     * 
     * @param  None
     * @return     Ticket price 
     */
    public double getPrice()
    {
        // put your code here
        return TICKET_PRICE;
    }
}