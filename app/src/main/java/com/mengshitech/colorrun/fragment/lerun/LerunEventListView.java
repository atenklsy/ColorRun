package com.mengshitech.colorrun.fragment.lerun;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.mengshitech.colorrun.R;
import com.mengshitech.colorrun.adapter.LeRunEventListviewAdapter;
import com.mengshitech.colorrun.fragment.BaseFragment;

/**
 * Created by kanghuicong on 2016/7/15  16:12.
 * 515849594@qq.com
 */
public class LerunEventListView extends BaseFragment {
    ListView lerun_listView;
    LeRunEventListviewAdapter adapter;
    View lerunevent;

    @Override
    public View initView() {
        lerunevent = View.inflate(getActivity(), R.layout.lerun_event, null);
        find();
        adapter = new LeRunEventListviewAdapter(getActivity());
        lerun_listView.setAdapter(adapter);

        lerun_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                toFragment(new IntoLerunEvent());
            }
        });

        return lerunevent;
    }

    private void find() {
        lerun_listView = (ListView) lerunevent.findViewById(R.id.lerun_listView);
    }

    private void toFragment(Fragment fragment) {
        FragmentManager fmManager = getFragmentManager();
        fmManager.beginTransaction().replace(R.id.flMain, fragment)
                .addToBackStack("fragment").commit();
    }
}
