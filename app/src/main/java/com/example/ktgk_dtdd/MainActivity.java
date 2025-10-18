package com.example.ktgk_dtdd;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnKQ;
    EditText   edtHoTen, edtMSV, edtDTB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        btnKQ = findViewById(R.id.btnKQ);
        edtDTB = findViewById(R.id.edtDTB);
        edtMSV = findViewById(R.id.edtMSV);
        edtHoTen = findViewById(R.id.edtHoTen);
                btnKQ.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String DTBStr = edtDTB.getText().toString();
                        String hoTenStr = edtHoTen.getText().toString();
                        String MSVStr = edtMSV.getText().toString();

                        if(hoTenStr.isEmpty() || MSVStr.isEmpty() || DTBStr.isEmpty()){
                            Toast.makeText(MainActivity.this, "Vui lòng điền đủ thông tin!", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        double DTB = Double.parseDouble(DTBStr);
                        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                        intent.putExtra("HoTen", hoTenStr);
                        intent.putExtra("MSV", MSVStr);
                        intent.putExtra("DTB", DTB);
                        startActivity(intent);
                    }
                });
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
    }
}