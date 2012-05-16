package itBrainiacs.muffins.test.ActivityTests;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;
import itBrainiacs.muffins.SettingsActivity;

public class SettingsActivityTest extends ActivityInstrumentationTestCase2<SettingsActivity> {

	SettingsActivity settingsActivity;
	EditText name;
	EditText email;
	EditText phone;
	EditText password;
	
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
	
	public void testSaveSettings() {
		
		String testName = "TestName";
		String testEmail = "TestEmail";
		String testPhone = "1";
		String testPassword = "TestPassword";
		
		setupEditTexts();
		
		name.setText(testName);
		email.setText(testEmail);
		phone.setText(testPhone);
		password.setText(testPassword);
		
		settingsActivity.onClick(settingsActivity.findViewById(itBrainiacs.muffins.R.id.settingsSaveButton));
		settingsActivity.finish();
		settingsActivity = getActivity();
		
		setupEditTexts();
		
		assertEquals(name.getText().toString(), testName);
		assertEquals(email.getText().toString(), testEmail);
		assertEquals(phone.getText().toString(), testPhone);
		assertEquals(password.getText().toString(), testPassword);
	}
	
	public void testDeleteSettings() {
		setupEditTexts();
		settingsActivity.onClick(settingsActivity.findViewById(itBrainiacs.muffins.R.id.settingsDeleteButton));
		
		assertEquals(name.getText().toString(), "");
		assertEquals(email.getText().toString(), "");
		assertEquals(phone.getText().toString(), "");
		assertEquals(password.getText().toString(), "");
	}
	
	private void setupEditTexts() {
		
		name = (EditText) settingsActivity.findViewById(itBrainiacs.muffins.R.id.settingsNameET);
		email = (EditText) settingsActivity.findViewById(itBrainiacs.muffins.R.id.settingsEmailET);
		phone = (EditText) settingsActivity.findViewById(itBrainiacs.muffins.R.id.settingsPhoneET);
		password = (EditText) settingsActivity.findViewById(itBrainiacs.muffins.R.id.settingsPasswordET);
		
		String testName = "TestName";
		String testEmail = "TestEmail";
		String testPhone = "1";
		String testPassword = "TestPassword";
				
		name.setText(testName);
		email.setText(testEmail);
		phone.setText(testPhone);
		password.setText(testPassword);
	}
}