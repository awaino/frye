package binarysearchtree;

import java.util.ArrayList;

public class BinarySearchTreeNode<E extends Comparable<E>>{
    
    public E element;
    public BinarySearchTreeNode<E> left;
    public BinarySearchTreeNode<E> right;
    ArrayList<E> elementList1 = new ArrayList<E>();
    
    //constructor
    public BinarySearchTreeNode(){
        element = null;
    }

    public BinarySearchTreeNode(E element) {
        this.element = element; 
    }

    public void add(E element){
        //Add elements to the Binary Search Tree using compareTo from Comparable setup
        if(this.element.compareTo(element) > 0){
            if (leftExists()){
                left = new BinarySearchTreeNode<>(element);
            }else{
                left.add(element); 
            }
        }else if(this.element.compareTo(element) < 0){
            if (rightExists()){
                right = new BinarySearchTreeNode<>(element);
            }else{
                right.add(element);
            }
        }else if(this.element.compareTo(element) == 0){
            BinarySearchTree.size--;
            //System.out.println("size = " + BinarySearchTree.size);
            //No dupes
        }
    }

    public boolean leftExists(){
        if (left == null){
            return true;
        }
        return false;
    }

    public boolean rightExists(){
        if (right == null){
            return true;
        }
        return false;
    }

    public void display(int level){
        //Display contents of the Tree and their location
        if (level == 0){
            System.out.println("Element (Level " + level + "): " + this.element.toString());
        }else{
            System.out.println(" Element (Level " + level + "): " + this.element.toString());
        }
            if(left != null) {
                System.out.print("Left of  " + this.element.toString());
                left.display(level + 1);
            }

            if(right != null) {
                System.out.print("Right of " + this.element.toString());
                right.display(level + 1);
            
        }
    }

    //Traversals
    public void preOrderTraversal(BinarySearchTreeNode<E> root){
        if (root != null){
            System.out.println(root.element);
            preOrderTraversal(root.left);   
            preOrderTraversal(root.right);
        }
    }

    public void inOrderTraversal(BinarySearchTreeNode<E> root){
        if (root != null){
            inOrderTraversal(root.left);     
            System.out.println(root.element);
            inOrderTraversal(root.right);
        }
    }
    public void postOrderTraversal(BinarySearchTreeNode<E> root){
        if (root != null){
            postOrderTraversal(root.left);   
            postOrderTraversal(root.right);
            System.out.println(root.element);
        }
    }

    //Find element in the tree    
    public boolean findElement(BinarySearchTreeNode<E> root, E input){
        if (root == null){
            return false;
        }
        if (root.element.compareTo(input)== 0){
            return true;
        }
        if (root.element.compareTo(input) > 0){
            return findElement(root.left, input);
        }else
            return findElement(root.right, input);
    }
    
    //Delete element from the tree
    public boolean delete(E input, BinarySearchTreeNode<E> root){
        BinarySearchTreeNode<E> parent = root;
        BinarySearchTreeNode<E> current = root;
        
        boolean isLeftChild = false;
        while(current.element != input){
            parent = current;
            if(current.element.compareTo(input)> 0){
                isLeftChild = true;
                current = current.left;
            }else{
                isLeftChild = false;
                current = current.right;
            }
            if(current == null){
                return false;
            }
        }
        //Case 1
        if(current.left == null && current.right == null){
            if(current == root){
                root = null;
            }
            if(isLeftChild == true){
                parent.left = null;
            }else{
                parent.right = null;
            }
        }
        //Case 2
        else if(current.right == null){
            if(current == root){
                    root = current.left;
            }else if(isLeftChild){
                parent.left = current.left;
            }else{
                parent.right = current.left;
            }
        }
        else if(current.left == null){
            if(current == root){
                    root = current.right;
            }else if(isLeftChild){
                parent.left = current.right;
            }else{
                parent.right = current.right;
            }
        }else if(current.left != null && current.right != null){
            BinarySearchTreeNode<E> successor = getSuccessor(current);
            if(current == root){
                root = successor;
            }else if(isLeftChild){
                parent.left = successor;
            }else{
                parent.right = successor;
            }			
            successor.left = current.left;
        }		
        //Case 3    
        return true;		
    }

    //promote element
    public BinarySearchTreeNode<E> getSuccessor(BinarySearchTreeNode<E> deleteElement){
        BinarySearchTreeNode<E> successsor = null;
        BinarySearchTreeNode<E> successsorParent = null;
        BinarySearchTreeNode<E> current = deleteElement.right;
        while(current!= null){
            successsorParent = successsor;
            successsor = current;
            current = current.left;
        }

        if(successsor != deleteElement.right){
            successsorParent.left = successsor.right;
            successsor.right = deleteElement.right;
        }
        return successsor;
    }
    
    //Create ArrayList and add elements using in-order traversal method
    public ArrayList<E> elementTreeSort(){
        //perform in order traversal adding to the ArrayList
        if(left != null) {
            elementList1.addAll(left.elementTreeSort());
        }
        elementList1.add(this.element);
        if(right != null) {
            elementList1.addAll(right.elementTreeSort());    
        }  
        return elementList1;
    }
    
    //Print the ArrayList elements
    public void elementListPrint(){
        for (int i = 0; i < elementList1.size(); i++){
            System.out.println("ArrayList element " +(i+1) +": "+ elementList1.get(i));
        }
    }
}

