package itBrainiacs.muffins.test.ActivityTests;

import android.test.ActivityInstrumentationTestCase2;
import itBrainiacs.muffins.SettingsActivity;
import android.widget.EditText;

public class SettingsActivityTest extends ActivityInstrumentationTestCase2<SettingsActivity> {

	private SettingsActivity settingsActivity;
	private EditText name;
	private EditText email;
	private EditText phone;
	private EditText password;
	private String testName = "TestName";
	private String testEmail = "TestEmail";
	private String testPhone = "1";
	private String testPassword = "TestPassword";

	
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

		settingsActivity.runOnUiThread(
				new Runnable() {
					public void run() {
						name = (EditText) settingsActivity.findViewById(itBrainiacs.muffins.R.id.settingsNameET);
						email = (EditText) settingsActivity.findViewById(itBrainiacs.muffins.R.id.settingsEmailET);
						phone = (EditText) settingsActivity.findViewById(itBrainiacs.muffins.R.id.settingsPhoneET);
						password = (EditText) settingsActivity.findViewById(itBrainiacs.muffins.R.id.settingsPasswordET);

						settingsActivity.onClick(settingsActivity.findViewById(itBrainiacs.muffins.R.id.settingsSaveButton));
						settingsActivity.finish();
						settingsActivity = getActivity();

						name = (EditText) settingsActivity.findViewById(itBrainiacs.muffins.R.id.settingsNameET);
						email = (EditText) settingsActivity.findViewById(itBrainiacs.muffins.R.id.settingsEmailET);
						phone = (EditText) settingsActivity.findViewById(itBrainiacs.muffins.R.id.settingsPhoneET);
						password = (EditText) settingsActivity.findViewById(itBrainiacs.muffins.R.id.settingsPasswordET);

						assertEquals(name.getText().toString(), testName);
						assertEquals(email.getText().toString(), testEmail);
						assertEquals(phone.getText().toString(), testPhone);
						assertEquals(password.getText().toString(), testPassword);
					}
				});
		}

		public void testDeleteSettings() {

			settingsActivity.runOnUiThread(
				new Runnable() {
					public void run() {
						name = (EditText) settingsActivity.findViewById(itBrainiacs.muffins.R.id.settingsNameET);
						email = (EditText) settingsActivity.findViewById(itBrainiacs.muffins.R.id.settingsEmailET);
						phone = (EditText) settingsActivity.findViewById(itBrainiacs.muffins.R.id.settingsPhoneET);
						password = (EditText) settingsActivity.findViewById(itBrainiacs.muffins.R.id.settingsPasswordET);

						name.setText(testName);
						email.setText(testEmail);
						phone.setText(testPhone);
						password.setText(testPassword);

						settingsActivity.onClick(settingsActivity.findViewById(itBrainiacs.muffins.R.id.settingsDeleteButton));

						assertEquals(name.getText().toString(), "");
						assertEquals(email.getText().toString(), "");
						assertEquals(phone.getText().toString(), "");
						assertEquals(password.getText().toString(), "");

					}
				});
		}
}
	
	