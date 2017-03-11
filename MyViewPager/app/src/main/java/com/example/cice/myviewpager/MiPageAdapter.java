package com.example.cice.myviewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by cice on 11/3/17.
 */

public class MiPageAdapter extends FragmentStatePagerAdapter {

    public static final int NUM_FRAGMENTS= 3;


    public MiPageAdapter(FragmentManager fm){
        super(fm);

    }


    @Override
    public Fragment getItem(int position) {
        Fragment fragment= null;
        switch(position){
            case 0: fragment=new ScreenFragment1();
                break;
            case 1: fragment=new ScreenFragment2();
                break;
            case 2: fragment=new ImagenFragment();
        }

        return fragment;

    }

    @Override
    public int getCount() {
        return NUM_FRAGMENTS;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0){
            return "OPCION 1";
        }else if(position==1){
            return "OPCION 2";
        }else{
            return "OPCION 3";
        }
    }
}
