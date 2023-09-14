package com.hasibulasad.homoeodoctor;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hasibulasad.homoeodoctor.Adapter.SystemRvAdapter;
import com.hasibulasad.homoeodoctor.Models.SystemModel;

import java.util.ArrayList;

public class AnatomyActivity extends AppCompatActivity {
    RecyclerView anatomyRv;
    ArrayList<SystemModel> systemNameList = new ArrayList<>();
    SystemRvAdapter systemadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anatomy);

        anatomyRv = findViewById(R.id.idanatomyRv);

        systemNameList.add(new SystemModel(1,"Skeletal System"));
        systemNameList.add(new SystemModel(2,"Muscular System"));
        systemNameList.add(new SystemModel(3,"Nervous System"));
        systemNameList.add(new SystemModel(4,"Respiratory System"));
        systemNameList.add(new SystemModel(5,"Cardiovuscular System"));
        systemNameList.add(new SystemModel(6,"Digestive System"));
        systemNameList.add(new SystemModel(7,"Urinary System"));
        systemNameList.add(new SystemModel(8,"Reproductive System"));
        systemNameList.add(new SystemModel(9,"Endocrine System"));
        systemNameList.add(new SystemModel(10,"Integumentary System"));
        systemNameList.add(new SystemModel(11,"Lymphetic System"));


        anatomyRv.setLayoutManager(new LinearLayoutManager(this));
        systemadapter = new SystemRvAdapter(this, systemNameList, new SystemRvAdapter.ClickInterface() {
            @Override
            public void itemClickListener(int position) {
                Toast.makeText(AnatomyActivity.this, "Position : "+position, Toast.LENGTH_SHORT).show();
            }
        });
        anatomyRv.setAdapter(systemadapter);
        anatomyRv.setHasFixedSize(true);
    }
}