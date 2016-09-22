package stack1;

/*package stack1;

/**
 *
 * @author awain
 */
public class MazeSquare {

    MazeSolver maze = new MazeSolver();
    
    // set the default wall state to no walls.
    private boolean[] wall = {false, false, false, false};
    private boolean visited;
    private boolean abandoned;
    private Coordinate myPosition;

    // new squares are built without walls
    public MazeSquare(Coordinate p) {
        myPosition = p;
        this.clear();
    }

    // this might be nice to have....
    public MazeSquare(Coordinate p, boolean[] wallSet) {
        this(p);
        for (int i = 0; i < wallSet.length && i < wall.length; i++) {
            wall[i] = wallSet[i];
        }
    }

    public void toggleWall(Direction dir) {
        wall[dir.value()] = !wall[dir.value()];
       }

    public enum Direction {
    NORTH(0),
    SOUTH(1),
    EAST(2),
    WEST(3);

    private final int value;

    Direction(int value) {
        this.value = value;
    }
    
    int value() {
        return this.value;
        
        }
    }
    public boolean getWall (Direction dir){ 
    
    }

    
    public boolean isVisited(){ throw new RuntimeException("Unimplmemented."); }

    
    public void visit(){ throw new RuntimeException("Unimplmemented."); }


    public boolean isAbandoned(){ throw new RuntimeException("Unimplmemented."); }


    public void abandon(){ throw new RuntimeException("Unimplmemented."); }

    public void clear(){ throw new RuntimeException("Unimplmemented."); }
    
    public Coordinate getPosition() { throw new RuntimeException("Unimplmemented."); }
    
    public boolean Equals(MazeSquare other) { throw new RuntimeException("Unimplmemented."); }



/*The methods include a pair of constructors. If the one argument constructor 
is called, the square should be created with all four walls being "false." The 
toggleWall method inverts the state of the wall. Because we are using boolean 
variables to keep track of walls we can do something as simple as 
wall[dir] = !wall[[dir] to accomplish this. Finally we have a few 
accessor / mutator methods (isVisited, visit, etc) and a pair of utility 
methods. The first utility method is clear() which sets abandoned and visited 
to false. This is necessary to reset the maze once we've constructed it. The 
second is an Equals method. Two MazeSquare objects are equal if their positions
are equal (regardless of walls, etc.)
*/
}
