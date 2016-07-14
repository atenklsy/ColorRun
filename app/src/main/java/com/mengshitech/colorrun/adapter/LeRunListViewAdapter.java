package com.mengshitech.colorrun.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import com.mengshitech.colorrun.R;
import com.mengshitech.colorrun.bean.LeRunEntity;

import java.util.List;

public class LeRunListViewAdapter extends BaseAdapter {
	private Activity mActivity;
	List<LeRunEntity> mLeRunList;
	ListView mListView;

	public LeRunListViewAdapter(Activity activity, List<LeRunEntity> leRunList,
			ListView listView) {
		mActivity = activity;
		mLeRunList = leRunList;
		mListView = listView;
	}

	@Override
	public int getCount() {
		return mLeRunList.size();
	}

	@Override
	public LeRunEntity getItem(int position) {
		return mLeRunList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LeRunEntity mLeRunEntity = getItem(position);
		ViewHolder holder = null;
		if (convertView == null) {
			convertView = View.inflate(mActivity, R.layout.item_lerunlistview,
					null);
			holder = new ViewHolder();
			holder.ivLeRunBackground = (ImageView) convertView
					.findViewById(R.id.ivLeRunBackground);
			holder.tvLeRunCity = (TextView) convertView
					.findViewById(R.id.tvLeRunCity);
			holder.tvLeRunStatus = (TextView) convertView
					.findViewById(R.id.tvLeRunStatus);
			holder.tvLeRunLocation = (TextView) convertView
					.findViewById(R.id.tvLeRunLocation);
			holder.tvLeRunTime = (TextView) convertView
					.findViewById(R.id.tvLeRunTime);
			holder.tvLeRunOther = (TextView) convertView
					.findViewById(R.id.tvLeRunOther);
			holder.btnSignIn = (Button) convertView
					.findViewById(R.id.btnSignIn);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.ivLeRunBackground.setImageResource(mLeRunEntity
				.getLeRunBackgroundId());
		holder.tvLeRunCity.setText(mLeRunEntity.getLeRunCity());
		holder.tvLeRunStatus.setText(mLeRunEntity.getLeRunStatus());
		holder.tvLeRunLocation.setText(mLeRunEntity.getLeRunLocation());
		holder.tvLeRunTime.setText(mLeRunEntity.getLeRunTime());
		holder.tvLeRunOther.setText(mLeRunEntity.getLeRunOther());
		holder.btnSignIn.setTag(position);
		// mListView.setOnItemClickListener(new OnItemClickListener() {
		//
		// @Override
		// public void onItemClick(AdapterView<?> parent, View view,
		// final int position, long id) {
		// holder.btnSignIn.setOnClickListener(new OnClickListener() {
		//
		// @Override
		// public void onClick(View v) {
		// Toast.makeText(mActivity, "点击了第" + position + "的报名按钮",
		// Toast.LENGTH_SHORT);
		// }
		// });
		// }
		// });
		return convertView;
	}

	class ViewHolder {
		ImageView ivLeRunBackground;
		TextView tvLeRunCity;
		TextView tvLeRunStatus;
		TextView tvLeRunLocation;
		TextView tvLeRunTime;
		TextView tvLeRunOther;
		Button btnSignIn;
	}

}
