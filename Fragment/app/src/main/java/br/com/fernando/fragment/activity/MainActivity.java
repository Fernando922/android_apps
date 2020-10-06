package br.com.fernando.fragment.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.fernando.fragment.R;
import br.com.fernando.fragment.fragment.ContactsFragment;
import br.com.fernando.fragment.fragment.ConversationsFragment;

public class MainActivity extends AppCompatActivity {

    private Button btnContacts, btnConversations;
    private ConversationsFragment conversationsFragment;
    private ContactsFragment contactsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        btnContacts = findViewById(R.id.btnContacts);
        btnConversations = findViewById(R.id.btnConversations);
        conversationsFragment = new ConversationsFragment();
        contactsFragment = new ContactsFragment();

        //Configurar objeto para o Fragmento
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frContent, conversationsFragment);
        transaction.commit();


        btnConversations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frContent, conversationsFragment);
                transaction.commit();
            }
        });


        btnContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frContent, contactsFragment);
                transaction.commit();
            }
        });




        //remover sombra da actionbar
        getSupportActionBar().setElevation(0);
    }
}