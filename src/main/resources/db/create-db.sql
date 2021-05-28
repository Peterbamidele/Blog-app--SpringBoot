drop database if not exists blogdb;
create database blogdb;

create user if not exists 'bloguser'@'localhost' identified by '#Bamidele98';
grant all privileges on blogdb.* to 'bloguser'@'localhost';
flush privileges ;