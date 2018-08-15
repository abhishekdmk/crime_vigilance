package com.abnv.flamefreezer.crimevigilance;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class CrimesTab extends Fragment  {

    public CrimesTab() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.crimes_tab, container, false);
        final TextView mytext= (TextView)view.findViewById(R.id.textView3);
        final EditText editText= (EditText)view.findViewById(R.id.editText6);
        final ImageView img= (ImageView)view.findViewById(R.id.imageView9);
        mytext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mytext.setVisibility(View.INVISIBLE);
                editText.setVisibility(View.VISIBLE);
                img.setVisibility(View.VISIBLE);
            }
        });
        return view;
    }

}
