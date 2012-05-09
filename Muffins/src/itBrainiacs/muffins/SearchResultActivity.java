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

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ArrayList<String> shownList = new ArrayList<String>();
		shownList.add("SearchResultActivity open. List loaded.");

		
		Intent i = getIntent();
		if (i.hasCategory("Search")) {
			DataBook bookQuery = (DataBook) i.getParcelableExtra("QueriedBook");		
			LinkedList<DataBook> queryResultList = (LinkedList<DataBook>) ServerCommunicator.searchBooks(bookQuery);

			Toast.makeText(getApplicationContext(), "DB queried, list recieved" , Toast.LENGTH_LONG).show();
			DataBook book;
			while (queryResultList.size() > 0) {
				book = queryResultList.poll();
				shownList.add(book.getAuthor() + ": " + book.getTitle());
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
				Toast.makeText(getApplicationContext(), ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
			}
			
		});
	}
	
}

