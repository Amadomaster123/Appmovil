package com.example.appmovil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menuppa extends AppCompatActivity {

    Button btnpar,btnsal,btningfoto,btntuto ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuppa);

        btnsal = (Button) findViewById(R.id.salirmppa);
        btnsal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Registro.class);
                startActivity(intent);
            }
        });
    }
}

