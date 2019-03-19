drop database project_manager if exists;
create database project_manager;
use project_manager;

/*创建用户表*/
CREATE table user_(
	user_id int(10) auto_increment,
	user_jobNumber int(10) NOT NULL,
	user_name varchar(20) NOT NULL,
	user_phoneNumber varchar(20) NOT NULL,
	user_email varchar(50) NOT NULL,
	user_sex boolean NOT NULL,
	user_post varchar(50) NOT NULL,
	user_entryDate DATE NOT NULL,
	user_password varchar(30) NOT NULL,
	PRIMARY KEY(user_id)
)ENGINE=InnoDB,charset=utf8;

--插入一条数据
INSERT INTO user_ VALUES (null,281127,"admin","13632991223","ren.long1@byd.com",true,"电子工程师","2017-07-21","123456");