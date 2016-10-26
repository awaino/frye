package binarysearchtree;

import java.util.Random;

public class BinarySearchTree<E extends Comparable<E>>{
    private int size;
    private BinarySearchTreeNode<E> root;

    //constructor
    
    public BinarySearchTree() {
    
    }
       
    public BinarySearchTreeNode<E> FirstElement(E element){
        return new BinarySearchTreeNode<E>(element);
    }   
    
    public BinarySearchTree(E element){
        size = 0;
        root = FirstElement(element);
        
    }
          
    public boolean contains(E element){
        if(root ==null){
        return true;
        }return false;
    }
    
    public void display(){
        if(root!=null){
            root.display(0);
        }
    }
    
    public int randInput(){
        int min = 1;
        int max = 100;
        Random rand = new Random();
        int randomNum = rand.nextInt(max-min) + min;
        return randomNum;
    }

    private void add(E element) {
        size++;
        if (root == null){
            this.root = FirstElement(element);  
        }
        else root.add(element);
    }
    
    private class BinarySearchTreeNode<E extends Comparable<E>>{
        
        private E element;
        private BinarySearchTreeNode<E> left;
        private BinarySearchTreeNode<E> right;
        
        //constructor
        public BinarySearchTreeNode(){
            element = null;
            left = null;
            right = null;
        }
        
        

        private BinarySearchTreeNode(E element) {
           this.element = element; 
        }

        public void add(E element){
            System.out.println("this.element = " + this.element);
            System.out.println("element = " + element);
            if(this.element.compareTo(element) < 0){
                if (left.contains(null)){
                    left = new BinarySearchTreeNode<E>(element);
                    System.out.println("Left = " + left);
                }else{
                    left.add(element); 
                    System.out.println("Left = " + left);
                }
            }else if(this.element.compareTo(element) > 0){
                if (right.contains(null)){
                    right = new BinarySearchTreeNode<E>(element);
                    System.out.println("Right = " + right);
                }else{
                    right.add(element);
                    System.out.println("Right = " + right);
                }
            }else if(this.element.compareTo(element) == 0){
                    //No dupes
            }
        }
        
        public boolean contains (E element){
        
            return true;
        } 
        
        public void display(int level){
            System.out.println("Element (Level " + level + "): " + this.element.toString());

        if(left != null) {
            System.out.print("Left of " + this.element.toString());
            left.display(level + 1);
        }

        if(right != null) {
            System.out.print("Right of " + this.element.toString());
            right.display(level + 1);
        }
        }
    
    }

    public static void main(String[] args) {
           
        BinarySearchTree<Integer> create = new BinarySearchTree<Integer>();
        
        
        Integer element = create.randInput();
        System.out.println("This is the random start element: " + element);
        do{
            create.add(element);
            
        }while (create.size < 50);
        
        
        System.out.println("Size = " + create.size);
        
        create.display();
    }

}