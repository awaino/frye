package heap;
import java.util.Random;
import java.util.Comparator;

public class RMCHeapPriorityQueue<E extends Comparable <E>> {

    private E[] data;
    private int size = 0;
    public int i = 0;
    public int a, b = 0;
    private int initialCapacity = 11;
    public int leftChildOf = 0;
    public int rightChildOf = 0;
    public int parentOf = 0;
    public int root = 0;
    public E tmp = null;

    public RMCHeapPriorityQueue() {
        data = (E[]) new Comparable[initialCapacity];
        
    }

    public int randInput(){
        int min = 1;
        int max = 100;
        Random rand = new Random();
        int randomNum = rand.nextInt(max-min) + min;
        return randomNum;
    }

    public E peek() {
        return data[0];
    }

    public E delete(E top) {
        if (size != 0){
            top = data[1];
            data[1] = data[size--];
            percolateUp(a,b);   
        }return top;
    }

    public void add(E element) {
        //System.out.println("Size = " + size);
        //System.out.println("data.length = " + data.length);
        //System.out.println("i = " + i );
        if (i == data.length) {
            growArray(initialCapacity);
        }
        else{
            
            data[i] = element;
            System.out.println("Element " + i + " = " + element);
            i++;
            size++;
        }

    }
    
    public void buildHeapUp(){
       for (i = ((size/2)-1); i>=0; i--)
           percolateUp(a,b);         
        
    }
    
    public void buildHeapDown(){
       for (i = ((size/2)-1); i>=0; i--)
           percolateDown(a,b);         
        
    }
    
    public int size() {
        return size;
    }

    private void swap(int a, int b) {
        System.out.println("Swap A = " + data[a]);
        System.out.println("Swap B = " + data[b]);
        tmp = data[a];
        data[a] = data[b];
        data[b] = tmp;
        System.out.println("After swap A = " + data[a]);
        System.out.println("After swap B = " + data[b]);
        
    }

    private void percolateUp(int a, int b) {
        root = i;
        int leftChildOf = ((2*root) + 1);
        int rightChildOf = ((2*root) + 2);
        System.out.println("Root = " + data[root]); 
        System.out.println("Left Child = " + data[leftChildOf]); 
        System.out.println("Right Child = " + data[rightChildOf]);
         
        if (data[rightChildOf] != null){
            if(data[root].compareTo(data[rightChildOf]) < 0){
            a = root;
            b = rightChildOf;
            swap(a,b);
            percolateUp(a, b);
        }
        if(data[leftChildOf] !=null) {
            if(data[root].compareTo(data[leftChildOf]) < 0){
                a = root;
                b = leftChildOf;
                swap(a,b);
                percolateUp(a, b);
                }
            }
        }  
    }

    private void percolateDown(int a, int b) {
        root = i;
        int leftChildOf = ((2*i) + 1);
        int rightChildOf = ((2*i) + 2);
        System.out.println("Root = " + data[root]);
        System.out.println("Left Child = " + data[leftChildOf]);
        System.out.println("Right Child = " + data[rightChildOf]);
    
        if (data[rightChildOf] != null){
            if(data[root].compareTo(data[rightChildOf]) > 0){
            a = root;
            b = rightChildOf;
            swap(a,b);
            percolateDown(a, b);
        }
        if(data[leftChildOf] !=null) {
            if(data[root].compareTo(data[leftChildOf]) > 0){
                a = root;
                b = leftChildOf;
                swap(a,b);
                percolateDown(a, b);
                }
            }
        }
    }
    

    private void growArray(int initialCapacity) {
        if (i == data.length) { //grow array
            E[] old = data;
            data = (E[]) new Comparable[initialCapacity *2];
            System.arraycopy(old, 0, data, 0, size);
            initialCapacity = data.length;
            System.out.println("Initial Capacity now = " + initialCapacity);
            
        }
    }

    
    public void printHeap(){
        System.out.print("Heap contains = ");
        for (int i = 0; i < size; i++)
            System.out.print(data[i] +" ");
        System.out.println();
    }
}
