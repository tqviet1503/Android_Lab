package com.example.lab1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etName, etMSSV, etClass, etPhone, etPlan;
    private RadioGroup rgYear, rgMajor;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Khởi tạo các phần tử giao diện
        etName = findViewById(R.id.etName);
        etMSSV = findViewById(R.id.etMSSV);
        etClass = findViewById(R.id.etClass);
        etPhone = findViewById(R.id.etPhone);
        etPlan = findViewById(R.id.etPlan);
        rgYear = findViewById(R.id.rgYear);
        rgMajor = findViewById(R.id.rgMajor);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy dữ liệu từ các trường nhập liệu
                String name = etName.getText().toString();
                String mssv = etMSSV.getText().toString();
                String className = etClass.getText().toString();
                String phone = etPhone.getText().toString();
                String plan = etPlan.getText().toString();

                if (name.isEmpty() || mssv.isEmpty() || className.isEmpty() || phone.isEmpty() || plan.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Vui lòng điền đầy đủ thông tin.", Toast.LENGTH_SHORT).show();
                    return;
                }

                int selectedYearId = rgYear.getCheckedRadioButtonId();
                int selectedMajorId = rgMajor.getCheckedRadioButtonId();

                if (selectedYearId == -1 || selectedMajorId == -1) {
                    Toast.makeText(MainActivity.this, "Vui lòng chọn năm học và chuyên ngành.", Toast.LENGTH_SHORT).show();
                    return;
                }

                RadioButton selectedYear = findViewById(selectedYearId);
                RadioButton selectedMajor = findViewById(selectedMajorId);

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("Name", name);
                intent.putExtra("MSSV", mssv);
                intent.putExtra("Class", className);
                intent.putExtra("Phone", phone);
                intent.putExtra("Year", selectedYear.getText().toString());
                intent.putExtra("Major", selectedMajor.getText().toString());
                intent.putExtra("Plan", plan);
                startActivity(intent);
            }
        });
    }
}
