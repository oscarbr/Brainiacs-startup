package itBrainiacs.muffins;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddBookActivity extends Activity implements OnClickListener {
	
	/* Variables to be act as hooks to views specified in the layout-XML */
	private EditText authorET;
	private EditText titleET;
	private EditText ISBNET;
	private EditText versionET;
	private EditText courseET;
	private EditText priceET;
	private EditText commentET;
	private Button takePictureButton;
	private Button addButton;
	
	private final static int CAMERA_CATCHING_CODE = 100; //The code for activity request camera
	private final static int MEDIA_TYPE_IMAGE = 1;
	private Uri imageUri;
	
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.add_book_layout);
		
		/* Getting references to the objects (views) specified in the layout-XML */
		authorET = (EditText) findViewById(R.id.addBookAuthorET);
		titleET = (EditText) findViewById(R.id.addBookTitleET);
		ISBNET = (EditText) findViewById(R.id.addBookISBNET);
		versionET = (EditText) findViewById(R.id.addBookVersionET);
		courseET = (EditText) findViewById(R.id.addBookCourseET);
		priceET = (EditText) findViewById(R.id.addBookPriceET);
		commentET = (EditText) findViewById(R.id.addBookCommentET);
		
		takePictureButton = (Button) findViewById(R.id.addBookTakePictureButton);
		addButton = (Button) findViewById(R.id.addBookAddButton);
		
		/* Setting the 'add' button to execute onClick() when pressed */
		addButton.setOnClickListener(this);
	}
	
	/* Method called when the 'Add' button has been pressed and the user wants to add a book to the database */
	private void addBook() {
		
		/* Get the Strings from the field edited by the user */
		String author = authorET.getText().toString();
		String title = titleET.getText().toString();
		String isbn = ISBNET.getText().toString();
		String version = versionET.getText().toString();
		String course = courseET.getText().toString();
		String price = priceET.getText().toString();
		String comment = commentET.getText().toString();
		
		/* Place holder Toast to notify that the listener works */
		Toast.makeText(getApplicationContext(), "A book with"
				+ "\nAuthor: " + author 
				+ "\nTitle: " + title 
				+ "\nISBN: " + isbn
				+ "\nVersion: " + version
				+ "\nCourse: " + course
				+ "\nPrice: " + price
				+ "\nComment: " + comment
				+ "\nhas been added", Toast.LENGTH_LONG).show();
	}
	
	/* Method called when the 'Take Picture' button has been pressed and the user wants to add a photo of their book */
	private void takePicture() {
		
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		
		//http://developer.android.com/guide/topics/media/camera.html#intents
		//imageUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE);
	}
	
	/* On receiving the picture taken by the camera app. */
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		/* The Result comes from a camera activity */
		if (requestCode == CAMERA_CATCHING_CODE) {
	        
			/* Image has been captured and saved to a path specified in the intent */
			if (resultCode == RESULT_OK) {
				
				data.getData();
			
				/* Image has not been captured due to user cancelling process */
	        } else if (resultCode == RESULT_CANCELED) {
	        	
	        	Toast.makeText(getApplicationContext(), "Oh, snap, you cancelled, why did you do that?", Toast.LENGTH_SHORT).show();
	        
	        /* Something has gone terribly wrong and the application failed to capture image. */
	        } else {
	        	
	        	Toast.makeText(getApplicationContext(), "Ehh, something went wrong and no image was captured", Toast.LENGTH_SHORT);
	        }
		}
	}
	
	/* Method from the interface OnClickListener. Called when the any button that has this class as a listener is pressed*/
	public void onClick(View view) {
		if (view.getId() == R.id.addBookTakePictureButton) {
			
			takePicture();
			
		} else if (view.getId() == R.id.addBookAddButton) {
			
			addBook();
		}
	}
}
