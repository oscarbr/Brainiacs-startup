package itBrainiacs.muffins.test;

import android.test.*;
import itBrainiacs.muffins.SearchActivity;

public class SearchActivityTest extends ActivityInstrumentationTestCase2<SearchActivity> {
	
	SearchActivity searchActivity;
	
	
	public SearchActivityTest() {
		super(SearcActivity.class);
	}
	
	protected setUp() throws Exception {
		super.setUp();
		
		setActivityInitialTouchMode(false);
				
		searchActivity = getActivity();
		
	}
	
	public testPreConditions() {
		assertTrue(searchActivity != null);
	}
	
	public void testOnClick() {
		searchActivity.onClick(findViewById(itBrainiacs.muffins.R.id.searchSearchButton));
	}
}
