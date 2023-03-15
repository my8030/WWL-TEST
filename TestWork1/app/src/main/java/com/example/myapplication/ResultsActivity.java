package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView resultLabelTextView;
    private TextView scoreTextView;
    private Button playAgainButton;

    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        resultLabelTextView = findViewById(R.id.result_label_text_view);
        scoreTextView = findViewById(R.id.score_text_view);
        playAgainButton = findViewById(R.id.play_again_button);

        score = getIntent().getIntExtra("score", 0);
        updateScoreText();

        playAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultActivity.this, GameActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void updateScoreText() {
        scoreTextView.setText(getString(R.string.scoreTextView, score));
    }
}
