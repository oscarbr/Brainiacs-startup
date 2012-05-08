package itBrainiacs.muffins;

import java.util.LinkedList;

import org.json.JSONException;
import org.json.JSONObject;

import android.text.format.DateFormat;

public class DataBookFactory {

	/** 
	 * Static method returning a List of all the books contained in a JSONObject
	 * 
	 *@param JSONObject that contains one or several books
	 *@return True if the add was successfull
	 */
	public static LinkedList<DataBook> jsonToDataBooks(JSONObject jsonObject) {
		
		LinkedList<DataBook> dataBooks = new LinkedList<DataBook>();
		
		DataBook book = new DataBook();
		
		try {
			book.setTitle(jsonObject.get("title").toString());
			book.setAuthor(jsonObject.get("author").toString());
			book.setPrice(jsonObject.get("price").toString());
			book.setExpires(jsonObject.get("expires").toString());
		} catch (JSONException e) {
			e.printStackTrace();
			return dataBooks;
		}
		
		dataBooks.add(book);
		
		return dataBooks;
	}
	
	public static JSONObject dataBookToJSON(DataBook book) {
		
		JSONObject jsonBook = new JSONObject();
		
		try {
			jsonBook.put("author", book.getAuthor());
			jsonBook.put("title", book.getTitle());
			jsonBook.put("price", book.getPrice());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return jsonBook;
	}
}
