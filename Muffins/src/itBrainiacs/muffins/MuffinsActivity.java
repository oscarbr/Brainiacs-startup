
package itBrainiacs.muffins;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

public class MuffinsActivity extends TabActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        /* Edit layout/main.xml to change the settings for layout */
        setContentView(R.layout.main);
        
        /* Use res to access the res-folder (drawables) */
        Resources res = getResources();
        
        
        TabHost tabHost = getTabHost();
        
        /* TabSpec and Intent to be reused for every Activity put under each tab */
        TabHost.TabSpec spec;
        Intent intent;
        
        /* Setting the first tab to be intended to used as SearchActivity and setting the graphics for it */
        intent = new Intent().setClass(this, SearchActivity.class);
        spec = tabHost.newTabSpec("search").setIndicator("Search", res.getDrawable(R.drawable.icon_tab_search)).setContent(intent);
        tabHost.addTab(spec);
        
        /* Repeating the same for SearchResults */
        //intent = new Intent().setClass(this, SearchResultActivity.class);
        //spec = tabHost.newTabSpec("result").setIndicator("Store", res.getDrawable(R.drawable.icon_tab_searchresult)).setContent(intent);
        //tabHost.addTab(spec);
        
        /* The same procedure for AddBooks */
        intent = new Intent().setClass(this, AddBookActivity.class);
        spec = tabHost.newTabSpec("addBook").setIndicator("Add book", res.getDrawable(R.drawable.icon_tab_addbook)).setContent(intent);
        tabHost.addTab(spec);
        
        /* The same procedure for Settings */
        intent = new Intent().setClass(this, SettingsActivity.class);
        spec = tabHost.newTabSpec("settings").setIndicator("Settings", res.getDrawable(R.drawable.icon_tab_settings)).setContent(intent);
        tabHost.addTab(spec);
        
        /* Setting the default tab to be the first (search) */
        tabHost.setCurrentTab(0);
    }
}