package itBrainiacs.muffins.test;

import android.test.ActivityInstrumentationTestCase2;
import itBrainiacs.muffins.AddBookActivity;

public class AddBookActivityTest extends ActivityInstrumentationTestCase2<AddBookActivity> {

	AddBookActivity addBookActivity;
	
	public AddBookActivityTest() {
		super("itBrainiacs.muffins", AddBookActivity.class);
	}
	
	protected void setUp() throws Exception {
		super.setUp();
		
		setActivityInitialTouchMode(false);
		
		addBookActivity = getActivity();
	}
	
	public void testPreConditions() {
		assertTrue(addBookActivity != null);
	}
	
	public void testOnClick() {
		addBookActivity.onClick(addBookActivity.findViewById(itBrainiacs.muffins.R.id.addBookAddButton));	
	}
}