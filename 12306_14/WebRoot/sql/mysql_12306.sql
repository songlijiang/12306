create  database my_12306;
use my_12306;

create table t_user
( 
 id int auto_increment  primary key,
name varchar(30),
password varchar(30)
  
);



create table ticket3
( 
 id int auto_increment  primary key,
name varchar(30),
startstation varchar(30),
endstation varchar(30),
stations varchar(80),
num int,
endtime timestamp,
starttime timestamp
  
);



create table order3

(
  id int auto_increment  primary key,
   ticketid  int,
  orderid  int,
  num  int 



);


create table admin
(
	 id int auto_increment  primary key,
	name varchar(30),
password varchar(30)


);



