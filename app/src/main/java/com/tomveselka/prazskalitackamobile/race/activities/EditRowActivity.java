package com.tomveselka.prazskalitackamobile.race.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.tomveselka.prazskalitackamobile.R;
import com.tomveselka.prazskalitackamobile.race.row.RowDTO;
import com.tomveselka.prazskalitackamobile.race.row.RowViewModel;

public class EditRowActivity extends AppCompatActivity {

    Button btnCancel;
    Button btnSave;

    TextView textViewFromValue;
    TextView textViewFromPoints;
    TextView textViewToValue;
    TextView textViewToPoints;
    TextView textViewLineNumber;
    TextView textViewLinePoints;
    CheckBox nonStandardCheckbox;
    TextView textViewNonStandardDescription;
    TextView textViewTotalPoints;

    RowDTO rowDTO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int width = (int)(getResources().getDisplayMetrics().widthPixels*0.90);
        int height = (int)(getResources().getDisplayMetrics().heightPixels*0.80);
        setContentView(R.layout.activity_add_edit_race_list_item);
        this.getWindow().setLayout(width, height);

        textViewFromValue=findViewById(R.id.dialog_add_edit_item_from_input);
        textViewFromPoints=findViewById(R.id.dialog_add_edit_item_from_points);
        textViewToValue=findViewById(R.id.dialog_add_edit_item_to_input);
        textViewToPoints=findViewById(R.id.dialog_add_edit_item_to_points);
        textViewLineNumber =findViewById(R.id.dialog_add_edit_item_line_value);
        textViewLinePoints =findViewById(R.id.dialog_add_edit_item_line_points);
        nonStandardCheckbox=findViewById(R.id.dialog_add_edit_item_is_line_nonstandard_checkbox);
        textViewNonStandardDescription =findViewById(R.id.dialog_add_edit_item_nonstandard_line_description);
        textViewTotalPoints=findViewById(R.id.dialog_add_edit_item_from_input);

        getData();

        btnCancel = findViewById(R.id.dialog_add_edit_item_cancel_button);
        btnSave = findViewById(R.id.dialog_add_edit_item_save_button);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateRow();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void updateRow(){
        RowDTO returnDTO = new RowDTO();
        returnDTO.setId(rowDTO.getId());
        returnDTO.setFromStation(textViewFromValue.getText().toString());
        returnDTO.setFromPoints(Integer.valueOf(textViewFromPoints.getText().toString()));
        returnDTO.setToStation(textViewToValue.getText().toString());
        returnDTO.setToPoints(Integer.valueOf(textViewToPoints.getText().toString()));
        returnDTO.setLineNumber(textViewLineNumber.getText().toString());
        returnDTO.setLinePoints(Integer.valueOf(textViewLinePoints.getText().toString()));
        Intent intent = new Intent();
        intent.putExtra("return_from_row_to_edit",returnDTO);
        setResult(RESULT_OK,intent);
        Log.i("Sending data", "Sending data back to Race Activity row" + returnDTO.toString());
        finish();
    }

    public void getData(){
        Intent intent = getIntent();

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
            rowDTO = intent.getParcelableExtra("row_to_edit_activity",RowDTO.class);
        }else{
            rowDTO = intent.getParcelableExtra("row_to_edit_activity");
        }
        if(rowDTO!=null) {
            Log.i("Received data", "Received from Race Activity row " + rowDTO.toString());
            textViewFromValue.setText(rowDTO.getFromStation());
            textViewFromPoints.setText(String.valueOf(rowDTO.getFromPoints()));
            textViewToValue.setText(rowDTO.getToStation());
            textViewToPoints.setText(String.valueOf(rowDTO.getToPoints()));
            textViewLineNumber.setText(rowDTO.getLineNumber());
            textViewLinePoints.setText(String.valueOf(rowDTO.getLinePoints()));
            nonStandardCheckbox=findViewById(R.id.dialog_add_edit_item_is_line_nonstandard_checkbox);
            textViewNonStandardDescription =findViewById(R.id.dialog_add_edit_item_nonstandard_line_description);
            textViewTotalPoints=findViewById(R.id.dialog_add_edit_item_from_input);
        }
    }


}