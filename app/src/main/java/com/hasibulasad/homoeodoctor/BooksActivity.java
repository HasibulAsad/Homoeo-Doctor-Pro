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

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.hasibulasad.homoeodoctor.Adapter.RvAdapter;
import com.hasibulasad.homoeodoctor.Models.SystemModel;

import java.util.ArrayList;

public class BooksActivity extends AppCompatActivity {

    RecyclerView homoeonotesRv;
    ArrayList<SystemModel> noteslist = new ArrayList<>();
    RvAdapter notesAdapter;
    MaterialToolbar topappbarnotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);

        Window window = BooksActivity.this.getWindow();

// clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

// finally change the color
//        window.setStatusBarColor(ContextCompat.getColor(BooksActivity.this,R.color.goodgrey));

        homoeonotesRv = findViewById(R.id.homoeo_notes_rv);
        topappbarnotes = findViewById(R.id.topAppBarnotes);

       topappbarnotes.setNavigationOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               onBackPressed();
           }
       });

        String[] notesTitle = getResources().getStringArray(R.array.homoeo_notes_title);
        String[] notesDescription = getResources().getStringArray(R.array.homoeo_notes_description);

        for (int i = 0; i < notesTitle.length; i++) {
            noteslist.add(new SystemModel(i + 1, notesTitle[i], notesDescription[i]));
        }


        homoeonotesRv.setLayoutManager(new LinearLayoutManager(this));
        homoeonotesRv.setHasFixedSize(true);
        notesAdapter = new RvAdapter(this, noteslist, new RvAdapter.ClickInterface() {
            @Override
            public void itemClickListener(int position) {

                startActivity(new Intent(BooksActivity.this, DetailsActivity.class)
                        .putExtra("title", noteslist.get(position).getName())
                        .putExtra("description", noteslist.get(position).getDescription()));

            }
        });
        homoeonotesRv.setAdapter(notesAdapter);


    }
}