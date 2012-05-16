package itBrainiacs.muffins.test;

import android.test.*;
import itBrainiacs.muffins.SearchActivity;

public class SearchActivityTest extends ActivityInstrumentationTestCase2<SearchActivity> {
	
	SearchActivity searchActivity;
	
	
	public SearchActivityTest() {
		super(SearchActivity.class);
	}
	
	protected void setUp() throws Exception {
		super.setUp();
		
		setActivityInitialTouchMode(false);
				
		searchActivity = getActivity();
		
	}
	
	public void testPreConditions() {
		assertTrue(searchActivity != null);
	}
	
	public void testOnClick() {
		searchActivity.onClick(searchActivity.findViewById(itBrainiacs.muffins.R.id.searchSearchButton));
	}
}
