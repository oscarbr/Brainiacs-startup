package itBrainiacs.muffins;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.LinkedList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/** 
 * Class for handling the conversion between DataBooks and JSONObjects in both directions.
 * Also contains methods for searching Libris for books based on ISBN and returns matching
 * DataBooks. 
 */
public class DataBookFactory {

	/**
	 * Static method returning a List of all the books contained in a
	 * JSONObject as DataBooks.
	 * 
	 * @param jsonArray the JSONArray to be parsed
	 * @return LinkedList<DataBook> with the books in the search results. Empty
	 *         list if the JSONObject doesn't contain any books
	 */
	public static LinkedList<DataBook> jsonToDataBooks(JSONArray jsonArray) {

		// Instasiate the list as a LinkedList (Linked best because of iterating over it later)
		LinkedList<DataBook> dataBooks = new LinkedList<DataBook>();

		JSONObject jsonObject;
		DataBook book;

		// This for-loop iterates over the JSONObject elements in the
		// JSONArray given as an parameter
		for (int i = 0; i < jsonArray.length(); i++) {

			/*
			 * This try-catch is to catch JSONExceptions thrown by getJSONObject()
			 * Also any JSONExceptions that might be thrown by the get() calls
			 * in all the IF-statements.
			 * 
			 * The IF-statements are necessary to keep the get() calls from throwing
			 * exceptions if the key checked for doesn't exist. Should the exception be thrown
			 * the properties after the one where the exception occurred will be skipped.
			 * The IF-statement prevents this.
			 */
			try {
				jsonObject = jsonArray.getJSONObject(i);
				book = new DataBook();

				// Check if the JSONObject have a value to the key "title"
				if (jsonObject.has("title")) {
					/* Set the title of DataBook to the value connected to the 
					 * "title" key in the JSONObject
					 */
					book.setTitle(jsonObject.get("title").toString());
				}

				//The following IF-statments are the same as above but different property
				if (jsonObject.has("author")) {
					book.setAuthor(jsonObject.get("author").toString());
				}
				if (jsonObject.has("price")) {
					book.setPrice(jsonObject.get("price").toString());
				}
				if (jsonObject.has("expires")) {
					book.setExpires(jsonObject.get("expires").toString());
				}
				if (jsonObject.has("isbn")) {
					book.setIsbn(jsonObject.get("isbn").toString());
				}
				if (jsonObject.has("publisher")) {
					book.setPublisher(jsonObject.get("publisher").toString());
				}
				if (jsonObject.has("edition")) {
					book.setEdition(jsonObject.get("edition").toString());
				}
				if (jsonObject.has("publYear")) {
					book.setPublYear(jsonObject.get("publYear").toString());
				}
				if (jsonObject.has("course")) {
					book.setCourse(jsonObject.get("course").toString());
				}
				if (jsonObject.has("comment")) {
					book.setComment(jsonObject.get("comment").toString());
				}
				if (jsonObject.has("bookType")) {
					book.setBookType(jsonObject.get("bookType").toString());
				}
				if (jsonObject.has("period")) {
					book.setPeriod(jsonObject.get("period").toString());
				}
				if (jsonObject.has("isbn")) {
					book.setIsbn(jsonObject.get("isbn").toString());
				}
				if (jsonObject.has("email")) {
					book.setEmail(jsonObject.get("email").toString());
				}
				if (jsonObject.has("phone")) {
					book.setPhone(jsonObject.get("phone").toString());
				}
				if (jsonObject.has("saleID")) {
					book.setSaleID(jsonObject.get("saleID").toString());
				}
				if (jsonObject.has("language")) {
					book.setLanguage(jsonObject.get("language").toString());
				}
				// The DataBook is done, add it to the list
				dataBooks.add(book);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		// Returning the list of databooks
		return dataBooks;
	}

	/**
	 * Static method returning a JSONObject of a DataBook.
	 * 
	 * @param book
	 *            string book to be parsed to json
	 * @return JSONObject representation of book.
	 */
	public static JSONObject dataBookToJSON(DataBook book) {

		JSONObject jsonBook = new JSONObject();

		/*
		 * Several IF-statements to check for properties of the DataBook
		 * As long as the methods are different for each property, this is necessary.
		 */
		// Check if there is a specific value for the author in the DataBook
		if (book.getAuthor() != null) {
			try {
				 // Assign the author value of the provided DataBook to the JSONObject
				 // representation of that book.
				jsonBook.put("author", book.getAuthor());
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		if (book.getTitle() != null) {
			try {
				jsonBook.put("title", book.getTitle());
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		if (book.getPrice() != null) {
			try {
				jsonBook.put("price", book.getPrice());
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		if (book.getIsbn() != null) {
			try {
				jsonBook.put("isbn", book.getIsbn());
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		if (book.getEdition() != null) {
			try {
				jsonBook.put("edition", book.getEdition());
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		if (book.getCourse() != null) {
			try {
				jsonBook.put("course", book.getCourse());
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		if (book.getPublYear() != null) {
			try {
				jsonBook.put("publYear", book.getPublYear());
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		if (book.getComment() != null) {
			try {
				jsonBook.put("comment", book.getComment());
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		if (book.getBookType() != null) {
			try {
				jsonBook.put("bookType", book.getBookType());
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		if (book.getPublisher() != null) {
			try {
				jsonBook.put("publisher", book.getPublisher());
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		if (book.getLanguage() != null) {
			try {
				jsonBook.put("language", book.getLanguage());
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		if (book.getExpires() != null) {
			try {
				jsonBook.put("expires", book.getExpires());
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		if (book.getEmail() != null) {
			try {
				jsonBook.put("email", book.getEmail());
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		if (book.getPhone() != null) {
			try {
				jsonBook.put("phone", book.getPhone());
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		if (book.getPassword() != null) {
			try {
				jsonBook.put("password", book.getPassword());
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		if (book.getSaleID() != null) {
			try {
				jsonBook.put("saleID", book.getSaleID());
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return jsonBook;
	}

	/**
	 * Static method for searching libris for specified ISBN, returns DataBook
	 * object.
	 * 
	 * @param isbn
	 *            string isbn number
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
	 * Static method for parsing json string from Libris to a DataBook object.
	 * 
	 * @param json
	 *            string json to be parsed
	 * @return DataBook object with title, creater, publisher, date & language
	 */
	public static DataBook parseLibris(String json) {
		DataBook bok = new DataBook();
		try {
			JsonElement jelement = new JsonParser().parse(json);
			JsonObject jobject = jelement.getAsJsonObject();
			jobject = jobject.getAsJsonObject("xsearch");
			JsonArray jarray = jobject.getAsJsonArray("list");
			jobject = jarray.get(0).getAsJsonObject();

			if (jobject.has("title"))
				bok.setTitle(jobject.get("title").toString().replace("\"", ""));
			if (jobject.has("creator"))
				bok.setAuthor(jobject.get("creator").toString().replace("\"", ""));
			if (jobject.has("publisher"))
				bok.setPublisher(jobject.get("publisher").toString().replace("\"", ""));
			if (jobject.has("date"))
				bok.setPublYear(jobject.get("date").toString().replace("\"", ""));
			if (jobject.has("language"))
				bok.setLanguage(jobject.get("language").toString().replace("\"", ""));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return bok;
	}
}
