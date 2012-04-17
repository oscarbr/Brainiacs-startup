package itBrainiacs.muffins;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class AddBookActivity extends Activity {
	
	
	/* Variables to be act as hooks to views specified in the layout-XML */
	private EditText authorET;
	private EditText titleET;
	private Button addButton;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.add_book_layout);
		
		/* Getting references to the objects (views) specified in the layout-XML */
		authorET = (EditText) findViewById(R.id.addBookAuthorET);
		titleET = (EditText) findViewById(R.id.addBookTitleET);
		addButton = (Button) findViewById(R.id.addBookAddButton);
	}
}
