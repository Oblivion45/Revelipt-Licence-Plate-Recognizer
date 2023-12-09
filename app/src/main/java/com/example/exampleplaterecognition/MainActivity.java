package com.example.exampleplaterecognition;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.example.exampleplaterecognition.R;
import com.example.exampleplaterecognition.MyPagerAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi ViewPager
        ViewPager2 viewPager = findViewById(R.id.viewPager);

        // Inisialisasi dan set adapter
        MyPagerAdapter adapter = new MyPagerAdapter(this);
        viewPager.setAdapter(adapter);
    }
}