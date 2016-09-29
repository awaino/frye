package stack1;

/*package stack1;

/**
 *
 * @author awain
 */
public class MazeSquare {

    Main maze = new Main();
     
    
    // set the default wall state to no walls.
    private boolean[] wall = {false, false, false, false};
    private boolean visited; //and !visited
    private boolean abandoned; //and !abandoned
    private Coordinate myPosition; //(Row x, and Column y)
    boolean[] defaultWallSet = {false, true, true, false}; // S, E walls up
    
    // new squares are built without walls
    public MazeSquare(Coordinate p) {
        myPosition = p;
        this.clear();
    }

    // this might be nice to have....
    public MazeSquare(Coordinate p, boolean[] wallSet) {
        this(p);
        wall = wallSet.clone();
    }

    public void toggleWall(Direction dir) {
        wall[dir.value()] = !wall[dir.value()];
    }
           
    public boolean getWall (Direction dir){ 
        return wall[dir.value()];
    }
    
    public void setWall(Direction dir){
      wall[dir.value()] = defaultWallSet[dir.value()];
    }
    
    public boolean isVisited(){
    //check for not abandoned = true then mark isVisited(x,y) once Visited = true 
        return this.visited ;
    }
    
    public void visit(){
        this.visited = true;
    }

    public boolean isAbandoned(){
        return this.abandoned;
    }
    public void abandon(){
        this.abandoned = true;
    }
    public void clear(){
        visited = false;
        abandoned = false;
    }
    public Coordinate getPosition() {
        return this.myPosition;
    }
    
    public boolean Equals(MazeSquare other) {
        Coordinate tempCoordinate = other.myPosition;

        if(this.myPosition.isEqual(tempCoordinate))
            return true;

        return false;
    }
}
