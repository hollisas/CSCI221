/**
 * Creates an object that will allow one to store and manipulate an array of strings,
 *      without having to write many of the low-level array-manipulation routines. A
 *      StringsList object stores 0 or more String objects, with empty locations, if 
 *      any at the end of the list.
 * 
 * @author Austin Hollis 
 * @version 3/19/17
 */
public class StringsList
{
    /**
     * Instance Variables
     */
    //size is the current amount of elements in the list.
    private int size = 0;
    //capacity is the max total size of allowed spaces.
    private int capacity = 0;
    //creates an empty String Array.
    private String[] stringArray;

    /**
     * Constructor for objects of class StringsList
     * Instantiates an empty StringsList with maximum capacity of 10 that will 
     *      store strings(String values).
     * Preconditions: None.
     */
    public StringsList()
    {
        //Initialise instance variables
        //Initialise this.size to 0.
        this.size = 0;
        //Initialise this.capacity to 10 *Cannot be changed by user*
        this.capacity = 10;
        //Initialise this.stringArray to have a max size of value capacity.
        this.stringArray = new String[capacity];
    }

    /**
     * Getter method to returns number of elements currently stored in the list.
     * Preconditions: None.
     */
    public int size()
    {
        //Returns number of elements currently stored in the list.
        return this.size;
    }

    /**
     * Appends String 'a' at end of the list.
     * Postcondition: List has 'a' appended, size is updated accordingly.
     */
    public void add(String a)
    {
        //Checks for the size of object to be less than the length of the stringArray.
        if(this.size < this.stringArray.length)
        {
            //If this.size is less than this.stringArray 
            //Check if this.size is less than this.capacity.
            if(this.size < this.capacity)
            {
                //Store 'a' into stringArray at position equal to this.size.
                this.stringArray[this.size()] = a;
                //Increment the objects size by 1.
                this.size++;
            }
            else
            {
                //If this.size is not less than this.capacity print that the list is full
                System.out.println("List is full");
            }
        }
        else
        {
            //If this.size is not less than the length of the String Array enlarge the capacity
            //by twice the current size.
            this.enlarge();
            //Once you increase the capacity perform the add method again. 
            //*User should not be aware that the capacity is being increased*
            this.add(a);
        }
    }
    
    /**
     * Inserts String 'a' in the specific user-numbered location in the list
     *      (The first element is at location 1 to the user)
     *      If there is already an item at position location, that element and all other
     *      elements following it are pushed one position over(to the next highest index)
     *      in the list. If the list is alredy full, at capacity, then the array size is
     *      doubled using the enlarge method.
     * Precondition: Location is in range of 1 to size+1
     * Postcondition: Contents modified as necessary and size is updated accordingly.
     */
    public void insert(String a, int location)
    {
        //Check for this.size to be less than this.capacity
        if(this.size < this.capacity)
        {
            //Check for location to be less than or equal to this.size
            //and that the String 'a' is not of null type.
            if(location <= this.size && a != null)
            {
                //Check for this.stringArray at index location-1 to be equal to null type.
                if(this.stringArray[location-1] == null)
                {
                    //Stores String 'a' into this.stringArray at index location-1.
                    this.stringArray[location-1] = a;
                    //Increment this.size by 1.
                    this.size++;
                }
                else
                {
                    /*If this.stringArray at index location-1 does not equal null
                    go through a for loop that initializes i to this.capacity-1
                    and iterates through the loop location-1 times and then
                    decrements i by 1 after each iteration.*/
                    for(int i = this.capacity-1; i >= location-1; i--)
                    {
                        //Shifts elements by 1.
                        this.stringArray[i] = this.stringArray[i-1];
                    }
                    //Stores String 'a' into stringArray at index location-1.
                    this.stringArray[location-1] = a;
                    //Increments this.size by 1.
                    this.size++;
                }
            }
            else
            {
                //If the check fails enlarge the capacity
                this.enlarge();
                //Then rerun the insert method with the same parameters.
                this.insert(a, location);
            }
        }
    }
    
