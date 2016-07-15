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
public class rainbowFragment extends BaseFragment {
	private Activity mActivity;
	List<HistoryEntity> mHistoryList;
	ListView lvRainbowFragment;

	public rainbowFragment(Activity activity) {
		mActivity = activity;
		// TODO Auto-generated constructor stub
		initView();

	}

	View rainbowView;

	@Override
	public View initView() {
		initEntity();
		rainbowView = View.inflate(mActivity, R.layout.fragment_rainbow, null);
		findById();
		return rainbowView;
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
		lvRainbowFragment = (ListView) rainbowView
				.findViewById(R.id.lvRainbowFragment);
		initDatas();
	}

	private void initDatas() {
		HistoryAdapter mHistoryAdapter = new HistoryAdapter(mActivity,
				mHistoryList, lvRainbowFragment);
		lvRainbowFragment.setAdapter(mHistoryAdapter);
	}

}
