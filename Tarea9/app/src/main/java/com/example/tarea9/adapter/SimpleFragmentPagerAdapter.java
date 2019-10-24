package com.example.tarea9.adapter;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.tarea9.fragment.ManagerFragment;
import com.example.tarea9.fragment.ManagerListFragment;
import com.example.tarea9.fragment.WorkerListFragment;

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;
    private int mTotalTabs;

    public SimpleFragmentPagerAdapter(FragmentManager fm, Context context, int tab) {
        super(fm);
        mContext = context;
        mTotalTabs =tab;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 1:

                return new WorkerListFragment();




            case 2:

                return new ManagerListFragment();



                default:
                    return new ManagerFragment();


        }

    }

    @Override
    public int getCount() {
        return mTotalTabs;
    }
}
