package itBrainiacs.muffins;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.NameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Rikard Andersson mail@rikardandersson.se
 * @version 0.1
 * @since 2012-04-25
 */

public class ServerCommunicator {
	
	/** 
	 * Static method. Called when a book is to be added to the database.
	 * 
	 *@param JSONObject that contains author (required) and title (required)
	 *of the book to be added.
	 *@return True if the add was successfull 
	 */
	public static String addBook(DataBook book){
		/* Path to server script */
		String url = "http://muffins.trestad.net/muffin_app/add_book.php";
		return requestResponsFromServer(DataBookFactory.dataBookToJSON(book), url);
	}
	
	/** 
	 * Static method. Called when the user wants to search for a book.
	 * 
	 *@param JSONObject that contains author (required) and title (required)
	 *of the book to be searched for.
	 *@return JSONObject with the search results. Null if there was an error.
	 */
	public static LinkedList<DataBook> searchBooks(DataBook book){
		/* Path to server script */
		JSONObject jsonSearch = DataBookFactory.dataBookToJSON(book);
		String url = "http://muffins.trestad.net/muffin_app/search_books.php";
		JSONObject jsonResults = new JSONObject();
		try {
			jsonResults = new JSONObject(requestResponsFromServer(jsonSearch, url));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return DataBookFactory.jsonToDataBooks(jsonResults);
	}
	
	
	/* Sends the request in json-formatting as a String with the key 
	 * "jsondata" to the server and returns the results */
	private static String requestResponsFromServer(JSONObject jsonRequest, String url) {
		String results = null;
		try {
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost(url);
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);  
			nameValuePairs.add(new BasicNameValuePair("jsondata", jsonRequest.toString()));  
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			HttpResponse response = httpclient.execute(httppost);
			InputStream in = response.getEntity().getContent();
			results = MuffinsUtility.convertStreamToString(in);
		
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return results;
	}


}
