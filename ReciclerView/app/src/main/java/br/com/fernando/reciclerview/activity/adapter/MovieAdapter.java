package br.com.fernando.reciclerview.activity.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.fernando.reciclerview.R;
import br.com.fernando.reciclerview.activity.model.Movie;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    private List<Movie> moviesList;

    public MovieAdapter(List<Movie> list) {
           this.moviesList = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { //cria as visualizações

        View listItem = LayoutInflater.from(parent.getContext()) //converte xml em visualização
                .inflate(R.layout.adapter_lista, parent, false);


        return new MyViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //monta a exibição dos items


        Movie movie = moviesList.get(position);


        holder.title.setText(movie.getTitle());
        holder.gender.setText(movie.getGender());
        holder.year.setText(movie.getYear());
    }

    @Override
    public int getItemCount() {  //define a quantidade de itens na lista
        return moviesList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{  //guardar os dados antes de serem exibidos na lista

        TextView title, year, gender;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.tvTitle);
            year = itemView.findViewById(R.id.tvYear);
            gender = itemView.findViewById(R.id.tvGender);

        }
    }

}









//View Holder é a representação de cada item na lista que é reaproveitado por questao de performance (reciclagem) exibe só o necessário
