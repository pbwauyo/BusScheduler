package com.example.busscheduler.adapters;

import android.content.Context;
import android.icu.text.Normalizer2;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.busscheduler.R;
import com.example.busscheduler.models.BusStop;
import com.example.busscheduler.viewholders.BaseViewHolder;

import java.util.ArrayList;

import fr.castorflex.android.smoothprogressbar.SmoothProgressBar;

public class BusStopsAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private ArrayList<BusStop> busStopList;
    private Context context;
    private OnClickListener onClickListener;
    private SmoothProgressBar progressBar;
    private final int VIEW_TYPE_NORMAL = 1;
    private final int VIEW_TYPE_EMPTY = 0;

    public BusStopsAdapter(Context context, ArrayList<BusStop> busList, OnClickListener onClickListener, SmoothProgressBar progressBar){
        this.context = context;
        this.busStopList = busList;
        this.onClickListener = onClickListener;
        this.progressBar = progressBar;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        if (viewType == VIEW_TYPE_NORMAL){
            return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.bus_stop_row, viewGroup, false));
        }
        else {
            return new EmptyViewHolder(LayoutInflater.from(context).inflate(R.layout.empty_adapter_view, viewGroup, false));
        }

    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder viewHolder, int i) {
        progressBar.setVisibility(View.GONE);
        viewHolder.bind(i);
    }

    @Override
    public int getItemCount() {
        if(busStopList.size()==0){
            return 1;
        }
        return busStopList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(busStopList != null && busStopList.size() > 0){
            Log.d("View Type", "Normal");
            return VIEW_TYPE_NORMAL;

        }
        else {
            Log.d("View Type", "Empty");
            return VIEW_TYPE_EMPTY;
        }
    }

    public class ViewHolder extends BaseViewHolder implements View.OnClickListener {
        private TextView busStopIDTxt, busStopNameTxt, busStopLocationTxt;

        ViewHolder(View view){
            super(view);
            busStopIDTxt = view.findViewById(R.id.bus_stop_id);
            busStopNameTxt = view.findViewById(R.id.bus_stop_name);
            busStopLocationTxt = view.findViewById(R.id.bus_stop_location);

            view.setOnClickListener(this);
        }

        @Override
        public void bind(int position){
            super.bind(position);
            busStopIDTxt.setText(busStopList.get(position).getBuStopId());
            busStopNameTxt.setText(busStopList.get(position).getBusStopName());
            busStopLocationTxt.setText(busStopList.get(position).getBusStopLocation());
        }

        @Override
        public void onClick(View v) {
            onClickListener.onClickViewHolder(v, getAdapterPosition());
        }
    }

    //view holder for empty adapter
    public class EmptyViewHolder extends BaseViewHolder{
        EmptyViewHolder(View view){
            super(view);
        }
    }

    public interface OnClickListener{
        void onClickViewHolder(View view, int adapterPosition);
    }
}
