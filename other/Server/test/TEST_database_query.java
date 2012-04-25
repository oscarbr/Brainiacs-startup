	private void testDB(){
		try {
			/* Creating a json-representation of the query and 
			 * convert it to a String to be able to send in a POST 
			 * to the php-script on the server */
			JSONObject query = new JSONObject();
			query.put("author", "Emilio");
			query.put("title", "Management");
			String json = query.toString();
		
			// Create a new HttpClient and Post Header
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost("http://muffins.trestad.net/muffin_app/search_books.php");

		   	List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);  
		   	nameValuePairs.add(new BasicNameValuePair("jsondata", json));  
		   	httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
	        HttpResponse response = httpclient.execute(httppost);
	        
	        InputStream in = response.getEntity().getContent();
	        
	        String results = convertStreamToString(in);
	        	        
			JSONObject jsonResults = new JSONObject(results);
			
			Toast.makeText(getApplicationContext(), (String) jsonResults.get("author"), Toast.LENGTH_LONG).show();
			Toast.makeText(getApplicationContext(), (String) jsonResults.get("title"), Toast.LENGTH_LONG).show();
			Toast.makeText(getApplicationContext(), (String) jsonResults.get("testPerson"), Toast.LENGTH_LONG).show();


			} catch (ClientProtocolException e) {
				System.out.println("ERROR (ClientProtocolException): " + e.toString());
			} catch (IOException e) {
			    System.out.println("ERROR (IOException): " + e.toString());	    
			} catch (JSONException e) {
				System.out.println("ERROR (JSONException): " + e.toString());
				e.printStackTrace();
			} 
		
			
	}
	private String convertStreamToString(InputStream is) {
 
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