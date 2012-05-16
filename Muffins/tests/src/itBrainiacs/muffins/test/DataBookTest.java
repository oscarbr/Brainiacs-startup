/**
 * 
 */
package itBrainiacs.muffins.test;

import itBrainiacs.muffins.DataBook;
import android.test.AndroidTestCase;

/**
 * @author Administrator
 *
 */
public class DataBookTest extends AndroidTestCase {

	/**
	 * UnittestID:DB1
	 * @throws java.lang.Exception
	 */
	public void setUp() throws Exception {
		super.setUp();
	}

	/**
	 * UnittestID:DB2
	 * Test method for {@link java.lang.Object#equals(java.lang.Object)}.
	 */
	public void testEquals() {
		DataBook expectedBook = new DataBook();
		expectedBook.setTitle("Konsten att make love");
		expectedBook.setAuthor("Filip Sandviken");
		expectedBook.setIsbn("1234567890");
		expectedBook.setPublYear("1993");
		expectedBook.setEdition("first");
		expectedBook.setCourse("XXX666");
		expectedBook.setPrice("11");
		
		DataBook testBook = new DataBook();
		testBook.setTitle("Konsten att make love");
		testBook.setAuthor("Filip Sandviken");
		testBook.setIsbn("1234567890");
		testBook.setPublYear("1993");
		testBook.setEdition("first");
		testBook.setCourse("XXX666");
		testBook.setPrice("11");
		
		assertEquals("", expectedBook, testBook);
	}

}
