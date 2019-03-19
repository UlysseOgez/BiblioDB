package com.example.bibliodb;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddBookActivity extends AppCompatActivity {

    EditText etAuteur;
    EditText etTitre;
    EditText etDate;
    EditText etResume;

    BibliDatabase bdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        etAuteur = findViewById(R.id.editTextAuteur);
        etTitre = findViewById(R.id.editTextTitre);
        etDate = findViewById(R.id.editTextDate);
        etResume = findViewById(R.id.editTextResume);

        bdb = BibliDatabase.getDatabase(this);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new InsertBookTask().execute();
            }
        });
    }

    private class InsertBookTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {

            Book firstBook = new Book();
            firstBook.Auteur = etAuteur.getText().toString();
            firstBook.Titre = etTitre.getText().toString();
            firstBook.Resume = etResume.getText().toString();
            firstBook.DateParution = etDate.getText().toString();

            bdb.bookDao().insertBook(firstBook);

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            Toast.makeText(AddBookActivity.this, "nouvelle livre ajouté !", Toast.LENGTH_SHORT).show();
        }

    }

}
