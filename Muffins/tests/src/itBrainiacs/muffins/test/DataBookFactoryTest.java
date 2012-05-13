package itBrainiacs.muffins.test;

import itBrainiacs.muffins.*;

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
	 */
	public void testJsonToDataBooks() {
		fail("Not yet implemented"); // TODO
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
