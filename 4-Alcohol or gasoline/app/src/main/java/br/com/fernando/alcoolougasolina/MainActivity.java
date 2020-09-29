package br.com.fernando.alcoolougasolina;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnCalculate;
    TextView tvResponse;
    EditText etAlcohol, etGasoline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAlcohol = findViewById(R.id.etAlcohol);
        etGasoline = findViewById(R.id.etGasoline);
        tvResponse = findViewById(R.id.tvResult);
        btnCalculate = findViewById(R.id.btnCalculate);


        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateBestOption();
            }
        });


    }

    private void calculateBestOption() {
        double alcoholPrice = Double.parseDouble(etAlcohol.getText().toString().replace(",", "."));
        double gasolinePrice = Double.parseDouble(etGasoline.getText().toString().replace(",", "."));

        double result = alcoholPrice / gasolinePrice * 100;

        if (result > 70 || alcoholPrice > gasolinePrice) {
            tvResponse.setText("Melhor abastecer com Gasolina");
        } else {
            tvResponse.setText("Melhor abastecer com Álcool");
        }

        System.out.println(result);


    }
}