package itBrainiacs.muffins;

//TESTING TO COMMENT TO GET THIS SHIT WORKING!

import java.util.LinkedList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.Toast;

/* implementing OnClickListener in order to catch events where buttons are clicked and something needs to happen */
public class SearchActivity extends Activity implements OnClickListener {
	
	/* Variables to act as references to views specified in the layout-XML */
	private Button searchButton;
	private EditText isbnET;
	private EditText authorET;
	private EditText titleET;
	private EditText versionET;
	private EditText courseET;
	
	/** Called when the activity is initially created */

	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.search_layout);
        
		/* Getting references to the objects (views) specified in the layout-XML */
        isbnET = (EditText) findViewById(R.id.searchISBNET);
        authorET = (EditText) findViewById(R.id.searchAuthorET);
        titleET = (EditText) findViewById(R.id.searchTitleET);
        versionET = (EditText) findViewById(R.id.searchVersionET);
        courseET = (EditText) findViewById(R.id.searchCourseET);
        searchButton = (Button) findViewById(R.id.searchSearchButton);
        
		/* Setting the 'add' button to execute onClick() when pressed */
		searchButton.setOnClickListener(this);
    }

	/* Method called when the searchButton is pressed */
	public void onClick(View view) {
		searchBooks();
	}
	
	/* Method to be called when executing a search */
	private void searchBooks() {
		/* Fetching the text filled in by the user in the fields */
		String author = authorET.getText().toString();
		String title = titleET.getText().toString();
		String isbn = isbnET.getText().toString();
		String version = versionET.getText().toString();
		String course = courseET.getText().toString();
		
		
		/* creates a DataBook-object which is to be queried from the database via the SearchResultActivity */
		DataBook bookQuery = new DataBook();
		bookQuery.setAuthor(author);
		bookQuery.setTitle(title);
		bookQuery.setIsbn(isbn);

		Intent i = new Intent(this, SearchResultActivity.class);
		i.addCategory("Search");
		i.putExtra("QueriedBook", bookQuery);
		
		startActivity(i);

	}
	

}
	