import java.util.ArrayList;
public class Stack {
	private ArrayList<Integer> stack;

    Stack()
    {
        stack = new ArrayList<Integer>();
    }

    public void push(int element)
    {
        stack.add(element);
    }

    public void pop()
    {
    	if (stack.isEmpty())
    		System.out.println("Stack is empty");

        	stack.remove(0);
        	System.out.printf("Pop: ");
        	printStack();
    }

    public int peek()
    {
        int sizeOfStack;

        sizeOfStack = stack.size();

        if (sizeOfStack>=1)
            return(stack.get(sizeOfStack-1));
	
        return(-1);
	
    }

    public int search(int element)
    {
        return(stack.indexOf(element));
    }

    public Boolean move(int element)
    {
        int pos, tmp1, tmp2;
        pos = search(element);
	
        if (pos == -1)
        {
        	System.out.println("Move: Element does not exist in the stack");
        	return(false);
        }
	
        while (pos>0)
        {
        	tmp1 = stack.get(pos);
        	tmp2 = stack.get(pos-1);
        	stack.set(pos-1, tmp1);
        	stack.set(pos, tmp2);
        	pos--;
        }

        return(true);
    }
 
    public void printStack()
    {
        for (Integer item: stack)
	    System.out.printf("%d ", item);
        System.out.println();
    }
}
