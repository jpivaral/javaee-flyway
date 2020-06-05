create table dbFlyWayTest.person(
    id int primary key auto_increment,
    first_name varchar(50) not null,
    last_name varchar(50) not null
);

insert into dbFlyWayTest.person(first_name, last_name)
values('test1','test1'),
('test2','test2');