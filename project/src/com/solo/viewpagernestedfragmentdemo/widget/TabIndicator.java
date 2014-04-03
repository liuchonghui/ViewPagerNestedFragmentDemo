package com.solo.viewpagernestedfragmentdemo.widget;

public interface TabIndicator extends ViewPager.OnPageChangeListener {
	void setViewPager(ViewPager view);

	void setViewPager(ViewPager view, int initialPosition);

	void setCurrentItem(int item);

	void setOnPageChangeListener(ViewPager.OnPageChangeListener listener);

	void notifyDataSetChanged();
}
