package com.example.mireaapp_5;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.ViewHolder> {
    private List<String> items;
    private Drawable[]  pictures;
    public SimpleAdapter(List<String> items, Drawable[] pictures) {
        this.items = items;
        this.pictures = pictures;
    }
    @NonNull
    @Override
    public SimpleAdapter.ViewHolder onCreateViewHolder(@NonNull
                                                       ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate
                (R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder
                                         holder, int position) {
        Drawable id = null;
        String item = items.get(position);
        if(position < pictures.length) {
            id = pictures[position];
        }
        holder.textView.setText(item);
        if(id != null) {
            holder.imageView.setImageDrawable(id);
        }
    }
    @Override
    public int getItemCount() {
        return items.size();
    }
    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;
        ViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.item_text);
            imageView = view.findViewById(R.id.imageView2);
        }
    }
}
