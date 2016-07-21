package com.mengshitech.colorrun.fragment.me;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.mengshitech.colorrun.MainActivity;
import com.mengshitech.colorrun.R;
import com.mengshitech.colorrun.adapter.MyshowListViewAdapter;
import com.mengshitech.colorrun.fragment.BaseFragment;
import com.mengshitech.colorrun.utils.MainBackUtility;

/**
 * atenklsy
 */
public class myShowFragment extends BaseFragment {
    View mShowView;
    ListView myshow_listview;
    MyshowListViewAdapter adapter;

    @Override
    public View initView() {
        mActivity = getActivity();
        mShowView = View.inflate(mActivity, R.layout.me_myshow, null);
        MainBackUtility.MainBack(mShowView,"我的show",getFragmentManager());
        find();

        adapter = new MyshowListViewAdapter(getActivity());
        myshow_listview.setAdapter(adapter);

        return mShowView;
    }

    private void find() {
        myshow_listview = (ListView)mShowView.findViewById(R.id.lv_me_myshow);
    }
}
