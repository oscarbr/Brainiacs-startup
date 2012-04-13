package itBrainiacs.muffins;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SearchActivity extends Activity {
	
	/** Called when the activity is initially created */
    
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        /* Placeholder textView */
        
        TextView tw = new TextView(this);
        tw.setText("This is where you search for books by differnet criterias");
        this.setContentView(tw);
    }
}
