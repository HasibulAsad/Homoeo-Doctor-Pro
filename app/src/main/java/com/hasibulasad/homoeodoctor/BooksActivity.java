package com.hasibulasad.homoeodoctor;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hasibulasad.homoeodoctor.Adapter.RvAdapter;
import com.hasibulasad.homoeodoctor.Models.SystemModel;

import java.util.ArrayList;

public class BooksActivity extends AppCompatActivity {

    RecyclerView homoeonotesRv;
    ArrayList<SystemModel> noteslist = new ArrayList<>();
    RvAdapter notesAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);

        homoeonotesRv = findViewById(R.id.homoeo_notes_rv);

        String [] notesTitle = getResources().getStringArray(R.array.homoeo_notes_title);
        String [] notesDescription = getResources().getStringArray(R.array.homoeo_notes_description);

        for (int i=0;i<notesTitle.length;i++){
            noteslist.add(new SystemModel(i+1,notesTitle[i],notesDescription[i]));
        }



        homoeonotesRv.setLayoutManager(new LinearLayoutManager(this));
        homoeonotesRv.setHasFixedSize(true);
        notesAdapter = new RvAdapter(this, noteslist, new RvAdapter.ClickInterface() {
            @Override
            public void itemClickListener(int position) {

            }
        });
        homoeonotesRv.setAdapter(notesAdapter);


    }
}