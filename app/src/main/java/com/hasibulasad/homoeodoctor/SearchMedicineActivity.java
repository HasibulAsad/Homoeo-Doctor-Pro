package com.hasibulasad.homoeodoctor;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.hasibulasad.homoeodoctor.Dbhelper.DatabaseHelper;
import com.hasibulasad.homoeodoctor.Models.LokkhonModel;

import java.util.ArrayList;
import java.util.List;

public class SearchMedicineActivity extends AppCompatActivity {

    private DatabaseHelper mDBHelper;
    private SQLiteDatabase mDatabase;


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

        mDBHelper = new DatabaseHelper(this);


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
    public List<LokkhonModel> getListProduct() {
        LokkhonModel lokkhonModel = null;
        List<LokkhonModel> lokkhonModelArrayList = new ArrayList<>();
        mDBHelper.openDatabase();
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM homoeoMedicine", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            lokkhonModel = new LokkhonModel(
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getString(7),
                    cursor.getString(8),
                    cursor.getString(9)
            );
            lokkhonModelArrayList.add(lokkhonModel);
            cursor.moveToNext();
        }
        cursor.close();
        mDBHelper.closeDatabase();
        return lokkhonModelArrayList;
    }

}