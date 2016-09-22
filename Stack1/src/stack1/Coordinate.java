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

    public boolean equals(Coordinate rhs) {
        return (row == rhs.getRow() && col == rhs.getCol());
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
