package com.mengshitech.colorrun;

import android.app.Application;
import android.content.Context;

/**
 * 获取全局变量
 * 
 * @author atenklsy
 * 
 */
public class MyApplication extends Application {
	private static Context mContext;

	@Override
	public void onCreate() {
		super.onCreate();
		mContext = getApplicationContext();
	}

	public static Context getContext() {
		return mContext;
	}
}
