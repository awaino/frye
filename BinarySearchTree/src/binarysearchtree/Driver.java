package binarysearchtree;

import java.util.Scanner;

public class Driver {
 
    public static void main(String[] args) {

        BinarySearchTree<Integer> create = new BinarySearchTree<Integer>();
        System.out.println("Creating Binary Search Tree.");
        
        //Fill the tree with random numbers from 1 to 100
        do{
            Integer element = create.randInput();
            create.add(element);
        }while (BinarySearchTree.size < 30); //change number to change total elements of the tree
        
        
        //Traversals
        System.out.println("\nDisplaying contents and location \nof the Binary Search Tree Elements.\n");
        create.display();

        System.out.println("\nPre-order Traversal:");
        create.preOrderTraversal();
        System.out.println("\nIn-order Traversal:");
        create.inOrderTraversal();
        System.out.println("\nPost-order Traversal:");
        create.postOrderTraversal();
        
        //Find and delete element, then reprint in-order traversal
        Scanner fromUser = new Scanner(System.in);
        System.out.print("Please input Integer from 1 to 100 to locate: \n");
        
        //Send the text to the input string and then find it
        create.input = fromUser.nextInt();
        System.out.println("Integer entered is: " + create.input +"\n");
        
        //If it exists in the tree, delete it
        if (create.findElement(create.input)){
            System.out.println("Integer " + create.input+ " found\n");
            System.out.println("Deleting Integer: " + create.input);
            create.deleteElement(create.input);
            System.out.println("\nNew in-order traversal:");
            create.inOrderTraversal();
        
        //If it does not exit in the tree
        }else{
            System.out.println("Integer " +create.input+ " not found");
        }  
        
        //ArrayList function
        System.out.println("\nCreating Arraylist.");
        create.treesort();
    } 
}
