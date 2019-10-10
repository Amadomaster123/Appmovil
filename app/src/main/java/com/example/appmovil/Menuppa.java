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
        btnpar = (Button) findViewById(R.id.parlante);
        btnpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Parlante.class);
                startActivity(intent);
            }
        });

        btnsal = (Button) findViewById(R.id.salirmppa);
        btnsal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Registro.class);
                startActivity(intent);
            }
        });
        btningfoto = (Button) findViewById(R.id.btnfoto);
        btningfoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Foto.class);
                startActivity(intent);
            }
        });

        btntuto = (Button) findViewById(R.id.Tuto);
        btntuto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Tutorial.class);
                startActivity(intent);

            }
        });
    }
}

