package com.mengshitech.colorrun.fragment.me;

import android.app.Activity;
import android.view.View;

import com.mengshitech.colorrun.R;
import com.mengshitech.colorrun.fragment.BaseFragment;

/**
 * atenklsy
 */
public class myShowFragment extends BaseFragment {
    View mShowlView;
    private Activity mActivity;


    @Override
    public View initView() {
        mActivity = getActivity();
        mShowlView = View.inflate(mActivity, R.layout.fragment_mylerun, null);



        return mShowlView;
    }
}
