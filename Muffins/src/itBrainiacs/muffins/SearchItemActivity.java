package itBrainiacs.muffins;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

public class SearchItemActivity extends Activity implements OnClickListener {
	TextView title;
	TextView author;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.search_item_layout);
		
		title = (TextView) findViewById(R.id.bookTitleTW);
		author= (TextView) findViewById(R.id.bookAuthorTW);
	}

	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
