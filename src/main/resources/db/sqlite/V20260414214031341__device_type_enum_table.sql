drop table if exists `device_type_enum`;
create table `device_type_enum` (
	device_type_enum_id	INTEGER PRIMARY KEY AUTOINCREMENT,
	type_name	varchar(512)	not null
);insert into	device_type_enum	(device_type_enum_id,type_name)	values	("1","摄像头");
insert into	device_type_enum	(device_type_enum_id,type_name)	values	("2","门禁");
insert into	device_type_enum	(device_type_enum_id,type_name)	values	("3","烟感");
