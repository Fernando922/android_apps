package br.com.fernando.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView lvLocals;
    private String[] items = {
            "Angra dos Reis",
            "Caldas Novas",
            "França",
            "Itália",
            "Nova Zelândia",
            "Budapeste",
            "Nova York",
            "Buenos Aires",
            "Orlando",
            "Japão",
            "Australia",
            "Marrocos",
            "Toronto",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvLocals = findViewById(R.id.lvLocals);


        //cria um adaptador, que é reponsável por manipular o array e colocar na lista
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1, //id do TextView no layout escolhido
                items //array a ser tratado
        );

        //Adiciona o adaptador na lista
        lvLocals.setAdapter(adapter);


        //Adicionar clique na lista
        lvLocals.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedValue = lvLocals.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, selectedValue, Toast.LENGTH_SHORT).show();
            }
        });

    }
}