package com.hhqit.shipdoan;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class AdapterViewPager extends FragmentStatePagerAdapter {
    List<FragmentMonAn> fragmentMonAnList = new ArrayList<>();
    List<String> titleList = new ArrayList<>();

    public void addFrament(FragmentMonAn fragmentMonAn,String title){
        fragmentMonAnList.add(fragmentMonAn);
        titleList.add(title);
    }

    public AdapterViewPager(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return fragmentMonAnList.get(i);
    }

    @Override
    public int getCount() {
        return fragmentMonAnList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }
}
