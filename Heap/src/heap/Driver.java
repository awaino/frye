package heap;

public class Driver {
        
    public static void main(String[] args) {

        RMCHeapPriorityQueue<Integer> queue = new RMCHeapPriorityQueue<>();
        
        int foo = Integer.parseInt(args[0]);
        
        
        for (queue.i = 0; queue.i < foo; queue.i++){ //create heap with random numbers
            Integer element = queue.randInput();
            queue.add(queue.i, element);
            queue.incrementSize();
        }
        
        if (foo < 20){
            queue.printHeap();
        }
        
        for (int j = queue.size / 2 ; j >= 0; j--) { // create heaped array
            queue.heap(j);
        }
        
        System.out.println("Number of elements = " + foo);
        
        if (foo < 20){
            queue.printHeap();
        }
        System.out.println("size = " + queue.size());
        
        
        queue.heapSort(); //create sorted array
        
        queue.peek(); //View data[0] just to make sure there is data in the array when finished
        
        if (foo < 20){
            queue.printHeap();
        }
    }
}
