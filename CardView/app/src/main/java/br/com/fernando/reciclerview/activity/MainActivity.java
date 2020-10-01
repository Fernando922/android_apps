package br.com.fernando.reciclerview.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.fernando.reciclerview.R;
import br.com.fernando.reciclerview.adapter.PostAdapter;
import br.com.fernando.reciclerview.model.Post;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvPosts;
    private List<Post> posts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvPosts = findViewById(R.id.rvPosts);

        //cria posts
        createPosts();

        //define adapter
        PostAdapter adapter = new PostAdapter(posts);

        //Define layout
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        // LinearLayoutManager layoutManager = new GridLayoutManager(this, 2);  GRID LAYOUT

        rvPosts.setLayoutManager(layoutManager);
        rvPosts.setHasFixedSize(true);
        rvPosts.setAdapter(adapter);


    }

    private void createPosts() {
        Post post = new Post("Fernando", "Uma viagem Top", R.drawable.imagem1);
        posts.add(post);

        post = new Post("Marcos", "Neblina!!", R.drawable.imagem2);
        posts.add(post);

        post = new Post("Thiago", "Saudades do de paris, e dos ratos", R.drawable.imagem3);
        posts.add(post);

        post = new Post("Josiel", "Por do sol", R.drawable.imagem4);
        posts.add(post);
    }
}