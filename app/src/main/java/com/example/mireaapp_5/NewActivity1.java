package com.example.mireaapp_5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class NewActivity1 extends AppCompatActivity {


    ArrayAdapter<String> productAdapter;
    ArrayList<String> products_names = new ArrayList<String>();
    ArrayList<String> selected_products = new ArrayList<String>();

    ListView productsListView;

    Button button1;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new1);

        productsListView = (ListView) findViewById(R.id.list_view_2);
        button1 = findViewById(R.id.button2);
        button2 = findViewById(R.id.button3);

        Bundle argument = getIntent().getExtras();



        assert argument != null;
        Integer referering_id = Integer.valueOf(argument.get("id").toString());

        String[] products = new String[0];

        switch (referering_id) {
            case 1:
                products = getResources().getStringArray(R.array.products_1);
                break;
            case 2:
                products = getResources().getStringArray(R.array.products_2);
                break;
            case 3:
                products = getResources().getStringArray(R.array.products_3);
                break;
            case 4:
                products = getResources().getStringArray(R.array.products_4);
                break;
            case 5:
                products = getResources().getStringArray(R.array.products_5);
                break;
            case 6:
                products = getResources().getStringArray(R.array.products_6);
                break;
            case 7:
                products = getResources().getStringArray(R.array.products_7);
                break;
            case 8:
                products = getResources().getStringArray(R.array.products_8);
                break;
            case 9:
                products = getResources().getStringArray(R.array.products_9);
                break;
        }

        Collections.addAll(products_names, products);

        productAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice,products_names);


        productsListView.setAdapter(productAdapter);

        productsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String product = productAdapter.getItem(position);
                if (productsListView.isItemChecked(position))
                    selected_products.add(product);
                else
                    selected_products.remove(product);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                remove(v);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add(v);
            }
        });

    }

    public void add(View view){
        EditText productName = findViewById(R.id.editTextText);
        String user = productName.getText().toString();
        if(!user.isEmpty()){
            productAdapter.add(user);
            productName.setText("Name: ");
            productAdapter.notifyDataSetChanged();
        }
    }
    public void remove(View view){
        // получаем и удаляем выделенные элементы
        for(int i=0; i< selected_products.size();i++){
            productAdapter.remove(selected_products.get(i));
        }
        // снимаем все ранее установленные отметки
        productsListView.clearChoices();
        // очищаем массив выбраных объектов
        selected_products.clear();
        productAdapter.notifyDataSetChanged();
    }

}

