<?php

   $DBOperations_path =   __DIR__."/../sql/DBOperations.php";
 
include($DBOperations_path);

class GeneralFunctionsClass {

    public function __constructor() 
            
     {
        
    }

      
    public function getAllBooks($resultBooks) {
        $books = array();
            while ($rowBook = mysqli_fetch_array($resultBooks)) {
            $book = array("id" => $rowBook['id'], "title" => $rowBook['title']
                , "desc" => $rowBook['description'], "image" => $rowBook['image']
            );
            
            array_push($books, $book);
        }

        return $books;
    }
    
            

}
