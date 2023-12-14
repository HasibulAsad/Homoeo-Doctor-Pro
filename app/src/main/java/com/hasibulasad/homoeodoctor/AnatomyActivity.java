package com.hasibulasad.homoeodoctor;

import android.annotation.SuppressLint;
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

        systemNameList.add(new SystemModel(1, "Skeletal System", "by Hasibul Asad"));
        systemNameList.add(new SystemModel(2, "Muscular System", "by Hasibul Asad"));
        systemNameList.add(new SystemModel(3, "Nervous System", "by Hasibul Asad"));
        systemNameList.add(new SystemModel(4, "Respiratory System", "by Hasibul Asad"));
        systemNameList.add(new SystemModel(5, "Cardiovuscular System", "by Hasibul Asad"));
        systemNameList.add(new SystemModel(6, "Digestive System", "by Hasibul Asad"));
        systemNameList.add(new SystemModel(7, "Urinary System", "by Hasibul Asad"));
        systemNameList.add(new SystemModel(8, "Reproductive System", "by Hasibul Asad"));
        systemNameList.add(new SystemModel(9, "Endocrine System", "by Hasibul Asad"));
        systemNameList.add(new SystemModel(10, "Integumentary System", "by Hasibul Asad"));
        systemNameList.add(new SystemModel(11, "Lymphetic System", "by Hasibul Asad"));


        anatomyRv.setLayoutManager(new LinearLayoutManager(this));
        systemadapter = new RvAdapter(this, systemNameList, new RvAdapter.ClickInterface() {
            @Override
            public void itemClickListener(int position) {
                Toast.makeText(AnatomyActivity.this, "Position : " + position, Toast.LENGTH_SHORT).show();
            }
        });
        anatomyRv.setAdapter(systemadapter);
        anatomyRv.setHasFixedSize(true);
    }
}