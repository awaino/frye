package stack1;
import java.util.Scanner;
/**
 *
 * @author awain
 */
public class Main{
   
   public String coords = "";
   GenericStack Stack = new GenericStack();
   
    public static void main(String[] args) {
               
        Scanner fromUser = new Scanner(System.in);
        System.out.print("How many rows for the maze? \n");
        int r = fromUser.nextInt();
        System.out.print("How many columns for the maze? \n");
        int c = fromUser.nextInt();

        Maze aMaze = new Maze(r, c);
        System.out.println(aMaze);
        aMaze.genMaze();
        
        
    }
}        
         
