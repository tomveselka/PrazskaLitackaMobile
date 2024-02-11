package com.tomveselka.prazskalitackamobile.race.row;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.tomveselka.prazskalitackamobile.entities.RowEntity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {RowEntity.class}, version = 1)
public abstract class RowDatabase extends RoomDatabase {

    private static RowDatabase instance;

    public abstract RowDao rowDao();

    public static synchronized RowDatabase getInstance(Context context) {

        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext()
                    ,RowDatabase.class, "rows_of_races")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }

        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db){
            super.onCreate(db);

            RowDao rowDao = instance.rowDao();
            ExecutorService executorService = Executors.newSingleThreadExecutor();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    rowDao.insertRow(new RowEntity(false,5,false,"Křižíkova",false,6,false,"Invalidovna",false,4,false,"24","tram"));
                    rowDao.insertRow(new RowEntity(true,0,false,"Invalidovna",false,6,false,"Českomoravská",false,2,false,"B","metro"));
                    rowDao.insertRow(new RowEntity(true,0,false,"Českomoravská",false,31,true,"Klíčov",false,3,false,"151","bus"));
                }
            });
        }
    };


}
