package br.com.fernando.jokenpo;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    ImageView ivAppChoice, ivRock, ivPaper, ivScissor;
    TextView tvResult, tvUserScore, tvAppScore;
    int userScore, appScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivAppChoice = findViewById(R.id.ivAppChoice);
        ivRock = findViewById(R.id.ivRock);
        ivPaper = findViewById(R.id.ivPaper);
        ivScissor = findViewById(R.id.ivScissor);
        tvResult = findViewById(R.id.tvResult);
        tvUserScore = findViewById(R.id.tvUserScore);
        tvAppScore = findViewById(R.id.tvAppScore);

        userScore = 0;
        appScore = 0;


        ivRock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedRock();
            }
        });

        ivPaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedPaper();
            }
        });

        ivScissor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedScissor();
            }
        });
    }

    private void verifyResult(int userChoice) {
        int randomAppChoice = new Random().nextInt(3);

        switch (randomAppChoice) {
            case 0:
                ivAppChoice.setImageResource(R.drawable.pedra);
                break;
            case 1:
                ivAppChoice.setImageResource(R.drawable.papel);
                break;
            default:
                ivAppChoice.setImageResource(R.drawable.tesoura);
        }

        if (
                (randomAppChoice == 0 && userChoice == 1) ||
                        (randomAppChoice == 1 && userChoice == 2) ||
                        (randomAppChoice == 2 && userChoice == 0)

        ) {
            tvResult.setText("Você ganhou!");
            userScore = userScore + 1;
            tvUserScore.setText(String.valueOf(userScore));
        } else if (
                randomAppChoice == 0 && userChoice == 2 ||
                        randomAppChoice == 1 && userChoice == 0 ||
                        randomAppChoice == 2 && userChoice == 1

        ) {
            tvResult.setText("Você perdeu!");
            appScore = appScore + 1;
            tvAppScore.setText(String.valueOf(appScore));
        } else {
            tvResult.setText("Empate!");
        }


    }

    private void selectedRock() {
        verifyResult(0);
    }

    private void selectedPaper() {
        verifyResult(1);
    }

    private void selectedScissor() {
        verifyResult(2);
    }


}