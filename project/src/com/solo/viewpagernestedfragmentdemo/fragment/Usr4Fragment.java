package com.solo.viewpagernestedfragmentdemo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.solo.viewpagernestedfragmentdemo.R;

public class Usr4Fragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		RelativeLayout v1 = new RelativeLayout(getActivity());
		v1.setTag(new StringBuilder("usr4"));

		v1.setBackgroundResource(R.drawable.usr4);
		return v1;
	}
}
