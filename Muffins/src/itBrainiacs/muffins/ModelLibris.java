package itBrainiacs.muffins;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ModelLibris {
	
	public static void parseLibris(DataBook bok, String json) {
		JsonElement jelement = new JsonParser().parse(json);
		JsonObject jobject = jelement.getAsJsonObject();
		jobject = jobject.getAsJsonObject("xsearch");
		JsonArray jarray = jobject.getAsJsonArray("list");
		jobject = jarray.get(0).getAsJsonObject();
		
		bok.setTitle(jobject.get("title").toString());
		bok.setAuthor(jobject.get("creator").toString());
		bok.setPublisher(jobject.get("publisher").toString());
		bok.setDate(jobject.get("date").toString());
		bok.setLanguage(jobject.get("language").toString());
	}

	private static String convertStreamToString(InputStream is) {
		/*
		 * To convert the InputStream to String we use the
		 * BufferedReader.readLine() method. We iterate until the BufferedReader
		 * return null which means there's no more data to read. Each line will
		 * appended to a StringBuilder and returned as String.
		 */
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();

		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}
	
}
