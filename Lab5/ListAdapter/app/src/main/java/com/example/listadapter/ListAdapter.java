package com.example.listadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<AndroidVersion> androidVersions;
    private LayoutInflater inflater;

    public ListAdapter(Context context, ArrayList<AndroidVersion> androidVersions) {
        this.context = context;
        this.androidVersions = androidVersions;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return androidVersions.size();
    }

    @Override
    public Object getItem(int position) {
        return androidVersions.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.single_list_item, parent, false);
            holder = new ViewHolder();
            holder.imageView = convertView.findViewById(R.id.image_view);
            holder.textView1 = convertView.findViewById(R.id.text_view1);
            holder.textView2 = convertView.findViewById(R.id.text_view2);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        AndroidVersion version = androidVersions.get(position);
        holder.imageView.setImageResource(version.getIconId());
        holder.textView1.setText(version.getName());
        holder.textView2.setText("Version: " + version.getVersionNumber());

        return convertView;
    }

    static class ViewHolder {
        ImageView imageView;
        TextView textView1;
        TextView textView2;
    }
}