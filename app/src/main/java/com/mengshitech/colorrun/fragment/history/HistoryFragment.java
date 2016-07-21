package com.mengshitech.colorrun.fragment.history;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import com.mengshitech.colorrun.R;
import com.mengshitech.colorrun.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.*;
import android.os.*;
import android.support.v4.app.*;
import android.support.v4.view.*;
import android.view.View;
import android.widget.TextView;

/**
 * Created by kanghuicong on 2016/7/20  16:35.
 * 515849594@qq.com
 */
public class HistoryFragment extends BaseFragment{

    List<Fragment> fragmentList = new ArrayList<Fragment>();
    List<String>   titleList    = new ArrayList<String>();
    View historyview;


    @Override
    public View initView() {
        historyview = View.inflate(getActivity(), R.layout.view_pager_demo, null);
        ViewPager vp = (ViewPager)historyview.findViewById(R.id.viewPager);
        fragmentList.add(new colorFragment(getActivity()));
        fragmentList.add(new popFragment(getActivity()));
        fragmentList.add(new rainbowFragment(getActivity()));
        titleList.add("卡乐泡泡跑");
        titleList.add("卡乐彩色跑");
        titleList.add("卡乐荧光跑");
        vp.setAdapter(new myPagerAdapter(getActivity().getSupportFragmentManager(), fragmentList, titleList));
        return historyview;
    }
}