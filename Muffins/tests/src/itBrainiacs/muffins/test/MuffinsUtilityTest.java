/**
 * 
 */
package itBrainiacs.muffins.test;

import itBrainiacs.muffins.MuffinsUtility;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import android.test.AndroidTestCase;

/**
 * @author Administrator
 *
 */
public class MuffinsUtilityTest extends AndroidTestCase {

	/**
	 * UnittestID:MU1
	 * @throws java.lang.Exception
	 */
	public void setUp() throws Exception {
		super.setUp();
	}

	/**
	 * UnittestID:MU2
	 * Test method for {@link itBrainiacs.muffins.MuffinsUtility#convertStreamToString(java.io.InputStream)}.
	 * @throws IOException 
	 */
	public void testConvertStreamToString() throws IOException {
		String expectedString = "{\"xsearch\": {\n" +
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
		
		URL testUrlLibris = new URL("http://libris.kb.se/xsearch?query=NUMM:9119129610&format=json");
		InputStream testInputStream = testUrlLibris.openStream();

		assertEquals("", expectedString, MuffinsUtility.convertStreamToString(testInputStream));
	}

}
