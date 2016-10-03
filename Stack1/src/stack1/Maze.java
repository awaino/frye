package stack1;
import java.util.Random;
import java.util.ArrayList;

/**
 *
 * @author awain
 */
public class Maze {
    private MazeSquare[][] square;
    private Coordinate startPos;
    private Coordinate finishPos;
    private Coordinate lastPos;
    public Coordinate p ;
    private int numRows; 
    private int numCols; 
    GenericStack Stack = new GenericStack();
    
    public Maze(int numRows, int numCols) {
        this.numCols = numCols;
        this.numRows = numRows;
        
        this.square = new MazeSquare[numRows][numCols];
            for (int r = 0; r < numRows; r++){
                for (int c = 0; c < numCols; c++){
                    square[r][c] = new MazeSquare(new Coordinate(r, c));
                
                    square[r][c].setWall(Direction.SOUTH);
                    square[r][c].setWall(Direction.EAST);
                
                }   
                    if (numRows == 0){
                       square[0][numCols].toggleWall(Direction.WEST);
                    }
                    if (numCols == 0){
                      square[numRows][0].toggleWall(Direction.NORTH);
                    }
                }
        //this.clear();
        
        int a = randRow();
        int b = randRow();
        
        startPos = new Coordinate(a, 0);      
        square[a][0].toggleWall(Direction.WEST);
        finishPos = new Coordinate(b,numCols);
        square[b][numCols-1].toggleWall(Direction.EAST);
    }
    public int randRow(){
        int min = 0;
        int max = numRows;
        Random rand = new Random();
        int randomNum = rand.nextInt(max-min) + min;
        return randomNum;
    }
       
    public MazeSquare getSquareAt(Coordinate p){ 
    //Simple accessor method that returns the MazeSquare at the (r,c) position indicated by the provided Coordinate.
        return square[p.getRow()][p.getCol()];
    
    }
    public void visitSquare(Coordinate p){
    //.visit() the MazeSquare at the indicated Coordinate p.
        getSquareAt(p).visit();
    }    
    public void abandonSquare(Coordinate p){ 
    //.abandon() the MazeSquare at the indicated Coordinate p.
        getSquareAt(p).abandon();
    }
        
    public Coordinate northOf(Coordinate p) {
         return(new Coordinate(p.getRow() - 1, p.getCol()));
    }

    public Coordinate eastOf(Coordinate p) {
        return(new Coordinate(p.getRow(), p.getCol() + 1));
    }

    public Coordinate southOf(Coordinate p) {
        return(new Coordinate(p.getRow() + 1, p.getCol()));
    }

    public Coordinate westOf(Coordinate p) {
        return(new Coordinate(p.getRow(), p.getCol() - 1));
    }

    public boolean movePossible(Coordinate from, Coordinate to) { 
               
        int dist_col= to.getCol() - from.getCol();
        int dist_row= to.getRow() - from.getRow();
        
        if (Math.abs(dist_col) > 1)return false;
        if (Math.abs(dist_row) > 1)return false;
        
        if ((Math.abs(dist_col)==0)&&(Math.abs(dist_row)==0))return false;
        if ((Math.abs(dist_col)==1)&&(Math.abs(dist_row)==1))return false;
        
        //check if Coordinate to is abandoned
        //if ()
        
       /* if (dist_row == -1)
            return !(this.getSquareAt(from).getWall(Direction.SOUTH) || (this.getSquareAt(to).getWall(Direction.NORTH))); //south
        if (dist_row == 1)
            return !(this.getSquareAt(from).getWall(Direction.NORTH) || (this.getSquareAt(to).getWall(Direction.SOUTH))); //north
        if (dist_col == 1)
            return !(this.getSquareAt(from).getWall(Direction.WEST) || (this.getSquareAt(to).getWall(Direction.EAST))); //west
        if (dist_col == -1)
            return !(this.getSquareAt(from).getWall(Direction.EAST) || (this.getSquareAt(to).getWall(Direction.WEST))); //east
        */
        return true;  //check this later
    }
    public void genMaze(){
        Stack.push(startPos);
        Stack.peek();
        p = startPos;
        System.out.println("Step 3: \n" + startPos);
        System.out.println("Step 4: \n" + p);
        do
        
            moveP();
            
        while (p.getRow() != finishPos.getRow() && p.getCol() != finishPos.getCol());
        System.out.println("Step 8: Current position is: " + p);
        System.out.println("Step 9: Current finish position is: " + finishPos);
    }

