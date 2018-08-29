/**
 * The TestDriver will prove that a deep copy of the original stack is made and that the reverse method does work..
 * 
 * @author Austin Hollis 
 * @version 4/25/17
 */
public class TestDriver
{
    public static void main(String[] args)
    {
        //Print statement to tell what is being done first in the program.
        System.out.println("Proving that the copy is a deep copy");
        //Print statement for making it easier to read.
        System.out.println("------------------------------------");
        //Creates multiple integer values to be stored in the stack.
        int item1 = 3, item2 = 4, item3 = 21, item4 = 150;
        //Creates a new stack named originalStack.
        Stack originalStack = new Stack();
        //Pushes value onto the top of the stack.
        originalStack.push(item1);
        //Pushes value onto the top of the stack.
        originalStack.push(item2);
        //Pushes value onto the top of the stack.
        originalStack.push(item3);
        //Pushes value onto the top of the stack.
        originalStack.push(item4);
        //Creates a copy of the stack with everything that is in the originalStack in the same order.
        Stack copy = originalStack.copy();
        //Print statement for the location of the original stack.
        System.out.println("Original Stack location: " + originalStack);
        //Print statement for the size of the original stack.
        System.out.println("Original Stack size: " + originalStack.size());
        //Print statement to make it easier to read.
        System.out.println();
        //Print statement for the copies location.
        System.out.println("Copy location: " + copy);
        //Print statement for the size of the copy.
        System.out.println("Copy size: " + copy.size());
        //Print statement to make it easier to read.
        System.out.println();
        //Print statement to show the top value of the original stack.
        System.out.println("Top value of the original stack: " + originalStack.top());
        //Print statement to show the top value of the copy.
        System.out.println("Top value of the copy: " + copy.top());
        //Pushes a new copy onto the stack.
        copy.push(2001);
        //Print statement to make it easier to read.
        System.out.println();
        //Print statement to show the top value of the original stack.
        System.out.println("A new value was added to the copy to show that it is a deep copy.");
        //Print statement to show the top value of the original stack.
        System.out.println("Original Stack size: " + originalStack.size());
        //Print statement to show the top value of the copy.
        System.out.println("Copy size: " + copy.size());
        //Print statement to make it easier to read.
        System.out.println();
        //Print statement to show the top value of the original stack.
        System.out.println("Top value of the original stack: " + originalStack.top());
        //Print statement to show the top value of the copy.
        System.out.println("Top value of the copy: " + copy.top());
        //Print statement to make it easier to read.
        System.out.println();
        //Removes the recently added value from the copy.
        copy.pop();
        //Print statement to inform that the top value of the copy was removed.
        System.out.println("The recently added item was removed from the copy.");
        //Print statement to show that the top values are the same in the original and the copy.
        System.out.println("Top value of the original stack: " + originalStack.top());
        //Print statement to show that the top values are the same in the original and the copy.
        System.out.println("Top value of the copy: " + copy.top());
        //Print statement to show the size of the copy again for emphasis.
        System.out.println("The size of the copy is again: " + copy.size());
        //Print statement to make it easier to read.
        System.out.println();
        //While loop to iterate until the original stack is empty.
        while(originalStack.isEmpty() == false)
        {
            //Print statement to return the top values of the stack and the copy.
            System.out.println("Original Stack: " + originalStack.top() + "\nCopy of stack: " + copy.top());
            //Pops the top value from the stack.
            originalStack.pop();
            //Pops the top value from the copy.
            copy.pop();
            //Print statement to make it easier to read.
            System.out.println();
        }
        //Print statement to separate the sections of the driver for easy reading.
        System.out.println("-------------------------------------------------------------");
        //Print statement declaring that we are working with the  reverse method.
        System.out.println("Below is the test cases for the reverse method that was made.");
        //Print statement to keep things contained.
        System.out.println("-------------------------------------------------------------");
        //Runs the reverse method with the stored value.
        reverse(123);
        //Print statement for easier reading.
        System.out.println();
        //Runs the reverse method with the stored value.
        reverse(583);
        //Print statement for easier reading.
        System.out.println();
        //Runs the reverse method with the stored value.
        reverse(235);
        //Print statement for easier reading.
        System.out.println();
        //Runs the reverse method with the stored value.
        reverse(18736);
        //Print statement for easier reading.
        System.out.println();
        //Runs the reverse method with the stored value.
        reverse(1);
        //Print statement for easier reading.
        System.out.println();
        //Runs the reverse method with the stored value.
        reverse(0);
        //Print statement for easier reading.
        System.out.println();
        //Runs the reverse method with the stored value.
        reverse(-592);
        //Print statement to show that the program has finished running.
        System.out.println("This is the end of the program.");
    }

    public static int reverse(int numVal){
        //Creates a new stack named reversedStack.
        Stack reversedStack = new Stack();
        //Returns the number that was entered.
        System.out.println("The number entered was: " + numVal); //returns the variable.
        //Variable for the reverse form of the number.
        int reversedNum = 0;
        //Variable to store the parameter integer.
        int input = numVal;
        //While loop executes while the number is not equal to zero.
        while (input != 0)
        {
            //Multiplies the number by 10 then mods it by 10 to get remainder and overrides itself.
            reversedNum = reversedNum * 10 + input % 10;
            //Pushes the number onto the stack at the top.
            reversedStack.push(reversedNum);
            //Takes the entered number and does integer division by 10 and overrides the value stored in itself.
            input = input / 10;
        }
        //While loop that checks to see if the stack is empty or not.
        while(reversedStack.isEmpty() == false)
        {
            //Returns and removes the top number on the stack.
            reversedStack.pop();
        }
        //Print statement to print the number in reverse order.
        System.out.print("The reversed form of the entered number is: " + reversedNum);
        //Adds a new line for easier reading.
        System.out.print("\n");
        //Return statement needed for method.
        return reversedNum; 
    }
}
