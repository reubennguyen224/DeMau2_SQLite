package com.onthi.demau2_sqlite;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.onthi.demau2_sqlite.Adapter.AdapterNVVT;
import com.onthi.demau2_sqlite.Adapter.Spinner1Adapter;
import com.onthi.demau2_sqlite.Adapter.Spinner2Adapter;
import com.onthi.demau2_sqlite.Model.NhanVien;
import com.onthi.demau2_sqlite.Model.ViTri;

import java.util.ArrayList;
import java.util.List;

public class NVVT extends AppCompatActivity {

    Button btnGan;
    EditText txtTgian, txtMta;
    Spinner spNV, spVT;
    Spinner1Adapter adapter1;
    Spinner2Adapter adapter2;
    RecyclerView recyclerViewNVVT;

    DBHelper myDb;
    AdapterNVVT adapterNVVT;
    List<NhanVien> nhanViens = new ArrayList<>();
    List<ViTri> viTris = new ArrayList<>();
    ArrayList<String> nvvt_id, tgian, mta, idNV, idVT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nvvt);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Gán nhân viên vào vị trí");

        recyclerViewNVVT = findViewById(R.id.recyclerViewNVVT);
        btnGan = findViewById(R.id.btnGan);
        txtTgian = findViewById(R.id.txtTgian);
        txtMta = findViewById(R.id.txtMta);
        spNV = findViewById(R.id.spNV);
        spVT = findViewById(R.id.spVT);

        adapter1 = new Spinner1Adapter(NVVT.this, getNV(), R.id.item_name, R.id.item_id, R.layout.spinner_mode2);
        adapter2 = new Spinner2Adapter(NVVT.this, getVT(), R.id.item_name, R.id.item_id, R.layout.spinner_mode);

        spNV.setAdapter(adapter1);
        spVT.setAdapter(adapter2);

        myDb = new DBHelper(NVVT.this);
        btnGan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NhanVien nhanVien = (NhanVien) spNV.getSelectedItem();
                ViTri viTri = (ViTri) spVT.getSelectedItem();
                myDb.addNVVT(nhanVien.getMaNV(), viTri.getMaVT(), txtTgian.getText().toString().trim(), txtMta.getText().toString().trim());
                Intent intent = new Intent(NVVT.this, NVVT.class);
                startActivity(intent);
            }
        });

        nvvt_id = new ArrayList<>();
        tgian = new ArrayList<>();
        idNV = new ArrayList<>();
        idVT = new ArrayList<>();
        mta = new ArrayList<>();

        storeDataInArrays();
        adapterNVVT = new AdapterNVVT(NVVT.this, this, nvvt_id, idNV, idVT, tgian, mta);
        recyclerViewNVVT.setAdapter(adapterNVVT);
        recyclerViewNVVT.setLayoutManager(new LinearLayoutManager(NVVT.this));
    }

    private void storeDataInArrays() {
        Cursor cursor = myDb.readAllNVVT();
        if (cursor.getCount() != 0){
            while (cursor.moveToNext()){
                nvvt_id.add(cursor.getString(0));
                idNV.add(cursor.getString(1));
                idVT.add(cursor.getString(2));
                tgian.add(cursor.getString(3));
                mta.add(cursor.getString(4));
            }
        }

    }

    List<NhanVien> getNV(){

        myDb = new DBHelper(NVVT.this);
        Cursor cursor = myDb.readAllData();
        if (cursor.getCount() != 0){
            while (cursor.moveToNext()){
                NhanVien nhanVien = new NhanVien(cursor.getInt(0), cursor.getString(1));
                nhanViens.add(nhanVien);
            }
        }
        return nhanViens;
    }

    List<ViTri> getVT(){
        viTris.clear();
        myDb = new DBHelper(NVVT.this);
        Cursor cursor = myDb.readAllVtri();
        if (cursor.getCount() != 0){
            while (cursor.moveToNext()){
                ViTri viTri = new ViTri(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
                viTris.add(viTri);
            }
        }
        return viTris;
    }
}