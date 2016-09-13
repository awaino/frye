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
    
    DataStructure2 struct = new DataStructure2();
            
    public void input() {
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
                addPerson();
            }
        
            else if (listChoice == 2 && getAge ==0){
                System.out.println("No records, try again");
            }    
        
            else if (listChoice ==2 && getAge !=0) {
                struct.showAllListings();
            }
            
          /*  else if (listChoice == 3 && getAge ==0){
                System.out.println("No records, try again");
            }    
        
            else if (listChoice ==3 && getAge !=0) {
                eraseRecords();
            }
            
            else if (listChoice ==4 && getAge ==0) {
                System.out.println("No records, try again");
            }
            
            else if (listChoice ==4 && getAge != 0) {
                modifyRecords();
            }*/
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
    /*   
    public void eraseRecords(){
        System.out.print("Erasing record\n");   
        getAge = 0;
        getName = " ";
   
    }
    public void modifyRecords(){
        int listChoice2 = 0;
            
            System.out.print("Please select (1)Name or (2)Age to modify: ");
            
            Scanner in = new Scanner(System.in);
            listChoice2 = in.nextInt();
            System.out.println("You entered : "+ listChoice2);
                if (listChoice2 == 1){
                    setName(); 
                }
                else if (listChoice2 ==2){
                    setAge();
                } 
                else if (listChoice2 != 1 || listChoice2 != 2){
                    System.out.print("Invalid selection, returning to Main menu.\n\n");
                    return;    
            }
    }
    */
    
    public void addPerson(){
        struct.newNameAge = nameAge;
        struct.addListing();
    }
    
    public void main(String[] args){
        
        input();
    }

}




        
        
        
    
    