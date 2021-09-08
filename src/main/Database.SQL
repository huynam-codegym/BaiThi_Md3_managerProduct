create database managerproduct;
use managerproduct;
drop table category;
drop table product;

create table category(
                         id int primary key auto_increment,
                         categoryName varchar(255) not null
)

create table  product(
                         id int primary key auto_increment,
                         name varchar(255) not null,
                         price double not null,
                         quantity int not null,
                         color varchar(255) not null,
                         description varchar(255) not null,
                         categoryId int not null,
                         foreign key (categoryId) references category(id)
)