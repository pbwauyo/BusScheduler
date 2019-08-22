package com.example.busscheduler.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.busscheduler.R;
import com.example.busscheduler.models.BusModel;

import java.util.ArrayList;

public class BusesAdapter extends RecyclerView.Adapter<BusesAdapter.ViewHolder> {
    private ArrayList<BusModel> busList;
    private Context context;

    public BusesAdapter(Context context, ArrayList<BusModel> busList){
        this.context = context;
        this.busList = busList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.buses_row, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.arrivalTimeTxt.setText(busList.get(i).getArrivalTime());
        viewHolder.departureTimeTxt.setText(busList.get(i).getDepartureTime());
        viewHolder.stationNameTxt.setText(busList.get(i).getStationName());
        viewHolder.busNumberTxt.setText(busList.get(i).getBusNumber());
        viewHolder.arrivalDurationTxt.setText(busList.get(i).getArrivalDuration());
    }

    @Override
    public int getItemCount() {
        if(busList.size()==0){
            return 0;
        }
        return busList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView arrivalTimeTxt, departureTimeTxt, stationNameTxt, busNumberTxt, arrivalDurationTxt;

        ViewHolder(View view){
            super(view);
            arrivalTimeTxt = view.findViewById(R.id.arrival_time);
            departureTimeTxt = view.findViewById(R.id.departure_time);
            stationNameTxt = view.findViewById(R.id.station_name);
            busNumberTxt = view.findViewById(R.id.plate_number);
            arrivalDurationTxt = view.findViewById(R.id.duration);
        }
    }
}
