package com.example.lucas.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener{

    private TextView tvUsuario;
    private Button btnSair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        tvUsuario = (TextView) findViewById(R.id.tvUsuario);
        btnSair = (Button) findViewById(R.id.btnSair);

        btnSair.setOnClickListener(this);

        Bundle b = getIntent().getExtras();

        String usuario = b.getString("usuario");

        tvUsuario.setText(usuario);
    }

    public void onClick(View view){
        finish();
    }

}
