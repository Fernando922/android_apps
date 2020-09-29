package br.com.fernando.alcoolougasolina;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private Button btnCalculate;
    private TextView tvResult;
    private TextInputEditText etAlcohol, etGasoline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAlcohol = findViewById(R.id.etAlcohol);
        etGasoline = findViewById(R.id.etGasoline);
        tvResult = findViewById(R.id.tvResult);
        btnCalculate = findViewById(R.id.btnCalculate);


        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateBestOption();
            }
        });


    }

    private Boolean validateFields(String alcoholPrice, String gasolinePrice) {
        if (alcoholPrice == null || alcoholPrice.equals("")) {
            return false;
        }
        return gasolinePrice != null && !gasolinePrice.equals("");
    }

    private void calculateBestOption() {

        String alcoholValue = etAlcohol.getText().toString();
        String gasolineValue = etGasoline.getText().toString();

        Boolean isFieldsFilled = validateFields(alcoholValue, gasolineValue);

        if (!isFieldsFilled) {
            Toast.makeText(this, "Preencha todos os Campos!", Toast.LENGTH_SHORT).show();
            return;
        }

        double alcoholPrice = Double.parseDouble(alcoholValue);
        double gasolinePrice = Double.parseDouble(gasolineValue);

        double result = alcoholPrice / gasolinePrice * 100;

        if (result > 70 || alcoholPrice > gasolinePrice) {
            tvResult.setText("Melhor abastecer com Gasolina");
        } else {
            tvResult.setText("Melhor abastecer com Álcool");
        }


    }
}