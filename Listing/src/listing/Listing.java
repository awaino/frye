package listing;
import java.util.Scanner;
/**
 *
 * @author awain
 */
public class Listing {
    public int getAge = 0;
    public String getName = " ";
    public String nameAge =" ";
    
    DataStructure2 dStruct = new DataStructure2();
            
    public static void main(String[] args){
        
        Listing in = new Listing();
        in.dataInput();
    }
    
    
    public void dataInput() {
        int listChoice = 0;
               
        do{ 
        
            System.out.print("Make a selection:");
            System.out.print("\n1: Enter a record");
            System.out.print("\n2: List all records");
        //    System.out.print("\n3: Erase the records");
        //    System.out.print("\n4: Modify a record");
            System.out.print("\n3: Exit\nChoice? ");
            Scanner in = new Scanner(System.in);
            listChoice = in.nextInt();
            System.out.println("You entered : "+ listChoice);
        
            if (listChoice ==1){
                setName();
                setAge();
                nameAndAge();
                addPerson(nameAge);
            }
        
            else if (listChoice == 2 && getAge ==0){
                System.out.println("No records, try again");
            }    
        
            else if (listChoice ==2 && getAge !=0) {
                dStruct.showAllListings();
            }
            
            else if (listChoice ==3){
                System.out.println("Goodbye");
                System.exit(0);
            }
        }while (listChoice != 3);    
    } 
    public String setName(){
        System.out.print("Please input your name: ");
        Scanner scanInput = new Scanner(System.in);
        getName = scanInput.nextLine();
        System.out.println("You entered : " + getName);
       return (getName);
    }
    
    public int setAge(){
        System.out.print("Please input your age: ");
        Scanner in = new Scanner(System.in);
        getAge = in.nextInt();
        System.out.println("You entered : "+ getAge);
        return (getAge);  
    }
    public String nameAndAge(){
        nameAge = getName + ", " + getAge;
        return(nameAge);
    }
    
    public void addPerson(String nameAge){
        dStruct.newNameAge = nameAge;
        dStruct.addListing(nameAge);
    }
}
