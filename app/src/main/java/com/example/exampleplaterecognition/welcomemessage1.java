package com.example.exampleplaterecognition;

// Welcome Message 1.java
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.exampleplaterecognition.R;

public class welcomemessage1 extends Fragment {

    public welcomemessage1() {
        // Diperlukan konstruktor kosong
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.welcomemessage1, container, false);
    }
}