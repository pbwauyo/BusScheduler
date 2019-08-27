package com.example.busscheduler;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.busscheduler.adapters.BusStopsAdapter;
import com.example.busscheduler.models.BusModel;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private BusStopsAdapter adapter;
    private ArrayList<BusModel> busList;
    private RecyclerView.LayoutManager layoutManager;
    private final String TAG = MainActivity.class.getSimpleName();
    private final String RETRIEVE_OK = "OK";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        //uploadDummyDataToFirestoreDb();
//
//        busList = new ArrayList<>();
//        recyclerView = findViewById(R.id.recycler_view);
//        layoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);
//
//        new RetrieveData().execute();

    }


//    void uploadDummyDataToFirestoreDb(){
//        FirebaseFirestore db = FirebaseFirestore.getInstance();
//        CollectionReference reference = db.collection("buses");
//
//        String[] arrivalTimes, departureTimes, stationNames, busNumbers, arrivalDurations;
//        arrivalTimes = new String[]{"9:00AM", "10:00AM", "11:00AM", "12:00AM", "1:00PM", "2:00PM", "3:00PM", "4:00PM", "5:00PM"};
//        departureTimes = new String[]{"10:00AM", "11:00AM", "12:00AM", "13:00AM", "2:00PM", "3:00PM", "4:00PM", "5:00PM", "6:00PM"};
//        stationNames = new String[]{"STATION A", "STATION B", "STATION C", "STATION D", "STATION E", "STATION F", "STATION G", "STATION H", "STATION I"};
//        busNumbers = new String[]{"RWA 90AM", "RWA 00AM", "RWA 00AM", "RWA 12AM", "RWA 10PM", "RWA 20PM", "RWA 30PM", "RWA 40PM", "RWA 50PM"};
//        arrivalDurations = new String[]{"9 Mins", "10 Mins", "11 Mins", "12 Mins", "1 Mins", "2 Mins", "3 Mins", "4 Mins", "5 Mins"};
//
//        for(int i=0; i<arrivalTimes.length; i++){
//
//            reference.add(new BusModel(arrivalTimes[i], departureTimes[i], stationNames[i], busNumbers[i], arrivalDurations[i]))
//                    .addOnFailureListener(new OnFailureListener() {
//                        @Override
//                        public void onFailure(@NonNull Exception e) {
//                            Log.d("Error msg", e.getMessage());
//                        }
//                    })
//                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                        @Override
//                        public void onSuccess(DocumentReference documentReference) {
//                            Log.d("Success", "upload successful ");
//                        }
//                    });
//        }
//    }

//    class RetrieveData extends AsyncTask<Void, Void, Void>{
//
//        @Override
//        protected Void doInBackground(Void... voids) {
//
//            CollectionReference ref = FirebaseFirestore.getInstance().collection("buses");
//            //retrieve data from the firestore database
//            ref.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                @Override
//                public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                    BusModel bus;
//                    for(QueryDocumentSnapshot document : queryDocumentSnapshots){
//                        Log.d(TAG, document.getData().get("stationName").toString());
//
//                        bus = document.toObject(BusModel.class);
//                        busList.add(bus);
//                    }
//                    adapter = new BusStopsAdapter(MainActivity.this, busList);
//                    recyclerView.setAdapter(adapter);
//                }
//            })
//            .addOnFailureListener(new OnFailureListener() {
//                @Override
//                public void onFailure(@NonNull Exception e) {
//                    Log.d(TAG, "onFailure: failed");
//                }
//            });
//
//            return null;
//        }
//
//        @Override
//        protected void onProgressUpdate(Void... values) {
//            super.onProgressUpdate(values);
//        }
//
//        @Override
//        protected void onPostExecute(Void aVoid) {
//            super.onPostExecute(aVoid);
//
//            if(aVoid.equals(RETRIEVE_OK)){
//
//            }
//        }
//    }
}

