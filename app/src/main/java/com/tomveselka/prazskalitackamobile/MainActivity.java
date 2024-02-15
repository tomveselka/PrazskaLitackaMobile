package com.tomveselka.prazskalitackamobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;

import com.tomveselka.prazskalitackamobile.entities.RowEntity;
import com.tomveselka.prazskalitackamobile.race.domain.RowService;
import com.tomveselka.prazskalitackamobile.race.row.RowAdapter;
import com.tomveselka.prazskalitackamobile.race.row.RowViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView rowList;

    private RowViewModel rowViewModel;

    RowService rowService = new RowService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.race_row_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        RowAdapter adapter = new RowAdapter(MainActivity.this);
        recyclerView.setAdapter(adapter);

        rowViewModel = new ViewModelProvider.AndroidViewModelFactory(getApplication())
                .create(RowViewModel.class);
        rowViewModel.getAllRows().observe(this, new Observer<List<RowEntity>>() {
            @Override
            public void onChanged(List<RowEntity> rows) {
                adapter.setRows(rows);
            }
        });

    }
}