package com.mengshitech.colorrun.fragment.me;

import android.view.View;
import android.widget.LinearLayout;

import com.mengshitech.colorrun.R;
import com.mengshitech.colorrun.adapter.MyLerunListViewAdapter;
import com.mengshitech.colorrun.fragment.BaseFragment;
import com.mengshitech.colorrun.utils.MainBackUtility;
import com.mengshitech.colorrun.view.MyListView;

/**
 * atenklsy
 */
public class myLeRunFragment extends BaseFragment {
    View mLeRunView;
    MyListView myshow_listview;
    MyLerunListViewAdapter adapter;
    LinearLayout rlayout;

    @Override
    public View initView() {
        mActivity = getActivity();
        mLeRunView = View.inflate(mActivity, R.layout.me_mylerun, null);

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
//        {
//            // 透明状态栏
//            getActivity().getWindow().addFlags( WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        }

        MainBackUtility.MainBack(mLeRunView,"我的乐跑",getFragmentManager(),1);
        find();
        adapter = new MyLerunListViewAdapter(getActivity());
        myshow_listview.setAdapter(adapter);

        return mLeRunView;
    }

    private void find() {
        myshow_listview = (MyListView) mLeRunView.findViewById(R.id.lv_me_myshow);
        rlayout = (LinearLayout)mLeRunView.findViewById(R.id.title_tick);
    }
}
