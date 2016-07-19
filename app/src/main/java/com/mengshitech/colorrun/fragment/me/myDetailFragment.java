package com.mengshitech.colorrun.fragment.me;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.mengshitech.colorrun.MainActivity;
import com.mengshitech.colorrun.R;
import com.mengshitech.colorrun.fragment.BaseFragment;

/**
 * atenklsy
 */
public class myDetailFragment extends BaseFragment implements View.OnClickListener{
    View mDeatilView;
    LinearLayout me_head,me_nickname,me_phone,me_address,me_sex,me_land,me_autograph;


    @Override
    public View initView() {
        mActivity = getActivity();
        mDeatilView = View.inflate(mActivity, R.layout.fragment_mydetail, null);
        find();
        click();
        return mDeatilView;
    }

    private void click() {
        me_sex.setOnClickListener(this);
    }

    private void find() {
        me_head = (LinearLayout)mDeatilView.findViewById(R.id.ll_me_head);
        me_nickname = (LinearLayout)mDeatilView.findViewById(R.id.ll_me_nickname);
        me_phone = (LinearLayout)mDeatilView.findViewById(R.id.ll_me_phone);
        me_address = (LinearLayout)mDeatilView.findViewById(R.id.ll_me_address);
        me_sex = (LinearLayout)mDeatilView.findViewById(R.id.ll_me_sex);
        me_land = (LinearLayout)mDeatilView.findViewById(R.id.ll_me_land);
        me_autograph = (LinearLayout)mDeatilView.findViewById(R.id.ll_me_autograph);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_me_head:

                break;
            case R.id.ll_me_nickname:

                break;
            case R.id.ll_me_phone:

                break;
            case R.id.ll_me_address:

                break;
            case R.id.ll_me_sex:
                
                break;
            case R.id.ll_me_land:

                break;
            case R.id.ll_me_autograph:

                break;

            default:
                break;
        }
    }
}
