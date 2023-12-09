package com.example.exampleplaterecognition;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MyPagerAdapter extends FragmentStateAdapter {

    public MyPagerAdapter(FragmentActivity fa) {
        super(fa);
    }

    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new welcomemessage1();
            case 1:
                return new welcomemessage2();
            case 2:
                return new welcomemessage3();
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
