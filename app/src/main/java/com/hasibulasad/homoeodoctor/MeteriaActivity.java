package com.hasibulasad.homoeodoctor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.MaterialToolbar;
import com.hasibulasad.homoeodoctor.Adapter.RvAdapter;
import com.hasibulasad.homoeodoctor.Models.SystemModel;

import java.util.ArrayList;

public class MeteriaActivity extends AppCompatActivity {
MaterialToolbar topappbarmateria;
RecyclerView materiaRv;
ArrayList<SystemModel> materialist = new ArrayList<>();
RvAdapter materiaAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meteria);

        topappbarmateria = findViewById(R.id.topAppBarmateria);
        materiaRv = findViewById(R.id.materiaRv);


        setupStatusbarColor();

        String [] medicinenamelist = getResources().getStringArray(R.array.medicine_name_list);
        String [] medicinedescriptionlist = getResources().getStringArray(R.array.medicine_description_list);


        materiaAdapter = new RvAdapter(this, materialist, new RvAdapter.ClickInterface() {
            @Override
            public void itemClickListener(int position) {
                startActivity(new Intent(MeteriaActivity.this, DetailsActivity.class)
                        .putExtra("title", materialist.get(position).getName())
                        .putExtra("description", materialist.get(position).getDescription()));
            }
        });

        topappbarmateria.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        for (int i = 0; i < medicinenamelist.length; i++) {
            materialist.add(new SystemModel(i + 1, medicinenamelist[i], medicinedescriptionlist[i]));
        }

        materiaRv.setHasFixedSize(true);
        materiaRv.setAdapter(materiaAdapter);
        materiaRv.setLayoutManager(new LinearLayoutManager(this));



    }

    public void setupStatusbarColor(){

        Window window = MeteriaActivity.this.getWindow();

// clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

// finally change the color
//        window.setStatusBarColor(ContextCompat.getColor(MeteriaActivity.this,R.color.goodgrey));
    }

}