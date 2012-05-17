package itBrainiacs.muffins.test.ActivityTests;

import android.test.*;
import itBrainiacs.muffins.SearchActivity;

public class SearchActivityTest extends ActivityInstrumentationTestCase2<SearchActivity> {
	
	SearchActivity searchActivity;
	
	public SearchActivityTest() {
		super("itBrainiacs.muffins" ,SearchActivity.class);
	}
	
	protected void setUp() throws Exception {
		super.setUp();
		
		setActivityInitialTouchMode(false);
				
		searchActivity = getActivity();	
	}
	
	public void testOnClick() {
		//searchActivity.onClick(searchActivity.findViewById(itBrainiacs.muffins.R.id.searchSearchButton));
		
	}
}
