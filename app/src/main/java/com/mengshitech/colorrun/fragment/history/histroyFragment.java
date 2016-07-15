package com.mengshitech.colorrun.fragment.history;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.mengshitech.colorrun.R;
import com.mengshitech.colorrun.adapter.mFragmentAdapter;
import com.mengshitech.colorrun.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;
/**
 * atenklsy
 */
public class histroyFragment extends Fragment {
    // 初始化布局的能力不够
    View histroyView;
    ViewPager vpHistory;
    List<BaseFragment> mHisFragList;
    colorFragment mColoColorFragment;
    popFragment mPopFragment;
    rainbowFragment mRainbowFragment;
    //    TabLayout tabLayoutHistory;
    List<String> tabsNameList;
    private Activity mActivity;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mActivity = getActivity();
        histroyView = View.inflate(mActivity, R.layout.fragment_history, null);
        findById();
        return histroyView;
    }

    private void findById() {
        vpHistory = (ViewPager) histroyView.findViewById(R.id.vpHistory);
//        tabLayoutHistory = (TabLayout) histroyView.findViewById(R.id.tabLayoutHistory);
        initData();
    }

    private void initData() {
        initFragment();
//        initTabsName();
        mFragmentAdapter fragmentAdapter = new mFragmentAdapter(
                getChildFragmentManager(), mHisFragList, tabsNameList);
        // getChildFragmentManager替换getFragmentManager,解决了第二次无法初始化子fragment
        vpHistory.setAdapter(fragmentAdapter);

//        tabLayoutHistory.setupWithViewPager(vpHistory);
//        tabLayoutHistory.setTabsFromPagerAdapter(fragmentAdapter);

    }

//    private void initTabsName() {
//
//        tabsNameList = new ArrayList<String>();
//        tabsNameList.add("卡乐跑");
//        tabsNameList.add("泡泡跑");
//        tabsNameList.add("彩虹跑");
//        tabLayoutHistory.setTabMode(TabLayout.MODE_FIXED);
//        for (int i = 0; i < tabsNameList.size(); i++) {
//            tabLayoutHistory.addTab(tabLayoutHistory.newTab().setText(tabsNameList.get(i)));
//        }
//
//    }

    private void initFragment() {

        mHisFragList = new ArrayList<BaseFragment>();
        mColoColorFragment = new colorFragment(mActivity);
        mPopFragment = new popFragment(mActivity);
        mRainbowFragment = new rainbowFragment(mActivity);
        mHisFragList.add(mColoColorFragment);
        mHisFragList.add(mPopFragment);
        mHisFragList.add(mRainbowFragment);

    }


}
