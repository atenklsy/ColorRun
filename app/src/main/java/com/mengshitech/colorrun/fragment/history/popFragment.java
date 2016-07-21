package com.mengshitech.colorrun.fragment.history;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.widget.ListView;


import com.mengshitech.colorrun.R;
import com.mengshitech.colorrun.adapter.HistoryAdapter;
import com.mengshitech.colorrun.bean.HistoryEntity;
import com.mengshitech.colorrun.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;
/**
 * atenklsy
 */
@SuppressLint("ValidFragment")
public class popFragment extends BaseFragment {
    List<HistoryEntity> mHistoryList;
    ListView lvPopFragment;
    View popView;
    private Activity mActivity;

    public popFragment(Activity activity) {
        mActivity = activity;
        initView();
    }

    @Override
    public View initView() {
        initEntity();
        popView = View.inflate(mActivity, R.layout.fragment_pop, null);
        findById();
        return popView;
    }

    private void initEntity() {
        // 模仿外部数据源
        mHistoryList = new ArrayList<HistoryEntity>();
        HistoryEntity mHistoryEntity1 = new HistoryEntity();
        mHistoryEntity1.setImageid(R.mipmap.historybackground);
        mHistoryEntity1.setActivityTitle("市政卡乐跑");
        mHistoryEntity1.setActivityTime("2016年7月11日14时");
        mHistoryEntity1.setActivityLoc("江西省奥体中心");
        mHistoryList.add(mHistoryEntity1);
}

    private void findById() {
        lvPopFragment = (ListView) popView.findViewById(R.id.lvPopFragment);
        initDatas();
    }

    private void initDatas() {
        HistoryAdapter mHistoryAdapter = new HistoryAdapter(mActivity,
                mHistoryList, lvPopFragment);
        lvPopFragment.setAdapter(mHistoryAdapter);
    }

}
