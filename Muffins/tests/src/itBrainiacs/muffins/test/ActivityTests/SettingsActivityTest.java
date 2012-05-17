package itBrainiacs.muffins.test.ActivityTests;

import android.test.ActivityInstrumentationTestCase2;
import itBrainiacs.muffins.SettingsActivity;


public class SettingsActivityTest extends ActivityInstrumentationTestCase2<SettingsActivity> {

	private SettingsActivity settingsActivity;

	
	public SettingsActivityTest() {
		super("itBrainiacs.muffins", SettingsActivity.class);
	}
	
	protected void setUp() throws Exception {
		super.setUp();
		
		setActivityInitialTouchMode(false);
		
		settingsActivity = getActivity();
	}
}
	
	