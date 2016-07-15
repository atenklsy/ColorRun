package com.mengshitech.colorrun.adapter;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import com.mengshitech.colorrun.R;
import com.mengshitech.colorrun.bean.HistoryEntity;
import com.mengshitech.colorrun.fragment.history.mHistoryDetailFragment;

import java.util.List;
/**
 * atenklsy
 */
public class HistoryAdapter extends BaseAdapter {
	private Activity mActivity;
	List<HistoryEntity> mHistotyList;
	ListView mListView;

	public HistoryAdapter(Activity activity, List<HistoryEntity> historyList,
			ListView listView) {
		mActivity = activity;
		mHistotyList = historyList;
		mListView = listView;
	}

	@Override
	public int getCount() {
		return mHistotyList.size();
	}

	@Override
	public HistoryEntity getItem(int position) {
		return mHistotyList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		HistoryEntity mHistoryEntity = getItem(position);
		// 上面是该了getItem的方法，让她返回一个HistoryEntity类型的对象
		// HistoryEntity mHistoryEntity = mHistotyList.get(position);
		Log.d("atenklsy",
				"mHistoryEntity的内容" + mHistoryEntity.getActivityTitle()
						+ mHistoryEntity.getActivityTime()
						+ mHistoryEntity.getActivityLoc());
		ViewHolder holder = null;
		if (convertView == null) {
			convertView = View.inflate(mActivity,
					R.layout.item_history_listview, null);
			holder = new ViewHolder();
			holder.imgBackground = (ImageView) convertView
					.findViewById(R.id.ivHistoryBackground);
			holder.tvActivityTitle = (TextView) convertView
					.findViewById(R.id.tvActivityTitle);
			holder.tvActivityTime = (TextView) convertView
					.findViewById(R.id.tvActivityTime);
			holder.tvActivityLoc = (TextView) convertView
					.findViewById(R.id.tvActivityLoc);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.imgBackground.setImageResource(mHistoryEntity.getImageid());
		holder.tvActivityTitle.setText(mHistoryEntity.getActivityTitle());
		holder.tvActivityTime.setText(mHistoryEntity.getActivityTime());
		holder.tvActivityLoc.setText(mHistoryEntity.getActivityLoc());
		mListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				mHistoryDetailFragment HistoryDetailFragment = new mHistoryDetailFragment();
			}
		});
		return convertView;
	}

	class ViewHolder {
		ImageView imgBackground;
		TextView tvActivityTitle;
		TextView tvActivityTime;
		TextView tvActivityLoc;
	}

}
