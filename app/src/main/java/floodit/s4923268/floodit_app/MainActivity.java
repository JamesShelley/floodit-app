package floodit.s4923268.floodit_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        /*
        Creates the gameview object, setting the gameview equal to the custom view.
         */
        GameView gView = new GameView(this);
        setContentView(gView);
    }

}
