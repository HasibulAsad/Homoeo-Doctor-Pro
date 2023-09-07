package com.hasibulasad.homoeodoctor;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SearchMedicineActivity extends AppCompatActivity {

    Spinner gosolspinner, ghamspinner, khabarspinner, pipasaspinner, paikhanaspinner, prosabspinner, manosikotaspinner, srabspinner,
            boisistospinner;
    String [] gosolarray, ghamarray, khabararray, pipasaarray, paikhanaarray, prosabarray, manosikotaarray, srabarray, boisistoarray;
    ArrayAdapter<String> gosoladapter, ghamadapter, khabaradapter, pipasaadapter, paikhanaadapter, prosabadapter, manosikotaadapter, srabadapter,
            boisistoadapter;
    String selectedgosol, selectedgham, selectedkhabar, selectedpipasa, selectedpaikhana, selectedprosab, selectedmanosikota,
            selectedsrab, selectecboisisto;

    Button findmedicinebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_medicine);

        gosolspinner = findViewById(R.id.idgosolspinner);
        ghamspinner = findViewById(R.id.idghamspinner);
        khabarspinner = findViewById(R.id.idkhabarspinner);
        pipasaspinner = findViewById(R.id.idpipasaspinner);
        paikhanaspinner = findViewById(R.id.idpaikhanaspinner);
        prosabspinner = findViewById(R.id.idprosabspinner);
        manosikotaspinner = findViewById(R.id.idmanosikotaspinner);
        srabspinner = findViewById(R.id.idmanosikotaspinner);
        boisistospinner = findViewById(R.id.idboisistospinner);

        findmedicinebtn = findViewById(R.id.idfindmedicinebtn);


        gosolarray = getResources().getStringArray(R.array.gosol_array);
        ghamarray = getResources().getStringArray(R.array.gham_array);
        khabararray = getResources().getStringArray(R.array.khabar_array);
        pipasaarray = getResources().getStringArray(R.array.pipasa_array);
        paikhanaarray = getResources().getStringArray(R.array.paikhana_array);


        gosoladapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,gosolarray);
        gosolspinner.setAdapter(gosoladapter);

        ghamadapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,ghamarray);
        ghamspinner.setAdapter(ghamadapter);

        khabaradapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, khabararray);
        khabarspinner.setAdapter(khabaradapter);

        pipasaadapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,pipasaarray);
        pipasaspinner.setAdapter(pipasaadapter);


        findmedicinebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



            }
        });



    }
}