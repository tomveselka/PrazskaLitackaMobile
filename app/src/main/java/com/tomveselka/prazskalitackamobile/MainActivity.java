package com.tomveselka.prazskalitackamobile;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.tomveselka.prazskalitackamobile.entities.RowEntity;
import com.tomveselka.prazskalitackamobile.race.activities.EditRowActivity;
import com.tomveselka.prazskalitackamobile.race.domain.RowService;
import com.tomveselka.prazskalitackamobile.race.activities.AddRowActivity;
import com.tomveselka.prazskalitackamobile.race.row.RowAdapter;
import com.tomveselka.prazskalitackamobile.race.row.RowDTO;
import com.tomveselka.prazskalitackamobile.race.row.RowViewModel;

import org.modelmapper.ModelMapper;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView rowList;
    Button btnAddNew;
    ModelMapper modelMapper = new ModelMapper();

    private RowViewModel rowViewModel;

    ActivityResultLauncher<Intent> activityResultLauncherEditRow;
    ActivityResultLauncher<Intent> activityResultLauncherAddRow;

    RowService rowService = new RowService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAddNew = findViewById(R.id.add_row_button);
        //register activity
        registerActivityForUpdateRow();
        registerActivityForAddRow();

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
                Intent i = new Intent(MainActivity.this, EditRowActivity.class);
                i.putExtra("row_to_edit_activity",rowDTO);
                activityResultLauncherEditRow.launch(i);
            }
        });

        btnAddNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AddRowActivity.class);
                activityResultLauncherAddRow.launch(i);
            }
        });

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                RowEntity rowToBeDeleted = adapter.getRows(viewHolder.getAdapterPosition());
                builder.setTitle("Deleting row entry");
                builder.setMessage("Are you sure you want to delete entry from "+rowToBeDeleted.getFromStation()
                        +" to "+rowToBeDeleted.getToStation()+" via line "+rowToBeDeleted.getLineNumber()+"?");
                builder.setCancelable(true);
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        rowViewModel.delete(rowToBeDeleted);
                        Toast.makeText(getApplicationContext(),"Row Deleted", Toast.LENGTH_SHORT).show();
                        dialogInterface.cancel();
                    }
                });
                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                        adapter.notifyItemChanged(viewHolder.getAdapterPosition());
                    }
                });

                builder.create().show();
            }
        }).attachToRecyclerView(recyclerView);
    }

    public void registerActivityForUpdateRow(){
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

    public void registerActivityForAddRow(){
        activityResultLauncherAddRow = registerForActivityResult(new ActivityResultContracts.StartActivityForResult()
                , new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        int resultCode = result.getResultCode();
                        Intent data = result.getData();
                        RowDTO returnDTO;
                        if (resultCode == RESULT_OK && data != null) {
                            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
                                returnDTO = data.getParcelableExtra("return_from_row_to_add", RowDTO.class);
                            } else {
                                returnDTO = data.getParcelableExtra("return_from_row_to_add");
                            }
                            Log.i("Received data", "Received from Add Edit Activity row " + returnDTO.toString());

                            if (returnDTO != null){
                                RowEntity returnedRowEntity = modelMapper.map(returnDTO,RowEntity.class);
                                rowViewModel.insert(returnedRowEntity);
                            }
                        }
                    }
                });
    }
}