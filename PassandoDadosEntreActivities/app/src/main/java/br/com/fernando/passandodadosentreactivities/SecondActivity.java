package br.com.fernando.passandodadosentreactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView tvName, tvAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        tvName = findViewById(R.id.tvName);
        tvAge = findViewById(R.id.tvAge);


        //Recuperar os dados enviados
        Bundle data = getIntent().getExtras();
        String name = data.getString("name");
        int age = data.getInt("age");
        User user = (User) data.getSerializable("object");

        tvName.setText(user.getName());
        tvAge.setText(user.getEmail());

    }


}