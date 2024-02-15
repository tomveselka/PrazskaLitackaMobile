package com.tomveselka.prazskalitackamobile.race.row;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.tomveselka.prazskalitackamobile.AddEditRaceListItemActivity;
import com.tomveselka.prazskalitackamobile.MainActivity;
import com.tomveselka.prazskalitackamobile.R;
import com.tomveselka.prazskalitackamobile.entities.RowEntity;
import com.tomveselka.prazskalitackamobile.race.domain.RowService;

import java.util.ArrayList;
import java.util.List;

public class RowAdapter extends RecyclerView.Adapter<RowAdapter.RowHolder> {

    private List<RowEntity> rows = new ArrayList<>();

    private Context context;
    RowService rowService = new RowService();

    public RowAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_race_list_item,parent, false);
        return new RowHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RowHolder holder, int position) {
        RowEntity currentRow = rows.get(position);
        holder.textViewFromValue.setText(currentRow.getFromStation());
        holder.textViewFromPoints.setText(currentRow.getFromPoints()+"");
        holder.textViewToValue.setText(currentRow.getToStation());
        holder.textViewToPoints.setText(currentRow.getToPoints()+"");
        holder.imageViewTransportTypeIcon.setImageResource(R.drawable.bus_icon);
        holder.textViewTransportPoints.setText(currentRow.getLinePoints()+"");
        holder.textViewTotalPoints.setText(Integer.toString(rowService.getTotalPoints(currentRow)));
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("UserInput","Clicked on "+currentRow.getFromStation()+ " to " + currentRow.getToStation());
                //Toast.makeText(context,"test",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(context, AddEditRaceListItemActivity.class);
                i.putExtra("row_id",currentRow.getId());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return rows.size();
    }

    public void setRows(List<RowEntity> rows){
        this.rows = rows;
        notifyDataSetChanged();
    }


    class RowHolder extends RecyclerView.ViewHolder{
        TextView textViewFromValue;
        TextView textViewFromPoints;
        TextView textViewToValue;
        TextView textViewToPoints;
        ImageView imageViewTransportTypeIcon;
        TextView textViewTransportPoints;
        TextView textViewTotalPoints;

        CardView cardView;

        public RowHolder(@NonNull View itemView) {
            super(itemView);
            textViewFromValue = itemView.findViewById(R.id.from_value);
            textViewFromPoints = itemView.findViewById(R.id.from_points);
            textViewToValue = itemView.findViewById(R.id.to_value);
            textViewToPoints = itemView.findViewById(R.id.to_points);
            imageViewTransportTypeIcon = itemView.findViewById(R.id.transport_type_icon);
            textViewTransportPoints = itemView.findViewById(R.id.transport_points);
            textViewTotalPoints = itemView.findViewById(R.id.points_value);
            cardView = itemView.findViewById(R.id.row_card_view);
        }
    }
}
