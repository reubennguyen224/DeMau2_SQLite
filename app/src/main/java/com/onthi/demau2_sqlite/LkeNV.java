package com.onthi.demau2_sqlite;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import com.onthi.demau2_sqlite.Adapter.Adapter;
import com.onthi.demau2_sqlite.Adapter.Spinner1Adapter;
import com.onthi.demau2_sqlite.Adapter.Spinner3Adapter;
import com.onthi.demau2_sqlite.Model.NhanVien;

import java.util.ArrayList;
import java.util.List;

public class LkeNV extends AppCompatActivity {

    Button btnLke;
    Spinner spNS;
    RecyclerView recyclerViewLke;
    ArrayList<String> nv_id, tenNV, namsinhNV, quequanNV, trinhdoNV;
    DBHelper mydb;
    Spinner3Adapter adapterSp;
    Adapter adapterList;
    List<NhanVien> nhanViens = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lke_nv);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Liệt kê nhân viên");

        btnLke = findViewById(R.id.btnLK);
        spNS = findViewById(R.id.spLKNV);
        recyclerViewLke = findViewById(R.id.recyclerViewLKNV);
        mydb = new DBHelper(LkeNV.this);
        adapterSp = new Spinner3Adapter(LkeNV.this, getNV(), R.id.item_name, R.id.item_id, R.layout.spinner_mode2);

        spNS.setAdapter(adapterSp);
        NhanVien nhanVien = (NhanVien) spNS.getSelectedItem();

        nv_id = new ArrayList<>();
        tenNV = new ArrayList<>();
        namsinhNV = new ArrayList<>();
        quequanNV = new ArrayList<>();
        trinhdoNV = new ArrayList<>();

        storeDataInArrays();
        btnLke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NhanVien nhanVien = (NhanVien) spNS.getSelectedItem();
                //nhanViens.clear();
                //nhanViens = filter(Integer.toString(nhanVien.getNamsinh()));
                storeDataInArrays(Integer.toString(nhanVien.getNamsinh()));
                Intent intent = new Intent(LkeNV.this, LkeNV.class);
                startActivity(intent);
            }
        });




        adapterList = new Adapter(LkeNV.this, this, nv_id, tenNV, namsinhNV, quequanNV, trinhdoNV);
        recyclerViewLke.setAdapter(adapterList);
        recyclerViewLke.setLayoutManager(new LinearLayoutManager(LkeNV.this));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1){
            recreate();
        }
    }

    private void storeDataInArrays(String key) {
        Cursor cursor = mydb.findNV(key);
        if (cursor.getCount() != 0){
            while (cursor.moveToNext()){
                nv_id.add(cursor.getString(0));
                tenNV.add(cursor.getString(1));
                namsinhNV.add(cursor.getString(2));
                quequanNV.add(cursor.getString(3));
                trinhdoNV.add(cursor.getString(4));
            }
        }
    }
    private void storeDataInArrays() {
        Cursor cursor = mydb.readAllData();
        if (cursor.getCount() != 0){
            while (cursor.moveToNext()){
                nv_id.add(cursor.getString(0));
                tenNV.add(cursor.getString(1));
                namsinhNV.add(cursor.getString(2));
                quequanNV.add(cursor.getString(3));
                trinhdoNV.add(cursor.getString(4));
            }
        }
    }

    List<NhanVien> getNV(){

        Cursor cursor = mydb.readAllData();
        if (cursor.getCount() != 0){
            while (cursor.moveToNext()){
                NhanVien nhanVien = new NhanVien(cursor.getInt(0), cursor.getString(1), Integer.parseInt(cursor.getString(2)), cursor.getString(3), cursor.getString(4));
                nhanViens.add(nhanVien);
            }
        }
        return nhanViens;
    }

    List<NhanVien> filter(String key){
        Cursor cursor = mydb.findNV(key);
        if (cursor.getCount() != 0){
            while (cursor.moveToNext()){
                NhanVien nhanVien = new NhanVien(cursor.getInt(0), cursor.getString(1), cursor.getInt(2), cursor.getString(3), cursor.getString(4));
                nhanViens.add(nhanVien);
            }
        }
        return nhanViens;
    }
}