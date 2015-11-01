<?php


$id=$_POST["id"];
$vote=$_POST["vote"];


$server   = "*********";
$database = "***********";
$usernames = "***********";
$passwords = "***********";

$mysqlConnection = mysql_connect($server, $usernames, $passwords);
if (!$mysqlConnection)
{
  echo "Please try later.";
}
else
{
 mysql_select_db($database, $mysqlConnection);

$result = mysql_query("select count(1) FROM vote where id='$id'");
$row = mysql_fetch_array($result);

$total = $row[0];

if($total>0){
echo "Your Phone Is Already Voted";

}else{


$sql = "INSERT INTO vote( id,vote)
VALUES ('$id', '$vote')";
$conditio=mysql_query($sql);

  
 if($conditio){
   echo "Thank you for your vote ^_^ ";

 }
  else {
    echo "Fail due to your network";

 }


}


}

mysql_close($mysqlConnection);



?>


