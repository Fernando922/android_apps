package br.com.fernando.calculadoradegorjetas;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText etCheckValue, etTip, etTotal;
    private SeekBar sbPercentage;
    private TextView tvPercentageValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etCheckValue = findViewById(R.id.etCheckValue);
        etTip = findViewById(R.id.etTip);
        etTotal = findViewById(R.id.etTotal);
        sbPercentage = findViewById(R.id.sbPercent);
        tvPercentageValue = findViewById(R.id.tvPercentageValue);

        etCheckValue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                calculateValues();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        sbPercentage.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                calculateValues();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }

    private void calculateValues() {

        int percentage = sbPercentage.getProgress();
        tvPercentageValue.setText(percentage*10 + "%");

        String checkInput = etCheckValue.getText().toString();
        if(checkInput.equals("") || checkInput == null || percentage == 0){
            etTip.setText(getString(R.string.monetary_value, "0.0"));
            etTotal.setText(getString(R.string.monetary_value, "0.0"));
            Toast.makeText(this, "Digite um Valor primeiro!", Toast.LENGTH_SHORT).show();
            return;
        }

        double checkValue = Double.parseDouble(checkInput);


        DecimalFormat decimalFormat = new DecimalFormat("#0.00");

        double tip = (percentage/10.0 * checkValue);
        etTip.setText(getString(R.string.monetary_value, (decimalFormat.format(tip))));
        etTotal.setText(getString(R.string.monetary_value, (decimalFormat.format(checkValue+tip))));




    }
}