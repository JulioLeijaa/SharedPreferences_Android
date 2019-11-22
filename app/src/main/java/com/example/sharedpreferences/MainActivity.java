package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText CampoCorreo, CampoPassword;
    TextView txtcorreo, txtpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CampoCorreo = findViewById(R.id.CampoCorreo);
        CampoPassword = (EditText) findViewById(R.id.CampoPassword);
        txtcorreo = (TextView) findViewById(R.id.txtcorreo);
        txtpassword = findViewById(R.id.txtpassword);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnGuardar:
                Toast.makeText(this, "Guardando datos", Toast.LENGTH_SHORT).show();
                guardarPreferencias();
                break;
            case R.id.btnCargar:
                Intent it = new Intent(this, SecondActivity.class);
                startActivity(it);
                break;
        }
    }

    public void guardarPreferencias(){
        SharedPreferences preferences = getSharedPreferences("Credenciales", Context.MODE_PRIVATE);
        String correo = CampoCorreo.getText().toString();
        String pass = CampoPassword.getText().toString();

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("Correo",correo);
        editor.putString("Password", pass);

        editor.commit();

        CampoCorreo.setText("");
        CampoPassword.setText("");
    }
}
