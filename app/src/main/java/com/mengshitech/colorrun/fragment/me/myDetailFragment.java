package com.mengshitech.colorrun.fragment.me;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mengshitech.colorrun.R;
import com.mengshitech.colorrun.fragment.BaseFragment;
import com.mengshitech.colorrun.utils.DialogUtility;
import com.mengshitech.colorrun.utils.MainBackUtility;


/**
 * atenklsy
 */
public class myDetailFragment extends BaseFragment implements View.OnClickListener{
    View mDeatilView;
    FragmentManager fm;
    LinearLayout me_head,me_nickname,me_phone,me_address,me_sex,me_height,me_weight,me_land,me_autograph;
    TextView title_bar,tv_nickname,tv_phone,tv_sex,tv_height,tv_weight,tv_autograph;
    ImageView title_back;
    private String sex;

    public static myDetailFragment newInstance(Bundle bundle) {
        myDetailFragment fragment = new myDetailFragment();
        fragment.setArguments(bundle);
        return fragment;
    }
    @Override
    public View initView() {
        mActivity = getActivity();
        mDeatilView = View.inflate(mActivity, R.layout.fragment_mydetail, null);
        MainBackUtility.MainBack(mDeatilView,"个人信息",getFragmentManager());
        find();
        click();

        return mDeatilView;
    }

    private void click() {
        me_nickname.setOnClickListener(this);
        me_phone.setOnClickListener(this);
        me_sex.setOnClickListener(this);
        me_height.setOnClickListener(this);
        me_weight.setOnClickListener(this);
        me_autograph.setOnClickListener(this);
    }

    private void find() {
        me_head = (LinearLayout)mDeatilView.findViewById(R.id.ll_me_head);
        me_nickname = (LinearLayout)mDeatilView.findViewById(R.id.ll_me_nickname);
        tv_nickname = (TextView)mDeatilView.findViewById(R.id.tv_me_nickname);
        me_phone = (LinearLayout)mDeatilView.findViewById(R.id.ll_me_phone);
        tv_phone = (TextView)mDeatilView.findViewById(R.id.tv_me_phone);
        me_address = (LinearLayout)mDeatilView.findViewById(R.id.ll_me_address);
        me_sex = (LinearLayout)mDeatilView.findViewById(R.id.ll_me_sex);
        tv_sex = (TextView) mDeatilView.findViewById(R.id.tv_me_sex);
        me_height = (LinearLayout)mDeatilView.findViewById(R.id.ll_me_height);
        tv_height = (TextView)mDeatilView.findViewById(R.id.tv_me_height);
        me_weight = (LinearLayout)mDeatilView.findViewById(R.id.ll_me_weight);
        tv_weight = (TextView)mDeatilView.findViewById(R.id.tv_me_weight);
        me_land = (LinearLayout)mDeatilView.findViewById(R.id.ll_me_land);
        me_autograph = (LinearLayout)mDeatilView.findViewById(R.id.ll_me_autograph);
        tv_autograph = (TextView) mDeatilView.findViewById(R.id.tv_me_autograph);

    }

    @Override
    public void onClick(View v) {
        fm =getFragmentManager();
        switch (v.getId()){
            case R.id.ll_me_head:

                break;
            case R.id.ll_me_nickname:
                DialogUtility.DialogNickname(getActivity(),tv_nickname);
                break;
            case R.id.ll_me_phone:
                DialogUtility.DialogPhone(getActivity(),tv_phone);
                break;
            case R.id.ll_me_address:

                break;
            case R.id.ll_me_sex:
                DialogUtility.DialogSex(getActivity(),tv_sex);
                break;
            case R.id.ll_me_height:
                DialogUtility.DialogPhysique("height",getActivity(),tv_height);
                break;
            case R.id.ll_me_weight:
                DialogUtility.DialogPhysique("weight",getActivity(),tv_weight);
                break;
            case R.id.ll_me_land:

                break;
            case R.id.ll_me_autograph:
                DialogUtility.DialogAutograph(getActivity(),tv_autograph);
                break;

            default:
                break;
        }
    }

}
