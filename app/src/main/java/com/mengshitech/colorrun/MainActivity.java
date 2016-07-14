package com.mengshitech.colorrun;

import java.util.List;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.mengshitech.colorrun.fragment.history.histroyFragment;
import com.mengshitech.colorrun.fragment.lerun.lerunFragment;
import com.mengshitech.colorrun.fragment.me.meFragment;
import com.mengshitech.colorrun.fragment.show.showFragment;
import com.mengshitech.colorrun.utils.Utility;
import com.mengshitech.colorrun.view.NoScrollViewPager;


/**
 * 主页面
 *
 * @author atenklsy
 * @time 2016.7.7
 */

@SuppressLint("NewApi")
public class MainActivity extends FragmentActivity implements OnClickListener {
    public static RadioGroup rgMainBottom;
    public static View contentView;
    RadioButton rbMe, rbHistory, rbRun, rbShow;
    NoScrollViewPager mViewPager;
    // List<View> pageList;
    List<Fragment> fragmentList;
    FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        initFragment();

        rgMainBottom = (RadioGroup) findViewById(R.id.rgMainBottom);
        rgMainBottom.check(R.id.rbRun);
        // 进入主页面，初始页面pager为乐跑
        rbRun = (RadioButton) findViewById(R.id.rbRun);
        // rb乐跑
        rbShow = (RadioButton) findViewById(R.id.rbShow);
        // rb秀
        rbHistory = (RadioButton) findViewById(R.id.rbHistory);
        // rb历史
        rbMe = (RadioButton) findViewById(R.id.rbMe);
        // rb我的
        rbHistory.setOnClickListener(this);
        rbMe.setOnClickListener(this);
        rbRun.setOnClickListener(this);
        rbShow.setOnClickListener(this);

    }

    private void initFragment() {
        //一开始先初始到lerunFragment
        fm = getSupportFragmentManager();
        Utility.replace2MainFragment(fm, new lerunFragment());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rbRun:
                Utility.replace2MainFragment(fm, new lerunFragment());
                break;
            case R.id.rbShow:
                Utility.replace2MainFragment(fm, new showFragment());
                break;
            case R.id.rbHistory:
                Utility.replace2MainFragment(fm, new histroyFragment());
                break;
            case R.id.rbMe:
                Utility.replace2MainFragment(fm, new meFragment());
                break;
            default:
                break;
        }
    }

}