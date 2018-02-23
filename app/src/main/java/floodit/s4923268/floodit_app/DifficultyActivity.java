package floodit.s4923268.floodit_app;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DifficultyActivity extends AppCompatActivity {

    /*
    Creates a game object to allow access setRound() when clicking a button.
     */

    Game game = new Game(15,15,6);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_difficulty);

        /*
        Initiliazing button objects to their IDS.
         */

        Button btnEasy = findViewById(R.id.button11);
        Button btnMedium = findViewById(R.id.button9);
        Button btnHard = findViewById(R.id.button14);
        Button btnVHard = findViewById(R.id.button13);

        /*
         * When you click the easy button, the max count is set to 50.
         */
        btnEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDifficulity();
                game.setRound(50);

            }
        });

        /*
         * When you click the medium button, the max count is set to 45.
         */
        btnMedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDifficulity();
                game.setRound(45);

            }
        });

        /*
         * When you click the hard button, the max count is set to 40.
         */
        btnHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDifficulity();
                game.setRound(40);

            }
        });
        /*
         * When you click the very hard button, the max count is set to 35.
         */
        btnVHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDifficulity();
                game.setRound(35);

            }
        });
    }

    // After a button has been clicked, the main activity opens (the actual game).
    private void confirmDifficulity() {
        Intent intent = new Intent(this, MainActivity.class);
        /*
        Setting the animation of the change in activity.
         */
        ActivityOptions options = ActivityOptions.makeCustomAnimation(this,android.R.anim.fade_in, android.R.anim.fade_out);
        startActivity(intent,options.toBundle());
    }

}
