/**
 * 
 */
package itBrainiacs.muffins.test;

import java.util.LinkedList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import itBrainiacs.muffins.*;

import android.test.AndroidTestCase;

public class DataBookFactoryTest extends AndroidTestCase {
	
	/**
	 * UnittestID:DBF1
	 * @throws java.lang.Exception
	 */
	public void setUp() throws Exception {
		super.setUp();
	}
	
	/**
	 * TODO implement proper equals
	 * UnittestID:DBF2
	 * Test method for {@link itBrainiacs.muffins.DataBookFactory#jsonToDataBooks(org.json.JSONArray)}.
	 * @throws JSONException 
	 */
	public void testJsonToDataBooks() throws JSONException {
		DataBook expectedBook = new DataBook();
		expectedBook.setTitle("Konsten att make love");
		expectedBook.setAuthor("Filip Sandviken");
		expectedBook.setIsbn("1234567890");
		expectedBook.setPublYear("1993");
		expectedBook.setEdition("first");
		expectedBook.setCourse("XXX666");
		expectedBook.setPrice("11");
		
		LinkedList<DataBook> expectedBookList = new LinkedList<DataBook>();
		expectedBookList.add(expectedBook);
		
		JSONObject testObject = new JSONObject();
		testObject.put("title", "Konsten att make love");
		testObject.put("author", "Filip Sandviken");
		testObject.put("isbn", "1234567890");
		testObject.put("publYear", "1993");
		testObject.put("edition", "first");
		testObject.put("course", "XXX666");
		testObject.put("price", "11");

		JSONArray testArray = new JSONArray();
		testArray.put(testObject);
		
		LinkedList<DataBook> testBookList = new LinkedList<DataBook>();
		testBookList = DataBookFactory.jsonToDataBooks(testArray);
		
		assertEquals("", expectedBookList.getFirst().getAuthor(), testBookList.getFirst().getAuthor());
		assertEquals("", expectedBookList.getFirst().getTitle(), testBookList.getFirst().getTitle());
		assertEquals("", expectedBookList.getFirst().getPrice(), testBookList.getFirst().getPrice());
		assertEquals("", expectedBookList.getFirst().getIsbn(), testBookList.getFirst().getIsbn());
		assertEquals("", expectedBookList.getFirst().getEdition(), testBookList.getFirst().getEdition());
		assertEquals("", expectedBookList.getFirst().getPublYear(), testBookList.getFirst().getPublYear());
		assertEquals("", expectedBookList.getFirst().getCourse(), testBookList.getFirst().getCourse());	
	}

	/**
	 * TODO implement proper equals
	 * UnittestID:DBF3
	 * Test method for {@link itBrainiacs.muffins.DataBookFactory#dataBookToJSON(itBrainiacs.muffins.DataBook)}.
	 * @throws JSONException 
	 */
	public void testDataBookToJSON() throws JSONException {
		JSONObject expectedObject = new JSONObject();
		expectedObject.put("title", "Konsten att make love");
		expectedObject.put("author", "Filip Sandviken");
		expectedObject.put("isbn", "1234567890");
		expectedObject.put("publYear", "1993");
		expectedObject.put("edition", "first");
		expectedObject.put("course", "XXX666");
		expectedObject.put("price", "11");
		
		DataBook testBook = new DataBook();
		testBook.setTitle("Konsten att make love");
		testBook.setAuthor("Filip Sandviken");
		testBook.setIsbn("1234567890");
		testBook.setPublYear("1993");
		testBook.setEdition("first");
		testBook.setCourse("XXX666");
		testBook.setPrice("11");	
		
		assertEquals("", expectedObject.get("title"), DataBookFactory.dataBookToJSON(testBook).get("title"));
		assertEquals("", expectedObject.get("author"), DataBookFactory.dataBookToJSON(testBook).get("author"));
		assertEquals("", expectedObject.get("isbn"), DataBookFactory.dataBookToJSON(testBook).get("isbn"));
		assertEquals("", expectedObject.get("publYear"), DataBookFactory.dataBookToJSON(testBook).get("publYear"));
		assertEquals("", expectedObject.get("edition"), DataBookFactory.dataBookToJSON(testBook).get("edition"));
		assertEquals("", expectedObject.get("course"), DataBookFactory.dataBookToJSON(testBook).get("course"));
		assertEquals("", expectedObject.get("price"), DataBookFactory.dataBookToJSON(testBook).get("price"));
	}

	/**
	 * UnittestID:DBF4
	 * Test method for {@link itBrainiacs.muffins.DataBookFactory#searchLibris(java.lang.String)}.
	 */
	public void testSearchLibris() {
		DataBook testBook = DataBookFactory.searchLibris("9119129610");
		
		assertEquals("", "Sagan om ringen", testBook.getTitle());
		assertEquals("", "Tolkien, J. R. R., 1892-1973", testBook.getAuthor());
		assertEquals("", "Stockholm : PAN/Norstedt", testBook.getPublisher());
		assertEquals("", "1992", testBook.getPublYear());
		assertEquals("", "swe", testBook.getLanguage());
	}

	/**
	 * UnittestID:DBF5
	 * Test method for {@link itBrainiacs.muffins.DataBookFactory#parseLibris(java.lang.String)}.
	 */
	public void testParseLibris() {
		String testString = "{\"xsearch\": {\n" +
				"\"from\": 1,\n" +
				"\"to\": 1,\n" +
				"\"records\": 1,\n" +
				"\"list\": [\n" +
				"{\n" +
				"\"identifier\": \"http://libris.kb.se/bib/8345772\",\n" +
				"\"title\": \"Sagan om ringen\",\n" +
				"\"creator\": \"Tolkien, J. R. R., 1892-1973\",\n" +
				"\"type\": \"book\",\n" +
				"\"publisher\": \"Stockholm : PAN/Norstedt\",\n" + 
				"\"date\": \"1992\",\n" +
				"\"language\": \"swe\"\n" +
				"}\n" +
				"]\n" +
				"}}\n";
		
		DataBook testBook = DataBookFactory.parseLibris(testString);
		
		assertEquals("", "Sagan om ringen", testBook.getTitle());
		assertEquals("", "Tolkien, J. R. R., 1892-1973", testBook.getAuthor());
		assertEquals("", "Stockholm : PAN/Norstedt", testBook.getPublisher());
		assertEquals("", "1992", testBook.getPublYear());
		assertEquals("", "swe", testBook.getLanguage());	
	}

}
