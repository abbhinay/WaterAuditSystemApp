package com.abhinay.myapplication;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import static android.graphics.Color.rgb;

public class MyAdapter extends RecyclerView.Adapter <MyAdapter.ViewHolder>{

    RecyclerView recyclerView;
    Context context;
    ArrayList<String> items = new ArrayList<>();

    public void update(String name){
        items.add(name);
        notifyDataSetChanged(); //refreshes the recycler view automatically
    }

    public MyAdapter(RecyclerView recyclerView, Context context, ArrayList<String> items) {
        this.recyclerView = recyclerView;
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.color_list, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        //initialize the elements of indiv, items..
        //viewHolder.nameOfFile.setText(items.get(i));
        String color = items.get(i);
        color = color.replace("{", "");
        color = color.replace("}", "");
        String[] col = color.split(",");
        try{
            int r = Integer.parseInt(col[0].trim());
            int g = Integer.parseInt(col[1]);
            int b = Integer.parseInt(col[2]);
            viewHolder.nameOfFile.setBackgroundColor(rgb(r,g,b));
            viewHolder.nameOfFile.setText("calcium content = " + r + "ppm\n"+ "magnesium content = " + r +"ppm\n"+ "sulphur content = " + b + "ppm");
        }catch(Exception e){
            Log.d("abhinay", "exception new");
        }

    }

    @Override
    public int getItemCount() {
        //return the no of items...
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView nameOfFile;

        public ViewHolder(View itemView){
            super(itemView);
            nameOfFile= itemView.findViewById(R.id.colorBlock);
        }
    }
}
