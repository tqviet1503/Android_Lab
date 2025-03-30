package com.example.lab1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String name = intent.getStringExtra("Name");
        String mssv = intent.getStringExtra("MSSV");
        String className = intent.getStringExtra("Class");
        String phone = intent.getStringExtra("Phone");
        String year = intent.getStringExtra("Year");
        String major = intent.getStringExtra("Major");
        String plan = intent.getStringExtra("Plan");

        TextView tvName = findViewById(R.id.tvName);
        tvName.setText("Họ tên: " + name);
        TextView tvMSSV = findViewById(R.id.tvMSSV);
        tvMSSV.setText("MSSV: " + mssv);
        TextView tvClass = findViewById(R.id.tvClass);
        tvClass.setText("Lớp: " + className);
        TextView tvPhone = findViewById(R.id.tvPhone);
        tvPhone.setText("Số điện thoại: " + phone);
        TextView tvYear = findViewById(R.id.tvYear);
        tvYear.setText("Sinh viên năm: " + year);
        TextView tvMajor = findViewById(R.id.tvMajor);
        tvMajor.setText("Chuyên ngành: " + major);
        TextView tvPlan = findViewById(R.id.tvPlan);
        tvPlan.setText(plan);

        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(backIntent);
                finish();
            }
        });
    }
}
