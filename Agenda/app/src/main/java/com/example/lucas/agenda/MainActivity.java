package com.example.lucas.agenda;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BancoHelper bh;

    private ListView listView;
    private List<Contato> contatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.lista);


        bh = new BancoHelper(getBaseContext());


        contatos = bh.getAllContatos();


        CustonAdapter custonAdapter = new CustonAdapter(contatos, getApplicationContext());
        listView.setAdapter(custonAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Contato contato = new Contato();
                contato.setNome("Ana Paula" + contatos.size());
                contato.setTelefone("(67)9999-9999");
                contato.setImagem(R.drawable.carinhaa);
                bh.addContato(contato);

                contatos.add(contato);


                CustonAdapter custonAdapter = new CustonAdapter(contatos, getApplicationContext());
                listView.setAdapter(custonAdapter);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Funcao de delete
                bh.deleteContato(contatos.get(position));
                //contatos.get(position).setImagem(R.drawable.minaa);
                //usando funcao de update
                bh.updateContato(contatos.get(position));

                atualizaLista();
            }
        });
    }

    private void atualizaLista(){
        contatos= bh.getAllContatos();

        CustonAdapter custonAdapter = new CustonAdapter(contatos, getApplicationContext());
        listView.setAdapter(custonAdapter);
    }







}