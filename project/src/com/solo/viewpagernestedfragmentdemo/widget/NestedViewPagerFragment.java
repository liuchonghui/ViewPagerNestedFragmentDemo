package com.solo.viewpagernestedfragmentdemo.widget;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.solo.viewpagernestedfragmentdemo.R;
import com.solo.viewpagernestedfragmentdemo.fragment.Usr1Fragment;
import com.solo.viewpagernestedfragmentdemo.fragment.Usr3Fragment;
import com.solo.viewpagernestedfragmentdemo.fragment.Usr4Fragment;

public class NestedViewPagerFragment extends Fragment {
	private static final String[] CONTENT = new String[] { "User1", "User2",
			"User3", "User4", };
	CustomViewPager pager;
	TabPageIndicator indicator;
	PagerAdapter mAdapter;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		if (pager == null) {
			pager = (CustomViewPager) getView().findViewById(R.id.nested_pager);
			pager.setTouchEnabled(false);
			pager.setOffscreenPageLimit(2);
			pager.setAdapter(new NestedStatePagerAdapter(getFragmentManager()));
		}

		if (indicator == null) {
			indicator = (TabPageIndicator) getView().findViewById(
					R.id.nested_indicator);
			indicator.setSmoothScroll(false);
			indicator.setViewPager(pager);
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.nested_simple_tabs, null);
	}

	public class NestedStatePagerAdapter extends FragmentStatePagerAdapter {

		private ArrayList<Fragment> fragments;

		public ArrayList<Fragment> getFragments() {
			return fragments;
		}

		public void setFragments(ArrayList<Fragment> fragments) {
			this.fragments = fragments;
		}

		public NestedStatePagerAdapter(FragmentManager fm) {
			super(fm);
			ArrayList<Fragment> container = new ArrayList<Fragment>();
			container.add(new Usr1Fragment());
			container.add(new NestedNestedViewPagerFragment());
			// container.add(new Usr2Fragment());
			container.add(new Usr3Fragment());
			container.add(new Usr4Fragment());
			setFragments(container);
		}

		@Override
		public Fragment getItem(int position) {
			return getFragments().get(position);
		}

		@SuppressLint("DefaultLocale")
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
