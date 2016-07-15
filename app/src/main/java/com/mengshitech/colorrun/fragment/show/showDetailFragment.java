package com.mengshitech.colorrun.fragment.show;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.mengshitech.colorrun.R;
import com.mengshitech.colorrun.bean.ShowEntity;
import com.mengshitech.colorrun.fragment.BaseFragment;

/**
 * Created by atenklsy on 2016/7/14 22:03.
 * E-address:atenk@qq.com.
 */
public class showDetailFragment extends BaseFragment {
    View showDetailView;
    TextView tvContent;

    @Override
    public View initView() {
        showDetailView = View.inflate(getActivity(), R.layout.fragment_showdetail, null);
        findById();
        initDatas();
        return showDetailView;
    }


    private void findById() {
        tvContent = (TextView) showDetailView.findViewById(R.id.tvContent);
    }

    private void initDatas() {
        ShowEntity mShowEntity = (ShowEntity) getArguments().getSerializable("mShowEntity");
        Log.d("atenklsy","mShowEntity的数据"+mShowEntity.getTvShow_UserName());
        tvContent.setText(mShowEntity.getTvWordContent());
    }
}
