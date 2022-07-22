package com.onthi.demau2_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnNV, btnVtri, btnNVVT, btnLKNV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNV = findViewById(R.id.btnNV);
        btnVtri = findViewById(R.id.btnVT);
        btnNVVT = findViewById(R.id.btnNVVT);
        btnLKNV = findViewById(R.id.btnLKNV);


        btnNV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ThemNV.class);
                startActivity(intent);
            }
        });

        btnVtri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ThemVT.class);
                startActivity(intent);
            }
        });
        btnNVVT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NVVT.class);
                startActivity(intent);
            }
        });

        btnLKNV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LkeNV.class);
                startActivity(intent);
            }
        });
    }
}