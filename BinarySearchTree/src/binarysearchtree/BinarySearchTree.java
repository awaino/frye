package binarysearchtree;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BinarySearchTree<E extends Comparable<E>>{
    public static int size;
    public E input;
    public BinarySearchTreeNode<E> root;

    //constructor
    
    public BinarySearchTree(){
        size = 0;
        input = null;
        root = null;
    }  
    
    public void display(){
        if(root!=null){
            root.display(0);
        }
    }
    
    public void preOrderTraversal(){
        if(root!=null){
            root.preOrderTraversal(root);
        }
    }
    
    public void inOrderTraversal(){
        if(root!=null){
            root.inOrderTraversal(root);
        }
    }
    
    public void postOrderTraversal(){
        if(root!=null){
            root.postOrderTraversal(root);
        }
    }
    
    public int randInput(){
        int min = 1;
        int max = 100;
        Random rand = new Random();
        int randomNum = rand.nextInt(max-min) + min;
        return randomNum;
    }

    void add(E element) {
        System.out.println("Size = " + (size+1) + " Random element = " + element);
        size++;
        if (root == null){
            this.root = new BinarySearchTreeNode<E>(element); 
        }
        else root.add(element);
    }
    
    public boolean findElement(E input){
        if (root.findElement(root, input)){
            //System.out.println("Integer1 " + input+ " found");
            return true;
        }else{
            //System.out.println("Integer1 " + input+ " not found");
            return false;
        }
    }   
    
    public void deleteElement(E input){
        root.delete(input, root);
    }
    
    public void treesort(){
        root.elementTreeSort();
        root.elementListPrint();
    }
}
