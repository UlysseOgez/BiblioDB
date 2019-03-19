package com.example.bibliodb;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface BookDao {

    @Query("SELECT * FROM book")
    List<Book> getAll();

    @Query("SELECT * FROM book WHERE id = :bookid AND titre = :booktitle")
    Book findById(long bookid, String booktitle);

    @Insert
    void insertBook(Book book);

    @Update
    void updateBook(Book book);

    @Delete
    void deleteBook(Book book);

    @Query("DELETE FROM book WHERE id = :bookid")
    void deleteBookById(long bookid);

}
