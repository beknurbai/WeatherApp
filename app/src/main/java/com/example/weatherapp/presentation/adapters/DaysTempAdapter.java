package com.example.weatherapp.presentation.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherapp.R;
import com.example.weatherapp.models.DaysTempModels;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class DaysTempAdapter extends RecyclerView.Adapter<DaysTempAdapter.DaysTempViewHolder> {

    List list = new ArrayList();

    public DaysTempAdapter(List list) {
        this.list = list;
        DaysTempModels daysTempModels = new DaysTempModels(R.drawable.ic_temp_cloudy, "Mon, 21", "32", "23");
        DaysTempModels daysTempModels1 = new DaysTempModels(R.drawable.ic_sun_icon, "Tue, 21", "32", "23");
        DaysTempModels daysTempModels2 = new DaysTempModels(R.drawable.ic_wind_icon, "Wed, 21", "32", "23");
        DaysTempModels daysTempModels3 = new DaysTempModels(R.drawable.ic_sun_icon, "Monday, 21", "32", "23");
        DaysTempModels daysTempModels4 = new DaysTempModels(R.drawable.ic_temp_cloudy, "Monday, 21", "32", "23");
        list.add(daysTempModels);
        list.add(daysTempModels1);
        list.add(daysTempModels2);
        list.add(daysTempModels3);
        list.add(daysTempModels4);

    }

    @NonNull
    @Override
    public DaysTempViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_days, parent, false);
        return new DaysTempViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DaysTempViewHolder holder, int position) {
        holder.bind((DaysTempModels) list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class DaysTempViewHolder extends RecyclerView.ViewHolder {
        TextView daysOfWeek, tempUp, tempDown;
        ImageView daysImTempState;

        public DaysTempViewHolder(@NonNull View itemView) {
            super(itemView);
            daysOfWeek = itemView.findViewById(R.id.tv_next_day);
            tempDown = itemView.findViewById(R.id.tv_temp_next_day);
            daysImTempState = itemView.findViewById(R.id.image_days_card);
            tempUp = itemView.findViewById(R.id.tv_temp_up);
        }

        public void bind(DaysTempModels models) {
            daysOfWeek.setText(models.getTextDaysOfWeek());
            daysImTempState.setImageResource(models.getImageTempState());
            tempUp.setText(models.getTempUp());
            tempDown.setText(models.getTempDown());


        }
    }
}
