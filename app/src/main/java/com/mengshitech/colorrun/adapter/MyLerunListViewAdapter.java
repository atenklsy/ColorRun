package com.mengshitech.colorrun.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mengshitech.colorrun.R;
import com.mengshitech.colorrun.bean.ImageEntity;
import com.mengshitech.colorrun.bean.OrderEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kanghuicong on 2016/7/21  9:16.
 * 515849594@qq.com
 */
public class MyLerunListViewAdapter extends BaseAdapter {
    View view;
    int count;
    private static Map<Integer, View> map = new HashMap<Integer, View>();
    Context context;
    ImageEntity Ibm;
    List<OrderEntity> list;
    List<ImageEntity> bmlist;

    public MyLerunListViewAdapter(Context context){
        this.context = context;
    }

    public MyLerunListViewAdapter(int count, Context context, List<OrderEntity> list, List<ImageEntity> bmlist) {
        super();
        this.count = count;
        this.context = context;
        this.list=list;
        this.bmlist=bmlist;
    }
    @Override
    public int getCount() {
        return count;
    }

    @Override
    public Object getItem(int position) {
        OrderEntity info=list.get(position);
        return info.getLerun_id();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        OrderEntity info=list.get(position);
        Ibm=bmlist.get(position);
        Holder holder = null;
        if (convertView == null) {
            view = View.inflate(context, R.layout.me_mylerun_listview,
                    null);
            holder = new Holder();
            holder.myshow_poster = (ImageView)view.findViewById(R.id.iv_myshow_poster);
            holder.myshow_name = (TextView)view.findViewById(R.id.tv_myshow_name);
            holder.myshow_state = (TextView)view.findViewById(R.id.tv_myshow_state);
            holder.myshow_type= (TextView)view.findViewById(R.id.tv_myshow_type);
            holder.myshow_time=(TextView)view.findViewById(R.id.tv_myshow_time);
            holder.myshow_address=(TextView)view.findViewById(R.id.tv_myshow_address);
            view.setTag(holder);
        }else {
            view = convertView;
            holder = (Holder) view.getTag();
        }

        holder.myshow_poster.setImageBitmap(Ibm.getType_bitmap());
        System.out.println("活动海报"+Ibm.getType_bitmap());
        holder.myshow_name.setText(info.getLerun_title());
        System.out.println("活动名字"+info.getLerun_title());
        holder.myshow_state.setText(info.getLerun_state());
        holder.myshow_type.setText(info.getLerun_type());
        holder.myshow_time.setText(info.getLerun_time());
        holder.myshow_address.setText(info.getLerun_address());

        map.put(position, view);

        return view;
    }

    public void addItem(int item) {
        count = item;
    }

    class Holder{
        ImageView myshow_poster;
        TextView myshow_state;
        TextView myshow_name;
        TextView myshow_type;
        TextView myshow_time;
        TextView myshow_address;
    }
}
