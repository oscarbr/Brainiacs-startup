package itBrainiacs.muffins.test;

import android.test.ActivityInstrumentationTestCase2;
import itBrainiacs.muffins.MuffinsActivity;

public class MuffinsActivityTest extends ActivityInstrumentationTestCase2<MuffinsActivity> {

	MuffinsActivity muffinsActivity;
	
	public MuffinsActivityTest() {
		super("itBrainiacs.muffins", MuffinsActivity.class);
	}
	
	protected void setUp() throws Exception {
		super.setUp();
		
		setActivityInitialTouchMode(false);
		
		muffinsActivity = getActivity();
	}
	
	public void testPreConditions() {
		assertTrue(muffinsActivity != null);
	}
	
	
}