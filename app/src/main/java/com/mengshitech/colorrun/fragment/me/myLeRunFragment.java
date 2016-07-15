package com.mengshitech.colorrun.fragment.me;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mengshitech.colorrun.MainActivity;
import com.mengshitech.colorrun.R;
import com.mengshitech.colorrun.fragment.BaseFragment;

/**
 * atenklsy
 */
public class myLeRunFragment extends BaseFragment {
    View mDeatilView;
    private Activity mActivity;


    @Override
    public View initView() {
        mActivity = getActivity();
        mDeatilView = View.inflate(mActivity, R.layout.fragment_mylerun, null);
        return mDeatilView;
    }

}
