package itBrainiacs.muffins.test.ActivityTests;

import android.test.ActivityInstrumentationTestCase2;
import itBrainiacs.muffins.SearchResultActivity;

public class SearchResultActivityTest extends ActivityInstrumentationTestCase2<SearchResultActivity> {

	SearchResultActivity searchResultActivity;
	
	public SearchResultActivityTest() {
		super("itBrainiacs.muffins", SearchResultActivity.class);
	}
	
	protected void setUp() throws Exception {
		super.setUp();
		
		setActivityInitialTouchMode(false);
		
		searchResultActivity = getActivity();
	}

}