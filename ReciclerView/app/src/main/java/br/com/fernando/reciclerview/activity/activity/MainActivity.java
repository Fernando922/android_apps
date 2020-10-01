package br.com.fernando.reciclerview.activity.activity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.fernando.reciclerview.R;
import br.com.fernando.reciclerview.activity.RecyclerItemClickListener;
import br.com.fernando.reciclerview.activity.adapter.MovieAdapter;
import br.com.fernando.reciclerview.activity.model.Movie;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Movie> movies = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rvMovies);

        //criar filmes
        createMovies();


        //Configurar adapter (serve para converter o array para itens da lista)
        MovieAdapter adapter = new MovieAdapter(movies);


        //Configurar Recyclerview
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true); //Recomendação android para otimizar a lista
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);

        //evento de click
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener
                (getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Toast.makeText(MainActivity.this, movies.get(position).getTitle(), Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Toast.makeText(MainActivity.this, "Clique Longo", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }));

    }

    public void createMovies() {
        Movie movie = new Movie("Homem Aranha - De Volta ao lar", "genero", "2017");
        movies.add(movie);

        movie = new Movie("Mulher Maravilha", "Fantasia", "2017");
        movies.add(movie);

        movie = new Movie("Liga da Justiça", "Ficção", "2017");
        movies.add(movie);

        movie = new Movie("Capitão América - Guerra Civíl", "Aventura/Ficção", "2016");
        movies.add(movie);

        movie = new Movie("It: A Coisa", "Drama/Terror", "2017");
        movies.add(movie);


    }
}