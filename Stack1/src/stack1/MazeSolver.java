package stack1;
import java.util.Scanner;
/**
 *
 * @author awain
 */
public class MazeSolver {
   int x = 0;
   int y = 0;
   public String foo = "";
   int sizeT = 0;
    
   
   public static void main(String[] args) {
        MazeSolver maze = new MazeSolver();
        maze.menu();
        }
    
        public void menu(){
        //int Coordinates[][] = new int [10][10];
        GenericStack Stack = new GenericStack();
        int listChoice = 0;     
        do{
        System.out.println("Welcome to the Stack Tester.");
        System.out.println("Press 1 to enter coordinates. ");
        System.out.println("Press 2 to get the Stack count. ");
        System.out.println("Press 3 to show stack contents. ");
        System.out.println("Press 4 to remove the top stack item. ");
        System.out.print("Press 5 to Exit\nChoice? ");
        Scanner scanner = new Scanner(System.in);
        listChoice = scanner.nextInt();
                
            if (listChoice ==1){
                System.out.print("Enter coordinate X: ");
                scanner = new Scanner(System.in);
                x = scanner.nextInt();
                System.out.print("Enter coordinate Y: ");
                scanner = new Scanner(System.in);
                y = scanner.nextInt();
                
                System.out.println("Coordinates are " + x + ", " + y + "\n");
                
                fooGen();
                newPush();
                sizeT++;
                }
                else if (listChoice == 2 && sizeT ==0){
                    System.out.println("No records, try again\n");
                }    

                else if (listChoice ==2 && sizeT !=0) {
                    System.out.println("Current stack count is: " + sizeT + "\n");
                }
                
                else if (listChoice == 3 && sizeT ==0){
                    System.out.println("No records, try again\n");
                }    

                else if (listChoice ==3 && sizeT !=0) {
                    System.out.println(sizeT);
                    Stack.showAll();
                }
                
                else if (listChoice ==4 && sizeT == 0){
                    System.out.println("No records, try again\n");
                }
                else if (listChoice ==4 && sizeT != 0){
                    System.out.println("Popping Data (" + Stack.popData +")off the Stack.\n");
                    Stack.pop();
                    sizeT--;
                }
                else if (listChoice ==5){
                    System.out.println("Goodbye");
                    System.exit(0);
                }
            }while (listChoice !=5);
        }       
        public String fooGen(){
            foo = (x + ", " + y);
            return(foo);
    }

        public void newPush() {
        GenericStack Stack = new GenericStack();
        
        Stack.newFoo = foo;
        Stack.push(foo);
        }
        
}        
         
