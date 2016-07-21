package com.mengshitech.colorrun.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mengshitech.colorrun.R;

/**
 * Created by kanghuicong on 2016/7/21  9:16.
 * 515849594@qq.com
 */
public class MyshowListViewAdapter extends BaseAdapter {
    View view;
    Context context;

    public MyshowListViewAdapter(Context context){
        this.context = context;
    }
    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = null;
        if (convertView == null) {
            view = View.inflate(context, R.layout.me_myshow_listview,
                    null);
            holder = new Holder();
            holder.myshow_name = (TextView)view.findViewById(R.id.tv_myshow_name);
            holder.myshow_type= (TextView)view.findViewById(R.id.tv_myshow_type);
            holder.myshow_time=(TextView)view.findViewById(R.id.tv_myshow_time);
            holder.myshow_address=(TextView)view.findViewById(R.id.tv_myshow_address);
            view.setTag(holder);
        }else {
            view = convertView;
            holder = (Holder) view.getTag();
        }
        return view;
    }

    class Holder{
        TextView myshow_name;
        TextView myshow_type;
        TextView myshow_time;
        TextView myshow_address;
    }
}
