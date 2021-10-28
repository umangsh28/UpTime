package com.pns.uptimeapp.coursehack.repository;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.pns.uptimeapp.coursehack.interfaces.CourseHacksDataLoadListener;
import com.pns.uptimeapp.coursehack.model.CourseHackModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Repo {

    @SuppressLint("StaticFieldLeak")
    static Repo instance;
    private final ArrayList<CourseHackModel> data = new ArrayList<>();

    @SuppressLint("StaticFieldLeak")
    static Context sContext;
    static CourseHacksDataLoadListener sListener;

    public static Repo getInstance(Context context) {

        sContext = context;
        if (instance == null) {
            instance = new Repo();
        }
        sListener = (CourseHacksDataLoadListener) sContext;
        return instance;
    }

    public MutableLiveData<ArrayList<CourseHackModel>> getData() {

        if (this.data.size() == 0) {
            loadData();
        }

        MutableLiveData<ArrayList<CourseHackModel>> data = new MutableLiveData<>();
        data.setValue(this.data);

        return data;
    }

    private void loadData() {

        DatabaseReference reference = FirebaseDatabase.getInstance("https://uptime--new-default-rtdb.asia-southeast1.firebasedatabase.app/")
                .getReference("CourseHacks");

        reference.keepSynced(true);

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists()) {

                    for (DataSnapshot snapshot1 : snapshot.getChildren()) {

                        CourseHackModel model = snapshot1.getValue(CourseHackModel.class);
                        data.add(model);
                    }

                    sListener.onCourseHacksDataLoaded();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d("key", error.getMessage());
            }
        });
    }
}