package com.solo.viewpagernestedfragmentdemo.fragment;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.solo.viewpagernestedfragmentdemo.R;
import com.solo.viewpagernestedfragmentdemo.widget.CustomViewPager;
import com.solo.viewpagernestedfragmentdemo.widget.NestedViewPagerFragment;
import com.solo.viewpagernestedfragmentdemo.widget.TabPageIndicator;

public class ViewPagerNestingViewPagerFragment extends Fragment {
	private static final String[] CONTENT = new String[] { "User1", "User2",
			"User3", "User4", };
	CustomViewPager pager;
	TabPageIndicator indicator;
	PagerAdapter mAdapter;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		if (pager == null) {
			pager = (CustomViewPager) getView().findViewById(R.id.nest_pager);
			pager.setTouchEnabled(false);
			pager.setOffscreenPageLimit(3);
			pager.setAdapter(new UserStatePagerAdapter(
					getChildFragmentManager()));
		}

		if (indicator == null) {
			indicator = (TabPageIndicator) getView().findViewById(
					R.id.nest_indicator);
			indicator.setSmoothScroll(false);
			indicator.setViewPager(pager);
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.nested_tabs, null);
	}

	public class UserStatePagerAdapter extends FragmentStatePagerAdapter {

		private ArrayList<Fragment> fragments;

		public ArrayList<Fragment> getFragments() {
			return fragments;
		}

		public void setFragments(ArrayList<Fragment> fragments) {
			this.fragments = fragments;
		}

		public UserStatePagerAdapter(FragmentManager fm) {
			super(fm);
			ArrayList<Fragment> container = new ArrayList<Fragment>();
			container.add(new Usr1Fragment());
			container.add(new NestedViewPagerFragment());
			// container.add(new Usr2Fragment());
			container.add(new Usr3Fragment());
			container.add(new Usr4Fragment());
			setFragments(container);
		}

		@Override
		public Fragment getItem(int position) {
			return getFragments().get(position);
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return CONTENT[position % CONTENT.length];
		}

		@Override
		public int getCount() {
			return CONTENT.length;
		}

	}
}
