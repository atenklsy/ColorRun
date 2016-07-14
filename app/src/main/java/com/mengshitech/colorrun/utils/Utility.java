package com.mengshitech.colorrun.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;

import com.mengshitech.colorrun.MainActivity;
import com.mengshitech.colorrun.R;

/**
 * Created by atenklsy on 2016/7/14 12:04.
 * E-address:atenk@qq.com.
 */
public class Utility {
    public static void replace2DetailFragment(FragmentManager fragmentManager, Fragment fragment) {
        //跳转到子fragment，需要隐藏RadioGroup
        fragmentManager.beginTransaction().replace(R.id.flMain, fragment).addToBackStack(null).commit();
        MainActivity.rgMainBottom.setVisibility(View.GONE);
    }

    /**
     * 加入返回栈才能一个个地退出，即从AboutUs等子fragment中返回到meFragment，否则会直接退出
     * （因为这些fragment是放在MainActivity中的
     * ，不把这些fragment加入返回栈的话，返回栈中只有MainActivity
     * ，所以一旦点击了返回键，就会把MainActivity从返回栈中销毁）
     */

    public static void replace2MainFragment(FragmentManager fragmentManager, Fragment fragment) {
        //主页面四个fragment互相跳转，不需要隐藏RadioGrou
        fragmentManager.beginTransaction().replace(R.id.flMain, fragment).addToBackStack(null).commit();
    }
}
