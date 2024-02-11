package com.tomveselka.prazskalitackamobile.race.row;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Room;
import androidx.room.Update;

import com.tomveselka.prazskalitackamobile.entities.RowEntity;

import java.util.List;

@Dao
public interface RowDao {

    @Insert
    void insertRow(RowEntity row);

    @Update
    void updateRow(RowEntity row);

    @Delete
    void deleteRow(RowEntity row);

    @Query("SELECT * FROM rows_of_races ORDER BY id ASC")
    LiveData<List<RowEntity>> getAllRows();
}
