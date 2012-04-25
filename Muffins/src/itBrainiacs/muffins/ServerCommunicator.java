package itBrainiacs.muffins;

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
	public static boolean addBook(JSONObject book){
		return false;
	}
	
	/** 
	 * Static method. Called when the user wants to search for a book.
	 * 
	 *@param JSONObject that contains author (required) and title (required)
	 *of the book to be searched for.
	 *@return JSONObject with the search results. 
	 */
	public static JSONObject searchBooks(JSONObject search){
		return null;
	}

}
