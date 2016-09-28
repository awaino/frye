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
        Main maze = new Main();
        
        Scanner fromUser = new Scanner(System.in);
        System.out.print("rows? ");
        int r = fromUser.nextInt();
        System.out.print("cols? ");
        int c = fromUser.nextInt();

        Maze aMaze = new Maze(r, c);
        System.out.println(aMaze);
    }


   
    public String setCoordinates(int r, int c){
        coords = (r + "," + c);
        return(coords);
        }

    
        public void newPush() {
                
        Stack.sCoords = coords;
        Stack.push(coords);
        }
        
}        
         
