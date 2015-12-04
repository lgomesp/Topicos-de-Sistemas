package com.example.lucas.login;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private AlertDialog alerta;

    private EditText edtUsuario;
    private EditText edtSenha;
    private Button btnOk;

    static Usuarios usuarios[] = new Usuarios[10];
    static int n=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        edtUsuario = (EditText) findViewById(R.id.edtUsuario);
        edtSenha = (EditText) findViewById(R.id.edtSenha);
        btnOk = (Button) findViewById(R.id.btnOk);

        btnOk.setOnClickListener(this);

        Bundle b = getIntent().getExtras();

        if (b.containsKey("usuario") && b.containsKey("senha")){
            String usuario = b.getString("usuario");
            String senha = b.getString("senha");
            edtUsuario.setText(usuario);
            edtSenha.setText(senha);
        }
    }

    public void onClick(View view) {
        String usuario1 = edtUsuario.getText().toString();
        String senha = edtSenha.getText().toString();

        Usuarios usuario = new Usuarios();
        usuario.setNome(usuario1);
        usuario.setSenha(senha);
        usuarios[n] = usuario;
        n++;

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Conta Criada");
        builder.setMessage("Por favor, logue novamente!");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent i = new Intent(getBaseContext(), MainActivity.class);
                startActivity(i);
            }
        });
        alerta = builder.create();
        alerta.show();


    }
}
