package br.com.fernando.learnenglish.Fragments;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import br.com.fernando.learnenglish.R;

public class NumbersFragment extends Fragment implements View.OnClickListener {

    private ImageView ivOne, ivTwo, ivThree, ivFour, ivFive, ivSix;
    private MediaPlayer mediaPlayer;


    public NumbersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_numbers, container, false);

        initializeComponents(view);
        addListenerToComponents();


        // Inflate the layout for this fragment
        return view;
    }

    private void initializeComponents(View view) {
        ivOne = view.findViewById(R.id.ivOne);
        ivTwo = view.findViewById(R.id.ivTwo);
        ivThree = view.findViewById(R.id.ivThree);
        ivFour = view.findViewById(R.id.ivFour);
        ivFive = view.findViewById(R.id.ivFive);
        ivSix = view.findViewById(R.id.ivSix);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ivOne:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.one);
                playAudio();
                break;
            case R.id.ivTwo:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.two);
                playAudio();
                break;
            case R.id.ivThree:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.three);
                playAudio();
                break;
            case R.id.ivFour:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.four);
                playAudio();
                break;
            case R.id.ivFive:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.five);
                playAudio();
                break;
            case R.id.ivSix:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.six);
                playAudio();
                break;
        }
    }

    private void addListenerToComponents() {
        ivOne.setOnClickListener(this);
        ivTwo.setOnClickListener(this);
        ivThree.setOnClickListener(this);
        ivFour.setOnClickListener(this);
        ivFive.setOnClickListener(this);
        ivSix.setOnClickListener(this);
    }

    private void playAudio() {
        mediaPlayer.start();
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mediaPlayer.release();
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