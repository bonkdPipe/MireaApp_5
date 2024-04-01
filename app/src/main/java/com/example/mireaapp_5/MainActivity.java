package com.example.mireaapp_5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    Button button_recycler;
    Button button_scroll;

    Button button_spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_recycler = findViewById(R.id.button_recycler);

        button_scroll = findViewById(R.id.button_scroll_view);

        button_spinner = findViewById(R.id.button_spinnerr);

        ListView productsListView = (ListView) findViewById(R.id.list_view_1);

        String[] products = getResources().getStringArray(R.array.productsCategory);

        ArrayAdapter<String> productAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,products);

        productsListView.setAdapter(productAdapter);

        productsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(view.getContext(), NewActivity1.class);
                intent.putExtra("id", position+1);
                startActivity(intent);



            }
        });

        button_recycler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), NewActivity2.class);
                startActivity(intent);
            }
        });

        button_scroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), NewActivity3.class);
                startActivity(intent);
            }
        });

        button_spinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), NewActivity4.class);
                startActivity(intent);
            }
        });
    }
}