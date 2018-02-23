package floodit.s4923268.floodit_app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;


public class GameView extends View {

    int GRID_SIZE = 72;
    private GestureDetector mGestureDetector;
    private Game game = new Game(15, 15, 6);

    /**
     * Declares paint variables
     */
    Paint mGridPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint colorOne = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint colorTwo = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint colorThree = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint colorFour = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint colorFive = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint colorSix = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint white = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint mBGPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint scoreColour = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint loseColour = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint winColour = new Paint(Paint.ANTI_ALIAS_FLAG);

    public GameView(Context context) {
        super(context);
        System.out.println("max at gameview constructor:" + game.getMaxCount());
        init();
        mGestureDetector = new GestureDetector(context, new MyGestureListener());
    }

    private void init() {
        /*
         * Sets the colours of the colour variables.
         */
        mGridPaint.setStyle(Paint.Style.FILL);
        mGridPaint.setColor(0xff0000ff);

        colorOne.setStyle(Paint.Style.FILL);
        colorOne.setColor(Color.parseColor("#9c00c5"));

        colorTwo.setStyle(Paint.Style.FILL);
        colorTwo.setColor(Color.parseColor("#e0bbe0"));

        colorThree.setStyle(Paint.Style.FILL);
        colorThree.setColor(Color.parseColor("#5ed1fd"));

        colorFour.setStyle(Paint.Style.FILL);
        colorFour.setColor(Color.parseColor("#00d900"));

        colorFive.setStyle(Paint.Style.FILL);
        colorFive.setColor(Color.parseColor("#496741"));

        colorSix.setStyle(Paint.Style.FILL);
        colorSix.setColor(Color.parseColor("#3749e5"));

        scoreColour.setColor(Color.parseColor("#3749e5"));
        loseColour.setColor(Color.parseColor("#FF0000"));
        winColour.setColor(Color.parseColor("#00FF00"));

        white.setStyle(Paint.Style.FILL);
        white.setColor(Color.parseColor("#e812e8"));

    }

    /**
     * Draws a grid, the grid is coloured by AbstractGame
     *
     * @param canvas - draw to canvas
     */

    protected void onDraw(Canvas canvas) {
        int colourCode;

        for (int col = 0; col < game.getWidth(); col++) {
            for (int row = 0; row < game.getHeight(); row++) {
                Paint paint;
                colourCode = game.getColourPosition(col, row);

                if (colourCode == 0) {
                    paint = colorOne;
                } else if (colourCode == 1) {
                    paint = colorTwo;
                } else if (colourCode == 2) {
                    paint = colorThree;
                } else if (colourCode == 3) {
                    paint = colorFour;
                } else if (colourCode == 4) {
                    paint = colorFive;
                } else if (colourCode == 5) {
                    paint = colorSix;
                } else if (colourCode == 6) {
                    paint = white;
                } else {
                    paint = mBGPaint;
                }
                int left = col * (GRID_SIZE);
                int top = row * (GRID_SIZE);
                int right = left + GRID_SIZE;
                int bottom = top + GRID_SIZE;
                paint.setTextSize(50);
                scoreColour.setTextSize(70);
                loseColour.setTextSize(70);
                winColour.setTextSize(70);
                canvas.drawRect(left, top, right, bottom, paint);
            }
        }
            // Draws the current count to the screen
            canvas.drawText("Round: " + Integer.toString(game.getRound()), 325, 1200, scoreColour);
            // Draws the max count to the screen
            canvas.drawText("Max Round: " + Integer.toString(game.getMaxCount()), 325, 1300, scoreColour);

            //Displays game result - win or loss.
            if (game.getRoundTest() > game.getMaxCount() || game.getRoundTest() == game.getMaxCount()) {
                canvas.drawText("You LOST ", 325, 1400, loseColour);
                canvas.drawText("Final Score: ("+Integer.toString(game.overallCounter() + game.getRoundTest())+")", 325, 1500, loseColour);
            } else if (game.checkWin()) {
                canvas.drawText("WIN: ROUND " + Integer.toString(game.getRoundTest()), 325, 1400, winColour);
            }
    }
    @SuppressLint("ClickableViewAccessibility")
    public boolean onTouchEvent(MotionEvent ev) {
        // Tshe line below passes the event to the onTouchEvent method of the GestureDetector class.
        // This analyzes the event and if applicable triggers the appropriate callbacks in the
        // GestureDetector.OnSimpleGestureListener class.
        boolean r = this.mGestureDetector.onTouchEvent(ev);
        return super.onTouchEvent(ev) || r;
    }

    // This GestureListener class is enclosed within the GameView class
    class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
        // You shou ld always include onDown() and it should always return true.
        // Otherwise the GestureListener may ignore other events.
        public boolean onDown(MotionEvent ev) {
            return true;
        }

        public boolean onSingleTapUp(MotionEvent ev) {
            int x, y, row, column;

            x = (int) ev.getX();
            y = (int) ev.getY();
            row = y / GRID_SIZE;
            column = x / GRID_SIZE;

            if (row > 14 || column > 14) {
                // Creates a popup showing to the user to click in the grid.
                Toast.makeText(getContext(), "Please click in the 15 x 15 coloured grid.", Toast.LENGTH_SHORT).show();
            }
            else {
                // starts the flood algorithm.
                System.out.println("X: " + column + " , Y: " + row);
                game.touchColour(game.getColourPosition(column,row));
                invalidate();
            }
            return true;
        }


    }
    // end of GestureListener Class.
}

