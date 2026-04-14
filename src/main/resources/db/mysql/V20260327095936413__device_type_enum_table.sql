drop table if exists `device_type_enum`;
create table `device_type_enum` (
	device_type_enum_id	INT	 not null auto_increment,
	type_name	varchar(512)	not null,
	primary key (device_type_enum_id)
);insert into	device_type_enum	(device_type_enum_id,type_name)	values	("1","摄像头");
insert into	device_type_enum	(device_type_enum_id,type_name)	values	("2","门禁");
insert into	device_type_enum	(device_type_enum_id,type_name)	values	("3","烟感");
