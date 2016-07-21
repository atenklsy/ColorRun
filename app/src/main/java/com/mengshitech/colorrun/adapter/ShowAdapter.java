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
import android.widget.Toast;

import com.mengshitech.colorrun.R;
import com.mengshitech.colorrun.bean.ShowEntity;
import com.mengshitech.colorrun.fragment.show.showDetailFragment;
import com.mengshitech.colorrun.utils.Utility;

import java.util.ArrayList;
import java.util.List;

/**
 * atenklsy
 */
public class ShowAdapter extends BaseAdapter implements AdapterView.OnItemClickListener, View.OnClickListener {
    FragmentManager fm;
    ShowEntity mShowEntity;
    ViewHolder holder;
    List<TextView> tvShow_HeartList, tvShow_CommentList, tvShow_ShareList;
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
        holder = null;
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
        /**
         * 为各个子item设置position
         */
        holder.tvShow_Heart.setTag(position);
        holder.tvShow_Comment.setTag(position);
        holder.tvShow_Share.setTag(position);
        holder.tvShow_Heart.setOnClickListener(this);
        holder.tvShow_Comment.setOnClickListener(this);
        holder.tvShow_Share.setOnClickListener(this);

        return convertView;
    }

    /**
     * ListView的响应事件,跳转并传值
     *
     * @param parent
     * @param view
     * @param conPosition
     * @param id
     */

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int conPosition, long id) {
        showDetailFragment mShowDetailFragment = new showDetailFragment();
        Bundle args = new Bundle();
        args.putSerializable("mShowEntity", mShowEntity);
        mShowDetailFragment.setArguments(args);
        Utility.replace2DetailFragment(fm, mShowDetailFragment);
    }

    /**
     * 子item的各个控件的点击事件，响应之后获得其position
     *
     * @param v
     */
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.tvShow_Heart:
                int HeartPosition = Integer.valueOf(v.getTag().toString());//获取具体的position
                lvClick(HeartPosition, "tvShow_Heart");
                break;
            case R.id.tvShow_Comment:
                int CommentPosition = Integer.valueOf(v.getTag().toString());
                lvClick(CommentPosition, "tvShow_Comment");
                break;
            case R.id.tvShow_Share:
                int SharePosition = Integer.valueOf(v.getTag().toString());
                lvClick(SharePosition, "tvShow_Share");
                break;
            default:
                break;
        }
    }

    /**
     * 各个子item的控件的真实响应事件，获取上面传来的position，并响应点击
     *
     * @param ClickPosition
     * @param type
     */
    private void lvClick(final int ClickPosition, String type) {
        tvShow_HeartList = new ArrayList<TextView>();
        tvShow_CommentList = new ArrayList<TextView>();
        tvShow_ShareList = new ArrayList<TextView>();
        for (int i = 0; i <= mShowList.size() - 1; i++) {
            tvShow_HeartList.add(holder.tvShow_Heart);
        }
        for (int i = 0; i <= mShowList.size() - 1; i++) {
            tvShow_CommentList.add(holder.tvShow_Comment);
        }
        for (int i = 0; i <= mShowList.size() - 1; i++) {
            tvShow_ShareList.add(holder.tvShow_Share);
        }

        if (type.equals("tvShow_Heart")) {
            tvShow_HeartList.get(ClickPosition).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mActivity, "tvHeart" + tvShow_HeartList.get(ClickPosition).getText().toString(), Toast.LENGTH_SHORT).show();
                }
            });
        } else if (type.equals("tvShow_Comment")) {
            tvShow_CommentList.get(ClickPosition).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mActivity, "tvComment" + tvShow_CommentList.get(ClickPosition).getText().toString(), Toast.LENGTH_SHORT).show();
                }
            });

        } else if (type.equals("tvShow_Share")) {
            tvShow_ShareList.get(ClickPosition).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mActivity, "tvShare" + tvShow_ShareList.get(ClickPosition).getText().toString(), Toast.LENGTH_SHORT).show();
                }
            });

        } else {
            Toast.makeText(mActivity, "您的点击失败了！", Toast.LENGTH_SHORT).show();
        }
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
