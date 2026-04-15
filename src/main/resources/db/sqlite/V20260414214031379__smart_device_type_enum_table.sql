drop table if exists `smart_device_type_enum`;
create table `smart_device_type_enum` (
	smart_device_type_enum_id	INTEGER PRIMARY KEY AUTOINCREMENT,
	type_name	varchar(512)	not null
);insert into	smart_device_type_enum	(type_name,smart_device_type_enum_id)	values	("温度传感器","1");
insert into	smart_device_type_enum	(type_name,smart_device_type_enum_id)	values	("湿度传感器","2");
insert into	smart_device_type_enum	(type_name,smart_device_type_enum_id)	values	("烟雾报警器","3");
insert into	smart_device_type_enum	(type_name,smart_device_type_enum_id)	values	("智能门锁","4");
insert into	smart_device_type_enum	(type_name,smart_device_type_enum_id)	values	("智能摄像头","5");
insert into	smart_device_type_enum	(type_name,smart_device_type_enum_id)	values	("智能插座","6");
insert into	smart_device_type_enum	(type_name,smart_device_type_enum_id)	values	("智能灯","7");
insert into	smart_device_type_enum	(type_name,smart_device_type_enum_id)	values	("智能窗帘","8");
