package stack1;

/**
 *
 * @author awain
 */


public class GenericStack<E> {
    MazeSolver Maze = new MazeSolver();
    private E[] data;
    private int top;
    private int size;
    
    public int popData = 0;
    public String newFoo = "";
        
    public GenericStack() {
        top = 0;
        size = 100;
        data = (E[]) new Object[100];
    }
    public GenericStack (int n) {
        top = 0;
        size = n;
        data = (E[]) new Object[n];
    }

    
    public void push(E newFoo){
        data[top++] = newFoo;
        System.out.println(data[top-1] + "\n");
        
    }
    public E pop() {
        int topLocation;
        topLocation = top;
        top = top - 1;
        return data[topLocation];
    }
    public void showAll() {
        for(int i = top-1; i >= 0; i --)
            System.out.println(data[i]);
    }
    
}
