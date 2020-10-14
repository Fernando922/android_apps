package br.com.fernando.a9_annotationsapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

public class Annotation {

    private Context context;
    private SharedPreferences preferences;
    private final String FILE_NAME = "annotation.preferences";
    private final String KEY_NAME = "key_name";
    private SharedPreferences.Editor editor;

    public Annotation(Context c) {
        this.context = c;
        preferences = context.getSharedPreferences(FILE_NAME, 0);
        editor = preferences.edit();
    }

    public void save(String text) {
        editor.putString(KEY_NAME, text);
        editor.commit();
        Toast.makeText(context, "Anotações salvas com sucesso!", Toast.LENGTH_SHORT).show();
    }


    public String recoverAnnotation() {
        if(preferences.contains(KEY_NAME)){
            return preferences.getString(KEY_NAME, "ERROR!");
        }
        return null;
    }
}
