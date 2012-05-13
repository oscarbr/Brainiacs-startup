package itBrainiacs.muffins;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SettingsActivity extends Activity implements OnClickListener {
	
	private EditText nameET;
	private EditText emailET;
	private EditText phoneET;
	private EditText passwordET;
	
	private Button saveButton;
	private Button deleteButton;
	
	private Boolean detailsLoaded = false;
	private Boolean sufficientDetails = false;
	
	private String name = "";
	private String email = "";
	private String phone = "";
	private String password = "";
	private String userDetails = "";
	private String SavedUserDetails = "Muffins_saved_variables";
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.settings_layout);
		
		/* Getting references to the objects (views) specified in settings_layout.xml */
		nameET = (EditText) findViewById(R.id.settingsNameET);
		emailET = (EditText) findViewById(R.id.settingsEmailET);
		phoneET = (EditText) findViewById(R.id.settingsPhoneET);
		passwordET = (EditText) findViewById(R.id.settingsPasswordET);
		
		saveButton = (Button) findViewById(R.id.settingsSaveButton);
		saveButton.setOnClickListener(this);
		
		deleteButton = (Button) findViewById(R.id.settingsDeleteButton);
		deleteButton.setOnClickListener(this);
		
		try {
			FileInputStream fileRead = openFileInput(SavedUserDetails);
			DataInputStream dStream = new DataInputStream(fileRead);
			BufferedReader bReader = new BufferedReader(new InputStreamReader(dStream));
			name = bReader.readLine();
			email = bReader.readLine();
			phone = bReader.readLine();
			password = bReader.readLine();
			
			nameET.setText(name, TextView.BufferType.EDITABLE);
			emailET.setText(email, TextView.BufferType.EDITABLE);
			phoneET.setText(phone, TextView.BufferType.EDITABLE);
			passwordET.setText(password, TextView.BufferType.EDITABLE);
			
			detailsLoaded = true;
			
			// Check to see that the required details are correct
			if ((email.length() != 0 || phone.length() != 0) && password.length() > 4)
				sufficientDetails = true;
		}
		catch (IOException e) {
			Toast.makeText(getApplicationContext(), "No settings-file found", Toast.LENGTH_SHORT).show();
		}
		
		Intent intent = getIntent();
		if (intent.hasCategory("USER_DETAIL_CHECK")) {
			if (detailsLoaded && sufficientDetails)
				setResult(RESULT_OK, intent);
			else
				setResult(RESULT_CANCELED, intent);
			finish();
		}
			
		
	}
	
	/**
	 * Writes user details to private file in the internal storage of the device
	 * @param name Name of the application user
	 * @param email 
	 * @param phone 
	 * @param password
	 * @req No null values. If no information is entered empty Strings should be provided.
	 */
	private void saveSettings(String name, String email, String phone, String password) {
		userDetails = name + "\n" + email + "\n" + phone + "\n" + password;
		
		try {
			FileOutputStream fileWrite = openFileOutput(SavedUserDetails, Context.MODE_PRIVATE);
			fileWrite.write(userDetails.getBytes());
			fileWrite.close();
			Toast.makeText(getApplicationContext(), "User details saved", Toast.LENGTH_SHORT).show();
		}
		catch (IOException e) {
			Toast.makeText(getApplicationContext(), "File could not be created", Toast.LENGTH_SHORT).show();
		}
	}

	/**
	 * Clears all fields and deletes any previously saved files containing user details.
	 */
	private void deleteSettings() {
		userDetails = "";			
		if (deleteFile(SavedUserDetails)) {
			nameET.setText("");
			emailET.setText("");
			phoneET.setText("");
			passwordET.setText("");
		
			Toast.makeText(getApplicationContext(), "User details deleted", Toast.LENGTH_SHORT).show();
		}
		else
			Toast.makeText(getApplicationContext(), "File could not be found", Toast.LENGTH_SHORT).show();
		}
	

	public void onClick(View view) {
		if (view.getId() == R.id.settingsSaveButton) {
			name = nameET.getText().toString();
			email= emailET.getText().toString();
			phone = phoneET.getText().toString();
			password = passwordET.getText().toString();
		
			saveSettings(name, email, phone, password);
		}
		else if (view.getId() == R.id.settingsDeleteButton)
			deleteSettings();
	}
}
