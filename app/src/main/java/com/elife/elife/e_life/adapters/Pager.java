package com.elife.elife.e_life.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.elife.elife.e_life.fragments.CategoriesFragment;
import com.elife.elife.e_life.fragments.HomeFragment;
import com.elife.elife.e_life.fragments.SearchFragment;

/**
 * Created by anshad on 24/3/18.
 */

public class Pager extends FragmentStatePagerAdapter{

    //integer to count number of tabs
    int tabCount;

    //Constructor to the class
    public Pager(FragmentManager fm, int tabCount) {
        super(fm);
        //Initializing tab count
        this.tabCount= tabCount;
    }

    //Overriding method getItem
    @Override
    public Fragment getItem(int position) {
        //Returning the current tabs
        switch (position) {
            case 0:
                CategoriesFragment categoriesFragment = new CategoriesFragment();
                return categoriesFragment;
            case 1:
                HomeFragment homeFragment = new HomeFragment();
                return homeFragment;
            case 2:
                SearchFragment searchFragment = new SearchFragment();
                return searchFragment;
            default:
                return null;
        }
    }

    //Overriden method getCount to get the number of tabs
    @Override
    public int getCount() {
        return tabCount;
    }
}
