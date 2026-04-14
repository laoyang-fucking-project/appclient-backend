drop table if exists `device_status`;
create table `device_status` (
	device_status_id	INTEGER PRIMARY KEY AUTOINCREMENT,
	device_name	varchar(512)	not null,
	device_type_enum_device_type_enum_id_1	INTEGER	not null,
	device_status_enum_device_status_enum_id_1	INTEGER	not null,
	last_update_time	DATETIME	
);insert into	device_status	(last_update_time,device_name,device_status_id,device_type_enum_device_type_enum_id_1,device_status_enum_device_status_enum_id_1)	values	("2024-06-01 10:00:00.0 00:00:00.0","小区门禁","1","2","1");
