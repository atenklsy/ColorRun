package com.mengshitech.colorrun.adapter;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

public class LeRunVpAdapter extends PagerAdapter {
	private List<ImageView> mImgList;
	private ViewPager mViewPager;
	private boolean isRunning = false;
	int CurrentItem = -1;

	public LeRunVpAdapter(List<ImageView> ImgList, ViewPager viewPager,
			Boolean istrue) {
		mImgList = ImgList;
		mViewPager = viewPager;
		if (istrue.equals(true)) {
			mAutoHandler.sendEmptyMessage(0);
		}
	}

	@Override
	public int getCount() {
		return mImgList.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}

	@SuppressLint("HandlerLeak")
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		container.addView(mImgList.get(position));
		return mImgList.get(position);
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView(mImgList.get(position));
	}

	// 开启子线程，进行自动播放广告功能
	private Handler mAutoHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			CurrentItem++;
			Log.d("atenklsy", "CurrentItem的数量是" + CurrentItem);
			mViewPager.setCurrentItem(CurrentItem % mImgList.size(), false);
			isRunning = true;
			if (isRunning) {
				mAutoHandler.sendEmptyMessageDelayed(0, 3500);
			}
		}
	};
}
