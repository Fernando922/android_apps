package br.com.fernando.learnenglish.Fragments;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import br.com.fernando.learnenglish.R;

public class AnimalsFragment extends Fragment implements View.OnClickListener {

    private ImageView ivDog, ivCat, ivLion, ivMonkey, ivSheep, ivCow;
    private MediaPlayer mediaPlayer;


    public AnimalsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_animals, container, false);

        initializeComponents(view);
        addListenerToComponents();


        // Inflate the layout for this fragment
        return view;
    }

    private void initializeComponents(View view) {
        ivDog = view.findViewById(R.id.ivDog);
        ivCat = view.findViewById(R.id.ivCat);
        ivLion = view.findViewById(R.id.ivLion);
        ivMonkey = view.findViewById(R.id.ivMonkey);
        ivSheep = view.findViewById(R.id.ivSheep);
        ivCow = view.findViewById(R.id.ivCow);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ivDog:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.dog);
                playAudio();
                break;
            case R.id.ivCat:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.cat);
                playAudio();
                break;
            case R.id.ivLion:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.lion);
                playAudio();
                break;
            case R.id.ivMonkey:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.monkey);
                playAudio();
                break;
            case R.id.ivSheep:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.sheep);
                playAudio();
                break;
            case R.id.ivCow:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.cow);
                playAudio();
                break;
        }
    }

    private void addListenerToComponents() {
        ivDog.setOnClickListener(this);  //vai ser tratado dentro da propria classe que implementa onclick
        ivCat.setOnClickListener(this);
        ivLion.setOnClickListener(this);
        ivMonkey.setOnClickListener(this);
        ivSheep.setOnClickListener(this);
        ivCow.setOnClickListener(this);
    }

    private void playAudio() {
        mediaPlayer.start();

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.release();  //libera da memoria do aparelho os recursos utilizados
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }


}