package com.solo.viewpagernestedfragmentdemo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.solo.viewpagernestedfragmentdemo.R;
import com.solo.viewpagernestedfragmentdemo.ViewPagerNestedFragmentDemo;

public class SideMenuFragment extends ListFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.list, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		String[] colors = getResources().getStringArray(R.array.names);
		ArrayAdapter<String> mdapter = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, android.R.id.text1, colors);
		setListAdapter(mdapter);
	}

	@Override
	public void onListItemClick(ListView lv, View v, int position, long id) {
		Fragment newContent = null;
		switch (position) {
		case 0:
			newContent = new ViewPagerFragment();
			break;
		case 1:
			newContent = new CustomViewPagerFragment();
			break;
		case 2:
			newContent = new ViewPagerNestingViewPagerFragment();
			break;
		}
		if (newContent != null) {
			switchFragment(newContent, String.valueOf(position));
		}
	}

	private void switchFragment(Fragment fragment, String id) {
		if (getActivity() == null || getActivity().isFinishing()) {
			return;
		}

		if (getActivity() instanceof ViewPagerNestedFragmentDemo) {
			ViewPagerNestedFragmentDemo activity = (ViewPagerNestedFragmentDemo) getActivity();
			activity.switchContent(fragment, id);
		}
	}

}
