package com.tomveselka.prazskalitackamobile.race.row;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.tomveselka.prazskalitackamobile.entities.RowEntity;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RowRepository {
    private RowDao rowDao;
    private LiveData<List<RowEntity>> rows;

    private LiveData<List<RowEntity>> rowsById;
    ExecutorService executors = Executors.newSingleThreadExecutor();

    public RowRepository (Application application){
        RowDatabase database = RowDatabase.getInstance(application);
        rowDao = database.rowDao();
        rows=rowDao.getAllRows();
    }

    public void insertRow(RowEntity rowEntity){

        executors.execute(new Runnable() {
            @Override
            public void run() {
                rowDao.insertRow(rowEntity);
            }
        });
    }

    public void updateRow(RowEntity rowEntity){

        executors.execute(new Runnable() {
            @Override
            public void run() {
                rowDao.updateRow(rowEntity);
            }
        });
    }

    public void deleteRow(RowEntity rowEntity){

        executors.execute(new Runnable() {
            @Override
            public void run() {
                rowDao.deleteRow(rowEntity);
            }
        });
    }

    public LiveData<List<RowEntity>> getRows() {
        return rows;
    }

    public LiveData<List<RowEntity>> getRowsById() {return rowsById;}

}
