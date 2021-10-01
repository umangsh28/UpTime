package com.example.uptimeapp.documentaryhack.repository;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.uptimeapp.documentaryhack.interfaces.DocumentaryHacksDataLoadListener;
import com.example.uptimeapp.documentaryhack.model.DocumentaryHackModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Repo {

    @SuppressLint("StaticFieldLeak")
    static Repo instance;
    private final ArrayList<DocumentaryHackModel> data = new ArrayList<>();

    @SuppressLint("StaticFieldLeak")
    static Context sContext;
    static DocumentaryHacksDataLoadListener sListener;

    public static Repo getInstance(Context context) {

        sContext = context;
        if (instance == null) {
            instance = new Repo();
        }
        sListener = (DocumentaryHacksDataLoadListener) sContext;
        return instance;
    }

    public MutableLiveData<ArrayList<DocumentaryHackModel>> getData() {

        if (this.data.size() == 0) {
            loadData();
        }

        MutableLiveData<ArrayList<DocumentaryHackModel>> data = new MutableLiveData<>();
        data.setValue(this.data);

        return data;
    }

    private void loadData() {

        DatabaseReference reference = FirebaseDatabase.getInstance("https://uptime--new-default-rtdb.asia-southeast1.firebasedatabase.app/")
                .getReference("DocumentaryHacks");

        reference.keepSynced(true);

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists()) {

                    for (DataSnapshot snapshot1 : snapshot.getChildren()) {

                        DocumentaryHackModel model = snapshot1.getValue(DocumentaryHackModel.class);
                        data.add(model);
                    }

                    sListener.onDocumentaryHacksDataLoaded();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d("key", error.getMessage());
            }
        });
    }
}