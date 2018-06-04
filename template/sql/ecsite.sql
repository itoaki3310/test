drop database if exists ecsite;
create database if not exists ecsite;
use ecsite;

drop table if exists login_user_transaction;
create table login_user_transaction(
id int not null primary key auto_increment,
login_id varchar(16) unique,
login_pass varchar(16),
user_name varchar(50),
insert_date datetime,
updated_date datetime
);

drop database if exists item_info_transaction;
create database if not exists item_info_transaction;
use item_info_transaction;

drop table if exists user_buy_item_transaction;
create table user_buy_item_transaction(
id int not null primary key auto_increment,
item_transaction_id int,
total_plice int,
total_count int,
user_master_id varchar(255),
pay varchar(255),
insert_date datetime,
delete_date datetime
);

drop table if exists item_info_transaction;
create table item_info_transaction(
id int not null primary key auto_increment,
item_name varchar(255),
item_price int,
item_stock int,
pay varchar(255),
insert_date datetime,
delete_date datetime
);

INSERT INTO item_info_transaction(item_name,item_price,item_stock)
VALUES("ノートBook",100,50);

INSERT INTO login_user_transaction(login_id,login_pass,user_name)
VALUES("internous","internous01","test");

