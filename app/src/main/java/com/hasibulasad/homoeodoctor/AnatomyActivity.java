package com.hasibulasad.homoeodoctor;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hasibulasad.homoeodoctor.Adapter.RvAdapter;
import com.hasibulasad.homoeodoctor.Models.SystemModel;

import java.util.ArrayList;

public class AnatomyActivity extends AppCompatActivity {
    RecyclerView anatomyRv;
    ArrayList<SystemModel> systemNameList = new ArrayList<>();
    RvAdapter systemadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anatomy);

        anatomyRv = findViewById(R.id.idanatomyRv);

        systemNameList.add(new SystemModel(1,"Skeletal System","by Hasibul Asad"));
        systemNameList.add(new SystemModel(2,"Muscular System","by Hasibul Asad"));
        systemNameList.add(new SystemModel(3,"Nervous System","by Hasibul Asad"));
        systemNameList.add(new SystemModel(4,"Respiratory System","by Hasibul Asad"));
        systemNameList.add(new SystemModel(5,"Cardiovuscular System","by Hasibul Asad"));
        systemNameList.add(new SystemModel(6,"Digestive System","by Hasibul Asad"));
        systemNameList.add(new SystemModel(7,"Urinary System","by Hasibul Asad"));
        systemNameList.add(new SystemModel(8,"Reproductive System","by Hasibul Asad"));
        systemNameList.add(new SystemModel(9,"Endocrine System","by Hasibul Asad"));
        systemNameList.add(new SystemModel(10,"Integumentary System","by Hasibul Asad"));
        systemNameList.add(new SystemModel(11,"Lymphetic System","by Hasibul Asad"));


        anatomyRv.setLayoutManager(new LinearLayoutManager(this));
        systemadapter = new RvAdapter(this, systemNameList, new RvAdapter.ClickInterface() {
            @Override
            public void itemClickListener(int position) {
                Toast.makeText(AnatomyActivity.this, "Position : "+position, Toast.LENGTH_SHORT).show();
            }
        });
        anatomyRv.setAdapter(systemadapter);
        anatomyRv.setHasFixedSize(true);
    }
}