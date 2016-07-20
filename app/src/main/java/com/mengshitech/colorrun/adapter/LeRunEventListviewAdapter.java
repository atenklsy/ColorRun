package com.mengshitech.colorrun.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.mengshitech.colorrun.R;

/**
 * Created by kanghuicong on 2016/7/16  10:32.
 * 515849594@qq.com
 */
public class LeRunEventListviewAdapter extends BaseAdapter{
    View view;
    Context context;

    public LeRunEventListviewAdapter(Context context){
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
            view = View.inflate(context, R.layout.lerun_event_listview,
                    null);
            holder = new Holder();
            holder.lerun_event_name = (TextView)view.findViewById(R.id.lerun_event_name);
            holder.lerun_envent_type= (TextView)view.findViewById(R.id.lerun_envent_type);
            holder.lerun_envent_state=(TextView)view.findViewById(R.id.lerun_envent_state);
            holder.lerun_event_address=(TextView)view.findViewById(R.id.lerun_event_address);
            view.setTag(holder);
        }else {
            view = convertView;
            holder = (Holder) view.getTag();
        }
        return view;
    }


    class Holder{
            TextView lerun_event_name;
            TextView lerun_envent_type;
            TextView lerun_envent_state;
            TextView lerun_event_address;
        }
}
