package com.tomveselka.prazskalitackamobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.tomveselka.prazskalitackamobile.entities.RowEntity;
import com.tomveselka.prazskalitackamobile.race.row.RowViewModel;

import java.util.List;

public class AddEditRaceListItemActivity extends AppCompatActivity {

    Button btnCancel;

    private RowViewModel rowViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int width = (int)(getResources().getDisplayMetrics().widthPixels*0.90);
        int height = (int)(getResources().getDisplayMetrics().heightPixels*0.80);
        setContentView(R.layout.activity_add_edit_race_list_item);
        this.getWindow().setLayout(width, height);

        Intent intent = getIntent();
        int rowId = intent.getIntExtra("row_id",0);
        Log.i("Received data","Received from main activity id "+rowId);

        btnCancel = findViewById(R.id.dialog_add_edit_item_cancel_button);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


}