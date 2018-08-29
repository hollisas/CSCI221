import java.util.*;
/**
 * StackInterface provides the required methods for any stack of integers
 * 
 * @author McCauley
 */
public interface IntStackInterface
{
    /**
     * item is added tothe top of the stack
     */
    public void push(int item);
    
    /**
     * item at top of stack is removed
     */
    public void pop();
    
    /**
     * reference to item at top of stack is returned
     */
    public int top();
    
    /**
     * Number of items on stack
     */
    public int size();
    
    /**
     * true when stack contains no items, false otherwise
     */
    public boolean isEmpty();
}
