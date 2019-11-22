package com.example.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView txtcorreo, txtpassword;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txtcorreo =  findViewById(R.id.txtcorreo);
        txtpassword = findViewById(R.id.txtpassword);

        cargarPreferencias();
    }

    private void cargarPreferencias() {
        SharedPreferences preferences = getSharedPreferences("Credenciales", Context.MODE_PRIVATE);

        String lee_correo =preferences.getString("Correo","Vacio");
        String lee_pass =preferences.getString("Password","Vacio");

        txtcorreo.setText(lee_correo);
        txtpassword.setText(lee_pass);
    }
}
