package itBrainiacs.muffins;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class SettingsActivity extends Activity {
	
	private EditText emailET;
	private EditText phoneET;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.settings_layout);
		
		/* Getting references to the objects (views) specified in settings_layout.xml */
		emailET = (EditText) findViewById(R.id.settingsEmailET);
		phoneET = (EditText) findViewById(R.id.settingsPhoneET);
	}
	
}
