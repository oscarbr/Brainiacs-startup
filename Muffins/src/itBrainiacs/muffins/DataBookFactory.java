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

public class DataBookFactory {

	/**
	 * Static method returning a List of all the books contained in a JSONObject
	 * 
	 * @param JSONObject
	 *            that contains one or several books
	 * @return LinkedList<DataBook> with the books in the search results. Empty
	 *         list if the JSONObject doesnt contain any books
	 */
	public static LinkedList<DataBook> jsonToDataBooks(JSONArray jsonArray) {

		LinkedList<DataBook> dataBooks = new LinkedList<DataBook>();

		JSONObject jsonObject;
		DataBook book;

		// This for-loop iterates over the JSONObject elements in the
		// JSON-string returned by the server
		for (int i = 0; i < jsonArray.length(); i++) {

			try {
				jsonObject = jsonArray.getJSONObject(i);
				book = new DataBook();

				if (jsonObject.has("title")) {
					try {
						book.setTitle(jsonObject.get("title").toString());
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}
				if (jsonObject.has("author")) {
					try {
						book.setAuthor(jsonObject.get("author").toString());
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}
				if (jsonObject.has("price")) {
					try {
						book.setPrice(jsonObject.get("price").toString());
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}
				if (jsonObject.has("expires")) {
					try {
						book.setExpires(jsonObject.get("expires").toString());
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}
				if (jsonObject.has("isbn")) {
					try {
						book.setIsbn(jsonObject.get("isbn").toString());
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}
				if (jsonObject.has("publisher")) {
					try {
						book.setPublisher(jsonObject.get("publisher")
								.toString());
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}
				if (jsonObject.has("edition")) {
					try {
						book.setEdition(jsonObject.get("edition").toString());
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}
				if (jsonObject.has("publYear")) {
					try {
						book.setPublYear(jsonObject.get("publYear").toString());
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}
				if (jsonObject.has("course")) {
					try {
						book.setCourse(jsonObject.get("course").toString());
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}
				if (jsonObject.has("comment")) {
					try {
						book.setComment(jsonObject.get("comment").toString());
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}
				if (jsonObject.has("bookType")) {
					try {
						book.setBookType(jsonObject.get("bookType").toString());
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}
				if (jsonObject.has("period")) {
					try {
						book.setPeriod(jsonObject.get("period").toString());
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}
				if (jsonObject.has("isbn")) {
					try {
						book.setIsbn(jsonObject.get("isbn").toString());
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}
				if (jsonObject.has("email")) {
					try {
						book.setEmail(jsonObject.get("email").toString());
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}
				if (jsonObject.has("phone")) {
					try {
						book.setPhone(jsonObject.get("phone").toString());
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}
				if (jsonObject.has("saleID")) {
					try {
						book.setSaleID(jsonObject.get("saleID").toString());
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}
				if (jsonObject.has("language")) {
					try {
						book.setLanguage(jsonObject.get("language").toString());
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}
				dataBooks.add(book);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
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

		if (book.getAuthor() != null) {
			try {
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
		try {
			JsonElement jelement = new JsonParser().parse(json);
			JsonObject jobject = jelement.getAsJsonObject();
			jobject = jobject.getAsJsonObject("xsearch");
			JsonArray jarray = jobject.getAsJsonArray("list");
			jobject = jarray.get(0).getAsJsonObject();

			if (jobject.has("title"))
				bok.setTitle(jobject.get("title").toString());
			if (jobject.has("creator"))
				bok.setAuthor(jobject.get("creator").toString());
			if (jobject.has("publisher"))
				bok.setPublisher(jobject.get("publisher").toString());
			if (jobject.has("date"))
				bok.setPublYear(jobject.get("date").toString());
			if (jobject.has("language"))
				bok.setLanguage(jobject.get("language").toString());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return bok;
	}
}
