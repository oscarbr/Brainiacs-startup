/**
 * 
 */
package itBrainiacs.muffins.test;


import java.util.LinkedList;

import itBrainiacs.muffins.DataBook;
import itBrainiacs.muffins.ServerCommunicator;

import android.test.AndroidTestCase;

/**
 * @author Administrator
 *
 */
public class ServerCommunicatorTest extends AndroidTestCase {

	/**
	 * UnittestID:SC1
	 * @throws java.lang.Exception
	 */
	public void setUp() throws Exception {
		super.setUp();
	}

	/**
	 * UnittestID:SC2
	 * Test method for {@link itBrainiacs.muffins.ServerCommunicator#addBook(itBrainiacs.muffins.DataBook)}.
	 */
	public void testAddBook() {
		// TODO Implement test cannot be done until removing of books i db is possible. 
		fail("Not yet implemented");
	}

	/**
	 * TODO implement proper equals
	 * UnittestID:SC3
	 * Test method for {@link itBrainiacs.muffins.ServerCommunicator#searchBooks(itBrainiacs.muffins.DataBook)}.
	 */
	public void testSearchBooks() {
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
		
		DataBook testBook = new DataBook();
		testBook.setTitle("Konsten att make love");
		testBook.setAuthor("Filip Sandviken");
		testBook.setIsbn("1234567890");
		testBook.setPublYear("1993");
		testBook.setEdition("first");
		testBook.setCourse("XXX666");
		testBook.setPrice("11");
		
		assertEquals("", expectedBookList.get(0).getTitle(), ServerCommunicator.searchBooks(testBook).get(0).getTitle());
		assertEquals("", expectedBookList.get(0).getAuthor(), ServerCommunicator.searchBooks(testBook).get(0).getAuthor());
		assertEquals("", expectedBookList.get(0).getIsbn(), ServerCommunicator.searchBooks(testBook).get(0).getIsbn());
		assertEquals("", expectedBookList.get(0).getPublYear(), ServerCommunicator.searchBooks(testBook).get(0).getPublYear());
		assertEquals("", expectedBookList.get(0).getEdition(), ServerCommunicator.searchBooks(testBook).get(0).getEdition());
		assertEquals("", expectedBookList.get(0).getCourse(), ServerCommunicator.searchBooks(testBook).get(0).getCourse());
		assertEquals("", expectedBookList.get(0).getPrice(), ServerCommunicator.searchBooks(testBook).get(0).getPrice());
	}

}
