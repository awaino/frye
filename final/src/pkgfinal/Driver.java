package pkgfinal;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver {
    
    
    public static void main(String[] args) throws FileNotFoundException {
        
        String wordPath = args[0];
        String docPath = args[1];
        
        Word w = new Word();
        
        w.addWord(wordPath);
        w.createWordList(docPath);
        w.createDoclist();
        menu(w);
           
    }
 
    public static void menu(Word w){
        int selection = 0;
        while (selection != 4){
            System.out.println("\nFinal Project Menu\n");
            System.out.println("Press 1 for the Wordlist\n");
            System.out.println("Press 2 for the Doclist\n");
            System.out.println("Press 3 for Occurs With\n");
            System.out.println("Press 4 to quit\n");
        
            Scanner fromUser = new Scanner(System.in);
            System.out.print("Please make selection: ");
        
            while(!fromUser.hasNextInt()){
                System.out.println("\nInvalid entry please try program again.");
                return;
                }
            selection = fromUser.nextInt();        
        
            switch(selection){
                case 1:{
                System.out.println("Word list\n");
                System.out.println("Enter Document ID number (0 to 299): ");
                if (!fromUser.hasNextInt()){
                    System.out.println("Invalid entry, restarting menu.");
                    selection = 0;
                    break;
                }
                int docSelection = fromUser.nextInt();
                if ((docSelection >= 0) && (docSelection < 300)){
                    System.out.println("Document ID is: " + docSelection);
                    System.out.println("Words contained in Document " + 
                            docSelection +": " + w.getDocList(docSelection));
                    break;
                }
                else{
                    System.out.println("Document number out of range, "
                            + "please try the program again.");
                    break;
                    }
                }
            
                case 2:{
                System.out.println("Document list\n");
                System.out.println("Enter the Word: ");
                String wordSelection = null;
                wordSelection = fromUser.next();
                System.out.println("Word is: " +wordSelection);
                if (w.wordExists(wordSelection)){
                    String docPrint = (String) w.wordList.get(w.getWord(wordSelection));
                    System.out.println("Word is used in these documents: " 
                            + docPrint);
                }else{
                    System.out.println("Word is not used in any of the "
                            + "documents provided.");
                }
                break;
                }
            
                case 3:{
                System.out.println("Occurs with"); 
                System.out.println("Enter the Word: ");
                String wordOccurs = fromUser.next();
                System.out.println("Word is: " + wordOccurs);
                
                w.occursWith(wordOccurs);
                break;
                }
                
                case 4:{
                    System.out.println("\nExiting program");
                    return;
                }
                default:{
                    System.out.println("Invalid entry");
                }
            }    
        }
    }
}
