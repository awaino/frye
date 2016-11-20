package heap;
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

    public int randInput(){  //generate random numbers to fill array
        
        int min = 1;
        int max = 10000;
        Random rand = new Random();
        int randomNum = rand.nextInt(max-min) + min;
        return randomNum;
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
    
    public E peek() { //Peek at data[0]
        
        System.out.println("Heap top = " + data[0]);
        return data[0];
    }

    public E Pop(E top) { //Pop from highest to lowest
        
        if (size != 0){
            i = 0;
            size--;
            top = data[0];
            data[0] = data[size];
            data[size] = top;
            percolateDown(0);
        }return top;
    }

    public void add(E element) { //Add element then percolate up
        
        if (size == data.length) {
            growArray();
        }
        else{
            data[i] = element;
            percolateUp(i);
            i++;
            size++;
        }
    }
    
    public int size() {
        
        return size;
    }

    private void swap(int a, int b) { //Swap provided elements 
        
        tmp = data[a];
        data[a] = data[b];
        data[b] = tmp;
    }

    private void percolateUp(int i) { //Percolate up if parent is smaller
           
        if(parentOf(i)< 0)
            return;
        if(data[i].compareTo(data[parentOf(i)]) > 0){
            swap(i, parentOf(i));
            percolateUp(parentOf(i));
        }
    }

    private void percolateDown(int i) { //Percolate down 3 cases
        
        if(rightChildOf(i) < size){
            if(data[i].compareTo(data[rightChildOf(i)]) < 0){
                swap(i, rightChildOf(i));
                percolateDown(rightChildOf(i));
            }   //case 1
        }    
        if(leftChildOf(i) < size){
            if(data[i].compareTo(data[leftChildOf(i)]) < 0){
                swap(i, leftChildOf(i));
                percolateDown(leftChildOf(i));
            }   //case2
        }
        
        if(leftChildOf(i) == size){
            return; //i is a leaf
        }   //case 3
    }
    

    private void growArray() { //Grow array once end of array is reached
        
        if (size == data.length) { //grow array
            E[] old = data;
            data = (E[]) new Comparable[initialCapacity *2];
            System.arraycopy(old, 0, data, 0, size);
            initialCapacity = data.length;
        }
    }

    
    public void printHeap(){ //Print array
        
        System.out.print("Heap contains = ");
        for (int i = 0; i < data.length; i++)
            if (data[i] != null){
              System.out.print(data[i] +" ");  
            }
        System.out.println();
    }
}