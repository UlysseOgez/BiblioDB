package com.example.bibliodb;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Book.class}, version = 1)
public abstract class BibliDatabase extends RoomDatabase {
    public abstract BookDao bookDao();

    private static volatile BibliDatabase INSTANCE;

    static BibliDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (BibliDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            BibliDatabase.class, "database-bibli")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
