package com.tomveselka.prazskalitackamobile.race.row;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.tomveselka.prazskalitackamobile.entities.RowEntity;
import com.tomveselka.prazskalitackamobile.race.row.RowRepository;

import java.util.List;

public class RowViewModel extends AndroidViewModel {

    private RowRepository repository;
    private LiveData<List<RowEntity>> rows;

    public RowViewModel(@NonNull Application application) {
        super(application);

        repository = new RowRepository(application);
        rows = repository.getRows();
    }

    public void insert(RowEntity row){
        repository.insertRow(row);
    }

    public void update(RowEntity row){
        repository.updateRow(row);
    }

    public void delete(RowEntity row){
        repository.deleteRow(row);
    }

    public LiveData<List<RowEntity>>  getRowById(int id){return rows;}
    public LiveData<List<RowEntity>> getAllRows(){
        return rows;
    }
}
