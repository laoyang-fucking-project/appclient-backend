drop table if exists `device_status_enum`;
create table `device_status_enum` (
	device_status_enum_id	INTEGER PRIMARY KEY AUTOINCREMENT,
	status_name	varchar(512)	not null
);insert into	device_status_enum	(status_name,device_status_enum_id)	values	("正常","1");
insert into	device_status_enum	(status_name,device_status_enum_id)	values	("异常","2");
insert into	device_status_enum	(status_name,device_status_enum_id)	values	("离线","3");
