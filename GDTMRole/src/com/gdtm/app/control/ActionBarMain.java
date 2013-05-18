package com.gdtm.app.control;

import com.gdtm.app.R;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

/**
 * @author Nari Kim (wassupnari@gmail.com)
 */

public class ActionBarMain extends Activity implements TabListener {

	RelativeLayout rl;

	FragmentMain mFragMain;
	FragmentCL mFragCL;
	FragmentSetting mFragSetting;
	FragmentCC mFragCC;
	FragmentMeetingList mFragMeetingList;

	FragmentTransaction mFragTransaction = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.control_actionbar_main);
		try {
			rl = (RelativeLayout) findViewById(R.id.mainLayout);
			mFragTransaction = getFragmentManager().beginTransaction();
			ActionBar bar = getActionBar();
			bar.addTab(bar.newTab().setText("Meeting List").setTabListener(this));
			bar.addTab(bar.newTab().setText("CL").setTabListener(this));
			bar.addTab(bar.newTab().setText("Upcoming Meeting").setTabListener(this));
			bar.addTab(bar.newTab().setText("CC").setTabListener(this));
			bar.addTab(bar.newTab().setText("Setting").setTabListener(this));

			bar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM | ActionBar.DISPLAY_USE_LOGO);
			bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
			bar.setDisplayShowHomeEnabled(true);
			bar.setDisplayShowTitleEnabled(false);
			bar.show();

		} catch (Exception e) {
			e.getMessage();
		}
		/**
		 * Hiding Action Bar
		 */
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		getMenuInflater().inflate(R.menu.menu_actionbar_main, menu);
		return true;
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {

	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {

		if (tab.getText().equals("Meeting List")) {
			try {
				rl.removeAllViews();
			} catch (Exception e) {
			}
			mFragMeetingList = new FragmentMeetingList();
			mFragTransaction.addToBackStack(null);
			mFragTransaction = getFragmentManager().beginTransaction();
			mFragTransaction.add(rl.getId(), mFragMeetingList);
			mFragTransaction.commit();
		} else if (tab.getText().equals("CL")) {
			try {
				rl.removeAllViews();
			} catch (Exception e) {
			}
			mFragCL = new FragmentCL();
			mFragTransaction.addToBackStack(null);
			mFragTransaction = getFragmentManager().beginTransaction();
			mFragTransaction.add(rl.getId(), mFragCL);
			mFragTransaction.commit();
		} else if (tab.getText().equals("Upcoming Meeting")) {
			try {
				rl.removeAllViews();
			} catch (Exception e) {
			}
			mFragMain = new FragmentMain();
			mFragTransaction.addToBackStack(null);
			mFragTransaction = getFragmentManager().beginTransaction();
			mFragTransaction.add(rl.getId(), mFragMain);
			mFragTransaction.commit();
		} else if (tab.getText().equals("CC")) {
			try {
				rl.removeAllViews();
			} catch (Exception e) {
			}
			mFragCC = new FragmentCC();
			mFragTransaction.addToBackStack(null);
			mFragTransaction = getFragmentManager().beginTransaction();
			mFragTransaction.add(rl.getId(), mFragCC);
			mFragTransaction.commit();
		} else if (tab.getText().equals("Setting")) {
			try {
				rl.removeAllViews();
			} catch (Exception e) {
			}
			mFragSetting = new FragmentSetting();
			mFragTransaction.addToBackStack(null);
			mFragTransaction = getFragmentManager().beginTransaction();
			mFragTransaction.add(rl.getId(), mFragSetting);
			mFragTransaction.commit();
		}

	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {

	}

}
