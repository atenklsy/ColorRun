package com.mengshitech.colorrun.fragment.lerun;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.mengshitech.colorrun.MainActivity;
import com.mengshitech.colorrun.R;
import com.mengshitech.colorrun.adapter.LeRunEventListviewAdapter;
import com.mengshitech.colorrun.fragment.BaseFragment;
import com.mengshitech.colorrun.utils.MainBackUtility;
import com.mengshitech.colorrun.utils.Utility;

/**
 * Created by kanghuicong on 2016/7/15  16:12.
 * 515849594@qq.com
 */
public class LerunEventListView extends BaseFragment{
    ListView lerun_listView;
    LeRunEventListviewAdapter adapter;
    View lerunevent;
    TextView title_bar;
    ImageView title_back;

    @Override
    public View initView() {
        lerunevent = View.inflate(getActivity(), R.layout.lerun_event,null);
        MainActivity.rgMainBottom.setVisibility(View.GONE);
        MainBackUtility.MainBack(lerunevent,"活动",getFragmentManager());
        find();
        startAdapter();//listview的adapter
        return lerunevent;
    }

    private void startAdapter() {
        adapter = new LeRunEventListviewAdapter(getActivity());
        lerun_listView.setAdapter(adapter);

        //listview  item点击事件
        lerun_listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                FragmentManager fragmentManager = getFragmentManager();
                Utility.replace2DetailFragment(fragmentManager,new IntoLerunEvent());
            }
        });
    }

    private void find() {
        lerun_listView = (ListView)lerunevent.findViewById(R.id.lerun_listView);
    }
}
