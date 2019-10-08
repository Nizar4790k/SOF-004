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
            case 0:
                return new HomeFragment();

            case 1:

                return new RegisterFragment();

            case 2:

                return new ContactFragment();

            case 3: return new MusicFragment();

            default:
                return  new HomeFragment();


        }



    }

    @Override
    public int getCount() {
        return mTotalTabs;
    }


}
