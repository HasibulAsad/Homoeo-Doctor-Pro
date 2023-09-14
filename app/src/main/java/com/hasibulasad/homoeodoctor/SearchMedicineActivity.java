package com.hasibulasad.homoeodoctor;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hasibulasad.homoeodoctor.Adapter.ListProductAdapter;
import com.hasibulasad.homoeodoctor.Adapter.LokkhonRvAdapter;
import com.hasibulasad.homoeodoctor.Models.LokkhonModel;
import com.hasibulasad.homoeodoctor.Models.Product;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class SearchMedicineActivity extends AppCompatActivity {

    private DatabaseHelper mDBHelper;
    private RecyclerView lvProduct;
    private ListProductAdapter adapter;
    private List<Product> mProductList;
    TextView searchmedicinetv;
    ConstraintLayout lokkhonlayout;
    ArrayList<LokkhonModel> lokkonlist;

    LokkhonRvAdapter lokkhonAdapter;
    Spinner gosolspinner, ghamspinner, khabarspinner, pipasaspinner, paikhanaspinner, prosabspinner, manosikotaspinner, srabspinner,
            boisistospinner;
    String[] gosolarray, ghamarray, khabararray, pipasaarray, paikhanaarray, prosabarray, manosikotaarray, srabarray, boisistoarray;
    ArrayAdapter<String> gosoladapter, ghamadapter, khabaradapter, pipasaadapter, paikhanaadapter, prosabadapter, manosikotaadapter, srabadapter,
            boisistoadapter;
    String selectedgosol, selectedgham, selectedkhabar, selectedpipasa, selectedpaikhana, selectedprosab, selectedmanosikota,
            selectedsrab, selectedboisisto;

    Button findmedicinebtn;
    TextView gosoltv, ghamtv;

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
        srabspinner = findViewById(R.id.idsrabspinner);
        boisistospinner = findViewById(R.id.idboisistospinner);
        lokkhonlayout = findViewById(R.id.constraintLayout);
        searchmedicinetv = findViewById(R.id.searchmedicinetv);

        gosoltv = findViewById(R.id.idgosoltv);
        ghamtv = findViewById(R.id.idghamtv);

        findmedicinebtn = findViewById(R.id.idfindmedicinebtn);


        mDBHelper = new DatabaseHelper(this);
        lvProduct = findViewById(R.id.listview_product);
        mDBHelper = new DatabaseHelper(this);

        searchmedicinetv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Animation aniSlide = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_down);
                lokkhonlayout.startAnimation(aniSlide);

                lokkhonlayout.setVisibility(View.VISIBLE);
            }
        });

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


        gosolarray = getResources().getStringArray(R.array.gosol_array);
        ghamarray = getResources().getStringArray(R.array.gham_array);
        khabararray = getResources().getStringArray(R.array.khabar_array);
        pipasaarray = getResources().getStringArray(R.array.pipasa_array);
        paikhanaarray = getResources().getStringArray(R.array.paikhana_array);
        prosabarray = getResources().getStringArray(R.array.prosab_array);
        manosikotaarray = getResources().getStringArray(R.array.manosikota_array);
        srabarray = getResources().getStringArray(R.array.srab_array);
        boisistoarray = getResources().getStringArray(R.array.boisisto_array);


        gosolspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedgosol = adapterView.getSelectedItem().toString();
                if (selectedgosol.equals("সিলেক্ট করুন")) {
                    selectedgosol = "";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        gosoladapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, gosolarray);
        gosolspinner.setAdapter(gosoladapter);


        ghamspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedgham = adapterView.getSelectedItem().toString().trim();
                if (selectedgham.equals("সিলেক্ট করুন")) {
                    selectedgham = "";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        ghamadapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, ghamarray);
        ghamspinner.setAdapter(ghamadapter);


        khabarspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedkhabar = adapterView.getSelectedItem().toString().trim();
                if (selectedkhabar.equals("সিলেক্ট করুন")) {
                    selectedkhabar = "";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        khabaradapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, khabararray);
        khabarspinner.setAdapter(khabaradapter);

        pipasaspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedpipasa = adapterView.getSelectedItem().toString().trim();
                if (selectedpipasa.equals("সিলেক্ট করুন")) {
                    selectedpipasa = "";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        pipasaadapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, pipasaarray);
        pipasaspinner.setAdapter(pipasaadapter);


        paikhanaspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedpaikhana = adapterView.getSelectedItem().toString().trim();
                if (selectedpaikhana.equals("সিলেক্ট করুন")) {
                    selectedpaikhana = "";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        paikhanaadapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, paikhanaarray);
        paikhanaspinner.setAdapter(paikhanaadapter);

        prosabspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedprosab = adapterView.getSelectedItem().toString().trim();
                if (selectedprosab.equals("সিলেক্ট করুন")) {
                    selectedprosab = "";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        prosabadapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, prosabarray);
        prosabspinner.setAdapter(prosabadapter);


        manosikotaspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedmanosikota = adapterView.getSelectedItem().toString().trim();
                if (selectedmanosikota.equals("সিলেক্ট করুন")) {
                    selectedmanosikota = "";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        manosikotaadapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, manosikotaarray);
        manosikotaspinner.setAdapter(manosikotaadapter);

        srabspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedsrab = adapterView.getSelectedItem().toString().trim();
                if (selectedsrab.equals("সিলেক্ট করুন")) {
                    selectedsrab = "";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        srabadapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, srabarray);
        srabspinner.setAdapter(srabadapter);


        boisistospinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedboisisto = adapterView.getSelectedItem().toString().trim();
                if (selectedboisisto.equals("সিলেক্ট করুন")) {
                    selectedboisisto = "";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        boisistoadapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, boisistoarray);
        boisistospinner.setAdapter(boisistoadapter);


        findmedicinebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                lokkhonlayout.setVisibility(View.GONE);
                mProductList = mDBHelper.getListProduct();
                adapter = new ListProductAdapter(getApplicationContext(), mProductList);
                //Set adapter for listview
                lvProduct.setAdapter(adapter);
                lvProduct.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                lvProduct.setHasFixedSize(true);

            }
        });


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


    public class DatabaseHelper extends SQLiteOpenHelper {
        public static final String DBNAME = "HomoeoMedicine.db";
        public static final String DBLOCATION = "/data/data/com.hasibulasad.homoeodoctor/databases/";
        private Context mContext;
        private SQLiteDatabase mDatabase;

        public DatabaseHelper(Context context) {
            super(context, DBNAME, null, 1);
            this.mContext = context;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }

        public void openDatabase() {
            String dbPath = mContext.getDatabasePath(DBNAME).getPath();
            if (mDatabase != null && mDatabase.isOpen()) {
                return;
            }
            mDatabase = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READWRITE);
        }

        public void closeDatabase() {
            if (mDatabase != null) {
                mDatabase.close();
            }
        }

        public List<Product> getListProduct() {
            Product product = null;
            List<Product> productList = new ArrayList<>();
            openDatabase();

            Cursor cursor = mDatabase.rawQuery("SELECT * FROM homoeoMedicine where গোসল like'%" + selectedgosol + "%' " +
                    "and ঘাম like '%" + selectedgham + "%' " +
                    "and খাবার like '%" + selectedkhabar + "%' " +
                    "and পিপাসা like '%" + selectedpipasa + "%' " +
                    "and পায়খানা like '%" + selectedpaikhana + "%'" +
                    "and প্রসাব like '%" + selectedprosab + "%'" +
                    "and মানসিকতা like '%" + selectedmanosikota + "%'" +
                    "and স্রাব like '%" + selectedsrab + "%'" +
                    "and বৈশিষ্ট্য like '%" + selectedboisisto + "%'", null);

//            "SELECT * FROM "+ DB_NAME + " WHERE "
//                    + DB_NAME.id + " = " + DB_NAME.Id + " AND " + DB_NAME.Title +
//                    " LIKE  '"+search.getText()+"%'"

            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                product = new Product(
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6),
                        cursor.getString(7),
                        cursor.getString(8),
                        cursor.getString(9),
                        cursor.getString(10)
                );
                productList.add(product);
                cursor.moveToNext();
            }
            cursor.close();
            closeDatabase();
            return productList;
        }
    }

}