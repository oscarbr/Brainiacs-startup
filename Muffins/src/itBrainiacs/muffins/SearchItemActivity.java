package itBrainiacs.muffins;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Activity showing a specific book selected from the list retrieved when searching for books.
 */
public class SearchItemActivity extends Activity implements OnClickListener {

	/**
	 * Initializing the activity
	 *  
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.search_item_layout);

		TextView title = (TextView) findViewById(R.id.bookTitleTW);
		TextView author = (TextView) findViewById(R.id.bookAuthorTW);
		TextView price = (TextView) findViewById(R.id.bookPriceTW);
		TextView edition = (TextView) findViewById(R.id.editionTW);
		TextView comment = (TextView) findViewById(R.id.commentTW);
		TextView isbn = (TextView) findViewById(R.id.isbnTW);
		TextView course = (TextView) findViewById(R.id.courseTW);
		TextView email = (TextView) findViewById(R.id.emailTW);
		TextView phone = (TextView) findViewById(R.id.phoneTW);

		Intent i = getIntent();
		if (i.getCategories().contains("showInfo")) {
			DataBook book = (DataBook) i.getParcelableExtra("book");

			title.setText(book.getTitle());
			author.setText(book.getAuthor());
			price.setText(book.getPrice() + " SEK");

			String bookEdition = book.getEdition();
			if (!bookEdition.equals("null")) {
				edition.setText("Edition: " + bookEdition);
				edition.setVisibility(View.VISIBLE);
			}

			String bookIsbn = book.getIsbn();
			if (!bookIsbn.equals("null")) {
				isbn.setText("ISBN: " + bookIsbn);
				isbn.setVisibility(View.VISIBLE);
			}

			String bookCourse = book.getCourse();
			if (!bookCourse.equals("null")) {
				course.setText("Course: " + bookCourse);
				course.setVisibility(View.VISIBLE);
			}
			
			String bookComment = book.getComment();
			if (!bookComment.equals("null")) {
				comment.setText("Comment by uploader:\n" + bookComment);
				comment.setVisibility(View.VISIBLE);
			}
			
			if (book.getEmail() != null) {
				email.setText(book.getEmail());
				email.setVisibility(View.VISIBLE);
			}
			
			if (book.getPhone() != null) {
				phone.setText(book.getPhone());
				phone.setVisibility(View.VISIBLE);
			}
		}
	}

	/**
	 * Method from the interface OnClickListener. Called when the any button
	 * that has this class as a listener is pressed
	 * 
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 */
	public void onClick(View arg0) {
		// TODO Auto-generated method stub

	}

}
