package com.example.myapplication;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    private TextView instructionsTextView;
    private TextView scoreTextView;
    private Button clickMeButton;

    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        instructionsTextView = findViewById(R.id.instructions_text_view);
        scoreTextView = findViewById(R.id.score_text_view);
        clickMeButton = findViewById(R.id.click_me_button);

        score = 0;
        updateScoreText();

        clickMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementScore();
            }
        });
    }

    private void incrementScore() {
        score++;
        updateScoreText();
    }

    private void updateScoreText() {
        scoreTextView.setText(getString(R.string.score_text_view, score));
    }
}
