
/**
 * Write a description of class Room here.
 * 
 * @author Austin Hollis 
 * @version February 24, 2017.
 */
public class Room
{
    // instance variables
    //variable for capacity set as an int.
    private int capacity;
    //variable for room number set as a string.
    private String number;
    //variable for name the room is listed under set as a string.
    private String name;
    //variable for floorplan set up set as a char.
    private char setUp;
    //variable for whether or not the room is reconfigurable set as a boolean.
    private boolean isReconfigurable;
    //variable for the different configure options set as a string.
    private String configureOptions;
    //variable for canBeCombinedWith set as an object.
    private Room canBeCombinedWith;
    //variable for numberOfRooms set as an int.
    private static int numberOfRooms = 0;
    //variable for totalCapacity set as an int.
    private static int totalCapacity = 0;

    /**
     * Constructor for objects of class Room
     */
    public Room(String number, String name, int capacity, char setUp, boolean isReconfigurable, String configureOptions)
    {
        // initialise instance variables.
        //initialise this.number to number.
        this.number = number;
        //intialise this.name to name.
        this.name = name;
        //initialise this.capacity to equal capacity.
        this.capacity = capacity;
        //initialise this.setUp to equal setUp.
        this.setUp = setUp;
        //initialise this.isReconfigurable to equal isReconfigurable.
        this.isReconfigurable = isReconfigurable;
        //initialise this.configureOptions to equal configureOptions.
        this.configureOptions = configureOptions;
        //initialise this.canBeCombinedWith to null.
        this.canBeCombinedWith = null;
        //increment numberOfRooms by 1 for each object made.
        numberOfRooms++;
        //adjust the totalCapacity by the amount of space for people for each object.
        totalCapacity += this.capacity;
    }
    //method that accepts Room r.
    public void updateCanBeCombinedWith(Room r)
    {
        //sets this.canBeCombinedWith equal to the object r.
        this.canBeCombinedWith = r;
    }
    //returns the objects room capacity.
    public int getRoomCapacity()
    {
        //return capacity of the object.
        return this.capacity;
    }
    //sets up a method to check for reconfigurability and if the configure options contains the character option.
    public void reconfigure(char option)
    {
        //if statement to check for validity and change the setUp to that of option.
        if((this.isReconfigurable == true) && (this.configureOptions.indexOf(option) != -1))
        {
            //changes this.setUp to equal option.
            this.setUp = option;
        }
    }
    //method to return a boolean based on the inside if statement.
    public boolean isCompatibleWith(Room other)
    {
       //if statement for checking compatability based on equal capacity, configurability and options available.
       if((this.capacity == other.capacity) && (this.isReconfigurable == true) && (this.configureOptions == other.configureOptions))
       {
           //returns true.
           return true;
       }
       //if the if statement above turns out to be false in any point.
       else
       {
           //returns false.
           return false;
        }
    }
    //method to return the total number of rooms in the hotel.
    public static int getNumberOfRooms()
    {
        //returns the number of rooms.
        return numberOfRooms;
    }
    //method to return the total amount of capacity with the given rooms.
    public static int getTotalCapacity()
    {
        //returns total capacity.
        return totalCapacity;
    }
    //method to return a string of the other number being compared to in isCompatibleWith in the toString.
    public String getOtherNumber()
    {
        //returns the objects room number.
        return this.number;
    }
    //method to print out the final string.
    public String toString()
    {
        //variable for the final string for the method.
        String finalString = "Room number:      ";
        //variable for the reconfigurability string.
        String reconfigureString = "";
        //concatonates the string.
        finalString += this.number;
        //if statement to check to see if the object has a name or not.
        if(this.name != null)
        {
            //concatonates the string.
            finalString += "\n    name:   " + this.name;
        }
        //concatonates the string.
        finalString += "\n    capacity:     " + this.capacity;
        //concatonates the string.
        
        finalString += "\n    setUp:  " + this.setUp;
        //if statement to check if a room is reconfigurable or not.
        if(this.isReconfigurable == true)
        {
            //concatonates the string.
            finalString += "\n    reconfigure options:      ";
            //for loop to 
            for(int intPosition=0; intPosition<this.configureOptions.length()-1;intPosition++)
            {
                //checks to see if there is a character in configureOptions that matches 'B'
                if(this.configureOptions.charAt(intPosition)=='B')
                {
                    reconfigureString += "Banquet";
                }
                //checks to see if there is a character in configureOptions that matches 'U'
                else if(this.configureOptions.charAt(intPosition)=='U')
                {
                    reconfigureString += "U-shape";
                }
                //checks to see if there is a character in configureOptions that matches 'E'
                else if(this.configureOptions.charAt(intPosition)=='E')
                {
                    reconfigureString += "Boardroom";
                }
                //checks to see if there is a character in configureOptions that matches 'T'
                else if(this.configureOptions.charAt(intPosition)=='T')
                {
                    reconfigureString += "Theatre";
                }
                //checks to see if there is a character in configureOptions that matches 'C'
                else if(this.configureOptions.charAt(intPosition)=='C')
                {
                    reconfigureString += "Classroom";
                }
                reconfigureString += ", ";
            }
            //if statements to place a period at the end of the of the sentence
            if(this.configureOptions.charAt(this.configureOptions.length()-1) == 'B')
            {
                reconfigureString += "Banquet.";
            }
            //if statements to place a period at the end of the of the sentence
            if(this.configureOptions.charAt(this.configureOptions.length()-1) == 'U')
            {
                reconfigureString += "U-shape.";
            }
            //if statements to place a period at the end of the of the sentence
            if(this.configureOptions.charAt(this.configureOptions.length()-1) == 'E')
            {
                reconfigureString += "Boardroom.";
            }
            //if statements to place a period at the end of the of the sentence
            if(this.configureOptions.charAt(this.configureOptions.length()-1) == 'T')
            {
                reconfigureString += "Theatre.";
            }
            //if statements to place a period at the end of the of the sentence
            if(this.configureOptions.charAt(this.configureOptions.length()-1) == 'C')
            {
                reconfigureString += "Classroom.";
            }
            finalString += reconfigureString;
        }
        //if statement to check if the object can be combined with another room or not.
        if(this.canBeCombinedWith != null)
        {
            //concatonates the string.
            finalString += "\n    can be combined with room # " + this.canBeCombinedWith.getOtherNumber();
        }
        //concatonates the string.
        finalString += "\n";
        //returns the finalString.
        return finalString;
    }
}