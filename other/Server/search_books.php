<?php
	//Get the information from the request (POST)
	$jsonInput = $_POST['jsondata'];
	$decoded = json_decode($jsonInput,true);
	
	include '../../pswd.php';
		
	//Connect to the database
	$connection = mysql_connect($server, $username, $password) or die ("Could not connect to db: " . mysql_error());

	//Select the database to be used
	mysql_select_db("muffin_books", $connection) or die (mysql_error());
	
	
	$first = 0;
	$conditions = "";

	//Capture all the keys and values inputed. Risk of getting invalid once. 
	foreach ($decoded as $key => $value) {
		if ($first == 0) {
			$conditions = " WHERE " . $key . " = '" . $value . "'";
			$first = 1;
		} else {
			$condidtions = $condition . " AND " . $key . " = '" . $value . "'";
		}
	}

	//Construct the select-query
	$sql = "SELECT * FROM Books" . $conditions;
		
	//Make the query to the database with the connection
	$query_results = mysql_query($sql, $connection);
	
	$results = array();
	while($r = mysql_fetch_array($query_results, MYSQL_ASSOC)) {
		$results[] = $r;
	}
	
	//Return the data encoded in json
	echo json_encode($results);
	
	//Disconnect database
	mysql_close($connection);
?>

