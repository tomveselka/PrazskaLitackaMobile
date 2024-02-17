package com.tomveselka.prazskalitackamobile.race.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.tomveselka.prazskalitackamobile.R;
import com.tomveselka.prazskalitackamobile.race.row.RowDTO;
import com.tomveselka.prazskalitackamobile.race.row.RowViewModel;

public class AddRowActivity extends AppCompatActivity {

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

        btnCancel = findViewById(R.id.dialog_add_edit_item_cancel_button);
        btnSave = findViewById(R.id.dialog_add_edit_item_save_button);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveRow();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void saveRow(){
        RowDTO returnDTO = new RowDTO();
        returnDTO.setFromStation(textViewFromValue.getText().toString());
        returnDTO.setFromPoints(Integer.valueOf(textViewFromPoints.getText().toString()));
        returnDTO.setToStation(textViewToValue.getText().toString());
        returnDTO.setToPoints(Integer.valueOf(textViewToPoints.getText().toString()));
        returnDTO.setLineNumber(textViewLineNumber.getText().toString());
        returnDTO.setLinePoints(Integer.valueOf(textViewLinePoints.getText().toString()));
        returnDTO.setNonStandard(nonStandardCheckbox.isChecked());
        returnDTO.setNonStandardDescription(textViewNonStandardDescription.getText().toString());
        Intent intent = new Intent();
        intent.putExtra("return_from_row_to_add",returnDTO);
        setResult(RESULT_OK,intent);
        Log.i("Sending data", "Sending data back to Race Activity row" + returnDTO.toString());
        finish();
    }
}
