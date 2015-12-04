package com.example.lucas.calculadora;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Lucas on 05/11/2015.
 */
public class Main extends Activity {

    EditText v1, v2;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        v1 = (EditText) findViewById(R.id.edtV1);
        v2 = (EditText) findViewById(R.id.edtV2);
        resultado = (TextView) findViewById(R.id.tvResult);
    }

    public void mais(View view) {
        String valor1 = v1.getText().toString();
        String valor2 = v2.getText().toString();
        if (!(valor1.isEmpty() || valor2.isEmpty())) {
            int x = Integer.parseInt(valor1);
            int y = Integer.parseInt(valor2);
            resultado.setText("O resultado da soma é: " + (x + y));
        }
    }

    public void menos(View view) {
        String valor1 = v1.getText().toString();
        String valor2 = v2.getText().toString();
        if (!(valor1.isEmpty() || valor2.isEmpty())) {
            int x = Integer.parseInt(valor1);
            int y = Integer.parseInt(valor2);
            resultado.setText("O resultado da subtração é: " + (x - y));
        }
    }

    public void vezes(View view) {
        String valor1 = v1.getText().toString();
        String valor2 = v2.getText().toString();
        if (!(valor1.isEmpty() || valor2.isEmpty())) {
            int x = Integer.parseInt(valor1);
            int y = Integer.parseInt(valor2);
            resultado.setText("O resultado da multiplicação é: " + (x * y));
        }
    }

    public void dividir(View view) {
        String valor1 = v1.getText().toString();
        String valor2 = v2.getText().toString();
        if (!(valor1.isEmpty() || valor2.isEmpty())) {
            int x = Integer.parseInt(valor1);
            int y = Integer.parseInt(valor2);
            resultado.setText("O resultado da divisão é: " + (x / y));
        }
    }
}
