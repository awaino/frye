package stack1;

/**
 *
 * @author awain
 */


public class GenericStack<E> {
    
    private E[] data;
    private int top;
    private int size;
    public int top2 = top;

    public String sCoords = "";
    
    public GenericStack() {
        top = -1;
        size = 100;
        data = (E[]) new Object[100];
    }
    public GenericStack (int n) {
        top = -1;
        size = n;
        data = (E[]) new Object[n];
    }

    
    public boolean push(E sCoords){
        if (top == size -1)
            return false;
        else {
            top++;
            data[top] = sCoords;
            System.out.println(data[top] + " Popped on the stack.\n");
            return true;
        }   
    }
    public E peek(){
     
        System.out.println("Top = " + data[top].toString() + "\n");
        
        return null;
    }
    
    public E pop() {
        int topLocation;
        if(top == -1)
            return null;
        else {
            topLocation = top;
            top--;
            return data[topLocation];
        }
        
    }
    public void sizeT(){
        int t = 0;
        t= top +1;
        System.out.println("Total items in the stack = " + t + "\n");
    }
    
    
    public int showAll() {
        for(int i = top; i >= 0; i --)
            System.out.println(data[i]);
        return(top);
    } 
    
    
}
