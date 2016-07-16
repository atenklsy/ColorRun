package com.mengshitech.colorrun.fragment.lerun;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import android.widget.Toast;

import com.mengshitech.colorrun.MainActivity;
import com.mengshitech.colorrun.R;
import com.mengshitech.colorrun.adapter.LeRunGridViewAdapter;
import com.mengshitech.colorrun.adapter.LeRunListViewAdapter;
import com.mengshitech.colorrun.adapter.LeRunVpAdapter;
import com.mengshitech.colorrun.bean.LeRunEntity;
import com.mengshitech.colorrun.utils.Utility;
import com.mengshitech.colorrun.view.MyListView;


public class lerunFragment extends Fragment implements OnClickListener {
    View lerunView;
    ViewPager vpLeRunAd;
    // 广告首页ViewPager
    List<ImageView> imgList;
    // 广告图片
    TextView tvleRunCity, tvLeRunActivity, tvLeRunTheme, tvLeRunSignUp, tvLeRunFootPrint;
    // 城市选择按钮
    MyListView lvLerun;
    // 活动的ListView，为了避免冲突，屏蔽了ListView的滑动事件
    GridView gvHotActivity;
    List<LeRunEntity> mLeRunList;
    // 活动的数据源
    Boolean AutoRunning = true;
    FragmentManager fm;
    // 页面布局
    Activity mActivity;
    // 广告栏是否自动滑动

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mActivity = getActivity();
        lerunView = View.inflate(mActivity, R.layout.fragment_lerun, null);
        findById();
        return lerunView;

    }

    private void findById() {

        vpLeRunAd = (ViewPager) lerunView.findViewById(R.id.vpLeRunAd);
        // 顶部ViewPager滚动栏
        tvLeRunActivity = (TextView) lerunView.findViewById(R.id.tvLeRunActivity);
        // 活动按钮
        tvLeRunTheme = (TextView) lerunView.findViewById(R.id.tvLeRunTheme);
        // 主题按钮
        tvLeRunFootPrint = (TextView) lerunView.findViewById(R.id.tvLeRunFootPrint);
        // 足迹按钮
        tvLeRunSignUp = (TextView) lerunView.findViewById(R.id.tvLeRunSignUp);
        // 签到按钮
        tvleRunCity = (TextView) lerunView.findViewById(R.id.tvleRunCity);
        // 城市选择按钮
        lvLerun = (MyListView) lerunView.findViewById(R.id.lvLerun);
        gvHotActivity = (GridView) lerunView.findViewById(R.id.gvHotActivity);
        // 活动的listView
        initView();
    }

    private void initView() {
        initImgList();
        // 初始化ViewPager的图片
        initLeRunList();
        // 初始化listView数据
        fm = getFragmentManager();
        //初始化fm给ListView、GridView用
        tvLeRunActivity.setOnClickListener(this);
        Utility.changeDrawableSize(tvLeRunActivity, R.mipmap.temp_icon, 80, 80);
        tvLeRunTheme.setOnClickListener(this);
        Utility.changeDrawableSize(tvLeRunTheme, R.mipmap.temp_icon, 80, 80);
        tvLeRunFootPrint.setOnClickListener(this);
        Utility.changeDrawableSize(tvLeRunFootPrint, R.mipmap.temp_icon, 80, 80);
        tvLeRunSignUp.setOnClickListener(this);
        Utility.changeDrawableSize(tvLeRunSignUp, R.mipmap.temp_icon, 80, 80);
        vpLeRunAd
                .setAdapter(new LeRunVpAdapter(imgList, vpLeRunAd, AutoRunning));
        // 为广告位ViewPager加入数据源、viewpager、是否自动滚动
        lvLerun.setAdapter(new LeRunListViewAdapter(mActivity, mLeRunList, fm,
                lvLerun));
        // 为活动ListView加入数据源、ListView
        gvHotActivity.setAdapter(new LeRunGridViewAdapter(mActivity, mLeRunList, fm, gvHotActivity));
        // 为活动GridView加入数据源、GridView


    }

    private void initLeRunList() {
        // 模拟初始化活动ListView的数据源
        mLeRunList = new ArrayList<LeRunEntity>();
        LeRunEntity mLeRunEntity1 = new LeRunEntity();
        mLeRunEntity1.setLeRunBackgroundId(R.mipmap.poprun);
        mLeRunEntity1.setLeRunLocation("上海浦东外高桥森兰绿地");
        mLeRunEntity1.setLeRunName("泡泡跑");
        mLeRunEntity1.setLeRunTime("08月19日");
        mLeRunList.add(mLeRunEntity1);
        LeRunEntity mLeRunEntity2 = new LeRunEntity();
        mLeRunEntity2.setLeRunBackgroundId(R.mipmap.jxnu);
        mLeRunEntity2.setLeRunLocation("北京朝阳芳草地");
        mLeRunEntity2.setLeRunName("荧光跑");
        mLeRunEntity2.setLeRunTime("09月25日");
        mLeRunList.add(mLeRunEntity2);
        LeRunEntity mLeRunEntity3 = new LeRunEntity();
        mLeRunEntity3.setLeRunBackgroundId(R.mipmap.colorrun);
        mLeRunEntity3.setLeRunLocation("广州海珠广州塔");
        mLeRunEntity3.setLeRunName("卡乐跑");
        mLeRunEntity3.setLeRunTime("11月12日");
        mLeRunList.add(mLeRunEntity3);
    }

    private void initImgList() {
        // 模拟初始化广告栏的数据源
        imgList = new ArrayList<ImageView>();
        ImageView img1 = new ImageView(mActivity);
        img1.setScaleType(ScaleType.FIT_XY);
        // 将照片拉伸
        img1.setBackgroundResource(R.mipmap.lerun_ad_a);
        imgList.add(img1);
        ImageView img2 = new ImageView(mActivity);
        img2.setScaleType(ScaleType.FIT_XY);
        img2.setBackgroundResource(R.mipmap.lerun_ad_b);
        imgList.add(img2);
        ImageView img3 = new ImageView(mActivity);
        img3.setScaleType(ScaleType.FIT_XY);
        img3.setBackgroundResource(R.mipmap.lerun_ad_c);
        imgList.add(img3);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvLeRunActivity:
                // 活动按钮
                Toast.makeText(mActivity, "活动", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tvLeRunTheme:
                //主题按钮
                Toast.makeText(mActivity, "主题", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tvLeRunFootPrint:
                // 足迹按钮
                Toast.makeText(mActivity, "足迹", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tvLeRunSignUp:
                // 签到按钮
                Toast.makeText(mActivity, "签到", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tvleRunCity:
                // 城市选择按钮
                break;

            default:
                break;
        }
    }


}
