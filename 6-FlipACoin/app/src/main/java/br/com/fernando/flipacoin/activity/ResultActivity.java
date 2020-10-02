package br.com.fernando.flipacoin.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import br.com.fernando.flipacoin.R;

public class ResultActivity extends AppCompatActivity {

    private ImageView ivBack, ivCoin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        ivBack = findViewById(R.id.ivBack);
        ivCoin = findViewById(R.id.ivCoin);

        Bundle data = getIntent().getExtras();
        int randomValue = data.getInt("randomValue");

        if(randomValue == 1){
            ivCoin.setImageResource(R.drawable.moeda_cara);
        }else{
            ivCoin.setImageResource(R.drawable.moeda_coroa);
        }

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}