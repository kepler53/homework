create schema hw0407;

use hw0407;

create table order_tb(
	onum int primary key auto_increment,
    oprice int ,
    paycheck tinyint(1) default 0,
    delivercheck tinyint(1) default 0,
    unum int,
    pnum int,
    FOREIGN KEY (unum) REFERENCES user_tb (unum),
    FOREIGN KEY (pnum) REFERENCES product_tb (pnum)
);

explain select * from order_tb;
select * from order_tb;


create table product_tb(
	pnum int primary key auto_increment,
    pprice int,
    pentity int
);

create table user_tb(
	unum int primary key auto_increment,
    uname varchar(5) not null default '유령회원',
    uaddress varchar(20),
    uphonenum varchar(20)
);