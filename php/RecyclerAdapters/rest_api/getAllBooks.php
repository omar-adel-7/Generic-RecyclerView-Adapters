<?php

// array for JSON response
$response = array();

  include(__DIR__."/GeneralFunctions.php");
 
   if (isset($_POST['security90'])) {

$dbOperationsObject = new DBOperations();
$generalFunctionsObject = new GeneralFunctionsClass();

$books = array();
$resultBooks = $dbOperationsObject->getAllBooks();
$books = $generalFunctionsObject->getAllBooks($resultBooks);

$response["success"] = "yes";
$response["books"] = $books;
echo json_encode($response);

  }
  else 
  	{

 $response["success"] = "no";
 echo json_encode($response);
  }
?>

