package floodit.s4923268.floodit_app;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    Game game = new Game(15,15,6);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_menu);

        /*
        Menu Buttons
         */
        Button btnStartGame = findViewById(R.id.button2);
        Button btnInstructions = findViewById(R.id.button);

        btnStartGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchGame();
            }
        });

        btnInstructions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchInstructions();
            }
        });

    }
    /*
    Launches the Game Difficulty Activity
     */
    private void launchGame() {
        Intent intent = new Intent(this, DifficultyActivity.class);
        ActivityOptions options = ActivityOptions.makeCustomAnimation(this,android.R.anim.fade_in, android.R.anim.fade_out);
        startActivity(intent, options.toBundle());
    }

    /*
    Launches the Instructions Activity
     */
    private void launchInstructions() {

        Intent intent = new Intent(this, InstructionsActivity.class);
        ActivityOptions options = ActivityOptions.makeCustomAnimation(this,android.R.anim.fade_in, android.R.anim.fade_out);
        startActivity(intent, options.toBundle());
    }



}
