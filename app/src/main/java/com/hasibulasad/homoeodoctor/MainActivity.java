package com.hasibulasad.homoeodoctor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.hasibulasad.homoeodoctor.Dbhelper.DatabaseHelper;

import org.imaginativeworld.whynotimagecarousel.ImageCarousel;
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DatabaseHelper mDBHelper;
    ImageCarousel carousel;
    CardView searchcard, bookscard, anatomycard, physiologycard, repartorycard, meteriacard, finddoctorcard, aboutmecard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mDBHelper = new DatabaseHelper(this);

        carousel = findViewById(R.id.carousel);
        searchcard = findViewById(R.id.searchmedicinecard);
        bookscard = findViewById(R.id.bookscard);
        anatomycard = findViewById(R.id.anatomycard);
        physiologycard = findViewById(R.id.physiologycard);
        repartorycard = findViewById(R.id.repartorycard);
        meteriacard = findViewById(R.id.meteriacard);
        finddoctorcard = findViewById(R.id.finddoctorcard);
        aboutmecard = findViewById(R.id.aboutmecard);

        File database = getApplicationContext().getDatabasePath(DatabaseHelper.DBNAME);
        if (false == database.exists()) {
            mDBHelper.getReadableDatabase();
            //Copy db
            if (copyDatabase(this)) {
                Toast.makeText(this, "Copy database succes", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Copy data error", Toast.LENGTH_SHORT).show();
                return;
            }
        } //Get product list in db when db exists

        searchcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SearchMedicineActivity.class));
            }
        });
        bookscard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, BooksActivity.class));
            }
        });
        anatomycard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AnatomyActivity.class));
            }
        });
        physiologycard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PhysiologyActivity.class));
            }
        });
        repartorycard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RepartoryActivity.class));
            }
        });
        meteriacard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MeteriaActivity.class));
            }
        });
        finddoctorcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, FindDoctorActivity.class));
            }
        });
        aboutmecard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AboutMeActivity.class));
            }
        });


        List<CarouselItem> list = new ArrayList<>();

        list.add(new CarouselItem("https://www.hmbup.in/site/writereaddata/HomePage/Header/H_202305021805165120.jpg", "Medicine Sample"));
        list.add(new CarouselItem("https://post.healthline.com/wp-content/uploads/2020/08/Chamomile_and_Homeopathic_Medicine-1200x628-facebook-1200x628.jpg", "Its very useful."));
        list.add(new CarouselItem("https://assets.lybrate.com/q_auto,f_auto,w_1200/eagle/uploads/6e67eaf22dedfbabc6fa671cd0584385/7c91bf.jpg", "Homoeopathic Medicine"));
        list.add(new CarouselItem("https://cdn.britannica.com/07/192107-050-CE043374/anatomy-charts-human-body-muscle-systems-skeletal.jpg?w=400&h=225&c=crop", "Anatomy and Physiology"));
        list.add(new CarouselItem("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTbC6iX5uVvExeBhmoLRXsor3X8C5LZi-sQ2w&usqp=CAU", "Homoeo Doctor"));

        carousel.setData(list);


    }
    private boolean copyDatabase(Context context) {
        try {

            InputStream inputStream = context.getAssets().open(DatabaseHelper.DBNAME);
            String outFileName = DatabaseHelper.DBLOCATION + DatabaseHelper.DBNAME;
            OutputStream outputStream = new FileOutputStream(outFileName);
            byte[] buff = new byte[1024];
            int length = 0;
            while ((length = inputStream.read(buff)) > 0) {
                outputStream.write(buff, 0, length);
            }
            outputStream.flush();
            outputStream.close();
            Log.w("MainActivity", "DB copied");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}