package com.mengshitech.colorrun.fragment.me;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.mengshitech.colorrun.MainActivity;
import com.mengshitech.colorrun.R;
import com.mengshitech.colorrun.dao.UserDao;
import com.mengshitech.colorrun.utils.Utility;

/**
 * atenklsy
 */
public class meFragment extends Fragment implements OnClickListener {
    View meView;
    RelativeLayout rlUserHead;
    LinearLayout llMyLeRun, llMyShow, llAboutUs;
    FragmentManager fm;
    private Activity mActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mActivity = getActivity();
        initView();
        return meView;

    }

    private void initView() {
        meView = View.inflate(mActivity, R.layout.fragment_me, null);
        rlUserHead = (RelativeLayout) meView.findViewById(R.id.rlUserHead);
        // 头像那一行
        rlUserHead.setOnClickListener(this);
        llMyLeRun = (LinearLayout) meView.findViewById(R.id.llMyLeRun);
        // 我的乐跑那一行
        llMyLeRun.setOnClickListener(this);
        llMyShow = (LinearLayout) meView.findViewById(R.id.llMyShow);
        // 我的秀那一行
        llMyShow.setOnClickListener(this);
        llAboutUs = (LinearLayout) meView.findViewById(R.id.llAboutUs);
        // 关于我们那一行
        llAboutUs.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        fm = getFragmentManager();
        //fragmentManager（碎片管理器）
        switch (v.getId()) {
            case R.id.rlUserHead:
                // 点击头像事件
                Utility.replace2DetailFragment(fm, new myDetailFragment());
//                turn2Fragment(new myDetailFragment());

                break;
            case R.id.llMyLeRun:
                // 点击我的乐跑事件
                Utility.replace2DetailFragment(fm, new myLeRunFragment());
//                turn2Fragment(new myLeRunFragment());
                break;
            case R.id.llMyShow:
                // 点击我的秀事件
                Utility.replace2DetailFragment(fm, new myShowFragment());
//                turn2Fragment(new myShowFragment());
                break;
            case R.id.llAboutUs:
                // 点击关于我们事件

//                turn2Fragment(new AboutUsFragment());
                Utility.replace2DetailFragment(fm, new AboutUsFragment());
                break;

            default:
                break;
        }
    }


}
