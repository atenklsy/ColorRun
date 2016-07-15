package com.mengshitech.colorrun.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mengshitech.colorrun.MainActivity;
/**
 * atenklsy
 */
public abstract class BaseFragment extends Fragment {
    public static Activity mActivity;

    public BaseFragment() {
        mActivity = getActivity();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return initView();

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    // 子类必须实现初始化布局的方法
    public abstract View initView();

    // 可以不初始化
    public void initData() {

    }

    @Override
    public void onDetach() {
        super.onDetach();
        // 返回的时候要显示radioGroup
        MainActivity.rgMainBottom.setVisibility(View.VISIBLE);

    }
}
