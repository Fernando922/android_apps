package br.com.fernando.frasesdodia;

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


    public void newPhrase(View view) {

        TextView txtPhrase = findViewById(R.id.txtPhrase);
        String[] phrases = {"Tubarão que dorme a onda leva!", "Pau que nasce torto nunca se indireita", "Urubu na guerra é frango", "Mas vale um pássaro na mão do que dois voando!"};


        int random = new Random().nextInt(4);
        txtPhrase.setText(phrases[random]);


    }
}