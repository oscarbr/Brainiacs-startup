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
	
	//Construct the insert-query
	$sql = "INSERT INTO Books (author, title, testPerson) VALUES ('" . $decoded['author'] . "', '" . $decoded['title'] . "', 'Rikard Andersson')";
		
	//Make the query to the database with the connection
	if(!mysql_query($sql, $connection)){
		die("Could not add book to db" . mysql_error());
	}
	
	echo "Book added to database";
		
	//Disconnect database
	mysql_close($connection);
?>