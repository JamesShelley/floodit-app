package floodit.s4923268.floodit_app;

import java.util.Arrays;
import java.util.Random;

/*
 * Base class for the Flood It game. You can either extend this class (and keep everything clean) or
 * adapt it to no longer be abstract. It provides a framework for your implementation of the
 * assignment. You are able to change this class as you see fit, but remember that it is intended to
 * just contain game logic, not any Android related code.
 */

public abstract class AbstractGame {

    /**
     * The actual amount of columns in the game. This means there are mColumns*mRows cells.
     */
    private  int mColumns;
    /**
     * The actual amount of rows in the game. This means there are mColumns*mRows cells.
     */
    private  int mRows;
    /*
     * The actual amount of colours in a specific game.
     */
    private final int mColourCount;
    /*
        The 2d array that holds the colour information of each individual square.
     */
    protected final int[][] mData;


    /**
     * Constructor for a new game. Note that this does not actually initialize any cells. You will
     * have to write your own cell state logic. There are some abstract functions you should implement
     * using that data.
     *
     * The subclass should implement an algorithm to actually generate a maze and do this in the
     * subclass constructor.
     *
     *  // @param width The horizontal size of the game.
     *  // @param height The vertical size of the game.
     * // @param colourCount The amount of colours in the game.
     *
     */

    /*
    Returns the possible colours (code 1,2,3,4,5,6) in the possibleColours[] array.
     */
    public int[] getPossibleColours() {
        return possibleColours;
    }

    //Creates a random object
    Random rand = new Random();
    public int[] possibleColours = {1,2,3,4,5,6,7};

    /**
     * Abstract Game Constructor
     * @param width the width of the grid
     * @param height the height of the grid
     * @param colourCount the amount of colours
     */
    public AbstractGame(final int width, final int height, final int colourCount) {
        mColumns = width;
        mRows = height;
        mColourCount = colourCount;
        mData = new int[width][height];
    }
    // Returns the length of the array
    public int[] getArray() {
        return Arrays.copyOf(possibleColours, possibleColours.length);
    }

    // gets the colour at a specefic coordinate in the 2d array.
    public int getColourPosition(int column, int row) {
        return mData[column][row];
    }

    /*
     * The amount of columns in the game.
     * @return the column count.
     */
    public int getWidth() {
        return mColumns;
    }

    /*
     * The amount of rows in the game.
     * @return The row count.
     */
    public int getHeight() {
        return mRows;
    }


    /*
     * Implement this function to return the current game round (starting with 1, every flood
     * operation updates the round.
     * @return The current round
     */
    public abstract int getRound();

    /*
     * Set the colour at position (x,y) to the colour identified by the colour parameter
     * @param x The column to change
     * @param y The row to change
     * @param colour The new colour.
     */
    protected abstract void setColor(int x, int y, int colour);



}