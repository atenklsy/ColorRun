package com.mengshitech.colorrun.fragment.lerun;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.mengshitech.colorrun.R;
import com.mengshitech.colorrun.bean.LeRunEntity;
import com.mengshitech.colorrun.fragment.BaseFragment;

/**
 * Created by atenklsy on 2016/7/15 12:45.
 * E-address:atenk@qq.com.
 */
public class lerunDetailFragment extends BaseFragment {
    View lerunDetailView;
    TextView tvLeRunDetailContent;

    @Override
    public View initView() {
        mActivity = getActivity();
        lerunDetailView = View.inflate(mActivity, R.layout.fragment_lerundetail, null);
        findById();
        initDatas();
        return lerunDetailView;
    }

    private void findById() {
        tvLeRunDetailContent = (TextView) lerunDetailView.findViewById(R.id.tvLeRunDetailContent);
    }

    private void initDatas() {
        LeRunEntity mLeRunEntity = (LeRunEntity) getArguments().getSerializable("mclickLeRunEntity");
        int clickPosition = getArguments().getInt("clickPosition");
        Log.d("atenklsy", "得到的结果"
                + mLeRunEntity.getLeRunName());
        tvLeRunDetailContent.setText(clickPosition + mLeRunEntity.getLeRunName());
    }
}
