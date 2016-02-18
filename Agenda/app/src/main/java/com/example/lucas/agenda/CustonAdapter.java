package com.example.lucas.agenda;

/**
 * Created by Lucas on 01/02/2016.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jose on 21/01/2016.
 */
public class CustonAdapter extends BaseAdapter {
    private LayoutInflater layoutInflater;
    private List<Contato> itens;

    public CustonAdapter(List<Contato> itens,Context context) {
        this.itens = itens;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return itens.size();
    }

    @Override
    public Object getItem(int position) {
        return itens.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Pega o item de acordo com a posicao.
        Contato item = itens.get(position);
        //infla o layout para podermos preencher os dados
        convertView = layoutInflater.inflate(R.layout.item_layout,null);

        ((ImageView)convertView.findViewById(R.id.imageView)).setImageResource(item.getImagem());

        ((TextView) convertView.findViewById(R.id.tvNome)).setText(item.getNome());
        ((TextView)convertView.findViewById(R.id.tvValor)).setText(item.getTelefone());

        return convertView;
    }
}