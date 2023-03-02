package com.example.conversion_unidades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn_longitud, btn_peso, btn_volumen, btn_temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Conversor");

        btn_longitud = (Button) findViewById(R.id.btn_longitud);
        btn_longitud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityLongitud();
            }
        });

        btn_peso = (Button) findViewById(R.id.btn_peso);
        btn_peso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityPeso();
            }
        });

        btn_volumen = (Button) findViewById(R.id.btn_volumen);
        btn_volumen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityVolumen();
            }
        });

        btn_temp = (Button) findViewById(R.id.btn_temperatura);
        btn_temp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openActivityTemperatura();
            }
        });

    }

    public void openActivityLongitud(){
        Intent intent = new Intent(this, Longitud.class);
        startActivity(intent);
    }

    public void openActivityPeso(){
        Intent intent = new Intent(this, Peso.class);
        startActivity(intent);
    }

    public void openActivityVolumen(){
        Intent intent = new Intent(this, Volumen.class);
        startActivity(intent);
    }

    public void openActivityTemperatura(){
        Intent intent = new Intent(this, Temperatura.class);
        startActivity(intent);
    }

}

