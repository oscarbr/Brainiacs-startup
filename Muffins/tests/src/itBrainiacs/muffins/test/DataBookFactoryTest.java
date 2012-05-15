package itBrainiacs.muffins.test;

import java.util.LinkedList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import itBrainiacs.muffins.*;

import android.R.bool;
import android.test.AndroidTestCase;

public class DataBookFactoryTest extends AndroidTestCase {
	
	/**
	 * @throws java.lang.Exception
	 */
	public void setUp() throws Exception {
		super.setUp();
	}
	
	/**
	 * Test method for {@link itBrainiacs.muffins.DataBookFactory#jsonToDataBooks(org.json.JSONArray)}.
	 * @throws JSONException 
	 */
	public void testJsonToDataBooks() throws JSONException {
		
		DataBook bok = new DataBook();
		bok.setTitle("Konsten att make love");
		bok.setAuthor("Filip Sandviken");
		bok.setIsbn("1234567890");
		bok.setPublYear("1993");
		bok.setEdition("first");
		bok.setCourse("XXX666");
		bok.setPrice("11");
		
		LinkedList<DataBook> dataBooks = new LinkedList<DataBook>();
		dataBooks.add(bok);
		
		JSONObject object = new JSONObject();
		object.put("title", "Konsten att make love");
		object.put("author", "Filip Sandviken");
		object.put("isbn", "1234567890");
		object.put("publYear", "1993");
		object.put("edition", "first");
		object.put("course", "XXX666");
		object.put("price", "11");

		JSONArray array = new JSONArray();
		array.put(object);
		
		LinkedList<DataBook> dataBooks2 = new LinkedList<DataBook>();
		dataBooks2 = DataBookFactory.jsonToDataBooks(array);
		
		//[{"saleID":"22","edition":"first","phone":"","bookType":null,"period":null,"password":"","course":"XXX666","author":"Filip Sandviken",
		//"title":"Konsten att make love","expires":"2012-07-15","price":"11","email":"","isbn":"1234567890","comment":null,"publYear":"1993","sold":null}]

		assertEquals("", dataBooks.getFirst().getAuthor(), dataBooks2.getFirst().getAuthor());
		assertEquals("", dataBooks.getFirst().getTitle(), dataBooks2.getFirst().getTitle());
		assertEquals("", dataBooks.getFirst().getPrice(), dataBooks2.getFirst().getPrice());
		assertEquals("", dataBooks.getFirst().getIsbn(), dataBooks2.getFirst().getIsbn());
		assertEquals("", dataBooks.getFirst().getEdition(), dataBooks2.getFirst().getEdition());
		assertEquals("", dataBooks.getFirst().getPublYear(), dataBooks2.getFirst().getPublYear());
		assertEquals("", dataBooks.getFirst().getCourse(), dataBooks2.getFirst().getCourse());	
	}

	/**
	 * Test method for {@link itBrainiacs.muffins.DataBookFactory#dataBookToJSON(itBrainiacs.muffins.DataBook)}.
	 */
	public void testDataBookToJSON() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link itBrainiacs.muffins.DataBookFactory#searchLibris(java.lang.String)}.
	 */
	public void testSearchLibris() {
		DataBook bok = DataBookFactory.searchLibris("9119129610");
		
		assertEquals("", "Sagan om ringen", bok.getTitle());
		assertEquals("", "Tolkien, J. R. R., 1892-1973", bok.getAuthor());
		assertEquals("", "Stockholm : PAN/Norstedt", bok.getPublisher());
		assertEquals("", "1992", bok.getPublYear());
		assertEquals("", "swe", bok.getLanguage());
	}

	/**
	 * Test method for {@link itBrainiacs.muffins.DataBookFactory#parseLibris(java.lang.String)}.
	 */
	public void testParseLibris() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link java.lang.Object#Object()}.
	 */
	public void testObject() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link java.lang.Object#clone()}.
	 */
	public void testClone() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link java.lang.Object#equals(java.lang.Object)}.
	 */
	public void testEquals() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link java.lang.Object#finalize()}.
	 */
	public void testFinalize() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link java.lang.Object#getClass()}.
	 */
	public void testGetClass() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link java.lang.Object#hashCode()}.
	 */
	public void testHashCode() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link java.lang.Object#notify()}.
	 */
	public void testNotify() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link java.lang.Object#notifyAll()}.
	 */
	public void testNotifyAll() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link java.lang.Object#toString()}.
	 */
	public void testToString() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link java.lang.Object#wait()}.
	 */
	public void testWait() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link java.lang.Object#wait(long)}.
	 */
	public void testWaitLong() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link java.lang.Object#wait(long, int)}.
	 */
	public void testWaitLongInt() {
		fail("Not yet implemented"); // TODO
	}
	
}
