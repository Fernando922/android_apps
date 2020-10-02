package br.com.fernando.passandodadosentreactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSend = findViewById(R.id.btnSend);


        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);


                //Instanciar Objeto
                User user = new User("Fernando", "dipaula018@gmail.com");


                //Passar dados
                intent.putExtra("name", "Fernando");
                intent.putExtra("age", 28);
                intent.putExtra("object", user);
                startActivity(intent);
            }
        });
    }
}