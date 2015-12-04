package com.example.lucas.lanchoneted;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SingleListItem extends Activity {

    TextView tvIngredientes;
    TextView tvPreco;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.single_list_item_view);

        tvIngredientes = (TextView) findViewById(R.id.tvIngredientes);
        tvPreco = (TextView) findViewById(R.id.tvPreco);

        TextView txtProduct = (TextView) findViewById(R.id.product_label);

        Intent i = getIntent();
        // getting attached intent data
        String product = i.getStringExtra("product");
        // displaying selected product name
        txtProduct.setText(product);

        verificaLanche(product);

    }

    void verificaLanche(String produto) {
        String ingredientes = "", preco = "";

        switch (produto) {
            case "X-Nabi Chedid":
                ingredientes = "Queijo e Linguiça do Rosário";
                preco = "R$10,60";
                break;
            case "X-Limada":
                ingredientes = "Queijo, Linguiça do Rosário, Salada e Maionese";
                preco = "R$11,90";
                break;
            case "X-Pintado":
                ingredientes = "Queijo, Linguiça do Rosário, Salada, Bacon, Egg e Maionese";
                preco = "R$12,90";
                break;
            case "X-Santana":
                ingredientes = "Queijo, Linguiça do Rosário e Bacon";
                preco = "R$11,90";
                break;
            case "X-Parreira":
                ingredientes = "Queijo, Linguiça do Rosário e Vinagrete";
                preco = "R$11,90";
                break;
            case "X-Shedid":
                ingredientes = "Queijo, Linguiça do Rosário e Maionese";
                preco = "R$10,90";
                break;
            case "X-Baiano":
                ingredientes = "Queijo, Linguiça do Rosário e Egg";
                preco = "R$11,90";
                break;
            case "X-Alfredo":
                ingredientes = "Queijo, Linguiça do Rosário e Catupiry";
                preco = "R$12,30";
                break;
            case "X-Biro":
                ingredientes = "Queijo, Linguiça do Rosário e Creme de Milho";
                preco = "R$13,30";
                break;
            case "X-Amado":
                ingredientes = "Queijo, Linguiça do Rosário e Purê de Batata";
                preco = "R$12,20";
                break;
        }

        tvIngredientes.setText(ingredientes);
        tvPreco.setText(preco);

    }
}