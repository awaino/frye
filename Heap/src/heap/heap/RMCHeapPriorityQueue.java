package heap.heap;
import java.util.Random;
import java.util.Comparator;

public class RMCHeapPriorityQueue<E extends Comparable <E>> {

    private E[] data;
    private int size = 0;
    public int i, a, b = 0;
    private int initialCapacity = 11;
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
        System.out.println("Heap top = " + data[0]);
        return data[0];
    }

    public E Pop(E top) {
        if (size != 0){
            top = data[0];
            data[0] = data[size];
            data[size] = top;
            percolateDown(0); 
            size--;
            System.out.println(top);
        }return top;
    }

    public int leftChildOf(int i){
        return(2*i) +1;
    }
    
    public int rightChildOf(int i){
        return(2*i) +2;
    }
    
    public int parentOf(int i){
        return(i-1)/2;
    }
    
    public void add(E element) {
        //System.out.println("Size = " + size);
        //System.out.println("data.length = " + data.length);
        //System.out.println("i = " + i );
        if (size == data.length) {
            growArray();
        }
        else{
            
            data[i] = element;
            System.out.println("Element " + i + " = " + element);
            
            percolateUp(i);
            i++;
            size++;
            
        }

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

    private void percolateUp(int i) {
        System.out.println("i = " + data[i] );
        System.out.println("parent of i = " + data[parentOf(i)]);
        if (rightChildOf(i)<data.length){
            System.out.println("right child of i = " + data[rightChildOf(i)]);
        }
        if (leftChildOf(i) < data.length){
            System.out.println("left child of i = " + data[leftChildOf(i)]);
        }
        
        if(parentOf(i)< 0)
            return;
        if(data[i].compareTo(data[parentOf(i)]) > 0){
            swap(i, parentOf(i));
            percolateUp(parentOf(i));
        }
            
    }

    private void percolateDown(int i) {
        System.out.println("i = " + data[i] );
        System.out.println("parent of i = " + data[parentOf(i)]);
        if (rightChildOf(i)<data.length){
            System.out.println("right child of i = " + data[rightChildOf(i)]);
        }
        if (leftChildOf(i) < data.length){
            System.out.println("left child of i = " + data[leftChildOf(i)]);
        }      
        
        if(rightChildOf(i) != 0){
            if(data[i].compareTo(data[rightChildOf(i)]) > 0){
                swap(i, rightChildOf(i));
                percolateDown(rightChildOf(i));
            }
        }    
        if(leftChildOf(i) !=0){
            if(data[i].compareTo(data[leftChildOf(i)]) > 0){
                swap(i, leftChildOf(i));
                percolateDown(leftChildOf(i));
            }
        }
        if(leftChildOf(i) == 0){
            return;
        }
    }
    

    private void growArray() {
        if (size == data.length) { //grow array
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
