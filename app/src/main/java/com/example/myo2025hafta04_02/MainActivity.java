package com.example.myo2025hafta04_02;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.*;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    EditText et;
    Button btn;
    int birinci;
    int ikinci;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tv=(TextView)findViewById(R.id.textView);
        et=(EditText)findViewById(R.id.editTextNumber);
        btn=(Button)findViewById(R.id.button);
        baslat();
        btn.setOnClickListener(v -> {
            int girdi = Integer.parseInt(et.getText().toString());
            if (girdi == (birinci * ikinci)){
                Toast.makeText(this, "Tebrikler", Toast.LENGTH_SHORT).show();
                baslat();
            }else
                Toast.makeText(this, "Tekrar Dene", Toast.LENGTH_SHORT).show();


        });

    }
    public void baslat(){
         birinci= new Random().nextInt(10)+1;
         ikinci= new Random().nextInt(10)+1;
        tv.setText(birinci+" X "+ikinci+" = ?");

    }
}