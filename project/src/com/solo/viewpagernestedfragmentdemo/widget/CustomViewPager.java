package com.solo.viewpagernestedfragmentdemo.widget;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * @author liu_chonghui
 * 
 */
public class CustomViewPager extends ViewPager {

	private boolean mEnabled = true;

	public CustomViewPager(Context context) {
		this(context, null);
	}

	public CustomViewPager(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	public void setAdapter(PagerAdapter adapter) {
		super.setAdapter(adapter);
	}

	public void setTouchEnabled(boolean enabled) {
		mEnabled = enabled;
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		return mEnabled ? super.onInterceptTouchEvent(ev) : false;
	}

	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		return mEnabled ? super.onTouchEvent(ev) : false;
	}

}