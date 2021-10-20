package com.meanHun.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.meanHun.model.Home_Fragment;

public class AdapterFragment extends FragmentStatePagerAdapter {
    public AdapterFragment(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Home_Fragment();
            case 1:
                return new DialogFragment();
//                return new Fragment_2();
            case 2:
                return new DialogFragment();
            default:
                return new DialogFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
