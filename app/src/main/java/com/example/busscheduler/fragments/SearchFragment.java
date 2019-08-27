package com.example.busscheduler.fragments;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.busscheduler.R;
import com.example.busscheduler.activities.BusActivity;
import com.example.busscheduler.adapters.BusStopsAdapter;
import com.example.busscheduler.models.BusModel;
import com.example.busscheduler.models.BusStop;
import com.ferfalk.simplesearchview.SimpleSearchView;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

import fr.castorflex.android.smoothprogressbar.SmoothProgressBar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SearchFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SearchFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private SimpleSearchView searchView;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private BusStopsAdapter adapter;
    private SmoothProgressBar progressBar;

    public SearchFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SearchFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SearchFragment newInstance(String param1, String param2) {
        SearchFragment fragment = new SearchFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        layoutManager = new LinearLayoutManager(getActivity());
        //uploadDummyBusStopData();
        //uploadDummyBusDataToFirestoreDb();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        searchView = view.findViewById(R.id.bus_stop_search_view);
        progressBar = view.findViewById(R.id.progress_bar);
        recyclerView = view.findViewById(R.id.bus_stops_rv);

        recyclerView.setLayoutManager(layoutManager);



        searchView.post(new Runnable() {
            @Override
            public void run() {
                searchView.showSearch(true);
            }
        });

        searchView.setOnQueryTextListener(new SimpleSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                progressBar.setVisibility(View.VISIBLE);
                new RetrieveFirestoreData().execute(query);

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }

            @Override
            public boolean onQueryTextCleared() {
                return false;
            }
        });

        return view;
    }

    void uploadDummyBusStopData(){
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        CollectionReference collectionReference = db.collection("busStops");
        String[] busStopNames, busStopIDs, busStopLocations;
        busStopNames = new String[]{"Kampala road Station", "Pioneer Mall Station", "Wandegeya Station"};
        busStopIDs = new String[]{"30007", "70000", "40000"};
        busStopLocations = new String[]{"Kampala road", "William street", "Bombo road"};

        for(int i=0; i<busStopNames.length; i++){
            collectionReference.add(new BusStop(busStopNames[i], busStopIDs[i], busStopLocations[i]))
            .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                @Override
                public void onSuccess(DocumentReference documentReference) {
                    Log.d("SearchFragment", "onSuccess: busStop data upload successful");
                }
            })
            .addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Log.d("SearchFragment", "onFailure: " + e.getMessage());
                }
            });
        }
    }

    void uploadDummyBusDataToFirestoreDb(){
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        CollectionReference reference = db.collection("buses");
        String[] busNumbers, busNames, busStopIDs, busDistances, busCurrentCapacities, busArrivalDurations, busStopParkingPoints, busRoutes, busDetails, busUniqueNumbers;

        busNames = new String[]{"BUS A", "BUS B", "BUS C", "BUS D", "BUS E", "BUS F", "BUS G", "BUS H", "BUS I"};
        busArrivalDurations = new String[]{"9 Mins", "10 Mins", "11 Mins", "12 Mins", "1 Mins", "2 Mins", "3 Mins", "4 Mins", "5 Mins"};
        busStopParkingPoints = new String[]{"10-259", "12-201", "99-357", "07-206", "12-211", "10-317", "07-321", "12-230", "10-249"};
        busStopIDs = new String[]{"30007", "40000", "40000", "70000", "30007", "30007", "70000", "30007", "70000"};
        busDistances = new String[]{"12 km", "23 km", "4 km", "10 km", "9 km", "3 km", "15 km", " 6 km", "11 km"};
        busCurrentCapacities = new String[]{"Empty", "34", "90", "35", "Empty", "30", "9", "10", "20"};
        busRoutes = new String[]{"Kalerwa, Mperwerewe, Gayaza", "Makerere, Kikoni", "Bwaise, Kawempe, Luweero", "Tula, Kilokole, Kidokolo", "Jinja Rd, Nakawa, Ntinda", "Kireka, Banda, Bweyogerere", "Wandegeya,  Acacia, Kamwokya", "Luzira, Bugolobi", "Nsooba, Kyebando, Mperwewe"};
        busDetails = new String[]{"MAN 2010, Solo, Handicapped, AirConditioner, Capacity 56", "MERCEDES 2013, Articulated, Handicapped, Capacity 90", "MAN 2013, Articulated, AirCon, Capacity 81", "MAN 2007, Solo, Handicapped, AirCon, Capacity 56", "MAN 2008, Solo, Handicapped, Capacity 67", "TOYOTA 1998, Handicapped, Capacity 45", "MERCEDES 2019, Articulated, AirCon, Capacity 98", "MAN 2008, Solo, Handicapped, Capacity 34", "MAN 2010, Solo, Handicapped, Articulated, Capacity 45"};
        busNumbers = new String[]{"UCG 348T", "UGH 782H", "UKA 823P", "UER 893G", "UAK 505D", "UJL 782G", "UHA HWJ3", "UMG 829Y", "UNV HDJ2"};
        busUniqueNumbers = new String[]{"281", "377", "355", "357", "284", "361", "279", "261", "263"};

        for(int i=0; i<busNames.length; i++){

            reference.add(new BusModel(busNumbers[i], busNames[i], busStopIDs[i], busDistances[i], busCurrentCapacities[i], busArrivalDurations[i], busStopParkingPoints[i], busRoutes[i], busDetails[i], busUniqueNumbers[i]))
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.d("Error msg", e.getMessage());
                        }
                    })
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Log.d("Success", "upload successful ");
                        }
                    });
        }
    }

    class RetrieveFirestoreData extends AsyncTask<String, Void, Void>{

        @Override
        protected Void doInBackground(String... strings) {

            final String query = strings[0].trim();
            CollectionReference reference = FirebaseFirestore.getInstance().collection("busStops");
            reference.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                @Override
                public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                    BusStop busStop;
                    ArrayList<BusStop> busStops = new ArrayList<>();
                    for(QueryDocumentSnapshot snapshot : queryDocumentSnapshots){
                        busStop = snapshot.toObject(BusStop.class);
                        if(busStop.getBuStopId().equalsIgnoreCase(query)){
                            busStops.add(busStop);
                        }
                    }

                    Log.d("StopList Size: ", String.valueOf(busStops.size()));

                    adapter = new BusStopsAdapter(getActivity(), busStops, new BusStopsAdapter.OnClickListener() {
                        @Override
                        public void onClickViewHolder(View view, int adapterPosition) {
                            Toast.makeText(getActivity(), "Position: " + adapterPosition + " clicked", Toast.LENGTH_LONG).show();

                            Intent intent = new Intent(getActivity(), BusActivity.class);
                            intent.putExtra("busStopID", busStops.get(adapterPosition).getBuStopId());
                            startActivity(intent);
                        }
                    }, progressBar);
                    recyclerView.setAdapter(adapter);
                }
            })
            .addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Log.d("SearchFragment", "onFailure: " + e.getMessage());
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
