<?php
	//Get the information from the request (POST)
	
	$jsonInput = $_POST['jsondata'];
	$decoded = json_decode($jsonInput,true);
	
	//Connect to the database
	$connection = mysql_connect(localhost, muffin_master, svansk0ta); //might change this to be localhost
	
	if (!$connection) {
		die("Could not connect to db: " . mysql_error()); 	
	}
	
	//Select the database to be used
	mysql_select_db("muffin_books", $connection) or die(mysql_error());
	
	$sql = "INSERT INTO Books (author, title, testPerson) VALUES ( '" . $decoded['author'] . "', '" .  $decoded['title'] . "', 'Rikard Andersson')"
	
	//Make the query to the database from the POST-form
	if(!mysql_query($sql, $connection)) {
		die('Error: ' . mysql_error());
	}
	
	//Lets the application know that a row has been added
	echo "1 row added";
		
	//Disconnect database
	mysql_close($connection);	
?>