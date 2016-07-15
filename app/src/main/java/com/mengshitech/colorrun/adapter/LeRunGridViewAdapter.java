package com.mengshitech.colorrun.adapter;

import android.app.Activity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import com.mengshitech.colorrun.R;
import com.mengshitech.colorrun.bean.LeRunEntity;
import java.util.List;

/**
 * Created by atenklsy on 2016/7/15 10:55.
 * E-address:atenk@qq.com.
 */
public class LeRunGridViewAdapter extends BaseAdapter {
    List<LeRunEntity> mLeRunList;
    FragmentManager mFragmentManagr;
    GridView mLeRunGridView;
    Activity mActivity;

    public LeRunGridViewAdapter(Activity activity, List<LeRunEntity> leRunEntityList, FragmentManager fm, GridView gridView) {
        mActivity = activity;
        mLeRunList = leRunEntityList;
        mFragmentManagr = fm;
        mLeRunGridView = gridView;
    }

    @Override
    public int getCount() {
        return 2;
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
        ViewHolder holder;
        LeRunEntity mLeRunEntity = getItem(position);
        if (convertView == null) {
            convertView = View.inflate(mActivity, R.layout.item_lerun_gridview, null);
            holder = new ViewHolder();
            holder.ivBackground = (ImageView) convertView.findViewById(R.id.ivBackground);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.ivBackground.setImageResource(mLeRunEntity.getLeRunBackgroundId());

        return convertView;
    }

    class ViewHolder {

        ImageView ivBackground;

    }
}
