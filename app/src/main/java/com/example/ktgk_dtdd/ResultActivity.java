package com.example.ktgk_dtdd;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {
    Button btnBack;
    TextView tvKQ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);

        btnBack = findViewById(R.id.btnBack);
        tvKQ = findViewById(R.id.tvKQ);

        Intent intent = getIntent();
        String hoTen = getIntent().getStringExtra("hoTen");
        String MSV = getIntent().getStringExtra("MSV");
        double DTB = getIntent().getDoubleExtra("DTB", 0);
        String hocLuc;
        if(DTB >= 8.5) hocLuc = "Giỏi";
        else if(DTB >=6.5) hocLuc = "Khá";
        else if(DTB >= 5.0) hocLuc = "Trung bình";
        else hocLuc = "Yếu";
        tvKQ.setText("Họ tên: " + hoTen + "\nMSV: "+ MSV
            +"\nĐiểm trung bình: " + DTB
            +"\nHọc lực: " +hocLuc);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResultActivity.this, MainActivity.class));
            }
        });
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
    }
}