package com.mengshitech.colorrun.fragment.history;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by kanghuicong on 2016/7/20  17:01.
 * 515849594@qq.com
 */
public class myPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList;
    private List<String>   titleList;

    public myPagerAdapter(FragmentManager fm, List<Fragment> fragmentList, List<String> titleList){
        super(fm);
        this.fragmentList = fragmentList;
        this.titleList = titleList;
    }

    @Override
    public Fragment getItem(int arg0) {
        return (fragmentList == null || fragmentList.size() == 0) ? null : fragmentList.get(arg0);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return (titleList.size() > position) ? titleList.get(position) : "";
    }

    @Override
    public int getCount() {
        return fragmentList == null ? 0 : fragmentList.size();
    }
}
