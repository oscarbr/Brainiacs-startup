package itBrainiacs.muffins;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SettingsActivity extends Activity {
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		TextView tw = new TextView(this);
		tw.setText("This is where settings of the app will go. Here you will enter your personal information");
		this.setContentView(tw);
	}
	
}
