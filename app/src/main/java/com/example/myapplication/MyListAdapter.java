package com.example.myapplication;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import java.util.ArrayList;
public class MyListAdapter extends ArrayAdapter<String> {
    private final LayoutInflater inflater;
    private final int layout;
    private final ArrayList<String> items;
    public MyListAdapter(Context context, int resource,
                         ArrayList<String> items) {
        super(context, resource, items);
        this.items = items;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }
    @NonNull
    public View getView(int position, View convertView,
                        @NonNull ViewGroup parent) {
        @SuppressLint("ViewHolder")
        View view=inflater.inflate(this.layout, parent, false);
        TextView textView = view.findViewById(R.id.list_item_text_view);
        ImageView imageView = view.findViewById(R.id.list_item_image_view);
        String item = items.get(position);
        textView.setText(item);
        imageView.setImageDrawable(parent.getContext().getDrawable(R.drawable.element));
        return view;
    }
}