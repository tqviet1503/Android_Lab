package com.example.listviewcustomlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private FruitAdapter adapter;
    private ArrayList<Fruit> fruitList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize ListView
        listView = findViewById(R.id.listView);

        // Initialize the list of fruits
        fruitList = new ArrayList<>();

        // Add fruits to the list
        fruitList.add(new Fruit("Orange", 47, R.drawable.orange));
        fruitList.add(new Fruit("Cherry", 50, R.drawable.cherry));
        fruitList.add(new Fruit("Banana", 89, R.drawable.banana));
        fruitList.add(new Fruit("Apple", 52, R.drawable.apple));
        fruitList.add(new Fruit("Kiwi", 61, R.drawable.kiwi));
        fruitList.add(new Fruit("Pear", 57, R.drawable.pear));
        fruitList.add(new Fruit("Strawberry", 33, R.drawable.strawberry));
        fruitList.add(new Fruit("Lemon", 29, R.drawable.lemon));
        fruitList.add(new Fruit("Peach", 39, R.drawable.peach));
        fruitList.add(new Fruit("Apricot", 48, R.drawable.apricot));
        fruitList.add(new Fruit("Mango", 60, R.drawable.mango));

        // Initialize the adapter
        adapter = new FruitAdapter(this, fruitList);

        // Set the adapter to the ListView
        listView.setAdapter(adapter);
    }
}
