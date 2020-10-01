package br.com.fernando.reciclerview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.fernando.reciclerview.R;
import br.com.fernando.reciclerview.model.Post;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.MyViewHolder> {

    private List<Post> postsList;

    public PostAdapter(List<Post> list) {
        this.postsList = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View listItem = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post, parent, false);
        return new MyViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //exibição dos items
        Post post = postsList.get(position);

        holder.name.setText(post.getName());
        holder.post.setText(post.getPost());
        holder.image.setImageResource(post.getImage());


    }

    @Override
    public int getItemCount() {
        return postsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView name, post;
        private ImageView image;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tvName);
            post = itemView.findViewById(R.id.tvPost);
            image = itemView.findViewById(R.id.ivImage);
        }
    }
}
