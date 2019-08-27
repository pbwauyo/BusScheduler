package com.example.busscheduler.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.busscheduler.R;
import com.example.busscheduler.models.BusModel;
import com.example.busscheduler.viewholders.BaseViewHolder;

import java.util.ArrayList;

import fr.castorflex.android.smoothprogressbar.SmoothProgressBar;

public class BusAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private ArrayList<BusModel> busList;
    private Context context;
    private SmoothProgressBar progressBar;
    private final int VIEW_TYPE_NORMAL = 1;
    private final int VIEW_TYPE_EMPTY = 0;

    public BusAdapter(Context context, ArrayList<BusModel> busList, SmoothProgressBar progressBar){
        this.context = context;
        this.busList = busList;
        this.progressBar = progressBar;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        if(viewType==VIEW_TYPE_NORMAL){
            return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.bus_row, viewGroup, false));
        }
        else {
            return new EmptyViewHolder(LayoutInflater.from(context).inflate(R.layout.empty_adapter_view, viewGroup, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder viewHolder, int i) {
        progressBar.setVisibility(View.GONE);

    }

    @Override
    public int getItemViewType(int position) {
        if(busList != null && busList.size() >0){
            return VIEW_TYPE_NORMAL;
        }
        else return VIEW_TYPE_EMPTY;
    }

    @Override
    public int getItemCount() {
        if(busList.size()==0){
            return 1;
        }
        return busList.size();
    }

    public class ViewHolder extends BaseViewHolder{

        private TextView uniqueNumTxt, busNameTxt, parkingPointTxt, busNumberTxt, busDistanceTxt, busCurrentCapacityTxt, busArrivalTxt, busRouteTxt, busDetailsTxt;
        private MotionLayout motionLayout;

        ViewHolder(View view){
            super(view);

            motionLayout = view.findViewById(R.id.bus_row_motion_layout);
            uniqueNumTxt = view.findViewById(R.id.number);
            busNameTxt = view.findViewById(R.id.bus_name);
            parkingPointTxt = view.findViewById(R.id.parking_point);
            busNumberTxt = view.findViewById(R.id.bus_number);
            busDistanceTxt = view.findViewById(R.id.distance);
            busCurrentCapacityTxt = view.findViewById(R.id.fullness);
            busArrivalTxt = view.findViewById(R.id.arrival_duration);
            busRouteTxt = view.findViewById(R.id.routes);
            busDetailsTxt = view.findViewById(R.id.details);
        }

        public void bind(int position){
            super.bind(position);

            uniqueNumTxt.setText(busList.get(position).getBusUniqueNumber());
            busNameTxt.setText(busList.get(position).getBusName());
            parkingPointTxt.setText(busList.get(position).getBusStopPosition());
            busNumberTxt.setText(busList.get(position).getBusNumber());
            busDistanceTxt.setText(busList.get(position).getBusDistance());
            busCurrentCapacityTxt.setText(busList.get(position).getBusCurrentCapacity());
            busArrivalTxt.setText(busList.get(position).getBusArrivalDuration());
            busRouteTxt.setText(busList.get(position).getBusRoute());
            busDetailsTxt.setText(busList.get(position).getBusDetails());

            //animate recylerview items
            motionLayout.transitionToEnd();
        }

    }

    public class EmptyViewHolder extends BaseViewHolder{

        EmptyViewHolder(View view){
            super(view);
        }
    }
}
