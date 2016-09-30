package stack1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author awain
 */
public class Coordinate {
    private int row;
    private int col;

    public Coordinate(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
  
    public boolean isEqual(Coordinate p){
        if(this.col == p.getCol() && this.row == p.getRow())
            return true;
        else
        return false;
    }
    public String toString(){
        return "Row: " + this.row + ", Column: "+ this.col;
    }

}
