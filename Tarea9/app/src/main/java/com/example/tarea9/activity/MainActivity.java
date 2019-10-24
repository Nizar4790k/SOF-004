package com.example.tarea9.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

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






    }

    private class TabListener implements TabLayout.OnTabSelectedListener{

        @Override
        public void onTabSelected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    }


}
