package floodit.s4923268.floodit_app;

public class Game extends AbstractGame {

    // Counter variables to be used in win/loss.
    private int counter = 0;
    private static int maxCount = 40;

    /*
    Game constructor, takes a parameter of the width, height and colourCount.
     */
    public Game(int width, int height, int colourCount) {
        super(width, height, colourCount);
        /*
         *Loops through the mData 2d array and assigns each value a randomly assigned colour.
         */
        for (int i = 0; i < mData.length; i++) {
            for (int j = 0; j < mData[i].length; j++) {
                if (i < 15 || j < 15) {
                    mData[i][j] = rand.nextInt(getPossibleColours().length);
                }

            }
        }
    }
    public int getColourPosition(int column, int row) {
        return mData[column][row];
    }


    /*
    Access the private maxCount variable and assign it to the value of the parameter passed in.
     */
    public void setRound(int newMaxCount) {
        this.maxCount = newMaxCount;
    }


    public void touchColour(int colour) {
        int beforeColour = mData[0][0];
        floodGrid(0, 0, colour, beforeColour);
    }

    /*

     */
   private int nextColour;
   private int beforeColour;

    public void floodGrid(int x, int y, int nextColour, int beforeColour) {
        this.nextColour = nextColour;
        this.beforeColour = beforeColour;

        if (nextColour == beforeColour) return;
        if (x >= mData.length) return;
        if (y >= mData[x].length) return;
        int colour = mData[x][y];
        if (colour != beforeColour) return;
        setColor(x, y, nextColour);
        floodGrid(x + 1, y, nextColour, beforeColour);
        floodGrid(x, y + 1, nextColour, beforeColour);
        if (x > 0) {
            floodGrid(x - 1, y, nextColour, beforeColour);
        }
        if (y > 0) {
            floodGrid(x, y - 1, nextColour, beforeColour);
        }
    }

    public boolean checkWin() {
        for (int i = 0; i < mData.length; i++) {
            for (int j = 1; j < mData[i].length; j++) {
                if (nextColour != mData[i][j]) {
                    return false;
                }
            }
        }
        return counter <= maxCount;
    }


    public int getMaxCount() {
        return maxCount;
    }


    public int getRound() {
        if ((nextColour != beforeColour) && (counter < maxCount)) {
            checkWin();
            counter++;
            System.out.println("Move: " + counter + " / " + maxCount);
        }
        return counter;
    }

    int alwaysCount = 0;
    public int overallCounter() {
        if(nextColour != beforeColour) {
            alwaysCount++;
        }
        return alwaysCount;
    }

    public int getRoundTest() {
        return counter;
    }

    @Override
    protected void setColor(int x, int y, int colour) {
        mData[x][y] = colour;
    }

}
