drop table if exists demo;
create table demo(
id int primary key,
name varchar(255) NOT NULL
);
create sequence hibernate_sequence start with 1 increment by 1;