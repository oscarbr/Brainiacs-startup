package itBrainiacs.muffins.test;

import android.test.ActivityInstrumentationTestCase2;
import itBrainiacs.muffins.SettingsActivity;

public class SettingsActivityTest extends ActivityInstrumentationTestCase2<SettingsActivity> {

	SettingsActivity settingsActivity;
	
	public SettingsActivityTest() {
		super("itBrainiacs.muffins", SettingsActivity.class);
	}
	
	protected void setUp() throws Exception {
		super.setUp();
		
		setActivityInitialTouchMode(false);
		
		settingsActivity = getActivity();
	}
	
	public void testPreConditions() {
		assertTrue(settingsActivity != null);
	}
	
}