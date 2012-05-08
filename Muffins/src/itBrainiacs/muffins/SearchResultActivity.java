package itBrainiacs.muffins;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.ListActivity;
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
		
		/* Temporary solution, query will later be initiated from SearchActivity */
		DataBook loadDatabase = new DataBook();
		loadDatabase.setAuthor("emil nystrom");
		loadDatabase.setTitle("");
		
		LinkedList<DataBook> queryResultList = (LinkedList<DataBook>) ServerCommunicator.searchBooks(loadDatabase);
		ArrayList<String> shownList = new ArrayList<String>();
		
		if (queryResultList == null)
			Toast.makeText(getApplicationContext(), "No list found" , Toast.LENGTH_LONG).show();
		else {
			DataBook book;
			while (queryResultList.size() > 0) {
				book = queryResultList.poll();
				shownList.add(book.getTitle() + " by: " + book.getAuthor());
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
