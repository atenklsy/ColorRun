package com.mengshitech.colorrun.adapter;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.mengshitech.colorrun.R;
import com.mengshitech.colorrun.bean.ShowEntity;
import com.mengshitech.colorrun.fragment.show.showDetailFragment;
import com.mengshitech.colorrun.utils.Utility;

import java.util.List;

public class ShowAdapter extends BaseAdapter implements AdapterView.OnItemClickListener {
    FragmentManager fm;
    ShowEntity mShowEntity;
    private List<ShowEntity> mShowList;
    private ListView mListView;
    private Activity mActivity;

    public ShowAdapter(Activity activity, List<ShowEntity> showList,
                       ListView listView, FragmentManager fm) {
        mActivity = activity;
        mShowList = showList;
        mListView = listView;
        this.fm = fm;
    }

    @Override
    public int getCount() {
        return mShowList.size();
    }

    @Override
    public ShowEntity getItem(int position) {
        return mShowList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        mShowEntity = getItem(position);
        // 上面是该了getItem的方法，让她返回一个HistoryEntity类型的对象
        // HistoryEntity mHistoryEntity = mHistotyList.get(position);
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = View.inflate(mActivity,
                    R.layout.item_show_listview, null);
            holder = new ViewHolder();
            holder.ivUserHead = (ImageView) convertView
                    .findViewById(R.id.ivShow_UserHead);
            holder.tvShow_UserName = (TextView) convertView
                    .findViewById(R.id.tvShow_UserName);
            holder.ivShowPic = (ImageView) convertView
                    .findViewById(R.id.ivShowPic);
            holder.tvWordContent = (TextView) convertView
                    .findViewById(R.id.tvWordContent);
            holder.tvSendTime = (TextView) convertView
                    .findViewById(R.id.tvSendTime);
            holder.tvShow_Heart = (TextView) convertView
                    .findViewById(R.id.tvShow_Heart);

            holder.tvShow_Comment = (TextView) convertView
                    .findViewById(R.id.tvShow_Comment);
            holder.tvShow_Share = (TextView) convertView
                    .findViewById(R.id.tvShow_Share);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.ivUserHead.setImageResource(mShowEntity.getIvUserHead());
        holder.tvShow_UserName.setText(mShowEntity.getTvShow_UserName());
        holder.ivShowPic.setImageResource(mShowEntity.getIvShowPic());
        holder.tvWordContent.setText(mShowEntity.getTvWordContent());
        holder.tvSendTime.setText(mShowEntity.getTvSendTime());
        holder.tvShow_Heart.setText(mShowEntity.getTvShow_Heart());
        holder.tvShow_Comment.setText(mShowEntity.getTvShow_Comment());
        holder.tvShow_Share.setText(mShowEntity.getTvShow_Share());
        /**
         * 改变drawable的大小
         */
        Utility.changeDrawableDirection(holder.tvShow_Heart, R.mipmap.show_heart, 0);
        Utility.changeDrawableDirection(holder.tvShow_Comment, R.mipmap.show_comment, 0);
        Utility.changeDrawableDirection(holder.tvShow_Share, R.mipmap.show_share, 0);
        mListView.setOnItemClickListener(this);
        return convertView;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        showDetailFragment mShowDetailFragment = new showDetailFragment();
        Bundle args = new Bundle();
        args.putSerializable("mShowEntity", mShowEntity);
        mShowDetailFragment.setArguments(args);
        Utility.replace2DetailFragment(fm, mShowDetailFragment);
    }

    class ViewHolder {
        ImageView ivUserHead;
        TextView tvShow_UserName;
        ImageView ivShowPic;
        TextView tvWordContent;
        TextView tvSendTime;
        TextView tvShow_Heart;
        TextView tvShow_Comment;
        TextView tvShow_Share;
    }

}
