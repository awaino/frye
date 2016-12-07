package pkgfinal;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver {
    
    
    public static void main(String[] args) throws FileNotFoundException {
        
        Word w = new Word();
        File words = new File("d:/workspace/java/words.txt");  
        Scanner scnr1 = new Scanner(words);
        
        while (scnr1.hasNext()){
            String stem = scnr1.next();
            w.addWord(stem);
        }
              
        w.createWordList();
        w.createDoclist();
       
        System.out.println("Final Project Menu\n");
        System.out.println("Press 1 for the Wordlist\n");
        System.out.println("Press 2 for the Doclist\n");
        System.out.println("Press 3 for Occurs With\n");
        System.out.println("Press 4 to quit\n");
        
        Scanner fromUser = new Scanner(System.in);
        System.out.print("Please make selection: ");
        int selection = fromUser.nextInt();
        
        while (selection != 4){
            if (selection == 1){
                System.out.println("Word list\n");
                System.out.println("Enter Document ID number (0 to 299): ");
                while (!fromUser.hasNextInt()){
                    System.out.println("Invalid entry, please try again.");
                    return;
                }
                int docSelection = fromUser.nextInt();
                if ((docSelection >= 0) && (docSelection < 300)){
                    System.out.println("Document ID is: " + docSelection);
                    System.out.println("Words contained in Document " + 
                            docSelection +": " + w.getDocList(docSelection));
                    return;
                }
                else{
                    System.out.println("Document number out of range, "
                            + "please try again.");
                }
            }
            
            if (selection == 2){
                System.out.println("Document list\n");
                System.out.println("Enter the Word: ");
                String wordSelection = null;
                wordSelection = fromUser.next();
                System.out.println("Word is: " +wordSelection);
                if (w.wordExists(wordSelection)){
                    System.out.println("Word is used in these documents:" 
                            + w.wordList.get(w.getWord(wordSelection)));
                }else{
                    System.out.println("Word is not used in any of the "
                            + "documents provided.");
                }
                return;
            }
            
            if (selection == 3){
                System.out.println("Occurs with"); 
                System.out.println("Enter the Word: ");
                String wordOccurs = fromUser.next();
                System.out.println("Word is: " + wordOccurs);
                
                w.occursWith(wordOccurs);
                return;
            }
        }   
    }
 }