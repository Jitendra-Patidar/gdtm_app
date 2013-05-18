package com.gdtm.app.control;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * 
 * @author Nari Kim (wassupnari@gmail.com)
 */

public class FragmentMeetingList extends Fragment {

	private String arry[] = { "July. 6", "July. 13", "July. 20", "July. 27", "Aug. 3", "Aug. 10",
			"Aug. 17", "Aug. 24", "Aug. 31" };

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		ListView listView = new ListView(getActivity());
		ArrayAdapter<String> array = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1);
		for (String str : arry) {
			array.add(str);
		}
		listView.setAdapter(array);
		return listView;
	}
}
