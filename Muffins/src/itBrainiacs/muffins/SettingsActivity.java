package itBrainiacs.muffins;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
			
			Toast.makeText(getApplicationContext(), "Settings loaded", Toast.LENGTH_SHORT).show();
		}
		catch (IOException e) {
			Toast.makeText(getApplicationContext(), "Settings-file could not be found", Toast.LENGTH_SHORT).show();
		}
	}
	
	private void saveSettings() {
		name = nameET.getText().toString();
		email= emailET.getText().toString();
		phone = phoneET.getText().toString();
		password = passwordET.getText().toString();
		
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
