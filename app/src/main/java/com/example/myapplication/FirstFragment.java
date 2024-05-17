package com.example.myapplication;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
public class FirstFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        Button buttonToSecondFragment = view.findViewById(R.id.to_second);
        Button buttonToThirdFragment = view.findViewById(R.id.to_third);
        buttonToSecondFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .setReorderingAllowed(true).replace(R.id.fragment_container_view,
                                new SecondFragment()).addToBackStack(null).commit();
            }
        });
        buttonToThirdFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .setReorderingAllowed(true).replace(R.id.fragment_container_view,
                                new ThirdFragment()).addToBackStack(null).commit();
            }
        });
        return view;
    }
}