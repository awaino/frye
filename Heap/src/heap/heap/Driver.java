
package heap.heap;

public class Driver {

  
    public static void main(String[] args) {

        RMCHeapPriorityQueue<Integer> queue = new RMCHeapPriorityQueue<>();
        
        //int foo = Integer.parseInt(args[0]);
        
        
        do{
            Integer element = queue.randInput();
            queue.add(element);
        }while (queue.i <20); //change number to change total elements of the heap

        queue.peek();
        
        //if (queue.i < 20){
            queue.printHeap();
        //}
        
        while(queue.size() != 0){
            queue.Pop(queue.i);
        }
         
        queue.printHeap();          
        
    }

}
