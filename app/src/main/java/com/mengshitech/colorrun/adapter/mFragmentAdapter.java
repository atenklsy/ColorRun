package com.mengshitech.colorrun.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.mengshitech.colorrun.fragment.BaseFragment;

import java.util.List;
/**
 * atenklsy
 */
public class mFragmentAdapter extends FragmentPagerAdapter {
    List<BaseFragment> fragmentList;
    List<String> mTabsNameList;

    public mFragmentAdapter(FragmentManager fm, List<BaseFragment> fragmentList, List<String> tabsNameList) {
        super(fm);
        this.fragmentList = fragmentList;
        mTabsNameList = tabsNameList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        // 获取fragment的数量
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
//    传入TabList来修改Tab的值
        return mTabsNameList.get(position);
    }
}
