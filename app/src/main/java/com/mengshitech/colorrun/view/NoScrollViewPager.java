package com.mengshitech.colorrun.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class NoScrollViewPager extends ViewPager {

	/**
	 * @param context
	 * @param attrs
	 */
	public NoScrollViewPager(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param context
	 */
	public NoScrollViewPager(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public boolean onInterceptTouchEvent(MotionEvent event) {
		return false;
	}

	/**
	 * 禁止滑动触摸
	 */
	public boolean onTouchEvent(MotionEvent event) {
		return false;
	}
}