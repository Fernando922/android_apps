package br.com.fernando.sorteio;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void randomNumber(View view){
        TextView txtResult = findViewById(R.id.txtResult);

        int randomNumber = new Random().nextInt(11);  // 0 a 10

        txtResult.setText("Número: " + randomNumber);
    }



}