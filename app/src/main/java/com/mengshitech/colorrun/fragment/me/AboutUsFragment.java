package com.mengshitech.colorrun.fragment.me;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mengshitech.colorrun.R;
import com.mengshitech.colorrun.fragment.BaseFragment;

/**
 * atenklsy
 */
public class AboutUsFragment extends BaseFragment {
    View mDeatilView;


    @Override
    public View initView() {
        mActivity = getActivity();
        mDeatilView = View.inflate(mActivity, R.layout.fragment_aboutus, null);
        return mDeatilView;
    }


}
