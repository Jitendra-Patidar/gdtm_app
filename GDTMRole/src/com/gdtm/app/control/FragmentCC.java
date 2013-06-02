package com.gdtm.app.control;

import com.gdtm.app.R;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author Nari Kim (wassupnari@gmail.com)
 */

public class FragmentCC extends Fragment {

	private String arry[] = { "Tofeeq", "Ahmad", "Fragment", "Example", "Tofeeq", "Ahmad",
			"Fragment", "Example" };

	private static final String PREFERENCE = "MyPrefFile";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.control_frag_cc, null);
		// GridView listView = (GridView) view.findViewById(R.id.cc_scroll);
		// listView.setAdapter(new Adapter());
		SharedPreferences setting = this.getActivity().getSharedPreferences(PREFERENCE, 0);

		return view;
	}

	public class CCDataOpenHelper extends SQLiteOpenHelper {

		private static final int DATABASE_VERSION = 0;

		private static final String KEY_WORD = "Role";
		private static final String KEY_DEFINITION = "Achieved";

		private static final String CC_TABLE_NAME = "CC Database";
		private static final String CC_TABLE_CREATE = "CREATE_TABLE" + CC_TABLE_NAME + " ("
				+ KEY_WORD + " TEXT, " + KEY_DEFINITION + " Text);";

		public CCDataOpenHelper(Context context, String name, CursorFactory factory, int version) {

			super(context, CC_TABLE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {

			db.execSQL(CC_TABLE_CREATE);
		}

		@Override
		public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {

		}

	}

}
