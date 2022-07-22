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

import com.onthi.demau2_sqlite.Adapter.AdapterVT;

import java.util.ArrayList;

public class ThemVT extends AppCompatActivity {

    RecyclerView recyclerViewVT;
    Button btnAddVT;
    EditText txtTenVT, txtmotaVT;

    DBHelper myDb;
    com.onthi.demau2_sqlite.Adapter.AdapterVT adapter;
    ArrayList<String> vt_id, tenVT, motaVT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_vt);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Thêm vị trí công việc");

        recyclerViewVT = findViewById(R.id.recyclerViewVT);
        btnAddVT = findViewById(R.id.btnAddVT);
        txtTenVT = findViewById(R.id.txtTenVT);
        txtmotaVT = findViewById(R.id.txtMotaVT);

        myDb = new DBHelper(ThemVT.this);
        btnAddVT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDb.addVT(txtTenVT.getText().toString().trim(), txtmotaVT.getText().toString().trim());
                Intent intent = new Intent(ThemVT.this, ThemVT.class);
                startActivity(intent);
            }
        });

        vt_id = new ArrayList<>();
        tenVT = new ArrayList<>();
        motaVT = new ArrayList<>();

        storeDataInArrays();
        adapter = new AdapterVT(ThemVT.this, this, vt_id, tenVT, motaVT);
        recyclerViewVT.setAdapter(adapter);
        recyclerViewVT.setLayoutManager(new LinearLayoutManager(ThemVT.this));

    }

    private void storeDataInArrays() {
        Cursor cursor = myDb.readAllVtri();
        if (cursor.getCount() != 0){
            while (cursor.moveToNext()){
                vt_id.add(cursor.getString(0));
                tenVT.add(cursor.getString(1));
                motaVT.add(cursor.getString(2));
            }
        }

    }
}