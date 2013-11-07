package com.navercorp.utilsettest.test;

import android.app.Activity;
import android.os.Handler;
import android.test.ActivityInstrumentationTestCase2;

import com.jayway.android.robotium.solo.Solo;
import com.navercorp.utilset.ui.ScreenUtils;
import com.navercorp.utilsettest.MainActivity;

public class ScreenUtilsTestCase extends
		ActivityInstrumentationTestCase2<MainActivity> {
	private Solo solo;

	public ScreenUtilsTestCase() {
		// TODO Auto-generated constructor stub
		super(MainActivity.class);
	}

	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();

		solo = new Solo(getInstrumentation(), getActivity());
	}
	
	public void tearDown() throws Exception
	{
        solo.finishOpenedActivities();
	}
	
	private Handler handler = new Handler();

	public void testSetBrightness() {
		final Activity activity = solo.getCurrentActivity();

		handler.postDelayed(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				ScreenUtils.setScreenBrightness(activity, 0.04f);
			}
		}, 500);
		
		handler.postDelayed(new Runnable() {
			@Override
			public void run() {
				ScreenUtils.setScreenBrightness(activity, 1.0f);
			}
		}, 1500);

		solo.sleep(3000);
	}
}
