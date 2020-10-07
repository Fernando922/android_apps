package br.com.fernando.videoexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class PlayerActivity extends AppCompatActivity {


    private VideoView vvPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        vvPlay = findViewById(R.id.vvPlayer);

        //Esconde a status bar
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        //Esconder a ActionBar
        getSupportActionBar().hide();

        //Executar o vídeo
        vvPlay.setMediaController(new MediaController(this));  //adiciona os controladores
        vvPlay.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.video);
        vvPlay.start();
    }
}