    public void moveP(){        
        
        ArrayList<Coordinate> unlist;
        unlist = unvisitedNeighbors(p);
        System.out.println("Step 5: " + unlist.size() + " available move locations.");
        System.out.println("Step 6: " + unlist.get(0) + " is the first available location.");
        System.out.println("Step 6.5: " + p + " is the current location.");
        
        //random direction generator
        int min = 0;
        int max = unlist.size();
        Random rand = new Random();
        int randomNum = rand.nextInt(max-min +1) + min;
        
        //if under two moves available, no moves available
        //pop the last coordinate and go back one spot.
        if (unlist.size() < 1){
            
            Stack.pop();
            abandonSquare(p);
            p = lastPos;
        }

        //condition1 coordinates at the 4 corners.
        //only 2 moves possible list 0,1
        else if (unlist.size() == 2){
            //System.out.println(unlist.size());
            if (movePossible(p, (unlist.get(randomNum)))) {
                System.out.println("Step 6: " + unlist.get(randomNum) + " is the random location.");
                lastPos = p;
                p = (unlist.get(randomNum));
                System.out.println("Step 7: " +p);
                removeWalls(lastPos, p);
                Stack.push(p);
                Stack.peek();
                visitSquare(p);
            }
            
        }
        //condition2 coordinates on outside egde
        //3 moves possible list 0,1,2
        else if (unlist.size() == 3){
            //System.out.println(unlist.size());
            if (movePossible(p, (unlist.get(randomNum)))) {
            System.out.println("Step 6: " + unlist.get(randomNum) + " is the random location.");
            lastPos = p;
            p = (unlist.get(randomNum));
            System.out.println("Step 7: " +p);
            removeWalls(lastPos, p);
            Stack.push(p);
            Stack.peek();
            visitSquare(p);
            }
        }
        //condition3 inside coordinates
        //4 moves possible list 0,1,2,3
        else if(unlist.size() == 4){    
            //System.out.println(unlist.size());
            if (movePossible(p, (unlist.get(randomNum)))) {
            System.out.println("Step 6: " + unlist.get(randomNum) + " is the random location.");
            lastPos = p;
            p = (unlist.get(randomNum));
            System.out.println("Step 7: " +p);
            removeWalls(lastPos, p);
            Stack.push(p);
            Stack.peek();
            visitSquare(p);
            }
        }
    }
       
    private void removeWalls(Coordinate lastPos, Coordinate p){
        
        int dist_col= p.getCol() - lastPos.getCol();
        int dist_row= p.getRow() - lastPos.getRow();
        
        if (dist_row == -1){
            square[p.getCol()][p.getRow()].toggleWall(Direction.SOUTH);
        }
            
        if (dist_row == 1) {
            square[lastPos.getCol()][lastPos.getRow()].toggleWall(Direction.SOUTH);
        }
            
        if (dist_col == 1) {
            square[lastPos.getCol()][lastPos.getRow()].toggleWall(Direction.EAST);
        }
            
        if (dist_col == -1) {
            square[p.getCol()][p.getRow()].toggleWall(Direction.EAST);
        }
            
    }
    
    
    
    private void clear() {
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                square[i][j].clear();
            }
        }
    }
       
    // I'm going to leave this in here since we haven't
    // discussed the use of the ArrayList collection from the java library
    private ArrayList<Coordinate> unvisitedNeighbors(Coordinate p) {
        ArrayList<Coordinate> list = new ArrayList<Coordinate>();

        int r = p.getRow();
        int c = p.getCol();

        if (r > 0 && !square[r - 1][c].isVisited())
            list.add(new Coordinate(r - 1, c));
        if (r < numRows - 1 && !square[r + 1][c].isVisited())
            list.add(new Coordinate(r + 1, c));
        if (c > 0 && !square[r][c - 1].isVisited())
            list.add(new Coordinate(r, c - 1));
        if (c < numCols - 1 && !square[r][c + 1].isVisited())
            list.add(new Coordinate(r, c + 1));
        System.out.print("Step 4.5: " + list + "\n");
        return list;
    }

    // this will be made use of in the maze solver but is not useful here.
    // Just checks if p is within the bounds of the maze.
    private boolean validPos(Coordinate p) {
        return ((p.getRow() < numRows) && (p.getRow() >= 0) && (p.getCol() < numCols) && (p.getCol() >= 0));
    }

    @Override
    public String toString() {
        StringBuffer buf = new StringBuffer();
        // output the top
        for (int i = 0; i < numCols; i++)
            //System.out.println(i);
            buf.append("__");
        buf.append("_\n");
        
        // output the rows
        for (int i = 0; i < numRows; i++) {
            if (i != startPos.getRow()) {
                buf.append("|");
            } else {
                buf.append(" ");
            }
            
                for (int j = 0; j < numCols; j++) {
                if (square[i][j].getWall(Direction.SOUTH)) {
                    buf.append("_");
                } else {
                    buf.append(" ");
                }
               
                if (square[i][j].getWall(Direction.EAST)) {
                        buf.append("|");
                                        }
                else {
                    if (j + 1 < numCols) {
                        if (square[i][j + 1].getWall(Direction.SOUTH)) {
                            buf.append("_");
                        } else {
                            buf.append(".");
                        }
                    }
                }
            }
            buf.append("\n");
        }
        return buf.toString();
    }



}
