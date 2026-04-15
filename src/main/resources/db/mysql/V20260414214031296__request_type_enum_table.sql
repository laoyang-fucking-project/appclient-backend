drop table if exists `request_type_enum`;
create table `request_type_enum` (
	request_type_enum_id	INT	 not null auto_increment,
	type_name	varchar(512)	not null,
	primary key (request_type_enum_id)
);insert into	request_type_enum	(type_name,request_type_enum_id)	values	("物业报修","1");
insert into	request_type_enum	(type_name,request_type_enum_id)	values	("访客预约","2");
insert into	request_type_enum	(type_name,request_type_enum_id)	values	("活动报名","3");
