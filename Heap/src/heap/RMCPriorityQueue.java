package heap;

public interface RMCPriorityQueue<E> {
    public E peek();
    
    public E poll();
    
    public void add (E element);
    
    public int size();
    
}
