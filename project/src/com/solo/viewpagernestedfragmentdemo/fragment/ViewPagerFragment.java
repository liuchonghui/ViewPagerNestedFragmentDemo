package com.solo.viewpagernestedfragmentdemo.fragment;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.solo.viewpagernestedfragmentdemo.R;
import com.solo.viewpagernestedfragmentdemo.widget.PagerIndicator;

public class ViewPagerFragment extends Fragment {
	private static final String[] CONTENT = new String[] { "User1", "User2",
			"User3" };
	ViewPager pager;
	PagerIndicator indicator;
	PagerAdapter mAdapter;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		if (pager == null) {
			pager = (ViewPager) getView().findViewById(R.id.pager);
			pager.setAdapter(new UserStatePagerAdapter(getFragmentManager()));
		}

		if (indicator == null) {
			indicator = (PagerIndicator) getView().findViewById(
					R.id.indicator);
			indicator.setViewPager(pager);
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.pager_tabs, null);
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
			container.add(new Usr2Fragment());
			// container.add(new NestedViewPagerFragment());
			container.add(new Usr3Fragment());
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
