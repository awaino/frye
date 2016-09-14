package listing;

/**
 *
 * @author awain
 */
public class DataStructure2<T> {
 
    private int next = 0;
    private T[] data;
    public int size = 100;
    public String newNameAge =" "; 
    
    public DataStructure2(){
    this(100);
    }  
    
    public DataStructure2(int size){
        this.size = size;
        this.next = 0;
        this.data = (T[])new Object[size];
    }

    public void addListing(T newNameAge){
        
        data[next++] = newNameAge;
    }

    public void showAllListings(){
        for(int i=0; i < next; i++){
            System.out.println(data[i].toString());
        }
    }

}




