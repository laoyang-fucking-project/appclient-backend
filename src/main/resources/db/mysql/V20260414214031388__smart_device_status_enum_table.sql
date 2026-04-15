drop table if exists `smart_device_status_enum`;
create table `smart_device_status_enum` (
	smart_device_status_enum_id	int	 not null auto_increment,
	status_name	varchar(512)	not null,
	primary key (smart_device_status_enum_id)
);insert into	smart_device_status_enum	(smart_device_status_enum_id,status_name)	values	("1","在线");
insert into	smart_device_status_enum	(smart_device_status_enum_id,status_name)	values	("2","离线");
insert into	smart_device_status_enum	(smart_device_status_enum_id,status_name)	values	("3","故障");
