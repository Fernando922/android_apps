package br.com.fernando.a9_annotationsapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {


    private FloatingActionButton fabSave;
    private EditText etAnnotation;
    private Annotation annotation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fabSave = findViewById(R.id.fabSave);
        etAnnotation = findViewById(R.id.etAnnotation);

        annotation = new Annotation(getApplicationContext());

        etAnnotation.setText(annotation.recoverAnnotation());


        fabSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNotes(v);
            }
        });
    }


    private void saveNotes(View v) {

        if (etAnnotation.getText().toString().equals("")) {
            Snackbar.make(v, "Digite uma nota!", BaseTransientBottomBar.LENGTH_LONG).show();
        } else {
            String notes = etAnnotation.getText().toString();
            annotation.save(notes);
        }


    }
}