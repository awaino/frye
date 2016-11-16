
package heap;

public class Driver {

  
    public static void main(String[] args) {

        RMCHeapPriorityQueue<Integer> queue = new RMCHeapPriorityQueue<>();
        
        do{
            Integer element = queue.randInput();
            queue.add(element);
        }while (queue.i <12); //change number to change total elements of the heap

        
        queue.printHeap();
        queue.buildHeapUp();
        queue.printHeap();
        //queue.buildHeapDown();
        //queue.printHeap();



    }

}
