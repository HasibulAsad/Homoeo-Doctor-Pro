package com.hasibulasad.homoeodoctor;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hasibulasad.homoeodoctor.Adapter.SystemRvAdapter;
import com.hasibulasad.homoeodoctor.Models.SystemModel;

import java.util.ArrayList;

public class PhysiologyActivity extends AppCompatActivity {

    RecyclerView physiologyRv;
    ArrayList physiologyitemlist = new ArrayList();
    SystemRvAdapter physiologyadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physiology);

        physiologyRv = findViewById(R.id.physiologyRv);

        physiologyitemlist.add(new SystemModel(1,"Skeletal System"));
        physiologyitemlist.add(new SystemModel(2,"Muscular System"));
        physiologyitemlist.add(new SystemModel(3,"Nervous System"));
        physiologyitemlist.add(new SystemModel(4,"Respiratory System"));
        physiologyitemlist.add(new SystemModel(5,"Cardiovuscular System"));
        physiologyitemlist.add(new SystemModel(6,"Digestive System"));
        physiologyitemlist.add(new SystemModel(7,"Urinary System"));
        physiologyitemlist.add(new SystemModel(8,"Reproductive System"));
        physiologyitemlist.add(new SystemModel(9,"Endocrine System"));
        physiologyitemlist.add(new SystemModel(10,"Integumentary System"));
        physiologyitemlist.add(new SystemModel(11,"Lymphetic System"));

        physiologyadapter = new SystemRvAdapter(this, physiologyitemlist, new SystemRvAdapter.ClickInterface() {
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