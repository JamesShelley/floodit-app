package floodit.s4923268.floodit_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InstructionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_instructions);
        Button btnStartGame = findViewById(R.id.button4);

        btnStartGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchGame();
            }
        });

    }
    //launches the difficulty activity when the play button is clicked.
    private void launchGame() {
        Intent intent = new Intent(this, DifficultyActivity.class);
        startActivity(intent);
    }
}
