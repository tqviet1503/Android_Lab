package com.example.listadapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView toolbarTitle;
    private ListView listView;
    private ListAdapter adapter;
    private ArrayList<AndroidVersion> androidVersions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Toolbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Hide the default title
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        // Initialize and configure the TextView in the Toolbar
        toolbarTitle = findViewById(R.id.toolbar_title);
        toolbarTitle.setText("CustomListViewExample");

        // Initialize ListView
        listView = findViewById(R.id.list_view);

        // Initialize data
        androidVersions = new ArrayList<>();

        // Add data to the list of Android versions
        androidVersions.add(new AndroidVersion("Android Cupcake", "1.5", R.drawable.ic_cupcake));
        androidVersions.add(new AndroidVersion("Android Donut", "1.6", R.drawable.ic_donut));
        androidVersions.add(new AndroidVersion("Android Eclair", "2.0", R.drawable.ic_eclair));
        androidVersions.add(new AndroidVersion("Android Froyo", "2.2", R.drawable.ic_froyo));
        androidVersions.add(new AndroidVersion("Android Gingerbread", "2.3", R.drawable.ic_gingerbread));
        androidVersions.add(new AndroidVersion("Android Honeycomb", "3.0", R.drawable.ic_honeycomb));

        // Initialize adapter and attach it to the ListView
        adapter = new ListAdapter(this, androidVersions);
        listView.setAdapter(adapter);
    }
}
