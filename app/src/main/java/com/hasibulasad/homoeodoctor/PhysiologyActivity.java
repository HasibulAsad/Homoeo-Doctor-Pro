package com.hasibulasad.homoeodoctor;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hasibulasad.homoeodoctor.Adapter.RvAdapter;
import com.hasibulasad.homoeodoctor.Models.SystemModel;

import java.util.ArrayList;

public class PhysiologyActivity extends AppCompatActivity {

    RecyclerView physiologyRv;
    ArrayList physiologyitemlist = new ArrayList();
    RvAdapter physiologyadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physiology);

        physiologyRv = findViewById(R.id.physiologyRv);

        physiologyitemlist.add(new SystemModel(1,"Skeletal System","by Hasibul Asad"));
        physiologyitemlist.add(new SystemModel(2,"Muscular System","by Hasibul Asad"));
        physiologyitemlist.add(new SystemModel(3,"Nervous System","by Hasibul Asad"));
        physiologyitemlist.add(new SystemModel(4,"Respiratory System","by Hasibul Asad"));
        physiologyitemlist.add(new SystemModel(5,"Cardiovuscular System","by Hasibul Asad"));
        physiologyitemlist.add(new SystemModel(6,"Digestive System","by Hasibul Asad"));
        physiologyitemlist.add(new SystemModel(7,"Urinary System","by Hasibul Asad"));
        physiologyitemlist.add(new SystemModel(8,"Reproductive System","by Hasibul Asad"));
        physiologyitemlist.add(new SystemModel(9,"Endocrine System","by Hasibul Asad"));
        physiologyitemlist.add(new SystemModel(10,"Integumentary System","by Hasibul Asad"));
        physiologyitemlist.add(new SystemModel(11,"Lymphetic System","by Hasibul Asad"));

        physiologyadapter = new RvAdapter(this, physiologyitemlist, new RvAdapter.ClickInterface() {
            @Override
            public void itemClickListener(int position) {
                Toast.makeText(PhysiologyActivity.this, "Position : "+position, Toast.LENGTH_SHORT).show();
            }
        });
        physiologyRv.setAdapter(physiologyadapter);
        physiologyRv.setLayoutManager(new LinearLayoutManager(this));
        physiologyRv.setHasFixedSize(true);


    }
}