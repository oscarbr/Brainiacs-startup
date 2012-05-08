package itBrainiacs.muffins;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.LinkedList;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class DataBookFactory {

	/**
	 * Static method returning a List of all the books contained in a JSONObject
	 * 
	 * @param JSONObject
	 *            that contains one or several books
	 * @return LinkedList<DataBook> with the books in the search results. Empty
	 *         list if the JSONObject doesnt contain any books
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

	/**
	 * Static method returning a JSONObject of a DataBook
	 * 
	 * @param DataBook
	 *            to be made into a JSONObject
	 * @return JSONObject representation of book.
	 */
	public static JSONObject dataBookToJSON(DataBook book) {

		JSONObject jsonBook = new JSONObject();

		try {
			jsonBook.put("author", book.getAuthor());
			jsonBook.put("title", book.getTitle());
			jsonBook.put("price", book.getPrice());
			jsonBook.put("comment", book.getComment());
			jsonBook.put("isbn", book.getIsbn());
			jsonBook.put("edition", book.getEdition());
			jsonBook.put("course", book.getCourse());
			jsonBook.put("publYear", book.getPublYear());
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return jsonBook;
	}

	/**
	 * Static method for searching libris for specified ISBN, returns DataBook
	 * object
	 * 
	 * @param String
	 *            ISBN number
	 * @return DataBook with the book in the search results.
	 */
	// TODO Check behavior if multiple books are found
	public static DataBook searchLibris(String isbn) {

		URL libris;
		String streamString = "";
		isbn = "http://libris.kb.se/xsearch?query=NUMM:" + isbn
				+ "&format=json";

		try {
			libris = new URL(isbn);
			InputStream input;
			input = libris.openStream();
			streamString = MuffinsUtility.convertStreamToString(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DataBook bok = parseLibris(streamString);
		return bok;
	}

	/**
	 * Static method for parsing json string from Libris to a DataBook object
	 * 
	 * @param String
	 *            json
	 * @return DataBook object with title, creater, publisher, date & language
	 */
	public static DataBook parseLibris(String json) {

		DataBook bok = new DataBook();
		JsonElement jelement = new JsonParser().parse(json);
		JsonObject jobject = jelement.getAsJsonObject();
		jobject = jobject.getAsJsonObject("xsearch");
		JsonArray jarray = jobject.getAsJsonArray("list");
		jobject = jarray.get(0).getAsJsonObject();

		bok.setTitle(jobject.get("title").toString());
		bok.setAuthor(jobject.get("creator").toString());
		bok.setPublisher(jobject.get("publisher").toString());
		bok.setDate(jobject.get("date").toString());
		bok.setLanguage(jobject.get("language").toString());
		return bok;
	}
}
