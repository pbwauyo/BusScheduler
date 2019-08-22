package com.example.busscheduler;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.busscheduler.adapters.BusesAdapter;
import com.example.busscheduler.models.BusModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    BusesAdapter adapter;
    ArrayList<BusModel> busList;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        busList = new ArrayList<>();
        recyclerView = findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this);
        adapter = new BusesAdapter(this, buildDummyData());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    ArrayList<BusModel> buildDummyData(){
        ArrayList<BusModel> dummyList = new ArrayList<>();

        String[] arrivalTimes, departureTimes, stationNames, busNumbers, arrivalDurations;
        arrivalTimes = new String[]{"9:00AM", "10:00AM", "11:00AM", "12:00AM", "1:00PM", "2:00PM", "3:00PM", "4:00PM", "5:00PM"};
        departureTimes = new String[]{"10:00AM", "11:00AM", "12:00AM", "13:00AM", "2:00PM", "3:00PM", "4:00PM", "5:00PM", "6:00PM"};
        stationNames = new String[]{"STATION A", "STATION B", "STATION C", "STATION D", "STATION E", "STATION F", "STATION G", "STATION H", "STATION I"};
        busNumbers = new String[]{"RWA 90AM", "RWA 00AM", "RWA 00AM", "RWA 12AM", "RWA 10PM", "RWA 20PM", "RWA 30PM", "RWA 40PM", "RWA 50PM"};
        arrivalDurations = new String[]{"9 Mins", "10 Mins", "11 Mins", "12 Mins", "1 Mins", "2 Mins", "3 Mins", "4 Mins", "5 Mins"};

        for(int i=0; i<arrivalTimes.length; i++){
            dummyList.add(new BusModel(arrivalTimes[i], departureTimes[i], stationNames[i], busNumbers[i], arrivalDurations[i]));
        }

        return  dummyList;
    }
}

