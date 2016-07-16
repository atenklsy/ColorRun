package com.mengshitech.colorrun.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.mengshitech.colorrun.R;
import com.mengshitech.colorrun.bean.CommentEntity;

import java.util.List;


/**
 * Created by atenklsy on 2016/7/16 16:56.
 * E-address:atenk@qq.com.
 */
public class ShowDetailCommentAdpter extends BaseAdapter implements AdapterView.OnItemClickListener {
    List<CommentEntity> mCommentList;
    ListView mCommentListView;
    Activity mActivity;

    public ShowDetailCommentAdpter(Activity activity, List<CommentEntity> commentList, ListView listView) {
        mCommentList = commentList;
        mCommentListView = listView;
        mActivity = activity;
    }

    @Override
    public int getCount() {
        return mCommentList.size();
    }

    @Override
    public CommentEntity getItem(int position) {
        return mCommentList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CommentEntity mCommentEntity = getItem(position);
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = View.inflate(mActivity, R.layout.item_comment_style, null);
            holder = new ViewHolder();
            holder.ivUserHead = (ImageView) convertView.findViewById(R.id.ivComment_UserHead);
            holder.tvUserName = (TextView) convertView.findViewById(R.id.tvComment_UserName);
            holder.tvSendTime = (TextView) convertView.findViewById(R.id.tvComment_SendTime);
            holder.tvCommentContent = (TextView) convertView.findViewById(R.id.tvComment_Content);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.ivUserHead.setImageResource(mCommentEntity.getIvUserHead());
        holder.tvUserName.setText(mCommentEntity.getTvUserName());
        holder.tvSendTime.setText(mCommentEntity.getTvSendTime());
        holder.tvCommentContent.setText(mCommentEntity.getTvCommentContent());
        mCommentListView.setOnItemClickListener(this);
        return convertView;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, final int clickPosition, long id) {
//        clickPosition是被点击的那个position
    }

    class ViewHolder {
        ImageView ivUserHead;
        TextView tvUserName;
        TextView tvSendTime;
        TextView tvCommentContent;
    }
}
