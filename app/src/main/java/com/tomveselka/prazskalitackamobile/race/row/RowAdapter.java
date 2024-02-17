package com.tomveselka.prazskalitackamobile.race.row;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.tomveselka.prazskalitackamobile.R;
import com.tomveselka.prazskalitackamobile.entities.RowEntity;
import com.tomveselka.prazskalitackamobile.race.domain.RowService;

import java.util.ArrayList;
import java.util.List;

public class RowAdapter extends RecyclerView.Adapter<RowAdapter.RowHolder> {

    private List<RowEntity> rows = new ArrayList<>();
    private OnItemClickListener listener;
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
        holder.textViewTransportNumber.setText(currentRow.getLineNumber());
        holder.textViewTransportPoints.setText(currentRow.getLinePoints()+"");
        holder.textViewTotalPoints.setText(Integer.toString(rowService.getTotalPoints(currentRow)));

    }

    public interface OnItemClickListener{
        void onItemClick(RowEntity row);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener=listener;

    }

    @Override
    public int getItemCount() {
        return rows.size();
    }

    public void setRows(List<RowEntity> rows){
        this.rows = rows;
        notifyDataSetChanged();
    }

    public RowEntity getRows(int position){
        return rows.get(position);
    }

    class RowHolder extends RecyclerView.ViewHolder{
        TextView textViewFromValue;
        TextView textViewFromPoints;
        TextView textViewToValue;
        TextView textViewToPoints;
        ImageView imageViewTransportTypeIcon;
        TextView textViewTransportNumber;
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
            textViewTransportNumber= itemView.findViewById(R.id.transport_number);
            textViewTransportPoints = itemView.findViewById(R.id.transport_points);
            textViewTotalPoints = itemView.findViewById(R.id.points_value);
            cardView = itemView.findViewById(R.id.row_card_view);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if(listener!=null && position != RecyclerView.NO_POSITION){
                        listener.onItemClick(rows.get(position));
                    }

                }
            });
        }
    }
}
