package br.com.fernando.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private TextView tvName;
    private Button btnSave;
    private EditText etName;
    private static final String PREFERENCE_FILE = "PREFERENCE_FILE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tvName = findViewById(R.id.tvName);
        btnSave = findViewById(R.id.btnSave);
        etName = findViewById(R.id.etName);


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateName();
            }
        });

        SharedPreferences preferences = getSharedPreferences(PREFERENCE_FILE, 0);

        if(preferences.contains("name")){
            tvName.setText("Olá " +preferences.getString("name", "undefined"));
        }
    }

    private void updateName(){
        SharedPreferences preferences = getSharedPreferences(PREFERENCE_FILE, 0);
        SharedPreferences.Editor editor = preferences.edit();

        if(etName.getText().toString().equals("")){
            Toast.makeText(this, "Digite o nome!", Toast.LENGTH_SHORT).show();
        }else{
            String name = etName.getText().toString();
            editor.putString("name", name);
            editor.commit();
            tvName.setText("Olá " + etName.getText().toString());
        }
    }


}