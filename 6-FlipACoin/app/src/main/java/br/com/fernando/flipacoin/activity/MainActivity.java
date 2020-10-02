package br.com.fernando.flipacoin.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

import br.com.fernando.flipacoin.R;
import br.com.fernando.flipacoin.activity.ResultActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView ivPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ivPlay = findViewById(R.id.ivPlay);

        ivPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int randomValue = generateRandomValue();
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                intent.putExtra("randomValue", randomValue);
                startActivity(intent);
            }
        });
    }


    private int generateRandomValue() {
        int random = new Random().nextInt(2);
        return random;
    }
}