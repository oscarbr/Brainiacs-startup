package itBrainiacs.muffins;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SearchResultActivity extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		/* Placeholder textview */
		
		TextView tw = new TextView(this);
		tw.setText("This is where the search results will show up.");
		this.setContentView(tw);
	}
}
