package com.example.appmovil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Parlante extends AppCompatActivity {
    Button sal_par ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parlante);
        sal_par = (Button) findViewById(R.id.sal_parlante);
        sal_par.setOnClickListener(new View.OnClickListener() {

            public void onClick  (View v) {
                Intent intent = new Intent(getApplicationContext(), prueba.class);
                startActivity(intent);

            }
        });



    }
}
