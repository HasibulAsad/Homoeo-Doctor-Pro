package com.hasibulasad.homoeodoctor;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.hasibulasad.homoeodoctor.Adapter.RvAdapter;
import com.hasibulasad.homoeodoctor.Models.SystemModel;

import java.util.ArrayList;

public class AnatomyActivity extends AppCompatActivity {
    RecyclerView anatomyRv;
    ArrayList<SystemModel> systemNameList = new ArrayList<>();
    RvAdapter systemadapter;
    AppBarLayout appBarLayout;
    MaterialToolbar toolbaranatomy;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anatomy);

        Window window = AnatomyActivity.this.getWindow();

// clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

// finally change the color
//        window.setStatusBarColor(ContextCompat.getColor(AnatomyActivity.this, R.color.goodgrey));

        anatomyRv = findViewById(R.id.idanatomyRv);
        appBarLayout = findViewById(R.id.appBarLayout);
        toolbaranatomy = findViewById(R.id.toolbaranatomy);

        toolbaranatomy.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        appBarLayout.setStatusBarForegroundColor(
                MaterialColors.getColor(appBarLayout, R.attr.colorSurface));

        systemNameList.add(new SystemModel(1, "What is Anatomy", getResources().getString(R.string.what_is_anatomy)));
        systemNameList.add(new SystemModel(1, "Skeletal System", getResources().getString(R.string.Skeletal_anatomy_text)));
        systemNameList.add(new SystemModel(2, "Muscular System", getResources().getString(R.string.Muscular_anatomy_text)));
        systemNameList.add(new SystemModel(3, "Nervous System", getResources().getString(R.string.Nervous_anatomy_text)));
        systemNameList.add(new SystemModel(4, "Respiratory System", getResources().getString(R.string.Respiratory_anatomy_text)));
        systemNameList.add(new SystemModel(5, "Cardiovuscular System", getResources().getString(R.string.Cardiovascular_anatomy_text)));
        systemNameList.add(new SystemModel(6, "Digestive System", getResources().getString(R.string.Digestive_anatomy_text)));
        systemNameList.add(new SystemModel(7, "Urinary System", getResources().getString(R.string.Urinary_anatomy_text)));
        systemNameList.add(new SystemModel(8, "Reproductive System", getResources().getString(R.string.Reproductive_anatomy_text)));
        systemNameList.add(new SystemModel(9, "Endocrine System", getResources().getString(R.string.Endocrine_anatomy_text)));
        systemNameList.add(new SystemModel(10, "Integumentary System", getResources().getString(R.string.Exocrine_anatomy_text)));
        systemNameList.add(new SystemModel(11, "Lymphetic System", getResources().getString(R.string.Lymphatic_anatomy_text)));


        anatomyRv.setLayoutManager(new LinearLayoutManager(this));
        systemadapter = new RvAdapter(this, systemNameList, new RvAdapter.ClickInterface() {
            @Override
            public void itemClickListener(int position) {
                startActivity(new Intent(AnatomyActivity.this, DetailsActivity.class)
                        .putExtra("title", systemNameList.get(position).getName())
                        .putExtra("description", systemNameList.get(position).getDescription()));
            }
        });
        anatomyRv.setAdapter(systemadapter);
        anatomyRv.setHasFixedSize(true);
    }
}