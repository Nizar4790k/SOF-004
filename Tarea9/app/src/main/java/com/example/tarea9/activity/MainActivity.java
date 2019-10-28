package com.example.tarea9.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;

import com.example.tarea9.R;
import com.example.tarea9.adapter.SimpleFragmentPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity{

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private String mSelectedTabName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mTabLayout = findViewById(R.id.tab_layout);
        mViewPager = findViewById(R.id.view_pager);


        final int tabCount = mTabLayout.getTabCount();

        final SimpleFragmentPagerAdapter adapter = new SimpleFragmentPagerAdapter(
                getSupportFragmentManager(),this,tabCount);


             mViewPager.setAdapter(adapter);

             mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));

             String [] tabsNames= {
                     getString(R.string.worker),
                     getString(R.string.manager)

             };


             mTabLayout.addOnTabSelectedListener(new TabListener(mViewPager));




    }

    private class TabListener implements TabLayout.OnTabSelectedListener {

        private ViewPager mViewPager;



        public TabListener(ViewPager viewPager){
            mViewPager = viewPager;


        }

        @Override
        public void onTabSelected(TabLayout.Tab tab) {

            int position = tab.getPosition();

            mViewPager.setCurrentItem(position);






        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {



        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    }





}
