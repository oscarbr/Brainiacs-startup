package itBrainiacs.muffins;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/** 
 * Utility Class for Muffins application 
 */
public class MuffinsUtility {

	/**
	 * Collects all of the data from an InputStream and converts it into a
	 * String
	 * 
	 * @param InputStream
	 *            is
	 * @return String string
	 */
	public static String convertStreamToString(InputStream is) {

		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();
		
		// String where incoming lines are caught.
		String line = null;
		try {
			// Loop until there are no more lines
			while ((line = reader.readLine()) != null) {
				// Append caught line using the StringBuilder
				sb.append(line + "\n");
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// Close the InputStream
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// Convert all the lines caught in the StringBuilder into a String and return it.
		return sb.toString();
	}
}
