package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.weatherapp.models.DaysTempModels;
import com.example.weatherapp.presentation.adapters.DaysTempAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private DaysTempAdapter adapter;
    private ArrayList<DaysTempModels> card = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createRecView();

    }

    private void createRecView() {
        RecyclerView recyclerView = findViewById(R.id.rec_view_day_temp_state);
        adapter = new DaysTempAdapter(card);
        recyclerView.setAdapter(adapter);

    }
}