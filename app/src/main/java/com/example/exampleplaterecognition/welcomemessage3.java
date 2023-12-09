package com.example.exampleplaterecognition;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.content.Intent;

import androidx.fragment.app.Fragment;

public class welcomemessage3 extends Fragment {

    public welcomemessage3() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.welcomemessage3, container, false);

        // Find the ImageButton by its ID
        ImageButton mulaibutton = view.findViewById(R.id.mulaiButton);

        // Set an OnClickListener for the ImageButton
        mulaibutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(requireContext(), main_menu.class); // Replace with your new activity class
                startActivity(intent);
            }
        });

        return view;
    }
}