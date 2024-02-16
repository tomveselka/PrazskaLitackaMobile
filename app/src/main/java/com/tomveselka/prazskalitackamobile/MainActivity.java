package com.tomveselka.prazskalitackamobile;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.tomveselka.prazskalitackamobile.entities.RowEntity;
import com.tomveselka.prazskalitackamobile.race.domain.RowService;
import com.tomveselka.prazskalitackamobile.race.row.RowAdapter;
import com.tomveselka.prazskalitackamobile.race.row.RowDTO;
import com.tomveselka.prazskalitackamobile.race.row.RowViewModel;

import org.modelmapper.ModelMapper;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView rowList;

    ModelMapper modelMapper = new ModelMapper();

    private RowViewModel rowViewModel;

    ActivityResultLauncher<Intent> activityResultLauncherEditRow;

    RowService rowService = new RowService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //register activity
        registerActivityForUpdateNote();

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

        adapter.setOnItemClickListener(new RowAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(RowEntity row) {
                Log.i("UserInput","Clicked on "+row.getFromStation()+ " to " + row.getToStation());
                //Toast.makeText(context,"test",Toast.LENGTH_SHORT).show();

                RowDTO rowDTO = modelMapper.map(row, RowDTO.class);
                Intent i = new Intent(MainActivity.this, AddEditRaceListItemActivity.class);
                i.putExtra("row_to_edit_activity",rowDTO);
                activityResultLauncherEditRow.launch(i);
            }
        });
    }

    public void registerActivityForUpdateNote(){
        activityResultLauncherEditRow = registerForActivityResult(new ActivityResultContracts.StartActivityForResult()
                , new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        int resultCode = result.getResultCode();
                        Intent data = result.getData();
                        RowDTO returnDTO;
                        if (resultCode == RESULT_OK && data != null) {
                            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
                                returnDTO = data.getParcelableExtra("return_from_row_to_edit", RowDTO.class);
                            } else {
                                returnDTO = data.getParcelableExtra("return_from_row_to_edit");
                            }
                            Log.i("Received data", "Received from Add Edit Activity row " + returnDTO.toString());

                            if (returnDTO != null && returnDTO.getId()>0){
                                RowEntity returnedRowEntity = modelMapper.map(returnDTO,RowEntity.class);
                                rowViewModel.update(returnedRowEntity);
                            }
                        }
                    }
                });
    }
}