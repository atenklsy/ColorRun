package com.mengshitech.colorrun.fragment.history;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


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
public class colorFragment extends BaseFragment {
    ListView lvColorFragment;
    List<HistoryEntity> mHistoryList;
    View colorView;
    private Activity mActivity;

    public colorFragment(Activity activity) {
        mActivity = activity;
        initView();
    }

    @Override
    public View initView() {
        initEntity();
        // 获取数据源
        colorView = View.inflate(mActivity, R.layout.fragment_color, null);
        // 引入布局
        findById();
        // 初始化控件
        return colorView;
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
        lvColorFragment = (ListView) colorView
                .findViewById(R.id.lvColorFragment);
        initDatas();
    }

    private void initDatas() {
        HistoryAdapter mHistoryAdapter = new HistoryAdapter(mActivity,
                mHistoryList, lvColorFragment);
        lvColorFragment.setAdapter(mHistoryAdapter);
    }
}
