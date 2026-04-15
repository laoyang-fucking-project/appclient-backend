drop table if exists `request_type_enum`;
create table `request_type_enum` (
	request_type_enum_id	INTEGER PRIMARY KEY AUTOINCREMENT,
	type_name	varchar(512)	not null
);insert into	request_type_enum	(type_name,request_type_enum_id)	values	("物业报修","1");
insert into	request_type_enum	(type_name,request_type_enum_id)	values	("访客预约","2");
insert into	request_type_enum	(type_name,request_type_enum_id)	values	("活动报名","3");
