package itBrainiacs.muffins.test;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import itBrainiacs.muffins.*;

import android.test.AndroidTestCase;

public class DataBookFactoryTest extends AndroidTestCase {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		super.setUp();
	}
	
	/**
	 * Test method for {@link itBrainiacs.muffins.DataBookFactory#searchLibris(java.lang.String)}.
	 */
	public void testSearchLibris() {
		DataBook bok = DataBookFactory.searchLibris("9119129610");
		assertEquals("", "Sagan om ringen", bok.getTitle());
	}
	
	/**
	 * Test method for {@link itBrainiacs.muffins.DataBookFactory#dataBookToJSON(itBrainiacs.muffins.DataBook)}.
	 */
	public void testDataBookToJSON() {
		fail("Not yet implemented"); // TODO
	}
	
}
