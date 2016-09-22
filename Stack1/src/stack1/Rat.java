/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack1;

/**
 *
 * @author awain
 */
public class Rat {
    MazeSolver Maze = new MazeSolver();   
    private MazeSquare [][] square;
    private Coordinate startPosition;
    private Coordinate finishPosition;
    private int rows;
    private int cols;
    
    public Maze(int rows, int cols){ throw new RuntimeException("Unimplmemented."); }


    public MazeSquare getSquareAt(Coordinate p){ throw new RuntimeException("Unimplmemented."); }


    public void visit (Coordinate p){ throw new RuntimeException("Unimplmemented."); }


    public void abandon (Coordinate p){ throw new RuntimeException("Unimplmemented."); }


    public Coordinate getStart(){ throw new RuntimeException("Unimplmemented."); }


    public Coordinate getFinish(){ throw new RuntimeException("Unimplmemented."); }


    public Coordinate northOf(Coordinate p){ throw new RuntimeException("Unimplmemented."); }


    public Coordinate southOf (Coordinate p){ throw new RuntimeException("Unimplmemented."); }

    
    public Coordinate eastOf(Coordinate p){ throw new RuntimeException("Unimplmemented."); }


    public Coordinate westOf(Coordinate p){ throw new RuntimeException("Unimplmemented."); }


    public boolean movePossible(Coordinate from, Coordinate to){ throw new RuntimeException("Unimplmemented."); }


    public void clear(){ throw new RuntimeException("Unimplmemented."); }


    public boolean validPosition(Coordinate p){ throw new RuntimeException("Unimplmemented."); }


    private ArrayList<Coordinate> invisitedNeighbors(Coordinate p){ throw new RuntimeException("Unimplmemented."); }


    private void generateMaze(){ throw new RuntimeException("Unimplmemented."); }



}

