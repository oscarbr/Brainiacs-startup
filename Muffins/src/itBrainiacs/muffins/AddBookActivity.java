package itBrainiacs.muffins;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddBookActivity extends Activity implements OnClickListener {
	
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
		
		/* Setting the 'add' button to execute onClick() when pressed */
		addButton.setOnClickListener(this);
	}
	
	/* Method called when the 'Add' button has been pressed and the user wants to add a book to the database */
	private void addBook() {
		
		/* Get the Strings from the field edited by the user */
		String author = authorET.getText().toString();
		String title = titleET.getText().toString();
		
		/* Place holder Toast to notify that the listener works */
		Toast.makeText(getApplicationContext(), author + ", " + title + " has been added", Toast.LENGTH_LONG).show();
	}
	
	/* Method from the interface OnClickListener. Called when the any button that has this class as a listener is pressed*/
	public void onClick(View view) {
		this.addBook();
	}
}
