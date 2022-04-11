//Student 1 full name: Weifeng Huang
//Student 2 full name: Weifeng Huang
//==================================================


/**
 * Your documentation for this interface ....
 * An interface Stack contains 6 methods. 
 * The method isEmpty return ture if the stack is empty, otherwise return false.
 * The method push has one inupt parameter, and it add that parameter to the top of stack.
 * The method pop return the top value of the Stack, and remove it.
 * The method peek return the top value of the Stack, but not remove it.
 * The method size return the total number of value on Stack.
 * The method ttb return a string that represent the Stact vertically
 * (Mainly use in the class toString of HanoiTowerGame)
 */

public interface Stack {
	//your code here
    public abstract boolean isEmpty();
    public abstract void push(Object o);
    public abstract Object pop();
    public abstract Object peek();
    public abstract int size();
    public abstract String ttb(int disks);
}