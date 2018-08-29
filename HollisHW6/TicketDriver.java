import java.util.Scanner;
/**
 * Test Driver class TestTickets for the assignment.
 * 
 * @author Austin Hollis 
 * @version 4/8/17
 */
public class TicketDriver
{
    //private variable for the driver class.
    private static int TOTAL_TICKETS = 20;
    //main function
    public static void main( String[] args )
    {
        //Scanner for days in advance.
        Scanner input = new Scanner(System.in);
        //Creates an array with a space for 20 tickets.
        Ticket[] ticketArray = new Ticket[20];
        //initialises ticketNumber to 1.
        int ticketNumber = 1;
        //continues while the ticketNumber is less than or equal to the total number of tickets.
        while(ticketNumber <= TOTAL_TICKETS)
        {
            //If the ticket is in positions 0-5 or 16-20...
            if(ticketNumber-1 < 5 || ticketNumber-1 >= 15)
            {
                //creates an object of class WalkupTicket.
                ticketArray[ticketNumber-1] = new WalkupTicket(ticketNumber);
            }
            //If the ticket is in positions 6-10...
            else if(ticketNumber-1 < 10)
            {
                //print statement asking for how many days in advance the ticket was purchased.
                System.out.println("How many days in advance was the Advance Ticket purchased?");
                //input portion for scanner.
                int daysInAdv = input.nextInt();
                //creates an object of class AdvanceTicket.
                ticketArray[ticketNumber-1] = new AdvanceTicket(ticketNumber,daysInAdv);
            }
            //If the ticket is in positions 11-15...
            else if(ticketNumber-1 < 15)
            {
                //print statement asking for how many days the StudentAdvanceTicket was purchased.
                System.out.println("How many days in advance was the Student Advance Ticket purchased?");
                //input portion for scanner.
                int daysInAdv = input.nextInt();
                //creates an object of class StudentAdvanceTicket.
                ticketArray[ticketNumber-1] = new StudentAdvanceTicket(ticketNumber,daysInAdv);
            }
            //increments ticketNumber by 1.
            ticketNumber += 1;
        }
        //prints the ticketList.
        printTickets(ticketArray);
    }
    //Function used to print out the toString method of every item in the array.
    public static void printTickets(Ticket [] ticketArray)
    {
        for (int i=1; i <= TOTAL_TICKETS; i++)
        {
            System.out.println(ticketArray[i-1].toString());
        }
    } 
} // end class TicketDriver