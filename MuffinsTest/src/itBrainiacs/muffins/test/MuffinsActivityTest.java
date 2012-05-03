package itBrainiacs.muffins.test;

import itBrainiacs.muffins.MuffinsActivity;
import android.test.ActivityInstrumentationTestCase2;

public class MuffinsActivityTest extends
		ActivityInstrumentationTestCase2<MuffinsActivity> {

	public MuffinsActivityTest() {
		super("itBrainiacs.muffins", MuffinsActivity.class);
	}
	
	public MuffinsActivityTest(String pkg, Class<MuffinsActivity> activityClass) {
		super(pkg, activityClass);
	}

}
