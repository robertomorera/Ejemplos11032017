package com.example.cice.myviewpager;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    /**Permite la animacióm y la transición entre fragments*/
    private ViewPager viewPager;
    /**Suministra las vistas al ViewPager*/
    private MiPageAdapter miPageAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager=(ViewPager)findViewById(R.id.miviewpager);
        miPageAdapter= new MiPageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(miPageAdapter);
        TabLayout tabLayout=(TabLayout)findViewById(R.id.tabLayout);
        //tabLayout.addTab(tabLayout.newTab().setText("TAB 1"));
        //tabLayout.addTab(tabLayout.newTab().setText("TAB 2"));
        //tabLayout.addTab(tabLayout.newTab().setText("TAB 3"));
        /** Crea los tabs del tamaño del número de fragments**/
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.mipmap.ic_launcher);
        tabLayout.getTabAt(1).setIcon(R.mipmap.ic_launcher);
        tabLayout.getTabAt(2).setIcon(R.mipmap.ic_launcher);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Log.d(getClass().getCanonicalName(),"TAB SELECTED " +tab.getText());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                Log.d(getClass().getCanonicalName(),"TAB DESELECTED " +tab.getText());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                Log.d(getClass().getCanonicalName(),"TAB RESELECTED " +tab.getText());
            }
        });
    }

    @Override
    public void onBackPressed() {

        if(viewPager.getCurrentItem()==0){
            super.onBackPressed(); //finish
        }else{
            viewPager.setCurrentItem(viewPager.getCurrentItem()-1);

        }

    }
}
