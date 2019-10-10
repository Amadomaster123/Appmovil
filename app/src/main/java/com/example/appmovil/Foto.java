package com.example.appmovil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Foto extends AppCompatActivity {
    Button btnsalfoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foto);
        btnsalfoto =(Button)findViewById(R.id.btnsalcam);
        btnsalfoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Menuppa.class);
                startActivity(intent);
            }
        });
    }
}
