package com.example.busscheduler.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.busscheduler.R;
import com.example.busscheduler.adapters.BusAdapter;
import com.example.busscheduler.models.BusModel;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

import fr.castorflex.android.smoothprogressbar.SmoothProgressBar;

public class BusActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private SmoothProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus);

        Intent intent = getIntent();
        recyclerView = findViewById(R.id.bus_rv);
        progressBar = findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.VISIBLE);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        String busStopNum = intent.getStringExtra("busStopID");
        new RetrieveBusData().execute(busStopNum);

    }

    class RetrieveBusData extends AsyncTask<String, Void, Void>{

        @Override
        protected Void doInBackground(String... strings) {
            String busStopID = strings[0];

            FirebaseFirestore db = FirebaseFirestore.getInstance();
            CollectionReference collectionReference = db.collection("buses");

            collectionReference.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                @Override
                public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                    BusModel bus;
                    ArrayList<BusModel> busList = new ArrayList<>();
                    BusAdapter adapter;

                    for(QueryDocumentSnapshot snapshot : queryDocumentSnapshots){
                        bus = snapshot.toObject(BusModel.class);

                        if(bus.getBusStopNumber().equalsIgnoreCase(busStopID)){
                            busList.add(bus);
                            Log.d("busList", bus.getBusStopNumber());
                        }
                    }

                    adapter = new BusAdapter(BusActivity.this, busList, progressBar);
                    recyclerView.setAdapter(adapter);
                }
            })
            .addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Log.d("Bus Activity", "onFailure: " + e.getMessage());
                }
            });

            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

        }


    }
}
