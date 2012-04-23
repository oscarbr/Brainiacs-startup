package itBrainiacs.muffins;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Context;
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
			DataInputStream dataStream = new DataInputStream(fileRead);
			name = dataStream.readLine();
			email = dataStream.readLine();
			phone = dataStream.readLine();
			password = dataStream.readLine();
		}
		catch (IOException e) {
			Toast.makeText(getApplicationContext(), "Settings-file could not be found", Toast.LENGTH_SHORT).show();
		}
	}
	
	private void saveSettings() {
		userDetails = name + "\n" + email + "\n" + phone + "\n" + password;
		/* Writing user details to private file in the internal storage of the device */
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

	private void deleteSettings() {
		userDetails = "";			
		if (deleteFile(SavedUserDetails))
			Toast.makeText(getApplicationContext(), "User details deleted", Toast.LENGTH_SHORT).show();
		else
			Toast.makeText(getApplicationContext(), "File could not be found", Toast.LENGTH_SHORT).show();
		}
	

	public void onClick(View view) {
		if (view.getId() == R.id.settingsSaveButton) 
			saveSettings();
		else if (view.getId() == R.id.settingsDeleteButton)
			deleteSettings();
	}
	
}
