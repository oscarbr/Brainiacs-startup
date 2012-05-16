package itBrainiacs.muffins;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SearchItemActivity extends Activity implements OnClickListener {
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.search_item_layout);
		
		TextView title = (TextView) findViewById(R.id.bookTitleTW);
		TextView author = (TextView) findViewById(R.id.bookAuthorTW);
		TextView price = (TextView) findViewById(R.id.bookPriceTW);
		TextView edition = (TextView) findViewById(R.id.editionTW);
		TextView comment = (TextView) findViewById(R.id.commentTW);
		
		
		Intent i = getIntent();
		if (i.getCategories().contains("showInfo")) {
			DataBook book = (DataBook) i.getParcelableExtra("book");
			
			title.setText(book.getTitle());
			author.setText(book.getAuthor());
			price.setText(book.getPrice() + " SEK");
			
			String bookComment = book.getComment();
			if (!bookComment.equals("null")) {
				comment.setText("Comment by uploader:\n" + bookComment);
				comment.setVisibility(View.VISIBLE);
			}
			
			String bookEdition = book.getEdition();
			if (!bookEdition.equals("null")) {
				edition.setText("Edition: " + bookEdition);
				edition.setVisibility(View.VISIBLE);
			}			
		}
			
		
	}

	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
