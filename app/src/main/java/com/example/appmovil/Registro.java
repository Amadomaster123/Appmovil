package com.example.appmovil;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class Registro extends AppCompatActivity implements View.OnClickListener {



    private EditText Textcorreo;
    private EditText Textcontra;
    private Button btnregis,btnlogin;
    private ProgressDialog progressDialog;

    //objeto
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        firebaseAuth = FirebaseAuth.getInstance();
        Textcorreo=(EditText)findViewById(R.id.correo);
        Textcontra=(EditText)findViewById(R.id.password);
        btnregis=(Button)findViewById(R.id.btnregistro);
        btnlogin=(Button)findViewById(R.id.btnlogear);
        progressDialog = new ProgressDialog(this);
        btnregis.setOnClickListener(this);
        btnlogin.setOnClickListener(this);





    }

    private  void registrarusers(){
        String corr=Textcorreo.getText().toString().trim();
        String pass=Textcontra.getText().toString().trim();

        //Verificamos que las cajas de texto no esten vacías
        if(TextUtils.isEmpty(corr)){
            Toast.makeText(this,"Se debe ingresar un email",Toast.LENGTH_LONG).show();
            return;
        }


        if(TextUtils.isEmpty(pass)){
            Toast.makeText(this,"Falta ingresar la contraseña",Toast.LENGTH_LONG).show();
            return;
        }

        progressDialog.setMessage("Realizando registro en linea...");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(corr, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>(){
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success
                        if(task.isSuccessful()){

                            Toast.makeText(Registro.this,"Se ha registrado el usuario con el email: "+ Textcorreo.getText(),Toast.LENGTH_LONG).show();


                        }else{
                                if (task.getException() instanceof FirebaseAuthUserCollisionException){
                                    Toast.makeText(Registro.this,"Ese usuario ya existe ",Toast.LENGTH_LONG).show();
                                }
                                else{
                                    Toast.makeText(Registro.this,"No se pudo registrar el usuario ",Toast.LENGTH_LONG).show();
                                }

                        }
                    }
                });

    }

    private void loguser(){
            String corr=Textcorreo.getText().toString().trim();
            String pass=Textcontra.getText().toString().trim();

            //Verificamos que las cajas de texto no esten vacías
            if(TextUtils.isEmpty(corr)){
                Toast.makeText(this,"Se debe ingresar un email",Toast.LENGTH_LONG).show();
                return;
            }


            if(TextUtils.isEmpty(pass)){
                Toast.makeText(this,"Falta ingresar la contraseña",Toast.LENGTH_LONG).show();
                return;
            }

            progressDialog.setMessage("Realizando registro en linea...");
            progressDialog.show();

            firebaseAuth.signInWithEmailAndPassword(corr, pass)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>(){
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            //checking if success
                            if(task.isSuccessful()){

                                Toast.makeText(Registro.this,"Bienvenido : "+ Textcorreo.getText(),Toast.LENGTH_LONG).show();
                               Intent intent = new Intent(getApplicationContext(),Menuppa.class);
                               startActivity(intent);

                            }else{
                                if (task.getException() instanceof FirebaseAuthUserCollisionException){
                                    Toast.makeText(Registro.this,"Ese usuario ya existe ",Toast.LENGTH_LONG).show();
                                }
                                else{
                                    Toast.makeText(Registro.this,"No se pudo registrar el usuario ",Toast.LENGTH_LONG).show();
                                }

                            }
                        }
                    });

    }

    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btnregistro:
                registrarusers();
                break;
            case R.id.btnlogear:
                loguser();
                break;

        }




    }
}
