
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

public class AddBookActivity extends Activity implements OnClickListener {

	/* Variables to act as hooks to views specified in the layout-XML */
	private EditText authorET;
	private EditText titleET;
	private EditText ISBNET;
	private EditText versionET;
	private EditText publYearET;
	private EditText courseET;
	private EditText priceET;
	private EditText commentET;
	private Button takePictureButton;
	private Button addButton;
	
	private String name ="";
	private String email = "";
	private String phone = "";
	private String password = "";
	
	private String author = "";
	private String title = "";
	private String isbn = "";
	private String version = "";
	private String publYear = "";
	private String course = "";
	private String price = "";
	private String comment = "";
	
	/* The code for activity request camera. To be implemented
	 * private final static int CAMERA_CATCHING_CODE = 100; 
	 * private final static int MEDIA_TYPE_IMAGE = 1;
	 * private Uri imageUri;
	 */
	private final static int USER_DETAIL_REQUEST = 1;
	

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.add_book_layout);

		/* Getting references to the objects (views) specified in the layout-XML */
		authorET = (EditText) findViewById(R.id.addBookAuthorET);
		titleET = (EditText) findViewById(R.id.addBookTitleET);
		ISBNET = (EditText) findViewById(R.id.addBookISBNET);
		versionET = (EditText) findViewById(R.id.addBookVersionET);
		publYearET = (EditText) findViewById(R.id.addBookPubYearET);
		courseET = (EditText) findViewById(R.id.addBookCourseET);
		priceET = (EditText) findViewById(R.id.addBookPriceET);
		commentET = (EditText) findViewById(R.id.addBookCommentET);
		
		/*
		 * Picturebutton to be implemented. 
		takePictureButton = (Button) findViewById(R.id.addBookTakePictureButton);
		*/
		addButton = (Button) findViewById(R.id.addBookAddButton);

		/* Setting the 'add' button to execute onClick() when pressed */
		addButton.setOnClickListener(this);
	}
	
	/* Method from the interface OnClickListener. Called when the any button that has this class as a listener is pressed*/
	public void onClick(View view) {
		if (view.getId() == R.id.addBookTakePictureButton) {
			
			//takePicture();
			
		} else if (view.getId() == R.id.addBookAddButton) {
				addBook();
		}
	}

	/**
	 * Method called when the 'Add' button has been pressed and the user wants
	 * to add a book to the database
	 */
	private void addBook() {
		boolean validInput;

		/* Get the Strings from the field edited by the user */
		String author = authorET.getText().toString();
		String title = titleET.getText().toString();
		String isbn = ISBNET.getText().toString();
		String version = versionET.getText().toString();
		String publYear = publYearET.getText().toString();
		String course = courseET.getText().toString();
		String price = priceET.getText().toString();
		String comment = commentET.getText().toString();

		/* Validating the input provided by the user */
		validInput = checkInput(author, title, isbn, price, publYear);
		if (validInput) {
			
			Intent userDataIntent = new Intent();
			userDataIntent.setClass(AddBookActivity.this, SettingsActivity.class);
			userDataIntent.addCategory("USER_DETAIL_CHECK");
			startActivityForResult(userDataIntent, USER_DETAIL_REQUEST);



			/*
			 * Sends the query with addBook to the server via the
			 * ServerCommunicator-class
			 */





		}

	}
	

	/**
	 * Validates the user-input while attempting to add a new book, before
	 * adding to the database
	 * 
	 * @param author
	 *            Author of the book, must be atleast 10 characters
	 * @param title
	 *            Title of the book, must be atleast 10 characters
	 * @param isbn
	 *            ISBN-number. Must be 10 or 13 digits
	 * @param price
	 *            Price must be specified as a number between 0-10000.
	 * @return Returns a boolean stating if the input is valid
	 */
	private boolean checkInput(String author, String title, String isbn,
			String price, String publYear) {
		String badInput = "Please correct the following input before proceeding:\n\n";
		boolean validInput = true;

		if (author.length() < 10) {
			badInput = badInput
					+ "--Author name must be greater than 10 characters.\n";
			validInput = false;
		}
		if (title.length() < 10) {
			badInput = badInput
					+ "--Title must be greater than 10 characters.\n";
			validInput = false;
		}
		if (isbn.length() != 0
				&& ((isbn.length() != 10) && (isbn.length() != 13) || !onlyDigits(isbn))) {
			badInput = badInput
					+ "--The ISBN-number must be 10 or 13 digits long.\n";
			validInput = false;
		}
		if (!(price.length() > 0 && price.length() < 5) || !onlyDigits(price)) {
			badInput = badInput
					+ "--Please specify a price within the range of 0-10000 SEK.\n";
			validInput = false;
		}
		if (publYear.length() > 0) {
			if (!onlyDigits(publYear) || publYear.length() > 4) {
				badInput = badInput
						+ "--This is not a valid publishing year \n";
				validInput = false;
			} else {
				int inputYear = Integer.parseInt(publYear);
				Calendar c = Calendar.getInstance();
				int currentYear = c.get(Calendar.YEAR);
				if (currentYear < inputYear) {
					badInput = badInput
							+ "--This is not a valid publishing year \n";
					validInput = false;
				}
			}
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
	 * Checks to see that the string contains only digits
	 * @param s
	 * @return true if no non-digit characters were found
	 */
	private boolean onlyDigits(String s){
		for (int i=0; i < s.length(); i++) {
			if (!Character.isDigit(s.charAt(i)))
				return false;
		}
		return true;
	}
	


	/*
	 * Method called when the 'Take Picture' button has been pressed and the
	 * user wants to add a photo of their book

	private void takePicture() {

		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

		// http://developer.android.com/guide/topics/media/camera.html#intents
		// imageUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE);
	}

	*/
	
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == USER_DETAIL_REQUEST) {
			if (resultCode == RESULT_OK) {
				DataBook newBook = new DataBook();
				
				newBook.setAuthor(author);
				newBook.setTitle(title);
				newBook.setIsbn(isbn);
				newBook.setPrice(price);
				newBook.setCourse(course);
				newBook.setEdition(version);
				newBook.setPublYear(publYear);
				newBook.setComment(comment);
				
				String communicationResults = ServerCommunicator.addBook(newBook);
				Toast.makeText(getApplicationContext(), communicationResults,
						Toast.LENGTH_LONG).show();
				
				Toast.makeText(getApplicationContext(), "Book uploaded" , Toast.LENGTH_SHORT).show();
			}
			else {
				Toast.makeText(getApplicationContext(), "Please insert the required user details" , Toast.LENGTH_SHORT).show();
				Intent goToSettingsIntent = new Intent();
				goToSettingsIntent.setClass(AddBookActivity.this, SettingsActivity.class);
				startActivity(goToSettingsIntent);
			}
		}
		
		/* The Result comes from a camera activity 
		if (requestCode == CAMERA_CATCHING_CODE) 
			// Image has been captured and saved to a path specified in the intent
			if (resultCode == RESULT_OK) {
				data.getData();
				// Image has not been captured due to user cancelling process
	        } else if (resultCode == RESULT_CANCELED) {
	        	Toast.makeText(getApplicationContext(), "Oh, snap, you cancelled, why did you do that?", Toast.LENGTH_SHORT).show();
	        // Something has gone terribly wrong and the application failed to capture image.
	        } else {
	        	Toast.makeText(getApplicationContext(), "Ehh, something went wrong and no image was captured", Toast.LENGTH_SHORT);
	        } */
		}
	
}


