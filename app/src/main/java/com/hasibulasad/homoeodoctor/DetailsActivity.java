package com.hasibulasad.homoeodoctor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    TextView titletv, descriptionTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Window window = DetailsActivity.this.getWindow();

// clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

// finally change the color
        window.setStatusBarColor(ContextCompat.getColor(DetailsActivity.this,R.color.grey));



        titletv = findViewById(R.id.idDetailsTitle);
        descriptionTv = findViewById(R.id.idDetailsDescription);

        String title = getIntent().getStringExtra("title");
        String description = getIntent().getStringExtra("description");

        titletv.setText(title);
        descriptionTv.setText(description);

    }
}