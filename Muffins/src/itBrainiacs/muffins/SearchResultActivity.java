package itBrainiacs.muffins;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.TextView;

public class SearchResultActivity extends ListActivity {
	ArrayList<String> shownList;
	ArrayList<DataBook> bookList;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		shownList = new ArrayList<String>();
		bookList = new ArrayList<DataBook>();
		
		Intent i = getIntent();
		if (i.hasCategory("Search")) {
			DataBook bookQuery = (DataBook) i.getParcelableExtra("QueriedBook");		
			LinkedList<DataBook> queryResultList = (LinkedList<DataBook>) ServerCommunicator.searchBooks(bookQuery);

			DataBook book;
			if (queryResultList.size() == 0)
				shownList.add("No books found. Please make sure you are connected to the internet.");
			
			while (queryResultList.size() > 0) {
				book = queryResultList.poll();
				shownList.add(book.getTitle() + " by: " + book.getAuthor());
				bookList.add(book);
			}
		}
		
		
		/* The ArrayAdapter will later be of a type which we ourself create i.e. Sale */
		this.setListAdapter(new ArrayAdapter<String>(this, R.layout.search_results_list_item, shownList)); 
		
		
		/* A pointer to our ListView, used to edit settings for the ListView */
		ListView lv = this.getListView();
		
		/* Filters the list if the user starts typing */
		lv.setTextFilterEnabled(true);
		
		/* Defines what will happen if you click a button */
		lv.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View view, int position,	long id) {
				Intent bookInfoIntent = new Intent();
				bookInfoIntent.setClass(SearchResultActivity.this, SearchItemActivity.class);


				DataBook book = (DataBook) bookList.get(position);
				
				bookInfoIntent.addCategory("showInfo");
				bookInfoIntent.putExtra("book", book);

				startActivity(bookInfoIntent);
			}
			
		});
	}
	
}

