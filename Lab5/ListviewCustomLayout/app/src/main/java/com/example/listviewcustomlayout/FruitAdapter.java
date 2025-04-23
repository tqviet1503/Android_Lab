package com.example.listviewcustomlayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class FruitAdapter extends ArrayAdapter<Fruit> {

    private Context mContext;
    private ArrayList<Fruit> fruitList;

    public FruitAdapter(@NonNull Context context, ArrayList<Fruit> list) {
        super(context, 0, list);
        this.mContext = context;
        this.fruitList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;

        if (listItem == null) {
            listItem = LayoutInflater.from(mContext).inflate(R.layout.item_fruit, parent, false);
        }

        Fruit currentFruit = fruitList.get(position);

        ImageView fruitImage = listItem.findViewById(R.id.imgFruit);
        fruitImage.setImageResource(currentFruit.getImageResourceId());

        TextView fruitName = listItem.findViewById(R.id.tvFruitName);
        fruitName.setText(currentFruit.getName());

        TextView calories = listItem.findViewById(R.id.tvCalories);
        calories.setText(currentFruit.getCalories() + " Calories");

        return listItem;
    }
}