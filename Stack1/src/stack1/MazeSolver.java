package stack1;
import java.util.Scanner;
/**
 *
 * @author awain
 */
public class MazeSolver{
   int x = 0;
   int y = 0;
   public String coords = "";
   GenericStack Stack = new GenericStack();
   
   public static void main(String[] args) {
        MazeSolver maze = new MazeSolver();
        maze.menu();
        }
    
        /*public void menu(){
        //int Coordinates[][] = new int [10][10];
        
        int listChoice = 0;     
        do{
        System.out.println("Welcome to the Stack Tester.");
        System.out.println("Press 1 to enter coordinates. ");
        System.out.println("Press 2 to get the Stack count. ");
        System.out.println("Press 3 to show stack top item. ");
        System.out.println("Press 4 to show all stack items. ");
        System.out.println("Press 5 to remove the top stack item. ");
        System.out.print("Press 6 to Exit\nChoice? ");
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
                
                setCoordinates();
                newPush();
                }
                else if (listChoice == 2 && Stack.top2 == -1){
                    System.out.println("No records, try again\n");
                }    

                else if (listChoice ==2 && Stack.top2 !=-1) {
                    Stack.sizeT();
                }
                
                else if (listChoice == 3 && Stack.top2 == -1){
                    System.out.println("No records, try again\n");
                }    

                else if (listChoice ==3 && Stack.top2 !=-1) {
                Stack.peek();
                
                }
                else if (listChoice == 4 && Stack.top2 == -1){
                    System.out.println("No records, try again\n");
                }    

                else if (listChoice ==4 && Stack.top2 !=-1) {
                Stack.showAll();
                
                }
                else if (listChoice ==5 && Stack.top2 == -1){
                    System.out.println("No records, try again\n");
                }
                else if (listChoice ==5 && Stack.top2 != -1){
                    Stack.pop();
                    System.out.println("\n");
                }
                else if (listChoice ==6){
                    System.out.println("Goodbye");
                    System.exit(0);
                }
            }while (listChoice !=6);
        } */      
   
        public String setCoordinates(){
            coords = (x + "," + y);
            return(coords);
            }

    
        public void newPush() {
                
        Stack.sCoords = coords;
        Stack.push(coords);
        }
        
}        
         
