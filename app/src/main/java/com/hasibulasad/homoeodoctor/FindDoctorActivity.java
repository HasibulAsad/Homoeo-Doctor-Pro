package com.hasibulasad.homoeodoctor;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.MaterialToolbar;
import com.hasibulasad.homoeodoctor.Adapter.FindDoctorAdapter;
import com.hasibulasad.homoeodoctor.Models.DoctorListModel;

import java.util.ArrayList;

public class FindDoctorActivity extends AppCompatActivity {
MaterialToolbar topAppBarDoctor;
RecyclerView findDoctorRV;
FindDoctorAdapter doctorAdapter;
ArrayList<DoctorListModel> doctorList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);

        Window window = FindDoctorActivity.this.getWindow();
        topAppBarDoctor = findViewById(R.id.topAppBarDoctor);
        findDoctorRV = findViewById(R.id.findDoctorRv);
        doctorAdapter = new FindDoctorAdapter(this, doctorList, new FindDoctorAdapter.ClickInterface() {
            @Override
            public void itemClickListener(int position) {

            }
        });
        topAppBarDoctor.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

// clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

// finally change the color
//        window.setStatusBarColor(ContextCompat.getColor(FindDoctorActivity.this,R.color.goodgrey));


        doctorList.add(new DoctorListModel(R.drawable.person1,"Hasibul Asad", "L.H.M.P(Khulna),D.H.M.S(Incourse)","Kadirgong, Rajshahi","01799813508"));
        doctorList.add(new DoctorListModel(R.drawable.person2,"Jayedi Hasan", "L.H.M.P(Khulna),D.H.M.S(Incourse)","Kadirgong, Rajshahi","01799813508"));
        doctorList.add(new DoctorListModel(R.drawable.person3,"Rasikhul Alim", "L.H.M.P(Khulna),D.H.M.S(Incourse)","Kadirgong, Rajshahi","01799813508"));
        doctorList.add(new DoctorListModel(R.drawable.person1,"Rafidul Alim", "L.H.M.P(Khulna),D.H.M.S(Incourse)","Kadirgong, Rajshahi","01799813508"));
        doctorList.add(new DoctorListModel(R.drawable.person3,"Rizuanul Alim", "L.H.M.P(Khulna),D.H.M.S(Incourse)","Kadirgong, Rajshahi","01799813508"));
        doctorList.add(new DoctorListModel(R.drawable.person2,"Rahbarul Alim", "L.H.M.P(Khulna),D.H.M.S(Incourse)","Kadirgong, Rajshahi","01799813508"));
        doctorList.add(new DoctorListModel(R.drawable.person3,"Suraiya Tarannum", "L.H.M.P(Khulna),D.H.M.S(Incourse)","Kadirgong, Rajshahi","01799813508"));
        doctorList.add(new DoctorListModel(R.drawable.person2,"Halima Sadia", "L.H.M.P(Khulna),D.H.M.S(Incourse)","Kadirgong, Rajshahi","01799813508"));
        doctorList.add(new DoctorListModel(R.drawable.person1,"Hasin Bokhtier", "L.H.M.P(Khulna),D.H.M.S(Incourse)","Kadirgong, Rajshahi","01799813508"));
        doctorList.add(new DoctorListModel(R.drawable.person2,"Hasan Shahrier", "L.H.M.P(Khulna),D.H.M.S(Incourse)","Kadirgong, Rajshahi","01799813508"));
        doctorList.add(new DoctorListModel(R.drawable.person3,"Hafsa khatun", "L.H.M.P(Khulna),D.H.M.S(Incourse)","Kadirgong, Rajshahi","01799813508"));
        doctorList.add(new DoctorListModel(R.drawable.person1,"Hazra hamida", "L.H.M.P(Khulna),D.H.M.S(Incourse)","Kadirgong, Rajshahi","01799813508"));


        findDoctorRV.setAdapter(doctorAdapter);
        findDoctorRV.setLayoutManager(new LinearLayoutManager(this));
        findDoctorRV.setHasFixedSize(true);



    }
}