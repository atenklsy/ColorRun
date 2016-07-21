package com.mengshitech.colorrun.utils;

import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mengshitech.colorrun.R;

/**
 * Created by kanghuicong on 2016/7/21  14:46.
 * 515849594@qq.com
 */
public class MainBackUtility {

    public static void MainBack(View view, String title, final FragmentManager fm){

        TextView title_bar = (TextView)view.findViewById(R.id.title_barr);
        title_bar.setText(title);
        ImageView title_back = (ImageView)view.findViewById(R.id.title_back);

        title_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fm.popBackStack();
            }
        });
    }
}
