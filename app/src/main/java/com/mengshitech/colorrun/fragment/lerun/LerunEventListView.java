package com.mengshitech.colorrun.fragment.lerun;

import android.view.View;
import com.mengshitech.colorrun.R;
import com.mengshitech.colorrun.fragment.BaseFragment;

/**
 * Created by kanghuicong on 2016/7/15  16:12.
 * 515849594@qq.com
 */
public class LerunEventListView extends BaseFragment{
    View lerunevent;

    @Override
    public View initView() {
        lerunevent = View.inflate(getActivity(), R.layout.lerun_event,null);
        return lerunevent;
    }
}
