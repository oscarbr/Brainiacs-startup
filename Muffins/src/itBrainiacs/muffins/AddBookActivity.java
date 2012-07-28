package itBrainiacs.muffins;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.Character;
import java.util.Calendar;


/**
 *  Activity class for adding a book
 */
public class AddBookActivity extends Activity implements OnClickListener {

	/* Variables to act as hooks to views specified in the layout-XML */
	private EditText authorET;
	private EditText titleET;
	private EditText isbnET;
	private EditText editionET;
	private EditText courseET;
	private EditText priceET;
	private EditText commentET;
	private Button takePictureButton;
	private Button searchBookButton;
	private Button addButton;

	DataBook newBook;
	/*
	 * To be implemented. To allow the poster of the book to edit/delete
	 * 
	 * private String name =""; private String email = ""; private String phone
	 * = ""; private String password = "";
	 */

	/*
	 * The code for activity request camera. To be implemented private final
	 * static int CAMERA_CATCHING_CODE = 100; private final static int
	 * MEDIA_TYPE_IMAGE = 1; private Uri imageUri;
	 */
	private final static int USER_DETAIL_REQUEST = 1;

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.add_book_layout);

		/* Getting references to the objects (views) specified in the layout-XML */
		authorET = (EditText) findViewById(R.id.addBookAuthorET);
		titleET = (EditText) findViewById(R.id.addBookTitleET);
		isbnET = (EditText) findViewById(R.id.addBookISBNET);
		editionET = (EditText) findViewById(R.id.addBookEditionET);
		courseET = (EditText) findViewById(R.id.addBookCourseET);
		priceET = (EditText) findViewById(R.id.addBookPriceET);
		commentET = (EditText) findViewById(R.id.addBookCommentET);

		/*
		 * Picturebutton to be implemented. takePictureButton = (Button)
		 * findViewById(R.id.addBookTakePictureButton);
		 */
		searchBookButton = (Button) findViewById(R.id.searchBookButton);
		addButton = (Button) findViewById(R.id.addBookAddButton);

		/* Setting buttons to execute onClick() when pressed */
		searchBookButton.setOnClickListener(this);
		addButton.setOnClickListener(this);
	}

	/**
	 * Method from the interface OnClickListener. Called when the any button
	 * that has this class as a listener is pressed
	 *
	 * @param view the view
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 */
	public void onClick(View view) {
		if (view.getId() == R.id.searchBookButton) {
			searchIsbn();
		} else if (view.getId() == R.id.addBookAddButton) {
			addBook();
		} else if (view.getId() == R.id.addBookTakePictureButton) {
			// takePicture();
		}
	}

	/**
	 * Method executed when search Libris button is pressed, fills proper Edit
	 * text fields with found data.
	 * 
	 */
	private void searchIsbn() {
		String isbn = isbnET.getText().toString();
		DataBook librisResultBook = DataBookFactory.searchLibris(isbn);

		if (librisResultBook.getAuthor() != null)
			authorET.setText(librisResultBook.getAuthor());
		else
			authorET.setHint("no author found");
		if (librisResultBook.getTitle() != null)
			titleET.setText(librisResultBook.getTitle());
		else
			authorET.setHint("no title found");
	}

	/**
	 * Method called when the 'Add' button has been pressed and the user wants
	 * to add a book to the database.
	 */
	private void addBook() {
		newBook = new DataBook();
		String author = authorET.getText().toString();
		/* Get the Strings from the field edited by the user */
		newBook.setAuthor(authorET.getText().toString());
		newBook.setTitle(titleET.getText().toString());
		newBook.setIsbn(isbnET.getText().toString());
		newBook.setEdition(editionET.getText().toString());
		newBook.setCourse(courseET.getText().toString());
		newBook.setPrice(priceET.getText().toString());
		newBook.setComment(commentET.getText().toString());

		/* Validating the input provided by the user */
		boolean validInput = checkInput();
		if (validInput) {

			Intent userDataIntent = new Intent();
			userDataIntent.setClass(AddBookActivity.this,
					SettingsActivity.class);
			userDataIntent.addCategory("USER_DETAIL_CHECK");
			startActivityForResult(userDataIntent, USER_DETAIL_REQUEST);
		}
	}

	/**
	 * Validates the user-input while attempting to add a new book, before
	 * adding to the database.
	 * 
	 * @return Returns a boolean stating if the input is valid
	 */
	private boolean checkInput() {
		String badInput = "Please correct the following input before proceeding:\n\n";
		boolean validInput = true;

		if (newBook.getAuthor() == null || newBook.getAuthor().length() < 4) {
			badInput = badInput
					+ "--Author name must be greater than 4 characters.\n";
			validInput = false;
		}
		if (newBook.getTitle() == null || newBook.getTitle().length() < 5) {
			badInput = badInput
					+ "--Title must be greater than 5 characters.\n";
			validInput = false;
		}
		String isbn = newBook.getIsbn();
		if (isbn != null) {
			if ((isbn.length() != 0 && ((isbn.length() != 10)
					&& (isbn.length() != 13) || !onlyDigits(isbn)))) {
				badInput = badInput
						+ "--The ISBN-number must be 10 or 13 digits long.\n";
				validInput = false;
			}
		}
		String price = newBook.getPrice();
		if (price == null
				|| (!(price.length() > 0 && price.length() < 5) || !onlyDigits(price))) {
			badInput = badInput
					+ "--Please specify a price within the range of 0-10000 SEK.\n";
			validInput = false;
		}
		if (!validInput) {

			AlertDialog inputWarningDialog = new AlertDialog.Builder(this)
					.create();
			inputWarningDialog.setTitle("Invalid input!");
			inputWarningDialog.setMessage(badInput);
			inputWarningDialog.setButton("OK",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							// here you can add functions
						}
					});

			inputWarningDialog.show();
		}
		return validInput;
	}

	/**
	 * Checks to see that the string contains only digits.
	 * 
	 * @param s
	 *            the string to be checked
	 * @return true if no non-digit characters were found
	 */
	private boolean onlyDigits(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (!Character.isDigit(s.charAt(i)))
				return false;
		}
		return true;
	}

	/*
	 * Method called when the 'Take Picture' button has been pressed and the
	 * user wants to add a photo of their book
	 * 
	 * private void takePicture() {
	 * 
	 * Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
	 * 
	 * // http://developer.android.com/guide/topics/media/camera.html#intents //
	 * imageUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE); }
	 */

	/**
	 * Checks if the user details are set and attempts to add book to server database.
	 *
	 * @param requestCode the request code
	 * @param resultCode the result code
	 * @param data the data
	 * @see android.app.Activity#onActivityResult(int, int,
	 * android.content.Intent)
	 */
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == USER_DETAIL_REQUEST) {
			if (resultCode == RESULT_OK) {
				newBook.setName(data.getStringExtra("name"));
				newBook.setEmail(data.getStringExtra("email"));
				newBook.setPhone(data.getStringExtra("phone"));
				newBook.setPassword(data.getStringExtra("password"));
				
				String communicationResults = ServerCommunicator
						.addBook(newBook);
				if (communicationResults.contains("1"))
					Toast.makeText(getApplicationContext(), "Book uploaded",
							Toast.LENGTH_SHORT).show();
				else
					Toast.makeText(getApplicationContext(),
							"Book failed to upload", Toast.LENGTH_SHORT).show();

			} else {
				Toast.makeText(getApplicationContext(),
						"Please insert the required user details",
						Toast.LENGTH_SHORT).show();
				Intent goToSettingsIntent = new Intent();
				goToSettingsIntent.setClass(AddBookActivity.this,
						SettingsActivity.class);
				goToSettingsIntent.addCategory("USER_DETAIL_FILL");
				startActivity(goToSettingsIntent);
			}
		}

		/*
		 * The Result comes from a camera activity if (requestCode ==
		 * CAMERA_CATCHING_CODE) // Image has been captured and saved to a path
		 * specified in the intent if (resultCode == RESULT_OK) {
		 * data.getData(); // Image has not been captured due to user cancelling
		 * process } else if (resultCode == RESULT_CANCELED) {
		 * Toast.makeText(getApplicationContext(),
		 * "Oh, snap, you cancelled, why did you do that?",
		 * Toast.LENGTH_SHORT).show(); // Something has gone terribly wrong and
		 * the application failed to capture image. } else {
		 * Toast.makeText(getApplicationContext(),
		 * "Ehh, something went wrong and no image was captured",
		 * Toast.LENGTH_SHORT); }
		 */
	}

}
