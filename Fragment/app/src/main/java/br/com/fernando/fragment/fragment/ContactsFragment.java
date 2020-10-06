package br.com.fernando.fragment.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import br.com.fernando.fragment.R;


public class ContactsFragment extends Fragment {

    private Button btnShowSnack;


    public ContactsFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contacts, container, false);

        btnShowSnack = view.findViewById(R.id.btnShowSnack);


        btnShowSnack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar.make(view, "Nenhum contato foi encontrado!", BaseTransientBottomBar.LENGTH_INDEFINITE)
                        .setAction("ok!", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                btnShowSnack.setClickable(false);
                            }
                        });  //ou .show() aqui

                snackbar.setActionTextColor(getResources().getColor(R.color.colorPrimaryDark));
                snackbar.show();
            }
        });

        return view;
    }

}