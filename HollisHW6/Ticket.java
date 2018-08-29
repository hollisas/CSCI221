import java.text.*;
/**
 * Abstract Class for Ticket. This is the super most class.
 * 
 * @author Austin Hollis 
 * @version 4/5/2017
 */
public abstract class Ticket
{
    //private variable for ticket number.
    private int number;
    /**
     * Constructor for objects of class Ticket
     */
    public Ticket(int number)
    {
        //initialises the variable for number.
        this.number = number;
    }
    //abstract method for getPrice; will be used by all other subclasses.
    public abstract double getPrice();
    //method to return a toString method.
    public String toString()
    {   
        return "Number: " + this.number + " Price: $" + this.getPrice();
    }
}