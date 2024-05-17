package com.example.myapplication;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
public class SecondFragment extends Fragment {
    private final static String TAG = "MyTag";
    public static ArrayList<String> Items() {
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 201; i++) {
            list.add("MyList element №" + (i + 1));
        }
        return list;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        ListView itemsList = view.findViewById(R.id.list_view);
        ArrayList<String> list = Items();
        MyListAdapter adapter = new MyListAdapter(getContext(), R.layout.list_item, list);
        itemsList.setAdapter(adapter);
        itemsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(getContext(), list.get(position), Toast.LENGTH_LONG).show();
                Log.d(TAG, list.get(position));
            }
        });
        return view;
    }
}