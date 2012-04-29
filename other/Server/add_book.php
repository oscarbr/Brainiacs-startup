<?php
	//Get the information from the request (POST)
	$jsonInput = $_POST['jsondata'];
	$decoded = json_decode($jsonInput,true);
	
	$username = "muffin_master";
	$password = "***";
	$server = "localhost";
		
	//Connect to the database
	$connection = mysql_connect($server, $username, $password) or die ("Could not connect to db: " . mysql_error());

	//Select the database to be used
	mysql_select_db("muffin_books", $connection) or die (mysql_error());
	
	$first = 0;
	$keys = "";
	$values = "";
	
	//Capture all the keys and values inputed. Risk of getting invalid once. 
	foreach ($decoded as $key => $value) {
		if (first == 0) {
			$keys = $key;
			$values = "'" . $value . "'";
			first = 1;
		} else {
			$keys = $keys . ", " . $key;
			$values = $values . ", '" . $value . "'";
		}
	}		 
	
	//Construct the insert-query
	$sql = "INSERT INTO Books (" . $keys . ") VALUES (" . $values . ")";
		
	//Make the query to the database with the connection
	if(!mysql_query($sql, $connection)){
		die("Could not add book to db" . mysql_error());
	}
	
	echo "Book added to database";
		
	//Disconnect database
	mysql_close($connection);
?>