package com.example.lucas.lanchoneted;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lstListaLanches;
    List<String> lanches;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lanches = new ArrayList<String>();

        lanches.add("Item 1");
        lanches.add("Item 2");
        lanches.add("Item 3");


        /*
        lstListaLanches = (ListView) findViewById(R.id.lstListaLanches);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1,
                lanches);

        lstListaLanches.setAdapter(adapter);

         */

        // storing string resources into Array
        String[] adobe_products = {"X-Nabi Chedid", "X-Limada", "X-Pintado", "X-Santana",
                                   "X-Parreira", "X-Shedid", "X-Baiano", "X-Alfredo",
                                   "X-Biro", "X-Amado"};

        // Binding resources Array to ListAdapter
        lstListaLanches = (ListView) findViewById(R.id.lstListaLanches);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                R.layout.list_item, R.id.label, adobe_products);
        lstListaLanches.setAdapter(adapter);


        lstListaLanches.setOnItemClickListener(OnListClick());
    }

    private AdapterView.OnItemClickListener OnListClick() {
        return new AdapterView.OnItemClickListener(){

                @Override
                public void onItemClick(AdapterView<?> arg0, View view, int pos, long id) {
                    //Toast.makeText(getApplicationContext(), lanches.get(pos), Toast.LENGTH_LONG).show();

                    // selected item
                    String product = ((TextView) view).getText().toString();

                    // Launching new Activity on selecting single List Item
                    Intent i = new Intent(getApplicationContext(), SingleListItem.class);
                    // sending data to new activity
                    i.putExtra("product", product);
                    startActivity(i);
                }
            };
    }
}
