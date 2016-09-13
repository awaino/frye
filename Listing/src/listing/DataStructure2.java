package listing;


import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author awain
 */
public class DataStructure2<T> {
 
    private int next = 0;
    private T[] data;
    public int size = 100;
    Listing lst = new Listing();   
    public String newNameAge =" ";
    
    
    public DataStructure2(){
    this(100);
    }  
    
    public DataStructure2(int size){
        this.size = size;
        this.next = 0;
        this.data = (T[]new Object[size]);
    }

    public void addListing(){
        
        data[next++] = lst.newNameAge;
    }

    public void showAllListings(){
        for(int i=0; i < next; i++){
            System.out.println(data[i].toString());
        }
    }

}




