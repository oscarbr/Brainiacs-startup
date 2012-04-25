	private void testDB(){
		//Creating a json-representation of my query
		
		JSONObject query = new JSONObject();

		try {
			query.put("author", "Emilio");
			query.put("title", "Management");

		} catch (JSONException e1) {
			e1.printStackTrace();
		}
		
		String json = query.toString();
		Toast.makeText(getApplicationContext(), json, Toast.LENGTH_LONG).show();
		
		// Create a new HttpClient and Post Header
		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost("http://muffins.trestad.net/muffin_app/search_books.php");


		try {	    	
		   	List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);  
		   	nameValuePairs.add(new BasicNameValuePair("jsondata", json));  
		   	httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
	        HttpResponse response = httpclient.execute(httppost);
	        
	        InputStream in = response.getEntity().getContent();
	        
	        String results = convertStreamToString(in);
	        
	        Toast.makeText(getApplicationContext(), in.toString(), Toast.LENGTH_LONG).show();
	        Toast.makeText(getApplicationContext(), results, Toast.LENGTH_LONG).show();


			} catch (ClientProtocolException e) {
				System.out.println("ERROR (ClientProtocolException): " + e.toString());
			} catch (IOException e) {
			    System.out.println("ERROR (IOException): " + e.toString());	    
			} 
			
	}
	private String convertStreamToString(InputStream is) {
        /*
         * To convert the InputStream to String we use the BufferedReader.readLine()
         * method. We iterate until the BufferedReader return null which means
         * there's no more data to read. Each line will appended to a StringBuilder
         * and returned as String.
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