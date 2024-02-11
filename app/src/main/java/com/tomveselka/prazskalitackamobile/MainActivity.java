package com.tomveselka.prazskalitackamobile;

import static com.google.android.material.internal.ContextUtils.getActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.tomveselka.prazskalitackamobile.entities.RowEntity;
import com.tomveselka.prazskalitackamobile.race.domain.RowService;
import com.tomveselka.prazskalitackamobile.race.row.RowViewModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView rowList;

    private RowViewModel rowViewModel;

    RowService rowService = new RowService();
//https://abhiandroid.com/ui/custom-simpleadapter.html#Example_Of_Custom_SimpleAdapter_in_Android_Studio&gsc.tab=0
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rowList = findViewById(R.id.race_row_list);

        rowViewModel = new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(RowViewModel.class);
        rowViewModel.getAllRows().observe(this, new Observer<List<RowEntity>>() {
            @Override
            public void onChanged(List<RowEntity> rowEntities) {

            }
        });

        List<RowEntity> rowEntityList = rowService.returnListOfRows();
        ArrayList<HashMap<String, String>> mapArrayList = new ArrayList<>();
        for (int i = 0; i < rowEntityList.size(); i++) {
            HashMap<String, String> hashMap = new HashMap<>();//create a hashmap to store the data in key value pair
            hashMap.put("from_value", rowEntityList.get(i).getFromStation());
            hashMap.put("to_value", rowEntityList.get(i).getToStation());
            hashMap.put("from_points", String.valueOf(rowEntityList.get(i).getFromPoints()));
            hashMap.put("to_points", String.valueOf(rowEntityList.get(i).getToPoints()));
            hashMap.put("transport_type_icon", R.drawable.bus_icon + "");
            hashMap.put("transport_points", String.valueOf(rowEntityList.get(i).getLinePoints()));
            hashMap.put("points_value", String.valueOf(rowService.getTotalPoints(rowEntityList.get(i))));

            mapArrayList.add(hashMap);//add the hashmap into arrayList
        }

        //from - keys from HashMap
        String[] from = {"from_value", "to_value","from_points","to_points","transport_type_icon","transport_points","points_value"};
        //to - view in view of list item, same order as from
        int[] to = {R.id.from_value,R.id.to_value,R.id.from_points,R.id.to_points,R.id.transport_type_icon,R.id.transport_points,R.id.points_value};
        CustomAdapter simpleAdapter = new CustomAdapter(this, mapArrayList, R.layout.activity_race_list_item, from, to);//Create object and set the parameters for simpleAdapter
        rowList.setAdapter(simpleAdapter);//sets the adapter for listView

        //perform listView item click event
        rowList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(getApplicationContext(), String.valueOf(rowService.getTotalPoints(rowEntityList.get(i))), Toast.LENGTH_LONG).show();//show the selected image in toast according to position
                startActivity(new Intent(MainActivity.this, AddEditRaceListItemActivity.class));
            }
        });
    }
}