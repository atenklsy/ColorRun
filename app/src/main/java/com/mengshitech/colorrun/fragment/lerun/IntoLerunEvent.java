package com.mengshitech.colorrun.fragment.lerun;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.mengshitech.colorrun.MainActivity;
import com.mengshitech.colorrun.R;
import com.mengshitech.colorrun.fragment.BaseFragment;
import com.mengshitech.colorrun.utils.MainBackUtility;
import com.mengshitech.colorrun.utils.Utility;

/**
 * Created by kanghuicong on 2016/7/15.
 */

public class IntoLerunEvent extends BaseFragment implements OnClickListener {
    View into_lerun_view;
    TimeCount countdown;
    ImageView poster, map, title_back;
    TextView title_bar, address, name, origin, time, process, rule, price,
            number, tx_entry;
    LinearLayout bt_entry;

    @Override
    public View initView() {
        into_lerun_view = View.inflate(getActivity(), R.layout.lerun_into, null);
        MainBackUtility.MainBack(into_lerun_view,"活动详情",getFragmentManager());

        find();
        click();// 点击事件
        entry_type();// 查看报名的状态
        number_type();// 查看人数状态
        time();// 倒计时
        return into_lerun_view;
    }

    // 人数状态
    private void number_type() {
        // TODO Auto-generated method stub
        if (Integer.valueOf(number.getText().toString()) == 0) {
            tx_entry.setText("报名人数已满");
            bt_entry.setEnabled(false);
        }
    }

    // 查看报名的状态
    private void entry_type() {
        // TODO Auto-generated method stub

        SharedPreferences sharedPreferences = getActivity()
                .getSharedPreferences("entry_type", Activity.MODE_PRIVATE);
        String type = sharedPreferences.getString("type", "");
        String num = sharedPreferences.getString("number", "");

        if (type == "success") {
            number.setText(num + "");
            bt_entry.setBackgroundColor(Color.parseColor("#cccccc"));
            tx_entry.setText("已报名");
            bt_entry.setEnabled(false);
        }
    }

    // 倒计时
    private void time() {
        // TODO Auto-generated method stub
        //获取活动结束时间time
        String time = "2016年7月20日11时00分00秒";

        String time_finish = getTime(time);
        long time_now = new Date().getTime();

        int Time_finish = Integer.valueOf(time_finish) * 1000;
        int Time_now = (int) time_now;

        Log.i("时间戳", time_now + "");
        Log.i("Time_now", Time_now + "");
        Log.i("Time_finish", Time_finish + "");

        countdown.setEndTime(System.currentTimeMillis()
                + (Time_finish - Time_now));
    }

    // 活动结束时间转成时间戳
    public static String getTime(String time) {

        String re_time = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
        Date d;
        try {
            d = sdf.parse(time);
            long l = d.getTime();
            String str = String.valueOf(l);
            re_time = str.substring(0, 10);
            Log.i("时间戳", re_time + "");
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return re_time;
    }

    private void click() {
        // TODO Auto-generated method stub
        bt_entry.setOnClickListener(this);//报名按钮
        map.setOnClickListener(this);//点击地图放大
    }

    private void find() {
        // TODO Auto-generated method stub
        poster = (ImageView) into_lerun_view.findViewById(R.id.into_lerun_poster);// 活动海报
        map = (ImageView) into_lerun_view.findViewById(R.id.into_lerun_map);// 活动路线地图
        address = (TextView) into_lerun_view.findViewById(R.id.into_lerun_address);// 活动地点
        name = (TextView) into_lerun_view.findViewById(R.id.into_lerun_name);// 活动名字
        origin = (TextView) into_lerun_view.findViewById(R.id.into_lerun_origin);// 起点（与地点一样）
        time = (TextView) into_lerun_view.findViewById(R.id.into_lerun_time);// 活动时间
        process = (TextView) into_lerun_view.findViewById(R.id.into_lerun_process);// 活动流程
        rule = (TextView) into_lerun_view.findViewById(R.id.into_lerun_rule);// 活动规则
        price = (TextView) into_lerun_view.findViewById(R.id.into_lerun_price);// 活动费用
        number = (TextView) into_lerun_view.findViewById(R.id.into_lerun_number);// 剩余名额
        countdown = (TimeCount) into_lerun_view.findViewById(R.id.into_lerun_countdown);// 剩余时间
        bt_entry = (LinearLayout) into_lerun_view.findViewById(R.id.bt_into_lerun_entry);// 报名按钮
        tx_entry = (TextView) into_lerun_view.findViewById(R.id.tx_into_lerun_entry);// 立即报名
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.bt_into_lerun_entry:
                Toast.makeText(getActivity(), "报名成功！！",Toast.LENGTH_SHORT).show();
                number.setText(Integer.valueOf(number.getText().toString()) - 1
                        + "");


                //先用SharedPreferences存储报名状态，后面改成从服务器读取状态
                SharedPreferences mySharedPreferences = getActivity()
                        .getSharedPreferences("entry_type", Activity.MODE_PRIVATE);
                SharedPreferences.Editor editor = mySharedPreferences.edit();
                editor.putString("type", "success");
                editor.putString("number",
                        Integer.valueOf(number.getText().toString()) + "");
                editor.commit();

                entry_type();
                break;
            case R.id.into_lerun_map:
                //点击地图放大
                Utility.replace2DetailFragment(getFragmentManager(),new ShowMap());
            default:
                break;
        }
    }
}
