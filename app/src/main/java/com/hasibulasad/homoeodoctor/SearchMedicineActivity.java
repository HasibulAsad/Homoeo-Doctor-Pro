package com.hasibulasad.homoeodoctor;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
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
    ArrayList <LokkhonModel> lokkonlist;

    LokkhonRvAdapter lokkhonAdapter;
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
        lvProduct = findViewById(R.id.listview_product);
        mDBHelper = new DatabaseHelper(this);

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


        gosoladapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,gosolarray);
        gosolspinner.setAdapter(gosoladapter);
        selectedgosol= gosolspinner.getSelectedItem().toString();

        ghamadapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,ghamarray);
        ghamspinner.setAdapter(ghamadapter);
        selectedgham = ghamspinner.getSelectedItem().toString().trim();

        khabaradapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, khabararray);
        khabarspinner.setAdapter(khabaradapter);

        pipasaadapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,pipasaarray);
        pipasaspinner.setAdapter(pipasaadapter);



        findmedicinebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mProductList = mDBHelper.getListProduct();
                //Init adapter
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
            if(mDatabase != null && mDatabase.isOpen()) {
                return;
            }
            mDatabase = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READWRITE);
        }

        public void closeDatabase() {
            if(mDatabase!=null) {
                mDatabase.close();
            }
        }

        public List<Product> getListProduct() {
            Product product = null;
            List<Product> productList = new ArrayList<>();
            openDatabase();
            Cursor cursor = mDatabase.rawQuery("SELECT * FROM homoeoMedicine where ঘাম like '"+selectedgham+"' ", null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                product = new Product(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
                productList.add(product);
                cursor.moveToNext();
            }
            cursor.close();
            closeDatabase();
            return productList;
        }
    }

}