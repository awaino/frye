package hash2;

import java.util.*;

public class Hash {
    public HashMap<Character, Integer> hash2 = new HashMap<Character, Integer>();
    public String input;
    
    public void getInput(){
        //ask for input
        Scanner fromUser = new Scanner(System.in);
        System.out.print("Please input data for Hashing: \n");
        //send the test to the input string
        input = fromUser.nextLine();
        System.out.println("String entered is: \n" + input +"\n");
    }
    
    public void getChar(){
        //clear the contents
        hash2.clear();
        
        //cycle through the input string and get each character
        for (int index = 0; index < input.length();
        index++) {
        char tempChar = input.charAt(index);
        //System.out.println("aChar = " + aChar); //for testing correct parsing
        
        //if the character exists, increment the value count
            if(hash2.containsKey(tempChar)){
                hash2.put(tempChar, hash2.get(tempChar) + 1);
                }
        //if not, create the new key(character) with a count of one    
            else{ 
                hash2.put(tempChar, 1);
            }
        }
    }
    
    public void showHash(){
        // Get a set of the entries
      Set set = hash2.entrySet();
      
      // Get an iterator
      Iterator i = set.iterator();
      
      // Display elements
      while(i.hasNext()) {
         Map.Entry me = (Map.Entry)i.next();
         System.out.print(me.getKey() + ": ");
         System.out.println(me.getValue());
      }
      System.out.println();
    }


}