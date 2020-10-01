package br.com.fernando.reciclerview.model;

public class Post {

    private String name;
    private String post;
    private int image;

    public Post(String name, String post, int image) {
        this.name = name;
        this.post = post;
        this.image = image;
    }

    public int getImage() {
        return image;
    }


    public String getName() {
        return name;
    }

    public String getPost() {
        return post;
    }


}
