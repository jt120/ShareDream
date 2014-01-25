drop database IF EXISTS share_dream;
create database share_dream;
GRANT ALL ON share_dream.* TO 'root'@'localhost' IDENTIFIED BY 'root';
use share_dream;
drop table IF EXISTS t_user;
drop table IF EXISTS t_group;
drop table IF EXISTS t_user_group;
drop table IF EXISTS t_dream;
create table t_user(
	id int(10) primary key auto_increment,
	username varchar(100),
	password varchar(100),
	nickname varchar(100)
);
create table t_dream(
	id int(10) primary key auto_increment,
	name varchar(100),
	uid int(10),
	CONSTRAINT FOREIGN KEY (uid) REFERENCES t_user (id)
);
create table t_group(
	id int(10) primary key auto_increment,
	did int(10),
	name varchar(100),	
	CONSTRAINT FOREIGN KEY (did) REFERENCES t_dream (id)
);
create table t_user_group(
	uid int(10),
	gid int(10),
	CONSTRAINT FOREIGN KEY (uid) REFERENCES t_user (id),
	CONSTRAINT FOREIGN KEY (gid) REFERENCES t_group (id)
	
);
create table t_comment(
id int primary key auto_increment,
content varchar(255),
u_id int,
d_id int,
constraint foreign key (u_id) REFERENCES t_user(id),
constraint foreign key (d_id) REFERENCES t_dream(id)
);
insert into t_user values (null,"admin","admin","超级管理员");
