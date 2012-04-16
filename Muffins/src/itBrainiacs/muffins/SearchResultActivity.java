package itBrainiacs.muffins;

import java.util.ArrayList;

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
		
		/* Place holder list */
		ArrayList<String> ph = new ArrayList<String>();
		ph.add("Rikard");
		ph.add("Emil");
		ph.add("Filip");
		ph.add("Oscar");
		
		/* The ArrayAdapter will later be of a type which we ourself create i.e. Sale */
		this.setListAdapter(new ArrayAdapter<String>(this, R.layout.search_results_list_item, ph)); 
		
		/* A pointer to our ListView, used to edit settings for the ListView */
		ListView lv = this.getListView();
		
		/* Filters the list if the user starts typing */
		lv.setTextFilterEnabled(true);
		
		lv.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				Toast.makeText(getApplicationContext(), ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
			}
			
		});
	}
}
