import java.util.*;
/**
 * A FILO stack of ints.
 * -- "implements" IntStackInterface
 * -- stack implemented using an ArrayList
 * -- for efficiency purposes, the top of the stack
 * -- is the largest index in use.
 * 
 * @author McCauley
 */
public class Stack implements IntStackInterface
{
    // the stack is implemented using an ArrayList
    private ArrayList<Integer> stk;
    private Stack otherStk;
    /**
     * Constructor for objects of class Stack
     */
    public Stack()
    {
        // initialise instance variables
        stk = new ArrayList<Integer>();
    }

    /**
     * item is added to the top of the stack
     */
    public void push(int item){
        stk.add(item); // top of stack is at largest index
    }

    /**
     * item at top of stack is removed
     * Precondition: stack is not empty.
     * **** User should verify that stack is not empty, 
     * **** before calling this method.
     */
    public void pop(){
        stk.remove(stk.size()-1);      
    }

    /**
     * returns a reference item at top of stack is returned
     */
    public int top(){
        return stk.get(stk.size()-1);
    }

    /**
     * Number of items on stack
     */
    public int size(){
        return stk.size();
    }

    /**

     * true when stack contains no items, false otherwise
     */
    public boolean isEmpty(){
        return stk.size() == 0;
    }

    public Stack copy(){
        //Variable to store the value at the position for the copy of the stack.
		int posCopy;
		//Increment variable.
		int i = 0;
		//Creates a new stack in order to make the copy.
		Stack otherStk = new Stack();
		//While loop while the stack size is greater than the incrementing counter.
		while(i < stk.size())
		{
		    //Store the value at i and put it in the variable.
			posCopy = stk.get(i);
			//Put the value that was stored in the variable and put it in the new stack.
			otherStk.push(posCopy);
			//Increment by one.
			i++;
		}
		//Return the copy of the stack.
		return otherStk;
    }
}