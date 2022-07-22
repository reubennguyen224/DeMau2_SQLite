package com.onthi.demau2_sqlite;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.onthi.demau2_sqlite.Adapter.*;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ThemNV extends AppCompatActivity {
    RecyclerView recyclerView;
    Button btnAddNV;
    EditText txtTenNV, txtNamsinh, txtTrinhdo, txtQuequan;

    DBHelper myDb;
    com.onthi.demau2_sqlite.Adapter.Adapter adapter;
    ArrayList<String> nv_id, tenNV, namsinhNV, quequanNV, trinhdoNV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_nv);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Thêm nhân viên");

        recyclerView = findViewById(R.id.recyclerViewNV);
        btnAddNV = findViewById(R.id.button);
        txtTenNV = findViewById(R.id.txtTenNV);
        txtNamsinh = findViewById(R.id.txtNamsinh);
        txtTrinhdo = findViewById(R.id.txtTrinhdo);
        txtQuequan = findViewById(R.id.txtQuaQuan);
        myDb = new DBHelper(ThemNV.this);

        btnAddNV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myDb.addNV(txtTenNV.getText().toString().trim(), Integer.parseInt(txtNamsinh.getText().toString().trim()),
                        txtQuequan.getText().toString().trim(), txtTrinhdo.getText().toString().trim());
                Intent intent = new Intent(ThemNV.this, ThemNV.class);
                startActivity(intent);
            }
        });

        nv_id = new ArrayList<>();
        tenNV = new ArrayList<>();
        namsinhNV = new ArrayList<>();
        quequanNV = new ArrayList<>();
        trinhdoNV = new ArrayList<>();

        storeDataInArrays();
        adapter = new Adapter(ThemNV.this, this, nv_id, tenNV, namsinhNV, quequanNV, trinhdoNV);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(ThemNV.this));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1){
            recreate();
        }
    }

    private void storeDataInArrays() {
        Cursor cursor = myDb.readAllData();
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
}