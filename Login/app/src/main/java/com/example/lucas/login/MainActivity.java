package com.example.lucas.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    private EditText edtUsuario;
    private EditText edtSenha;
    private TextView tvTeste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUsuario = (EditText) findViewById(R.id.edtUsuario);
        edtSenha = (EditText) findViewById(R.id.edtSenha);
        tvTeste = (TextView) findViewById(R.id.tvTeste);

    }

    public void Entrar(View view) {
        String usuario = edtUsuario.getText().toString();
        String senha = edtSenha.getText().toString();

        if (usuario.isEmpty() || (senha.isEmpty())) {
            tvTeste.setText("Campos em Branco!");
        } else {
            if (verificaUsuario(usuario,senha)){
                Intent x = new Intent(getBaseContext(), Main3Activity.class);
                x.putExtra("usuario",usuario);
                startActivity(x);
            } else {
                tvTeste.setText("Usuário ou senha inválidos!");
            }
        }

    }

    public boolean verificaUsuario(String usuario, String senha) {
        for (Usuarios u: Main2Activity.usuarios){
            if (u != null && u.usuario.equals(usuario) && u.senha.equals(senha)) {
                return true;
            }
        }
        return false;
    }

    public void Cadastrar(View view) {
        Intent i = new Intent(this, Main2Activity.class);
        Bundle b = new Bundle();
        b.putString("usuario", edtUsuario.getText().toString());
        b.putString("senha", edtSenha.getText().toString());
        i.putExtras(b);
        startActivity(i);
    }
}
