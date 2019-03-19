package com.example.bibliodb;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.sql.Date;

@Entity
public class Book {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    public long Id;

    @NonNull
    public String Titre;

    @NonNull
    public String Auteur;

    @NonNull
    public String DateParution;

    @NonNull
    public String Resume;

}
