package com.mengshitech.colorrun.fragment.lerun;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.mengshitech.colorrun.R;
import com.mengshitech.colorrun.adapter.LeRunEventListviewAdapter;
import com.mengshitech.colorrun.fragment.BaseFragment;
import com.mengshitech.colorrun.utils.Utility;

/**
 * Created by kanghuicong on 2016/7/15  16:12.
 * 515849594@qq.com
 */
public class LerunEventListView extends BaseFragment implements View.OnClickListener{
    ListView lerun_listView;
    LeRunEventListviewAdapter adapter;
    View lerunevent;
    TextView title_bar;
    ImageView title_back;

    @Override
    public View initView() {
        lerunevent = View.inflate(getActivity(), R.layout.lerun_event,null);
        find();
        startAdapter();//listview的adapter
        click();
        return lerunevent;
    }

    private void click() {
        title_back.setOnClickListener(this);
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
        title_bar = (TextView)lerunevent.findViewById(R.id.title_barr);
        title_bar.setText("活动");
        title_back = (ImageView)lerunevent.findViewById(R.id.title_back);
    }

    //点击事件
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.title_back:
                getFragmentManager().popBackStack();
        }
    }
}
