package pkgfinal;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class Word<Word extends Comparable<Word>>{
    ArrayList<Word> wordList = new ArrayList<>(); //All words
    ArrayList foo = new ArrayList();  //Temp for moving data
    ArrayList foo2 = new ArrayList(); //Temp for moving data
    Document d = new Document();
    TreeMap wordsTm = new TreeMap();
    TreeSet occursTree = new TreeSet();
    
    private String stem;
    int wordNumber;
    
    public Word(String stem, ArrayList wordList, String tempDoc) {
        this.wordNumber = 1;
        this.stem = stem;
        this.wordList = wordList;
    }

    Word() {
        this.wordNumber = 1;
    }

    //Method to import the Words
    
    public void addWord(String wordPath) throws FileNotFoundException{
        Word stem = null;
        File words = new File(wordPath);  
        Scanner scnr1 = new Scanner(words);
        
        while (scnr1.hasNext()){
            stem = (Word) scnr1.next();
            if (wordList.isEmpty()){  //Create a dummy 0 element
                wordList.add(0, null);
            }
            if(wordList.get(0) == null){  //Add the words starting at element 1
                wordList.add(wordNumber, stem);                  
                wordNumber++;
            }
        }
    }
    
    /*  I did not create a new Document ArrayList with each Word.  I modified 
    the Document to add the word and then added the word to a TreeMap.  
    This gave me an easily returnable Document that contains all words in one 
    element.  It also gave me the ability to do a quick condition check in the
    TreeMap if the word existed or not.  I could also search the TreeMap and get
    the key back for the Words(value)location in the wordList ArrayList.
     */
    
    public void createWordList(String docPath) throws FileNotFoundException{
        File documents = new File(docPath);  
        String tempDoc = "";
        Scanner scnr = new Scanner(documents);
        while (scnr.hasNextLine()){
            String docs = scnr.nextLine();
            foo.add(docs);
            }
        d.docList2.addAll(foo);  //second doclist to get word numbers
        //will be cleared once wordlist is complete
        
        int k = 0;
        while (k != foo.size()){
            scnr = new Scanner((String) foo.get(k));
            int i = 0;
            tempDoc = "";
            while (scnr.hasNextLine()){    
                String temp = scnr.next();
                foo2.add(i, temp);
                i++;
            }
        int j = 0;           
        for (j = 1; j < foo2.size(); j++){    
            int wordInt = Integer.parseInt((String)foo2.get(j));
            wordsTm.put((wordInt), wordList.get(wordInt));
                if (j != foo2.size()){
                    tempDoc = tempDoc.concat((String)wordList.get(wordInt)
                            + " "); 
                }
            }
            d.docList.add((k),tempDoc);
            foo2.clear();
            k++;
        }
        foo.clear();
    }
    
    /*  Similar to the Document, I made the wordList contain in each element 
    the word, and every document it exists in.  When you then pull the element 
    that contains the word it already has all of its documents attached.
    */
    
    public void createDoclist(){
        for (int docListCtr = 0; docListCtr < d.docList2.size(); docListCtr++){
            Scanner scnr = new Scanner((String) d.docList2.get(docListCtr));    
            int j = 0;
            while (scnr.hasNext()){
                String words = scnr.next();
                foo.add(j,words);
                j++;
                }
            int k = 1;
            while (k < foo.size()){
                Integer docInt = Integer.parseInt((String)foo.get(k));
                String tempWord = ((String)wordList.get(docInt));
                tempWord = tempWord.concat(" " + docListCtr);
                wordList.set(docInt, ((Word)tempWord));
                k++;
            }
            foo.clear();
        }
    }
    
    /*  The occursWith method leverages off the TreeMap with only existing 
    words, and the elements in the wordList.  The Word is checked to see if 
    it exists in the TreeMap.  The Word is parsed for each Document ID, then
    all words from each Document are added to a BST.  Finally all words that
    exist in all documents that the original word exists in are alphabetically 
    ordered in the BST.  Total number of words and the entire BST are printed.
    */
    public void occursWith(Word input){
        if (wordsTm.containsValue(input)){
            System.out.println("Word exists in Words used TreeMap");
            int q = (int) getKeyFromValue (wordsTm, input);
            Word wordTemp = wordList.get(q);
            Scanner scnr = new Scanner((String) wordTemp);
            int j = 0;
            while (scnr.hasNext()){
                String words = scnr.next();
                foo.add(j,words);
                j++;
                }
                    
            int k = 1;
            while (k < foo.size()){
                Integer docInt = Integer.parseInt((String)foo.get(k));
                String wordTemp2 = (String) d.docList.get(docInt);
                Scanner scnr2 = new Scanner((String) wordTemp2);
                int m = 0;
                while (scnr2.hasNext()){
                    String words2 = scnr2.next();
                    foo2.add(m,words2);
                    if (!occursTree.contains(foo2.get(m))){
                        occursTree.add(words2);
                    }
                    m++;
                }
                k++;
            }
            printOccursTree(input);
            System.out.println("Total number of all words that occur in all "
                    + "documents with " +input + ": " + getOccursTreeSize());
            foo.clear();
        }else{
            System.out.println("Word " + input + " is not used in any of the "
                    + "documents provided.");
        }
    }
    
    //Method to get the key location for a Word
    
    public static Object getKeyFromValue(TreeMap hm, Object value){
        for (Object o : hm.keySet()) {
        if (hm.get(o).equals(value)) {
            return o;
            }
        }
        return null;
    }
    
    //Method to use the getKeyFromValue and return the word in that location
    
    public int getWord(Word wordSelection){
        int wordId = (int) getKeyFromValue(wordsTm, wordSelection);
        return wordId;
    }
    
    //Method to see if a word is in the tree map
    
    public boolean wordExists(Word wordSelection){
        if(wordsTm.containsValue(wordSelection)){
            return true;  
        }else{
            return false;
        }
    }
    
    //Various helper methods used in builing and testing
    
    public String getDocList(int input){
        d.docList.get(input);
        return ((String)d.docList.get(input));
    }
    
    public void printTree(){
        System.out.println("Words treemap contents = " + wordsTm.values());
    }
    
    public void printOccursTree(Word input){
        System.out.println("The word " +input + " occurs with: " 
                + (occursTree));
    }
    
    public int getOccursTreeSize(){
        return occursTree.size();
    }
    
    public int getWordListSize(){
        return wordList.size();
    }
    
    public void wordListPrint(){
        for (int i = 1; i < wordList.size(); i++){
            System.out.println("WordList element " +(i) +": "
                    + wordList.get(i));
        }
    }
    
    public void docListPrint(){
        for (int i = 1; i < d.docList.size(); i++){
            System.out.println("DocList element " +(i) +": "
                    + d.docList.get(i));
        }
    }
    
    public void docList2Print(){
        for (int i = 1; i < d.docList2.size(); i++){
            System.out.println("DocList2 element " +(i) +": "
                    + d.docList2.get(i));
        }
    }
    
    public void fooPrint(){
        for (int i = 0; i < foo.size(); i++){
            System.out.println("foo element " +(i) +": "+ foo.get(i));
        }
    }
    
    public void foo2Print(){
        for (int i = 0; i < foo2.size(); i++){
            System.out.println("foo2 element " +(i) +": "+ foo2.get(i));
        }
    }    
 }