    /**
     * Returns true if String 'a' is in the list, otherwise it will return false.
     */
    public boolean contains(String a)
    {
        //Check for String 'a' not being of null type.
        if (a != null)
        {
            //For loop that starts at 0 then iterates through the length of the stringArray
            //and then increments i by 1 each time.
            for(int i = 0; i < this.stringArray.length; i++)
            {
                //Check for stringArray at index i not being null 
                //and that stringArray at index i equals String 'a'.
                if (this.stringArray[i] != null && this.stringArray[i].equals(a))
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Returns the index (a value from 1 to size) of 'a' in the list, or -1 if 'a' is not in the list
     */
    public int find(String a)
    {
        //For loop that starts at 0 and iterates through this.size times and increments i by 1.
        for(int i = 0; i < this.size; i++)
        {
            //Check for stringArray at index i being equal to the String 'a'
            //and that stringArray does not equal null type.
            if(this.stringArray[i].equals(a) && this.stringArray != null)
            {
                //Return i+1 for the index of the position if check is true.
                return i+1;
            }
        }
        //Returns -1 if the String 'a' is not found.
        return -1;
    }
    
    /**
     * Removes the String 'a', if it is in the list. Any elements that follow 'a' in the list are
     *      are moved over one position(to the next lowest index) so there are no holes in the list.
     *      If 'a' is not in the list, the list is not changed.
     * Postcondition: Contents modified as necessary and size is updated accordingly.
     */
    public void delete(String a)
    {
        //Creates an integer to store the location of String 'a' after running the find method on it.
        int pos = this.find(a);
        //If String 'a' is found goes into the if statement.
        if(pos != -1)
        {
            //Creates a String labeled temporary.
            String temporary;
            for(int i = pos-1; i < this.size; i++)
            {
                //Stores the String in stringArray at position i+1 into temporary.
                temporary = this.stringArray[i+1];
                //Stores the String in temporary into stringArray at position i.
                this.stringArray[i] = temporary;
            }
            //Sets last index position in array to null type.
            this.stringArray[this.size] = null;
            //Decrements this.size by 1.
            this.size--;
        }
    }
    
    /**
     * Prints the contents of the StringsList for every location within the capacity of the list,
     *      showing the location of each element. For those locations where no String is stored,
     *      print null as the value.
     */
    public String displayList()
    {
        //The Format for the display of the String.
        //States the capacity and the size of the current StringList.
        String stringDisplay = "StringList: capacity " + this.capacity + ", size " + this.size + "\n";
        //For loop that starts at 0 and runs through the length of the stringArray
        //and increments i by 1.
        for(int i = 0; i < this.stringArray.length; i++)
        {
            //Displays the position of the element and the element itself.
            stringDisplay += "[" + (i+1) + "]" + this.stringArray[i] + "\n";
        }
        //Returns the String to print the result.
        return stringDisplay;
    }
    
    /**
     * Doubles the capacity of the list, whenever needed. Called by the insert method when
     *      a user inserts an element into a full list. This is done by creating a new list
     *      double the size and then copying the elements from the original into the new list.
     * Precondition: None.
     * Postcondition: Instance variables modified as necessary.
     */
    private void enlarge()
    {
        //Creates a temporary String that has the size of the current String object.
        String[] temporary = new String[this.size];
        //For loop that starts at 0 and iterates through the size of the current String object
        //and increments i by 1 each iteration.
        for(int i = 0; i < this.size; i++)
        {
            //Stores the element at position i in stringArray into the temporary String at the same
            //index.
            //Beginning of swap.
            temporary[i] = this.stringArray[i];
        }
        //Once each element has been stored into the temporary String double the size of capacity.
        this.capacity = this.capacity * 2;
        //Create a new String with the new capacity size.
        this.stringArray = new String[this.capacity];
        //Loop through the temporary String and store everything back into the newly made StringArray
        //with the larger capacity size.
        for(int i = 0; i < this.size; i++)
        {
            //End of swap.
            this.stringArray[i] = temporary[i];
        }
    }

    /*public static void main(String[] args)
    {
        StringsList myString = new StringsList();
        System.out.println(myString.displayList());
        myString.add("hello");
        myString.add("tomorrow");
        myString.add("cactus");
        myString.add("world");
        myString.add("a");
        myString.add("goodbye");
        System.out.println(myString.displayList());
        System.out.println(myString.find("hello"));
        System.out.println(myString.find("tomorrow"));
        System.out.println(myString.find("cactus"));
        System.out.println(myString.find("world"));
        System.out.println(myString.find("a"));
        System.out.println(myString.find("goodbye"));
        System.out.println(myString.find("spaghetti"));
        System.out.println(myString.contains("hello"));
        System.out.println(myString.contains("tomorrow"));
        System.out.println(myString.contains("cactus"));
        System.out.println(myString.contains("world"));
        System.out.println(myString.contains("a"));
        System.out.println(myString.contains("goodbye"));
        System.out.println(myString.contains("spaghetti"));
        System.out.println(myString.displayList());
        myString.add("stone");
        myString.add("rock");
        myString.add("84");
        myString.add("tongue");
        myString.add("eye");
        myString.add("foot");
        System.out.println(myString.displayList());
        myString.delete("stone");
        myString.delete("cactus");
        System.out.println(myString.displayList());
    }*/
}