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
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mengshitech.colorrun.MainActivity;
import com.mengshitech.colorrun.R;
import com.mengshitech.colorrun.adapter.LeRunListViewAdapter;
import com.mengshitech.colorrun.adapter.LeRunVpAdapter;
import com.mengshitech.colorrun.bean.LeRunEntity;
import com.mengshitech.colorrun.view.MyListView;


public class lerunFragment extends Fragment implements OnClickListener {
    View lerunView;
    ViewPager vpLeRunAd;
    // 广告首页ViewPager
    List<ImageView> imgList;
    // 广告图片
    LinearLayout llActivity, llNews, llCode;
    // 活动、资讯、二维码按钮
    TextView tvleRunCity;
    // 城市选择按钮
    MyListView lvLerun;
    // 活动的ListView，为了避免冲突，屏蔽了ListView的滑动事件
    List<LeRunEntity> mLeRunList;
    // 活动的数据源
    Boolean AutoRunning = true;
    // 页面布局
    private Activity mActivity;
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
        llActivity = (LinearLayout) lerunView.findViewById(R.id.llActivity);
        // 活动按钮
        llNews = (LinearLayout) lerunView.findViewById(R.id.llNews);
        // 资讯按钮
        llCode = (LinearLayout) lerunView.findViewById(R.id.llCode);
        // 二维码按钮
        tvleRunCity = (TextView) lerunView.findViewById(R.id.tvleRunCity);
        // 城市选择按钮
        lvLerun = (MyListView) lerunView.findViewById(R.id.lvLerun);
        // 活动的listView
        initView();
    }

    private void initView() {
        initImgList();
        // 初始化ViewPager的图片
        initLeRunList();
        // 初始化listView数据
        llActivity.setOnClickListener(this);
        llNews.setOnClickListener(this);
        llCode.setOnClickListener(this);
        vpLeRunAd
                .setAdapter(new LeRunVpAdapter(imgList, vpLeRunAd, AutoRunning));
        // 为广告位ViewPager加入数据源、viewpager、是否自动滚动
        lvLerun.setAdapter(new LeRunListViewAdapter(mActivity, mLeRunList,
                lvLerun));
        // 为活动ListView加入数据源、ListView

    }

    private void initLeRunList() {
        // 模拟初始化活动ListView的数据源
        mLeRunList = new ArrayList<LeRunEntity>();
        LeRunEntity mLeRunEntity1 = new LeRunEntity();
        mLeRunEntity1.setLeRunCity("上海");
        mLeRunEntity1.setLeRunBackgroundId(R.mipmap.jxnu);
        mLeRunEntity1.setLeRunStatus("报名正式开始");
        mLeRunList.add(mLeRunEntity1);
        LeRunEntity mLeRunEntity2 = new LeRunEntity();
        mLeRunEntity2.setLeRunCity("北京");
        mLeRunEntity2.setLeRunBackgroundId(R.mipmap.jxnu);
        mLeRunEntity2.setLeRunLocation("北京朝阳芳草地");
        mLeRunList.add(mLeRunEntity2);
        LeRunEntity mLeRunEntity3 = new LeRunEntity();
        mLeRunEntity3.setLeRunCity("广州");
        mLeRunEntity3.setLeRunBackgroundId(R.mipmap.jxnu);
        mLeRunEntity3.setLeRunLocation("广州天河广州塔");
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
            case R.id.llActivity:
                // 活动按钮
                Toast.makeText(mActivity, "活动", Toast.LENGTH_SHORT).show();
                break;
            case R.id.llNews:
                // 资讯按钮
                Toast.makeText(mActivity, "资讯", Toast.LENGTH_SHORT).show();
                break;
            case R.id.llCode:
                // 二维码按钮
                Toast.makeText(mActivity, "二维码", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tvleRunCity:
                // 城市选择按钮
                break;

            default:
                break;
        }
    }
}
