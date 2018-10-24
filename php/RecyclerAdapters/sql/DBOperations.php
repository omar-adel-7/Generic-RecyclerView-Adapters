<?php

 include  __DIR__."/DB.php";  

class DBOperations {

    public function __constructor() {
        
    }

    
    public function getAllBooks()
            {
        $com = new DbConnect();
        $sql = "select * from books order by id asc";
        $result = mysqli_query($com->getDb(), $sql);
        return $result;
    }
    
}
