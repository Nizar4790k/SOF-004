package com.example.tarea6;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;
    private  int mTotalTabs;

    public SimpleFragmentPagerAdapter(FragmentManager fm, Context context, int tab) {
        super(fm);
        mContext = context;
        mTotalTabs = tab;

    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 1:
                return new HomeFragment();

            case 2:

                return null;

            case 3:

                return null;

            case 4: return null;

            default:
                return  new HomeFragment();


        }



    }

    @Override
    public int getCount() {
        return mTotalTabs;
    }


}
