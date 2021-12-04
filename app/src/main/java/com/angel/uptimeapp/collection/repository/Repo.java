package com.angel.uptimeapp.collection.repository;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.angel.uptimeapp.collection.interfaces.CollectionDataLoadListener;
import com.angel.uptimeapp.collection.model.CollectionsModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Repo {

    @SuppressLint("StaticFieldLeak")
    static Repo instance;
    private final ArrayList<CollectionsModel> data = new ArrayList<>();

    @SuppressLint("StaticFieldLeak")
    static Context sContext;
    static CollectionDataLoadListener sListener;

    public static Repo getInstance(Context context) {

        sContext = context;
        if (instance == null) {
            instance = new Repo();
        }
        sListener = (CollectionDataLoadListener) sContext;
        return instance;
    }

    public MutableLiveData<ArrayList<CollectionsModel>> getData() {

        if (this.data.size() == 0) {
            loadData();
        }

        MutableLiveData<ArrayList<CollectionsModel>> data = new MutableLiveData<>();
        data.setValue(this.data);

        return data;
    }

    private void loadData() {

        DatabaseReference reference = FirebaseDatabase.getInstance("https://uptime--new-default-rtdb.asia-southeast1.firebasedatabase.app/")
                .getReference("Collections");

        reference.keepSynced(true);

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists()) {

                    for (DataSnapshot snapshot1 : snapshot.getChildren()) {

                        CollectionsModel model = snapshot1.getValue(CollectionsModel.class);
                        data.add(model);
                    }

                    sListener.onCollectionDataLoaded();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d("key", error.getMessage());
            }
        });
    }
}