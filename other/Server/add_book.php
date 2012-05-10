<?php
	//Get the information from the request (POST)
	$jsonInput = $_POST['jsondata'];
	$decoded = json_decode($jsonInput,true);
	
	include '../../pswd.php';
		
	//Connect to the database
	$connection = mysql_connect($server, $username, $password) or die ("Could not connect to db: " . mysql_error());

	//Select the database to be used
	mysql_select_db("muffin_books", $connection) or die (mysql_error());
	
	$keys = "expires";
	$values = "CURDATE() + INTERVAL 2 MONTH";	
	
	//Capture all the keys and values inputed. Risk of getting invalid once. 
	foreach ($decoded as $key => $value) {
			$keys = $keys . ", " . $key;
			$values = $values . ", '" . $value . "'";
	}
	
	
	//Construct the insert-query
	$sql = "INSERT INTO Books (" . $keys . ") VALUES (" . $values . ")";
	
	//Make the query to the database with the connection
	
	
	$results = mysql_query($sql, $connection);
	
	if(!$results){
		die("Could not add book to db" . mysql_error());
	} else {
		echo $results;
	}
	
	//Disconnect database
	mysql_close($connection);
?>