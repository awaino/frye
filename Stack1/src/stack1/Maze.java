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
    private int numRows; //set variable up later
    private int numCols; //set variable up later
      
    public Maze(int numRows, int numCols) {
        this.numCols = numCols;
        this.numRows = numRows;
        
        this.square = new MazeSquare[numRows][numCols];
            for (int r = 0; r < numRows; r++){
                for (int c = 0; c < numCols; c++){
                    square[r][c] = new MazeSquare(new Coordinate(r, c));
                    }
                }
        this.clear();
        
        int c = (int)(Math.random() * numCols);
        startPos = new Coordinate(0, c);
        
        int j = (int)(Math.random() * numCols);
        finishPos = new Coordinate(numRows - 1,j);
        
    }
    
    public Coordinate getStart(){
        return startPos;
    }
    
    public Coordinate getFinish(){
        return finishPos;
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
        
        if (dist_col == -1)
            return !(this.getSquareAt(from).getWall(Direction.SOUTH) || (this.getSquareAt(to).getWall(Direction.NORTH))); //south
        if (dist_col == 1)
            return !(this.getSquareAt(from).getWall(Direction.NORTH) || (this.getSquareAt(to).getWall(Direction.SOUTH))); //north
        if (dist_row == -1)
            return !(this.getSquareAt(from).getWall(Direction.WEST) || (this.getSquareAt(to).getWall(Direction.EAST))); //west
        if (dist_row == 1)
            return !(this.getSquareAt(from).getWall(Direction.EAST) || (this.getSquareAt(to).getWall(Direction.WEST))); //east
        
        return true;  //check this later
    }
    private void genMaze(){
        
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
                } else {
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
