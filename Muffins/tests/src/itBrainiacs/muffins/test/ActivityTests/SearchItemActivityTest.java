package itBrainiacs.muffins.test.ActivityTests;

import android.test.ActivityInstrumentationTestCase2;
import itBrainiacs.muffins.SearchItemActivity;

public class SearchItemActivityTest extends ActivityInstrumentationTestCase2<SearchItemActivity> {

	SearchItemActivity searchItemActivity;
	
	public SearchItemActivityTest() {
		super("itBrainiacs.muffins", SearchItemActivity.class);
	}
	
	protected void setUp() throws Exception {
		super.setUp();
		
		setActivityInitialTouchMode(false);
		
		searchItemActivity = getActivity();
	}
	
	public void testPreConditions() {
		assertTrue(searchItemActivity != null);
	}
}