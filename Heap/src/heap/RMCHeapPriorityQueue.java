package heap;
import java.util.Random;
import java.util.Comparator;

public class RMCHeapPriorityQueue<E extends Comparable <E>> {

    private E[] data;
    public int size = 0;
    public int i, a, b = 0;
    private int initialCapacity = 23;
    public E tmp = null;
    public static int pd_count = 0;

    public RMCHeapPriorityQueue() {
        
        data = (E[]) new Comparable[initialCapacity];
    }    

    public int randInput(){  //Generate random numbers to fill array
        
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

    public void incrementSize(){ //increment size, grow array if needed
        size++;
        if (size == data.length) {
            growArray();
        }
    }
    
    public void add(int i, E element) { //add element
        
            data[i] = element;
    }
    
    public int size() { //return size
        
        return size;
    }
    
    public E pop(){ //pop the top of the tree to the end of the array 
        if (size != 0){
            E root = data[0];
            data[0] = data[--size];
            heap(0); //then shuffle
            return root;
        }return null;
    }        
    
    public void heap(int i) { //shuffle elements around for heaped array
        int largestChild;
	E root = data[i];	

	while (i < size / 2) {	
            int leftChild =  leftChildOf(i);
            int rightChild = rightChildOf(i);
                
            if (rightChild < size && data[leftChild].compareTo(data[rightChild]) < 0){
                largestChild = rightChild;				
            } else {
                largestChild = leftChild;			
            }		

            if (root.compareTo(data[largestChild]) >= 0)
                break;		
            
            data[i] = data[largestChild];
            i = largestChild;
        }
	data[i] = root;
    }
    
    public void heapSort(){ // Sort entire array from lowest to highest
        for (int k = size-1; k >= 0; k--){
            E largestNode = pop();
            add(k, largestNode);
        }
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