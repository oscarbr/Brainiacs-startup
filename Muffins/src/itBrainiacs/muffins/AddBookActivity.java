package itBrainiacs.muffins;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class AddBookActivity extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		TextView tw = new TextView(this);
		tw.setText("This is where you add your books that you wanna sell.");
		setContentView(tw);
	}
}
