package hu.joszolgalat.android.app.ui.tablet;
//package com.ushahidi.android.app.ui.tablet;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TabHost;

import hu.joszolgalat.android.app.R;
import hu.joszolgalat.android.app.helpers.LocalActivityManagerFragment;
import hu.joszolgalat.android.app.ui.phone.CheckinMapActivity;
//import com.ushahidi.android.app.R;
//import com.ushahidi.android.app.helpers.LocalActivityManagerFragment;
//import com.ushahidi.android.app.ui.phone.CheckinMapActivity;

public class CheckinTabFragment extends LocalActivityManagerFragment {

	private TabHost mTabHost;

	private static final String TAG_LIST_CHECKIN = "list";

	private static final String TAG_MAP_CHECKIN = "map";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.tabs_report, container, false);
		mTabHost = (TabHost) view.findViewById(android.R.id.tabhost);
		mTabHost.setup(getLocalActivityManager());
		listListTab();
		listMapTab();
		return view;
	}


	private void listListTab() {
		if (mTabHost != null) {
			addTab(TAG_LIST_CHECKIN, R.drawable.list, ListCheckinFragmentActivity.class);
		}
	}

	private void listMapTab() {
		if (mTabHost != null) {
			addTab(TAG_MAP_CHECKIN, R.drawable.map, CheckinMapActivity.class);
		}
	}

	private void addTab(String indicator, int drawableId, Class<?> c) {
		TabHost tabHost = mTabHost;
		TabHost.TabSpec spec = tabHost.newTabSpec(indicator);
		Intent intent = new Intent(getActivity(), c);
		View tabIndicator = LayoutInflater.from(getActivity()).inflate(
				R.layout.tab_indicator, tabHost.getTabWidget(), false);
		ImageView icon = (ImageView) tabIndicator.findViewById(R.id.icon);
		icon.setImageResource(drawableId);
		spec.setIndicator(tabIndicator);
		spec.setContent(intent);
		tabHost.addTab(spec);
	}

	static CheckinTabFragment newInstance() {
		CheckinTabFragment f = new CheckinTabFragment();
		return f;
	}
}