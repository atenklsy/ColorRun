package com.mengshitech.colorrun.fragment.me;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

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
    ImageView title_back;
    TextView title;

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
    }
}
