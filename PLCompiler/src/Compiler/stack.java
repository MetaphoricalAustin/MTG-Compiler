package Compiler;

import java.util.ArrayList;
import java.util.List;

public class stack<E> //don't even know why I went through the trouble of genetics, I only needed characters anyway
{
	private static List<Object> stack;
	
	public stack()//default stack
	{
		stack = new ArrayList<>();
	}
	
	public stack(Object object)//new stack of type given
	{
		stack = new ArrayList<Object>();
	}
	
	public static void push(Object item)
	{
		stack.addLast(item);
	}
	
	public static <E> Object pop()
	{
		if(getSize() < 1)
		{
			return "nothing here yet";
		}
		else
			return stack.removeLast().toString(); //if I dont .toString() it fails because casting from objects is bad
	}
	
	public static int getSize()
	{
		return stack.size();
	}
	
	public static void printTop()
	{
		System.out.print(stack.getFirst()); //does not remove the item
	}
	
}	
