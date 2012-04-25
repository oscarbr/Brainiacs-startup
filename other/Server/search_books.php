<?php
	//Get the information from the request (POST)
	$jsonInput = $_POST['jsondata'];
	$decoded = json_decode($jsonInput,true);
	echo "At least connected!";
	/*
	//Connect to the database
	$connection = mysql_connect(localhost:3306, php_script_user, svansk0ta) or die ("Could not connect to db: " . mysql_error());


	//Select the database to be used
	mysql_select_db("muffin_books", $connection) or die(mysql_error());
	
	
	//Construct the query
	$sql = "SELECT * FROM Books WHERE author=" . $decoded['author'] . " AND title=" . $decoded['title'] . ";
	
	//Make the query to the database with the connection
	$query_results = mysql_query($sql, $connection); 
	
	//If no results were returned
	if (!$query_results) {
		die("Could not connect to db: ", mysql_error());
	}
	
	//Get the array from the results
	$info = mysql_fetch_array($query_results, MYSQL_ASSOC);
	
	//Return the data encoded in json
	echo json_encode($info);
	
	//Disconnect database
	mysql_close($connection);
	*/
?>

