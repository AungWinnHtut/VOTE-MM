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

$result = mysql_query("select count(1) FROM vote where vote=1");
$row = mysql_fetch_array($result);
$total = $row[0];


$result1 = mysql_query("select count(1) FROM vote where vote=2");
$row1 = mysql_fetch_array($result1);
$total1 = $row1[0];


$result2 = mysql_query("select count(1) FROM vote where vote=3");
$row2 = mysql_fetch_array($result2);
$total2 = $row2[0];

$result3 = mysql_query("select count(1) FROM vote where vote=4");
$row3 = mysql_fetch_array($result3);
$total3 = $row3[0];

$result4 = mysql_query("select count(1) FROM vote where vote=5");
$row4 = mysql_fetch_array($result4);
$total4 = $row4[0];

 
 echo "$total,$total1,$total2,$total3,$total4,";


}

mysql_close($mysqlConnection);



?>


