package com.mengshitech.colorrun.fragment.history;

import android.view.View;

import com.mengshitech.colorrun.R;
import com.mengshitech.colorrun.fragment.BaseFragment;

/**
 * atenklsy
 */
public class mHistoryDetailFragment extends BaseFragment {
	View mDeatilFragmentView;

	@Override
	public View initView() {
		mDeatilFragmentView = View.inflate(mActivity,
				R.layout.fragment_mhistorydetail, null);
		return mDeatilFragmentView;
	}
}
