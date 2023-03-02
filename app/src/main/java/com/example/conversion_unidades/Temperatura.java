package com.example.conversion_unidades;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Temperatura extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    String[] items = new String[]{"Celsius", "Fahrenheit", "Kelvin"};
    private Spinner temperaturaEntrada;
    private Spinner temperaturaSalida;
    private EditText et_entrada;
    private TextView et_salida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperatura);
        setTitle("Temperatura");

        temperaturaEntrada = (Spinner)findViewById(R.id.spinner_TempEntrada);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Temperatura.this,
                android.R.layout.simple_spinner_item,items);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temperaturaEntrada.setAdapter(adapter);
        temperaturaEntrada.setOnItemSelectedListener(this);

        temperaturaSalida = (Spinner)findViewById(R.id.spinner_tempSalida);
        ArrayAdapter<String>adapter2 = new ArrayAdapter<String>(Temperatura.this,
                android.R.layout.simple_spinner_item,items);

        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temperaturaSalida.setAdapter(adapter2);
        temperaturaSalida.setOnItemSelectedListener(this);

        et_entrada = (EditText) findViewById(R.id.et_entrada);
        et_salida = (TextView) findViewById(R.id.et_salida);
        et_entrada.setText("1");
        et_salida.setFocusable(false);


        et_entrada.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //Al cambiar el EditText ejecutamos un nuevo calculo
                Calcular();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
        Calcular();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // TODO Auto-generated method stub
    }

    public boolean validarCampos(){
        if(et_entrada.getText().toString().matches("")){
            Toast.makeText(this, "Ingrese un Valor a Convertir", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(et_entrada.getText().toString().matches("\\.")){
            Toast.makeText(this, "Ingrese un Valor Valido", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    public void Calcular(){
        double Celsius = 0;
        double res = 0;

        if(!validarCampos()) return;

        //Detectamos la Unidad de Longitud a convertir para convertilo a Litros y con esa base convertirlos a la Unidad de Longitud de salida seleccionada
        switch (temperaturaEntrada.getSelectedItem().toString()){
            case "Celsius":
                Celsius = Float.parseFloat(et_entrada.getText().toString());
                break;

            case "Fahrenheit":
                Celsius = (Float.parseFloat(et_entrada.getText().toString()) - 32) * (5/9);
                break;

            case "Kelvin":
                Celsius = Float.parseFloat(et_entrada.getText().toString()) - 273.15;
                break;
        }

        //Con la conversión anterior a Kg ahora convertimos ese valor en Kilogramo a la unidad de longitud seleccionada.
        switch (temperaturaSalida.getSelectedItem().toString()){
            case "Celsius":
                res = Float.parseFloat(et_entrada.getText().toString());
                break;

            case "Fahrenheit":
                res = (Float.parseFloat(et_entrada.getText().toString()) * (9/5)) + 32;
                break;

            case "Kelvin":
                res = Float.parseFloat(et_entrada.getText().toString()) + 273.15;
                break;
        }


        et_salida.setText(Double.toString(res));
    }

}